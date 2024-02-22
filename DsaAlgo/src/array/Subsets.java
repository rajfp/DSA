package array;

import java.util.ArrayList;
import java.util.List;

/*
Given an integer array nums of unique elements, return all possible
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.



Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]


Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.
 */
public class Subsets {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        subsets(new int[]{1, 2, 3}, new ArrayList<>(), list, 0);
        System.out.println(list);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());

        for (int num : nums) {
            int res = list.size();
            for (int i = 0; i < res; i++) {
                List<Integer> l = new ArrayList<>(list.get(i));
                l.add(num);
                list.add(l);
            }
        }
        return list;
    }

    //**BACKTRACKING**
    public static void subsets(int[] nums, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> list, int idx) {
        list.add(new ArrayList<>(curr));
        for (int i = idx; i < nums.length; i++) {
            curr.add(nums[i]);
            subsets(nums, curr, list, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}
