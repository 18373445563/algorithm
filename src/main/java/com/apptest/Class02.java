package com.apptest;

/**
 *
 */
public class Class02 {
    /**
     * @param args 1、递归二分求最大
     *             2、归并排序
     *             3、随机生成器
     *             4、局部最小(左右数据不能)
     *             5、有序对
     *             6、局部求和
     */

    public static void main(String[] args) {

        int[] arr = {3, 45, 1, 3, 5, 7, 2, 3, 4, 1, 0};
        int max=findMax(arr,0,arr.length-1);
        System.out.println(max);
    }

    //普通求最大时间复杂度为N  二分为log2N
    public static int findMax(int[] arr, int L, int R) {
        int res = 0;
//        if (arr.length < 2) {
//            return arr[0];
//        }
        if(L==R){
            return arr[L];
        }
        //求中点
        int M = L + (R - L) >> 1;
        int LMax = findMax(arr, L, M);
        int RMax = findMax(arr, M + 1, R);
        res=getMax(LMax,RMax);
        return res;
    }

    //两个数对大小
    public static int getMax(int a, int b) {
        if (a - b > 0) {
            return a;
        } else {
            return b;
        }
    }

}

