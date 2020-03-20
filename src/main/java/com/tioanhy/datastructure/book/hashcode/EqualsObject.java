package com.tianhy.datastructures.hashcode;



/**
 * @Author: thy
 * @Date: 2020/2/24 23:11
 * @Desc:
 */
public class EqualsObject {

    private int id;
    private String name;

    public EqualsObject(int id, String name) {
        this.id = id;
        this.name = name;
    }

    //重写equals方法
    @Override
    public boolean equals(Object obj) {
        //如果为null，或者并非同类
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        //如果引用指向同一个对象
        if (this == obj) {
            return true;
        }
        EqualsObject equalsObject = (EqualsObject) obj;
        if (equalsObject.getId() == this.id && (this.name).equals(equalsObject.getName())) {
            return true;
        }
        return false;
    }


    //hashcode是为每个对象生成一个int值
    @Override
    public int hashCode() {
        return id + name.hashCode();
//        return Objects.hash(id, name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
