package com.tianhy.datastructures.datatype.ref;

/**
 * @Author: thy
 * @Date: 2020/2/21 15:55
 * @Desc:
 */
public class RefObjDemo {
    //对象头最小占用12B

    //4个byte类型分配，占4B
    byte b1;
    byte b2;
    byte b3;
    byte b4;

    //5个引用变量，每个占4B,共20B
    Object o1;
    Object o2;
    Object o3;
    Object o4;
    Object o5;

    //两个引用变量占8B
    RefObjOther refObjOther1 = new RefObjOther();
    RefObjOther refObjOther2 = new RefObjOther();

    //综上，RefObjDemo对象占用：12B+4B+4B*5+4B*2=44B，取8的倍数：48B


    class RefObjOther {
        //double类型占用8B，此处是数引用变量
        //所以对象头12B+8B=16B
        double[] doubles = new double[1000];

    }


}
