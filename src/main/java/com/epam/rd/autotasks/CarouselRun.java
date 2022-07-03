package com.epam.rd.autotasks;

import java.util.Arrays;

public class CarouselRun {
    private final int[] arr;
    private int i = 0, j=0;
    private int sum = 0;
    private final int flag;
    private int decrement=1;
    private int limit;

    public CarouselRun(int[] arr) {
        this.arr = Arrays.copyOf(arr,arr.length);
        flag=0;
        for (int elem:arr) {
            sum+=elem;
        }
    }

    public CarouselRun(int[] arr, int flag) {
        this.arr = Arrays.copyOf(arr, arr.length);
        this.flag = flag;
        for (int elem : arr) {
            sum += elem;
        }
    }

    public CarouselRun(int[] arr, int flag, int limit) {
        this.arr = Arrays.copyOf(arr, arr.length);
        this.flag = flag;
        this.limit = limit;
        for (int elem: arr){
            sum+=elem;
        }
    }
    //    public CarouselRun(int[] arr, int counter, int halve) throws UnsupportedOperationException {
//        this.arr = Arrays.copyOf(arr, arr.length);
//        i = counter;
//        flag = halve;
//        for (int elem : arr) {
//            sum += elem;
//        }
//    }

    public int next() {
        int tempElem;
        if (isFinished()) {     //container is empty
            return -1;
        }
        if (i == arr.length) {
            i = 0;
            decrement++;
        }
        while (arr[i] <= 0) {
            i++;
            if (i == arr.length) {
                i = 0;
                decrement++;
            }
        }
        if (flag == 0) {
            sum--;
            return arr[i++]--;
        } else  if (flag==1) {
            tempElem = arr[i];
            arr[i] /= 2;
            sum = sum - arr[i] - tempElem % 2;
            i++;
            return tempElem;
        } else if (flag==2) {
            tempElem=arr[i];
            arr[i]-=decrement;
            i++;
            return tempElem;
        } else {
            sum--;
            j++;
            return arr[i++]--;
        }
    }

    public boolean isFinished() {
        if (flag == 2) {
            for (int elem : arr) {
                if (elem>0) {
                return false;
            }
        }
        return true;
    } else if (flag==3&&j==limit) {
            return true;
        } else {
            return sum == 0;
        }
    }
}



