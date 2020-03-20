package com.tioanhy.algorothm;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: thy
 * @Date: 2020/2/25 4:55
 * @Desc: 递归
 */
public class Recusion {
    private static StringBuffer stringBuffer = new StringBuffer();
    private static int count = 0;
    private static String string = "-";

    public static void main(String[] args) {
        System.out.println(f(10));
    }

    // f(x)=2f(x-1)+x^2
    public static int f(int x) {
        stringBuffer.append(string);
        stringBuffer.append(count);
        System.out.println(stringBuffer.toString());
        //基准情况
        if (x == 0) {
            return 0;
        }
        count++;
        //递归调用
        return 2 * f(x - 1) + x * x;
    }

    //找到最终推荐人
    public static String findReferrerID(String uid) {
        String referrerid = "select referrer_id from [table] where uid=" + uid;
        //基准情形
        if (referrerid == null) {
            return referrerid;
        }
        //执行递归
        return findReferrerID(referrerid);
    }


    private static Map<Long, Long> map = new HashMap<>();

    /**
     * 假设有n台阶梯，每次只跨1或2个台阶，有多少种走法到达？
     * 分为两类走法，第一类是先跨1个台阶，第二类是先跨2个台阶
     * 所以n个台阶的走法就是，先走1个台阶后 n-1种走法
     * 先走2个台阶后，n-2种走法
     */
    //f(n)=f(n-1)+f(n-2)
    public static Long findStaris(Long x) {
        //基准情形
        if (x == 1) {
            return 1L;
        }
        if (x == 2) {
            return 2L;
        }

        if (map.containsKey(x)) {
            return map.get(x);
        }
        //避免重复
        Long tmp = findStaris(x - 1) + findStaris(x - 2);
        map.put(x, tmp);
        return tmp;

    }

}
