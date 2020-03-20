package com.tioanhy;

import lombok.extern.slf4j.Slf4j;

import java.util.Stack;


/**
 * {@link}
 *
 * @Desc:
 * @Author: thy
 * @CreateTime: 2019/5/3
 **/
@Slf4j
public class StackTest {


    public static void main(String[] args) {
//        ArrayStack arrayStack = new ArrayStack(2);
//
//
//        for (int i = 0; i < 10; i++) {
//            arrayStack.push("thy"+ i);
//        }
//
//        System.out.println(Json.toJson(arrayStack));
//        String pop = arrayStack.pop();
//        System.out.println(pop);
//        System.out.println(Json.toJson(arrayStack));
//
        Stack<String> stacks = new Stack<>();
        for (int i = 0; i < 10; i++) {
            stacks.push("thy"+i);
            System.out.println(stacks.search("thy" + i));
        }
//        System.out.println(Json.toJson(stacks));

        String pop = stacks.pop();
        System.out.println(pop);
//        System.out.println(Json.toJson(stacks));

        String peek = stacks.peek();
        System.out.println(peek);
//        System.out.println(Json.toJson(stacks));

    }
}
