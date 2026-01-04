package com.leetcode.twopointers;

public class LeetCode11 {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea  =0;
        
        while(left<right){
            int currentArea =Math.min(height[left],height[right]) * (right - left);
            maxArea =Math.max(maxArea ,currentArea );
            
            if(height[left]<=height[right]){
                int originalHeight = height[left];
                //直接跳过无效高度的指针移动
                do {
                    left++;
                } while (left < right && height[left] <= originalHeight);
            }
            else{
                int originalHeight = height[right];
                do {
                    right--;
                } while (left < right && height[right] <= originalHeight);
            }
        }
        return maxArea ;
    }
}
