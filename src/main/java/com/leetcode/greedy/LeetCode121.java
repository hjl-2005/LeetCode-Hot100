package com.leetcode.greedy;

/// [力扣题解](https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/solutions/136684/121-mai-mai-gu-piao-de-zui-jia-shi-ji-by-leetcode-/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode121 {
    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;

        for (int price : prices) {
            if (price < minprice) {
                minprice = price;
            }
            if (price - minprice > maxprofit) {
                maxprofit = price - minprice;
            }
        }
        return maxprofit;
    }
}
