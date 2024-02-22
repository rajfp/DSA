package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.



Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output:
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output:
[
[1,2,2],
[5]
]

 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(0, candidates, target, new ArrayList<>(), list);
        return list;
    }

    public static void combinationSum(int start, int[] candidates, int target, List<Integer> curr, List<List<Integer>> list) {
        if (target == 0) {
            list.add(new ArrayList<>(curr));
            return;
        }
        if (target < 0)
            return;
        for (int i = start; i < candidates.length; i++) {
            if (i > start && (candidates[i] == candidates[i - 1])) continue;
            curr.add(candidates[i]);
            combinationSum(i + 1, candidates, target - candidates[i], curr, list);
            curr.remove(curr.size() - 1);
        }
    }
}
