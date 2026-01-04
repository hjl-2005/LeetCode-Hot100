package com.leetcode.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 优化思路:<br>
 * 1.在第一个元素>0时，提前停止
 * <pre>{@code
 * //调前剪枝
 * if (nums[first] > 0) {
 *     return res; // 或者 break; 因为后面不可能有解了
 * }
 * }
 * </pre>
 * 2.增加更积极的剪枝条件
 * <p>
 * 最小和剪枝：如果当前固定的数加上它后面两个最小的数（即 nums[first+1]和 nums[first+2]）之和已经大于0，那么对于这个 first以及之后更大的 first，三数之和都只会更大，因此可以提前终止整个循环。<br>
 * 最大和剪枝：如果当前固定的数加上数组末尾两个最大的数（即 nums[n-2]和 nums[n-1]）之和仍然小于0，说明这个数太小了，即使配上最大的两个数也无法达到0，应该跳过当前 first，继续检查下一个更大的数。
 * </p>
 * <pre>{@code
 * // 优化1: 最小和剪枝
 * if (first < length - 2 && nums[first] + nums[first+1] + nums[first+2] > 0) {
 *     break;
 * }
 * // 优化2: 最大和剪枝
 * if (first < length - 2 && nums[first] + nums[length-2] + nums[length-1] < 0) {
 *     continue;
 * }
 * }
 * </pre>
 *
 */
public class LeetCode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        //第一层遍历
        for (int first = 0; first < length; first++) {
            //跳过相同元素,但第一个不跳
            if (first != 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int third = length - 1;
            int target = -nums[first];
            //第二层遍历
            for (int second = first + 1; second < length; second++) {
                //跳过相同元素，但是第一个不跳过
                if (second != first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                //第三层遍历
                while (second < third && nums[second] + nums[third] > target) {
                    third--;
                }
                if (second >= third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    res.add(Arrays.asList(nums[first], nums[second], nums[third]));
                }
            }
        }
        return res;
    }
}
