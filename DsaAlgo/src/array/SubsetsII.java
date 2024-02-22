package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an integer array nums that may contain duplicates, return all possible
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.



Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]



 */
public class SubsetsII {
    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[]{1, 2, 2}));
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        subsets(nums, new ArrayList<>(), list, 0);
        return list;
    }

    public static void subsets(int[] nums, ArrayList<Integer> curr, List<List<Integer>> list, int idx) {
        list.add(new ArrayList<>(curr));
        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i - 1]) continue;
            curr.add(nums[i]);
            subsets(nums, curr, list, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}
