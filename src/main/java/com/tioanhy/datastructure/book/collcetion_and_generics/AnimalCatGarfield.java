package com.tianhy.datastructures.collcetion_and_generics;

import com.tianhy.datastructures.collcetion_and_generics.domain.Animal;
import com.tianhy.datastructures.collcetion_and_generics.domain.Cat;
import com.tianhy.datastructures.collcetion_and_generics.domain.Garfield;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: thy
 * @Date: 2020/2/21 2:05
 * @Desc: 以动物、猫、加菲猫为例，说明extends和super
 */
public class AnimalCatGarfield {
    public static void main(String[] args) {
        acg();
    }

    public static void acg() {
        //声明3个依次继承的类的集合，Object>Animal>Cat>Garfield
        List<Animal> animals = new ArrayList<>();
        List<Cat> cats = new ArrayList<>();
        List<Garfield> garfields = new ArrayList<>();

        animals.add(new Animal());
        cats.add(new Cat());
        garfields.add(new Garfield());

        //赋值操作
/*
        <? extends T>只能赋值T或T的子类的集合
        List<? extends Cat> extendsCatFromAnimal = animals;
*/
        List<? super Cat> superCatFromAnimal = animals;
        List<? extends Cat> extendsCatFromCat = cats;
        List<? super Cat> superCatFromCat = cats;
        List<? extends Cat> extendsCatFromFarfield = garfields;
/*
        <? super T>只能赋值T或T父类的集合
        List<? super Cat> superCatFromGarfield = garfields;
*/

        //add方法
/*
        任何元素都不能添加进<? extends T>
        extendsCatFromCat.add(new Animal());
        extendsCatFromCat.add(new Cat());
        extendsCatFromCat.add(new Garfield());
*/
/*
        <? super T>只能添加T或T子类的集合
        superCatFromAnimal.add(new Animal());
*/
        superCatFromAnimal.add(new Cat());
        superCatFromAnimal.add(new Garfield());

        //get方法
        //所有的super操作能够返回元素，但使泛型丢失，只能返回Object对象

        //以下extends可以返回元素，只能返回Cat及Cat父类对象
        Cat cat = extendsCatFromCat.get(0);
        Object catObject = extendsCatFromCat.get(0);

/*
        虽然extendsCatFromFarfield集合从Garfield赋值而来，但类型擦除后，并不知情
        Garfield garfield = extendsCatFromFarfield.get(0);
*/


    }
}
