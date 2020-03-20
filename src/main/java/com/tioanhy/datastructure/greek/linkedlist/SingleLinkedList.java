package com.tioanhy.datastructure.greek.linkedlist;

import lombok.Data;

/**
 * {@link}
 *
 * @Desc: 单链表操作
 * @Author: thy
 * @CreateTime: 2019/5/6
 **/
public class SingleLinkedList {

    private Node head = null;

    /**
     * 根据指定的value查找结点
     * @param value
     * @return
     */
    public Node findByValue(int value){
        Node node = head;
        while (node != null && node.data != value){
            node = node.next;
        }
        return node;
    }

    /**
     * 根据下标查找结点
     * @param index
     * @return
     */
    public Node findByIndex(int index){
        Node node = head;
        int t = 0;
        if(node != null && t != index){
            node = node.next;
            ++t;
        }
        return node;
    }


    /**
     * 无头结点
     * 插入链表头部
     * @param value
     */
    public void insertAtHead(int value){
        Node node = new Node(value,null);
        insertAtHead(node);
    }

    private void insertAtHead(Node newNode) {
        if(head == null){
            head = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }
    }

    /**
     * 插入尾部
     * @param value
     */
    public void insertArTail(int value){
        Node newNode = new Node(value,null);
        if(head == null){
            head = newNode;
        }else {
            Node node = head;
            while (node.next != null){
                node = node.next;
            }
            //走出while 说明到了最后一个结点了
            newNode.next = node.next;
            node.next = newNode;
        }
    }

    /**
     * 删除指定的结点
     * @param p
     */
    public void deleteByNode(Node p){
        if(head == null || p == null){return;}

        if(head == p){
            head = head.next;
            return;
        }

        Node g = head;
        while (g != null && g.next!= p){
            g = g.next;
        }
        //走出while 说明找到了要删除结点的前驱结点
        if(g == null){
            return;
        }
        //此时 g.next 指针被删除了，所以把 g.next.next 指针赋予 g.next
        g.next = g.next.next;
    }


    @Data
    public static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }


}
