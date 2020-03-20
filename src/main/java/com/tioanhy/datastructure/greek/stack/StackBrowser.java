package com.tioanhy.datastructure.greek.stack;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * {@link}
 *
 * @Desc: 浏览器的前进/回退
 * <p>
 * 思路：首页面压X栈，返回从X出栈，压Y栈。前进从Y出栈，压X栈
 * @Author: thy
 * @CreateTime: 2020/3/2 19:27
 **/
public class StackBrowser {

    public static void main(String[] args) throws InterruptedException {
        StackBrowser browser = new StackBrowser();
        browser.open("http://www.baidu.com");
        browser.open("http://news.baidu.com/");
        browser.open("http://news.baidu.com/ent");

        browser.goBack();
        browser.goBack();

        browser.goForward();
        browser.open("http://www.qq.com");
        browser.goForward();
        browser.goBack();
        browser.goForward();

        browser.goBack();
        browser.goBack();
        browser.goBack();
        browser.goBack();
        browser.checkCurrentPage();
    }

    //当前页
    private String currentPage;
    //back stack
    private LinkedListBaseStack backStack;
    //forward stack
    private LinkedListBaseStack forwardStack;
    private AtomicInteger integer = new AtomicInteger(0);

    public StackBrowser() {
        this.backStack = new LinkedListBaseStack();
        this.forwardStack = new LinkedListBaseStack();

    }

    //打开
    public void open(String url) {
        //如果当前也页不为空，
        if (this.currentPage != null) {
            this.backStack.push(this.currentPage);
            this.forwardStack.clear();
        }
        showUrl(url, "Open", integer.incrementAndGet());

    }

    //前进
    public String goForward() {
        if (canForward()) {
            //将当前页入back
            this.backStack.push(this.currentPage);
            //且从forWard出栈
            String pop = this.forwardStack.pop();
            showUrl(pop, "Forward", integer.incrementAndGet());
            return pop;
        }
        System.err.println("Can not go forward, no page ahead");
        return null;

    }

    //后退
    public String goBack() {
        if (canBack()) {
            this.forwardStack.push(this.currentPage);
            String pop = this.backStack.pop();
            showUrl(pop, "Back", integer.decrementAndGet());
            return pop;
        }
        System.err.println("Can not go back, no page behind");
        return null;
    }

    public synchronized void showUrl(String url, String prefix, int page) {
        this.currentPage = url;
        System.out.println(prefix + "Page " + url + "    <pageNum :>" + page);
    }

    public void checkCurrentPage() {
        System.out.println("CurrentPage is " + this.currentPage);
    }


    public boolean canBack() {
        return this.backStack.size > 0;
    }

    public boolean canForward() {
        return this.forwardStack.size > 0;
    }


    //基于链表实现栈
    public static class LinkedListBaseStack {
        //栈大小
        private int size;
        //
        private Node top;

        //创建节点
        static Node createNode(String data, Node next) {
            return new Node(data, next);
        }

        //清除
        public void clear() {
            this.top = null;
            this.size = 0;
        }

        //入队
        public void push(String data) {
            Node node = createNode(data, this.top);
            this.top = node;
            this.size++;
        }

        //出栈
        public String pop() {
            Node topNode = this.top;
            if (topNode == null) {
                System.err.println("The stack is empty");
                return null;
            }
            //把在顶层要出栈元素的next赋值 top，也就是说，它的下一个元素是现在的top
            this.top = topNode.next;
            if (this.size > 0) {
                //元素个数减1
                this.size--;
            }
            //返回出栈的元素
            return topNode.data;
        }

        //size
        public int size() {
            return this.size;
        }

        //getTopData
        public String getTopData() {
            return this.top.data;
        }

        public void print() {
            System.out.println("Print stack");
            Node currentNode = this.top;
            while (currentNode != null) {
                String data = currentNode.data;
                System.out.println(data + "\t");
                currentNode = currentNode.next;
            }
            System.out.println();
        }


    }

    //数据节点
    public static class Node {
        private String data;
        private Node next;

        public Node(String data) {
            this(data, null);
        }

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
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
