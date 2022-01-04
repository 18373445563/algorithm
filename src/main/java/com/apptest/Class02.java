package com.apptest;

import static com.apptest.util.randomArray;

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
     *             7、有序数组中找到大于等于某个数的最左侧位置
     */

    public static void main(String[] args) {
        int[] arr = {3, 45, 1, 3, 5, 7, 2, 3, 4, 1, 0};
        int[] orderArr = {1, 2, 3, 3, 5, 7};
        int[] miniArr = {2, 1, 4, 6, 5, 4};
        int[] smallArr = {1, 3, 2, 4};
        //int[] smallArr = {1, 3, 2};
//        int[] smallArr = {1, 3, 2,4};
        //int[] arr = {1,2,3,2};
//        int[] arrR = {4};
//----------------------------------------------------
        // int[] res=merge(arr,0,1,2);
//----------------------------------------------------
        //int max=findMax(arr,0,arr.length-1);
        //System.out.println(max);
//---------------------------------------------------
//        int[] res=mergeSort(arr,0,arr.length-1);
//        for (int i = 0; i <res.length ; i++) {
//            System.out.println(res[i]);
//        }
//---------------------------------------------------
//          int i= orderlyLookLeft(orderArr,8,0,orderArr.length-1);
//          System.out.println(i);
//---------------------------------------------------
//局部最小
//        localMini(miniArr,0,miniArr.length-1)
// ---------------------------------------------------
//求小和（一个数左边比它小的数的和）
//        int smaSum = smallSum(smallArr, 0, smallArr.length - 1);
//        System.out.println(smaSum);
    }

    //两个数对大小
    public static int getMax(int a, int b) {
        if (a - b > 0) {
            return a;
        } else {
            return b;
        }
    }

    //递归求最大值
    public static int findMax(int[] arr, int L, int R) {
        int res = 0;
        if (arr.length < 2) {
            return arr[0];
        }
        if (L == R) {
            return arr[L];
        }
        //求中点
        int M = L + ((R - L) >> 1);
        int LMax = findMax(arr, L, M);
        int RMax = findMax(arr, M + 1, R);
        res = getMax(LMax, RMax);
        return res;
    }

    //归并排序
    public static int[] mergeSort(int[] arr, int l, int r) {
        if (arr.length < 2) {
            return arr;
        }
        if (l == r) {
            return arr;
        }
        int m = l + ((r - l) >> 1);
        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);
        merge(arr, l, m, r);
        return arr;

    }

    //有序找大于等于某个数的最左侧位置
    public static int orderlyLookLeft(int[] arr, int num, int l, int r) {
        //取中点
        if (arr.length == 1) {
            return 0;
        }
        int m = l + ((r - l) >> 1);
        //二分到死
        if (l == r) {
            return l;
        }
        if (arr[m] < num) {
            return orderlyLookLeft(arr, num, m + 1, r);
        } else {
            return orderlyLookLeft(arr, num, l, m);
        }
    }

    //求局部最小,无序相邻的数一定不相等，求一个局部最小的位置
    public static void localMini(int[] arr, int l, int r) {
        //判断首尾是否满足要求
        if (arr[l] < arr[l + 1]) {
            System.out.println(l);
            return;
        }
        if (arr[r - 1] < arr[r]) {
            System.out.println(r - 1);
            return;
        }
        //取中点二分判断左右两边
        int m = l + ((r - l) >> 1);
        localMini(arr, l, m);

    }

    //小和
    public static int smallSum(int[] arr, int l, int r) {
        //改版的归并排序
        // 获取中点
        int m = l + ((r - l) >> 1);
        if (l == r) {
            return 0;
        }
        //左边
        smallSum(arr, l, m);
        //右边
        smallSum(arr, m + 1, r);
        //求和
        //System.out.println("参数："+l+":"+m+":"+r);
        return mergeSum(arr, l, m, r);

    }

    //merge
    public static void merge(int[] arr, int l, int m, int r) {
        int oldL = l;
        int index = 0;
        int indexR = m + 1;
        int[] help = new int[r - l + 1];
        //左边merge右边
        while (l <= m && indexR <= r) {
            help[index++] = arr[l] <= arr[indexR] ? arr[l++] : arr[indexR++];
        }
        while (l <= m) {
            help[index++] = arr[l++];
        }
        while (indexR <= r) {
            help[index++] = arr[indexR++];
        }
        // 把新数组中的数覆盖nums数组
        for (int x = 0; x < help.length; x++) {
            arr[x + oldL] = help[x];
        }


    }

    //mergeSum
    public static int mergeSum(int[] arr, int l, int m, int r) {
        int sum = 0;
        int oldL = l;
        int index = 0;
        int indexR = m + 1;
        int[] help = new int[r - l + 1];
        //左边merge右边
        while (l <= m && indexR <= r) {
//            help[index++] = arr[l] < arr[indexR] ? arr[l++] : arr[indexR++];
//            sum=sum+(r-indexR)*arr[l];
            if (arr[l] < arr[indexR]) {
                sum = sum + (r - l) * arr[l];
                help[index++] = arr[l++];
            } else {
                help[index++] = arr[indexR++];
            }

        }
        while (l <= m) {
            help[index++] = arr[l++];
        }
        while (indexR <= r) {
            help[index++] = arr[indexR++];
        }
        // 把新数组中的数覆盖nums数组
        for (int x = 0; x < help.length; x++) {
            arr[x + oldL] = help[x];
        }
        return sum;
    }

}

//递归函数Master公式：T（N）=a*T(N/b)+O(N^d）
//·利用Master公式求时间复杂度
//        logb^a<d :O(N^d)
//        logb^a>d:O(N^logb^a)
//        logb^a=d:O(N^d*logN)

