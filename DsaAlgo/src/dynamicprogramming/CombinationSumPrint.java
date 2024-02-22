package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
frequency
 of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.



Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:

Input: candidates = [2], target = 1
Output: []
 */
public class CombinationSumPrint {
    //    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//
//    }
    public static void main(String[] args) {
        int[] a = new int[]{7, 2, 6, 5};
        Arrays.sort(a);
        int target = 16;
        int[][] dp = new int[a.length + 1][target + 1];
        List<List<Integer>> list = new ArrayList<>();
        for (int[] x : dp) {
            Arrays.fill(x, -1);
        }

        System.out.println(combinationSum(new ArrayList<>(), target));
    }

    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Collections.sort(a);
        combinationSum(0, a, b, new ArrayList<>(), list);
        return list;
    }

    public static void combinationSum(int start, ArrayList<Integer> candidates, int target, List<Integer> curr, ArrayList<ArrayList<Integer>> list) {
        if (target == 0) {
            list.add(new ArrayList<>(curr));
            return;
        }
        if (target < 0)
            return;
        for (int i = start; i < candidates.size(); i++) {
            if (i > start && (candidates.get(i) == candidates.get(i - 1))) continue;
            curr.add(candidates.get(i));
            combinationSum(i, candidates, target - candidates.get(i), curr, list);
            curr.remove(curr.size() - 1);
        }
    }
}
