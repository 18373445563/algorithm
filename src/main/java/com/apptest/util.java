package com.apptest;

public class util {

    //随机生成器
    public static int[] randomArray(int maxLength, int limitValue) {
//      int[] arr=new int[maxLength];
        //长度随机
        int length=(int)(maxLength*Math.random());
        int[] arr=new int[length];
        for (int i = 0; i <length ; i++) {
            arr[i]=(int) (limitValue*(Math.random()));
        }
        return arr;
    }

}
