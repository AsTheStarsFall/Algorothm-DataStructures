package com.tioanhy;

import com.tioanhy.datastructure.greek.linkedlist.LRUBasedLinkedList;

import java.util.Scanner;

/**
 * {@link}
 *
 * @Desc:
 * @Author: thy
 * @CreateTime: 2019/5/6
 **/
public class LRUBasedLinkedListTest {


    public static void main(String[] args) {
        LRUBasedLinkedList list = new LRUBasedLinkedList();
        Scanner sc = new Scanner(System.in);
        while (true){
            list.add(sc.nextInt());
            list.printAll();
        }
    }
}
