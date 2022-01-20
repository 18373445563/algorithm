package com.apptest.singleList;

/**
 * @param <T>
 * 链表实现
 */
public class SingleLinked<T> {
    //头节点
    private Node head;
    //链表长度
    private int size;
    //定义链表结构
    private class Node{
        private T value;
        //Node 引用类型，代表下一个元素引用地址
        private Node next;
        //构造函数
        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }
        public Node(T value) {
           this(value,null);
        }

    }
    public SingleLinked() {
        this.head = null;
        this.size = 0;
    }

    //指定位置增加数据
    public void someAddData(T t,int index){
        //定义节点
        Node node=new Node(t);
        //寻找index的前一个节点，使其next指向当前节点，当前节点的next指向前一个节点的next

        // 通过index查找前一个节点
        Node previousNode=this.head;
        for (int i = 0; i <index-1 ; i++) {
            previousNode=previousNode.next;
        }

        node.next=previousNode.next;

        previousNode.next=node;

        //链表长度加1
        this.size++;
    }

    //向头部插入
    public void addFirst(T t){
        //定义节点
        Node node=new Node(t);
        //当前节点的下一个节点指向上一次头节点
        node.next=this.head;
        //更新头节点位置
        this.head=node;
        //链表长度加1
        this.size++;
    }

    //向尾部插入
    public void lastAdd(T t){

        this.someAddData(t,size);
//        //定义节点
//        Node node=new Node(t);
//        //寻找尾节点
//       // 通过size和头节点找吗
//        Node lastNode=this.head;
//        for (int i = 0; i <size-1 ; i++) {
//            lastNode=lastNode.next;
//        }
//        //尾节点的next指向当前节点
//        lastNode.next=node;
//        //链表长度加1
//        this.size++;
    }



    //指定位置删除数据
    public void delSomeIndex(int index){
        //获取头节点遍历到index前一个节点，让前一个节点的指针指向下一个节点的下一个位置
        Node previousNode=this.head;
        for (int i = 0; i <index-1 ; i++) {
            previousNode=previousNode.next;
        }
        previousNode.next=previousNode.next.next;
        //链表长度减1
        this.size--;
    }


    //删除头部
    public void delFirst(){
        //删除当前头节点，将头节点的next作为新头
        this.head=this.head.next;
        //链表长度减1
        this.size--;
    }

    //删除尾部
    public void delLast(){
        this.delSomeIndex(size);
    }

    //查询指定位置数据
    public T findByIndex(int index){
        Node node=this.head;
        for (int i = 0; i <index-1 ; i++) {
            node=node.next;
        }
        System.out.println(node.next.value);
        return node.next.value;
    }

    //获取链表第一个
    public T findFirst(){
        System.out.println(this.head.value);
        return this.head.value;
    }

    //获取链表最后一个
    public T findLast(){
        return findByIndex(size-1);
    }

    //打印链表数据
    public void printList(){
        Node node= this.head;
        for (int i = 0; i <size ; i++) {
            System.out.println(node.value);
            node=node.next;
        }
    }


    //单链表逆序要求时间复杂度O(N)空间复杂度（1）
    public void reverseList(){
        Node p;
        Node temp=head.next;
        head.next=null;
        while (temp!=null){
            p=temp;
            temp=p.next;
            p.next=head;
            head=p;

        }

    }

    //获取List 长度
    public int getSize(){
      return this.size;
    }


}
