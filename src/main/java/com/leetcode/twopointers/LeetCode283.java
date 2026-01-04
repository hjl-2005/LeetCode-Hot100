package com.leetcode.twopointers;

public class LeetCode283 {
    public void moveZeroes(int[] nums) {
        int size=nums.length,left=0,right=0;
        while(right<size){
            if(nums[right]!=0){
                int temp=nums[right];
                nums[right]=nums[left];
                nums[left]=temp;
                left++;
            }
            right++;
        }
    }
}
