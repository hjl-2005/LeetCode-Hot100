package com.leetcode.twopointers;

/**
 * 动态规划
 * <pre>{@code
 * int length = height.length;
 *         int[] leftMax=new int[length];
 *         int[] rightMax=new int[length];
 *         int res = 0;
 *
 *         //动态规划得到每个柱子左侧的最大高度
 *         leftMax[0]=height[0];
 *         for (int i = 1; i < length; i++) {
 *             leftMax[i]=Math.max(leftMax[i - 1], height[i]);
 *         }
 *         //动态规划得到每个柱子右侧的最大高度
 *         rightMax[length-1]=height[length-1];
 *         for (int i = length - 2; i >= 0; i--) {
 *             rightMax[i]=Math.max(rightMax[i + 1], height[i]);
 *         }
 *         //遍历每个节点得到总雨水量
 *         for (int i = 0; i < length; i++) {
 *             res+=Math.min(leftMax[i], rightMax[i]) - height[i];
 *         }
 *         return res;
 * }</pre>
 *
 */
public class LeetCode42 {
    /**
     *<p>
     *      这里有个逻辑是：如果 height[left]&lt;height[right]，则必有 leftMax&lt;rightMax，反之也一样<br>
     *      那么为什么呢：关键在于，每次比较 height[left]和 height[right]，只会移动值较小一侧的指针，所以逻辑是一直成立的
     *</p>
     */
    public int trap(int[] height) {
        int length = height.length;
        int left=0,right= length -1;
        int leftMax = 0, rightMax = 0;
        int res = 0;
        while(left<right){
            leftMax=Math.max(leftMax, height[left]);
            rightMax=Math.max(rightMax, height[right]);
            if(height[left]<height[right]){
                res+=leftMax-height[left];
                left++;
            }
            else{
                res+=rightMax-height[right];
                right--;
            }
        }
        return res;
    }
}
