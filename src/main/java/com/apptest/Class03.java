package com.apptest;

/**
 *
 */
public class Class03 {
    /**
     * @param args 1、一个数组和num 将小于放在左边，大于等于放在右边 时间复杂度N，空间复杂1
     *             2、荷兰国旗问题分为小于、等于、大于
     *             3、快排1.0 （将小于放在左边，确认最后一位）
     *             4、快排2.0
     *             5、快排3.0(随机队尾)
     */
    private static int[] arr = {3,2, 1,2, 7, 5,5};
    private static int[] arrFlag = {1,3,2,4,3,7};
    //private static int[] arrFlag = {1,3,2,3};
    public static void main(String[] args) {
//--------------------------------------------------------------
//        partitionArr(6);
//        for (int i = 0; i <arr.length ; i++) {
//            System.out.println(arr[i]);
//        }
// --------------------------------------------------------------
//        dutchFlag(arrFlag,3);
//        for (int i = 0; i <arrFlag.length ; i++) {
//            System.out.println(arrFlag[i]);
//        }
// --------------------------------------------------------------
        //快排1.0
//        fastQueue1(arr,0,arr.length-1);
//        for (int i = 0; i <arr.length ; i++) {
//            System.out.println(arr[i]);
//        }
//-------------------------------------------------------------
        //快排2.0使用荷兰国旗解决
//        fastQueue2(arr,0,arr.length-1);
//        for (int i = 0; i <arr.length ; i++) {
//            System.out.println(arr[i]);
//        }
//------------------------------------------------------
        //快排3.0,由于1.0，2.0都是取最后一位，容易受原始数据影响
        //3.0采用随机选取值的方式，看概率，理论上是N*logN
        fastQueue3(arr,0,arr.length-1);
        for (int i = 0; i <arr.length ; i++) {
            System.out.println(arr[i]);
        }
    }

    //数据分区
    public static void partitionArr( int num) {
        int index=0;
        //主要是指针操作
        for (int j = 0; j <arr.length; j++) {
            if(arr[j]<num){
                 swap(arr,index,j);
                 index=index+1;
            }
        }
    }


    //两个数交换
    public static void swap(int[] arr,int i,int j) {
        if(i==j){
           return;
        }
       int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    //荷兰国旗问题
    public static void dutchFlag(int[] arr,int num) {
        int begin=0;
        int end=arr.length-1;
        int i=0;
        while (i <=end ) {
            if(arr[i]<num){
                swap(arr,begin,i);
                begin++;
                i++;
            }else if(arr[i]>num){
                swap(arr,end,i);
                end--;
            }else {
                i++;
            }
        }
    }

    //快排1.0
    public static void fastQueue1(int[] arr,int l,int r) {
        if(l==r){
            return;
        }
        int index= sortHelp(arr,l,r);
        if(l==index){
            return;
        }
        if(r==index){
            return;
        }
        fastQueue1(arr,l,index-1);
        fastQueue1(arr,index+1,r);
    }

    //快排2.0
    public static void fastQueue2(int[] arr,int l,int r) {
        if(l==r){
            return;
        }

        int[] Index= sortHelp2(arr,l,r);
        if(l==Index[0]){
            return;
        }
        if(r==Index[1]){
            return;
        }
        fastQueue1(arr,l,Index[0]-1);
        fastQueue1(arr,Index[1]-1,r);
    }

    //快排2.0
    public static void fastQueue3(int[] arr,int l,int r) {
        if(l==r){
            return;
        }

        int[] Index= sortHelp3(arr,l,r);
        if(l==Index[0]){
            return;
        }
        if(r==Index[1]){
            return;
        }
        fastQueue1(arr,l,Index[0]-1);
        fastQueue1(arr,Index[1]-1,r);
    }


    //数据分区
    public static int sortHelp(int[] arr,int l,int r) {
        if(l==r){
            return l;
        }
        int index=l;
        int num=arr[r];
        //主要是指针操作
        for (int j = l; j <r+1; j++) {
            if(arr[j]<num){
                swap(arr,index,j);
                index=index+1;
            }
        }
        swap(arr,index,r);
        return index;
    }
    //2.0荷兰国旗
    public static int[] sortHelp2(int[] arr,int l,int r) {
        int num=arr[r];
        int[] res=new int[2];
        int begin=l;
        int end=arr.length-1;
        int i=0;
        while (i <=end ) {
            if(arr[i]<num){
                swap(arr,begin,i);
                begin++;
                i++;
            }else if(arr[i]>num){
                swap(arr,end,i);
                end--;
            }else {
                i++;
            }
        }
        res[0]= begin;
        res[1]=end;
        return res;
    }
    //3.0荷兰国旗
    public static int[] sortHelp3(int[] arr,int l,int r) {
        int rand=(int)(Math.random()*(r-l));
        int num=arr[rand];
        int[] res=new int[2];
        int begin=l;
        int end=arr.length-1;
        int i=0;
        while (i <=end ) {
            if(arr[i]<num){
                swap(arr,begin,i);
                begin++;
                i++;
            }else if(arr[i]>num){
                swap(arr,end,i);
                end--;
            }else {
                i++;
            }
        }
        res[0]= begin;
        res[1]=end;
        return res;
    }


    public static int sortHelpRight(int[] arr,int l,int r) {
        int num=arr[r];
        int begin=l;
        int end=arr.length-1;
        int i=0;
        while (i <=end ) {
            if(arr[i]<num){
                swap(arr,begin,i);
                begin++;
                i++;
            }else if(arr[i]>num){
                swap(arr,end,i);
                end--;
            }else {
                i++;
            }
        }
        return i;
    }






}

