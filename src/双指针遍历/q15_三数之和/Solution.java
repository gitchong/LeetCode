package 双指针遍历.q15_三数之和;

import java.util.*;
import java.util.stream.IntStream;

/**
 * 数组遍历 + 双指针遍历 o(n^2)
 */
class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rs = new ArrayList<>();

        if (nums.length < 3) {
            return rs;
        }

        Arrays.sort(nums);
        if (nums[0] > 0) {
            return rs;
        }

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    rs.add(temp);
                    // 去除左边重复
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // 去除右边重复
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        int[] nums = IntStream.range(-5, 5).toArray();
        List<List<Integer>> lists = threeSum(nums);
        lists.stream().forEach(x -> System.out.println(x));
    }
}
