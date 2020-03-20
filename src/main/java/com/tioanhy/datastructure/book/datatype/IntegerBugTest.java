package com.tioanhy.datastructure.book.datatype;

import com.tioanhy.datastructure.greek.array.serializer.ISerializer;
import com.tioanhy.datastructure.greek.array.serializer.JavaSerializer;

/**
 * @Author: thy
 * @Date: 2020/2/21 17:05
 * @Desc: 包装类型相关故障问题演示
 */
public class IntegerBugTest {
    public static void main(String[] args) {
        deserilize();
    }

    public static void deserilize() {
/*
        ISerializer serializer = new FastJsonSerializer();
        byte[] serialize = serializer.serialize(Integer.valueOf(128));
        Integer integer = serializer.deSerialize(serialize, Integer.class);
*/
        //Java原生序列化
        ISerializer serializer = new JavaSerializer();
        byte[] serialize = serializer.serialize(Integer.valueOf(1));
        Integer integer = serializer.deSerialize(serialize, Integer.class);
        compare(integer);
    }

    public static void compare(Integer var) {
        //传入的参数var反序列化生成新的对象，而右边的是缓存中的对象
        if (var == Integer.valueOf(1)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
