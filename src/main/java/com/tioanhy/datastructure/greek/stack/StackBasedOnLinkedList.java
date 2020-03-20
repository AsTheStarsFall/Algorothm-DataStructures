package com.tioanhy.datastructure.greek.stack;


/**
 * {@link}
 *
 * @Desc: 基于链表实现的栈
 * @Author: thy
 * @CreateTime: 2019/5/4
 **/
public class StackBasedOnLinkedList {

    public static void main(String[] args) {
        StackBasedOnLinkedList stackBasedOnLinkedList = new StackBasedOnLinkedList();


    }

    private Node top;

    public void push(int value) {
        Node newNode = new Node(value, null);
        //如果栈空，新节点为top
        if (top == null) {
            top = newNode;
        } else {
            //如果不是空，将当前节点指针指向top
            newNode.next = top;
            //设置为顶元素
            top = newNode;
        }

    }

    //出栈
    public int pop() {
        if (top == null) {
            return -1;
        }
        int val = top.data;
        top = top.next;
        return val;
    }

    public void print() {
        Node node = top;
        while (top != null) {
            System.out.println(node.data + "  ");
            node = node.next;
        }
        System.out.println();
    }


    private static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

}
