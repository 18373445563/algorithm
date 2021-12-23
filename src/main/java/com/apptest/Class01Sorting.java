package com.apptest;

/**
 *
 */
public class Class01Sorting {

    public static void main(String[] args) {
        int[] oddNum={1,1,2,2,3,3,3,3,4};

        int[] twoNum={1,1,2,2,3,3,3,3,4,5};

        int[] arr={3,45,1,3,5,7,2,3,4,1,0};
        //int[] arr={3,45,1,4};
        int[] swap={3,45};
        //奇数
        //System.out.println(oddNumber(oddNum));
        //两个数交换
        //swap(swap,0,1);
        //2个奇数
       // twoNumber(twoNum);
        //选择排序
       // selectSort(arr);
        //冒泡排序
        //bubbleSort(arr);
        //选择排序
        insertSort(arr);


    }
    //选择排序
    public static void selectSort(int[] arr){
        for (int i = 0; i <arr.length ; i++) {
            for (int j = i; j <arr.length-1 ; j++){
                if(arr[i]>arr[j+1]){
                    //位置交换
                    swap(arr,i,j+1);
                }
            }
        }
        for (int i = 0; i < arr.length ; i++) {
            System.out.println(arr[i]);
        }

    }

    //冒泡排序
    public static void bubbleSort(int[] arr){
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <arr.length-1-i ; j++){
                if(arr[j]>arr[j+1]){
                    //位置交换
                    swap(arr,j,j+1);
                }
            }
        }
        for (int i = 0; i < arr.length ; i++) {
            System.out.println(arr[i]);
        }
    }

    //插入排序时间复杂度与数组的有序程度有关，优于选择和冒泡
    public static void insertSort(int[] arr){
        for (int i = 0; i <arr.length-1 ; i++) {
            for(int j = i+1; j >0 ; j--){
                if(arr[j]<arr[j-1]){
                    //位置交换
                    swap(arr,j,j-1);
                }
            }
            
        }
        for (int i = 0; i < arr.length ; i++) {
            System.out.println(arr[i]);
        }
    }

    //找到一个数组出现奇数次
    public static int oddNumber(int[] arr){
        //异或
        int res=0;
        for (int i = 0; i < arr.length ; i++) {
            res=res^arr[i];
        }
        return res;
    }

    //找到两个数组出现奇数次
    public static void twoNumber(int[] arr){
        //异或获取a、b的值
        int a=0;
        int res=0;
        for (int i = 0; i < arr.length ; i++) {
            res=res^arr[i];
        }
        //获取右侧第一位为1的数，用于区分a、b
        int res1=res&(~res+1);
        for (int j = 0; j < arr.length ; j++) {
           if((arr[j]&res1)!=0){
               a=a^arr[j];
           }
        }
        int b=a^res;
        System.out.println(a+":"+b);

    }
    public static void swap(int[] arr,int i,int j){
        arr[i]=arr[i]^arr[j];
        arr[j]=arr[i]^arr[j];
        arr[i]=arr[i]^arr[j];
    }
}

