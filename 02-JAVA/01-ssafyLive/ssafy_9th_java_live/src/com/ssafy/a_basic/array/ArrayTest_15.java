package com.ssafy.a_basic.array;

import java.util.Arrays;

public class ArrayTest_15 {
    public static void main(String[] args) {
        int[] nums = {7,2,3,4};
        int[][][] nums2 = new int[2][3][2];
        nums2[0] = nums; 
        
        System.out.print(Arrays.deepToString(nums2));
    }
}
