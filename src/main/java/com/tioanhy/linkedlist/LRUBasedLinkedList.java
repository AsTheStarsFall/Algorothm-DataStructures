package com.tioanhy.linkedlist;

import lombok.Data;


/**
 * {@link}
 *
 * @Desc: 基于单链表的LRU淘汰缓存算法
 * @Author: thy
 * @CreateTime: 2019/5/5
 **/
public class LRUBasedLinkedList<T> {
    /**
     * 默认容量
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 头结点
     */
    private SNode<T> headNode;

    private Integer length;

    private Integer capacity;

    public LRUBasedLinkedList() {
        this.headNode = new SNode<>();
        this.capacity = DEFAULT_CAPACITY;
        this.length = 0;
    }

    public LRUBasedLinkedList(Integer capacity) {
        this.headNode = new SNode<>();
        this.capacity = capacity;
        this.length = 0;
    }

    /**
     * 添加数据
     * 1、如果链表中已存在：1、删除原来的数据 2、插入链表头部
     * 2、如果链表中不存在：如果链表已满，删除尾部，插入头部
     *
     * @param data
     */
    public void add(T data) {
        SNode preNode = findPreNode(data);

        //如果能找到当前元素的前驱结点，说明当前元素在链表已经存在
        //如果当前元素在链表存在，删除原来数据，再插入到链表头部
        if (preNode != null) {
            deleteElemOrial(preNode);
            insertElemAtBegin(data);
        } else {
            //链表中不存在

            //当链表已满
            if (length >= capacity) {
                //删除尾节点
                deleteElemAtEnd();
            }
            //插入到头结点
            insertElemAtBegin(data);
        }
    }

    /**
     * 查找当前元素的前驱结点
     *
     * @param data
     */
    public SNode findPreNode(T data) {
        //头结点
        SNode node = headNode;
        //在头结点有后续结点的情况下，从头结点开始遍历
        while (node.next != null) {
            //如果当前元素与头结点的后续结点匹配上，返回头结点
            if (data.equals(node.next.element)) {
                return node;
            }
            //否则将头结点的后续结点赋值给node，继续遍历
            node = node.next;
        }
        return null;
    }

    /**
     * 删除原来的数据,删除前驱结点的下一个结点
     *
     * @param preNode
     */
    private void deleteElemOrial(SNode preNode) {
        //前驱结点的后续结点
        SNode next = preNode.getNext();
        //将后续结点的后续结点赋值给前驱结点的后续结点
        preNode.next = next.getNext();
        //删除
        next = null;
        length--;
    }

    /**
     * 插入链表头部
     *
     * @param data
     */
    private void insertElemAtBegin(T data) {
        //获取头结点的next指针
        SNode headNodeNext = headNode.getNext();
        //把头结点的next指针赋值给要插入的结点
        headNode.setNext(new SNode(data, headNodeNext));
        length++;
    }

    /**
     * 删除尾结点
     */
    private void deleteElemAtEnd() {
        SNode head = headNode;
        if (head.getNext() == null) {
            return;
        }
        //从头结点开始，遍历下下个结点，直到为空为止
        while (head.getNext().getNext() != null) {
            //倒数第二个结点
            head = head.getNext();
        }
        //走出了while循环，说明找到了尾结点

        //尾结点
        SNode temp = head.getNext();
        //倒数第二个结点，现在为新的尾结点
        head.setNext(null);
        //尾结点设空
        temp = null;
        length--;

    }


    /**
     * 打印
     */
    public void printAll() {
        SNode node = headNode.getNext();
        while (node != null) {
            System.out.print(node.getElement() + ",");
            node = node.getNext();
        }
        System.out.println();
    }


    /**
     * 结点信息
     * @param <T>
     */
    @Data
    public class SNode<T> {

        private T element;

        private SNode next;

        public SNode(T element) {
            this.element = element;
        }

        public SNode(T element, SNode next) {
            this.element = element;
            this.next = next;
        }

        public SNode() {
            this.next = null;
        }
    }
}
