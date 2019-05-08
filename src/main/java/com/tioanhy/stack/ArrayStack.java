package com.tioanhy.stack;

/**
 * {@link}
 *
 * @Desc: 基于数组实现的顺序栈
 * @Author: thy
 * @CreateTime: 2019/5/3
 **/
public class ArrayStack {

    //临时数组
    private String[] temps ;

    // 数组
    private String[] items;
    // 栈中的元素个数
    private int count = 0;
     //栈的大小
    private int n;

    // 初始化，申请一个大小为n的数组

    public ArrayStack(int n) {
        this.items = new String[n];
        this.count = 0;
        this.n = n;
    }

    //入栈
    public void push(String item) {
        //如果count元素个数 == 数组长度，栈满
        if (count == items.length) {
            resize(2*items.length);
        }
        //将数据放入count位置
        items[count] = item;
        // ++count : 先执行 count = count+1,再使用count的值
        // count++ : 先使用count的值，再执行count = count+1
        ++count;
        n = items.length;
    }

    //出栈
    public String pop() {
        //如果count ==0 栈空
        if (count == 0) {
            return null;
        }
        //处于栈顶的数据
        String tem = items[count - 1];
        //将原来处于栈顶的数据删除
        items[count -1] = null;
        --count;
        return tem;
    }

    //扩容
    private void resize(int length){
        temps = new String[length];
        for (int i = 0; i < count; i++) {
            temps[i] = items[i];
        }
        items = temps;
    }
}
