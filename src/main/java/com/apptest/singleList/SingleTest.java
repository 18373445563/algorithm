package com.apptest.singleList;

public class SingleTest {
    public static void main(String[] args) {
        SingleLinked<String> list=new SingleLinked<String>();
        list.addFirst("5");
        list.lastAdd("6");
        list.lastAdd("7");
        list.reverseList();
        //list.findFirst();
        //list.findLast();
        //list.findByIndex(2);
        list.printList();
        //list.deleteFirst();
        //list.someAddData("6",list.getSize()-1);
    }
}
