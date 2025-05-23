package stack;

import java.util.Stack;

/*
962. Maximum Width Ramp
Medium
Topics
Companies
A ramp in an integer array nums is a pair (i, j) for which i < j and nums[i] <= nums[j]. The width of such a ramp is j - i.

Given an integer array nums, return the maximum width of a ramp in nums. If there is no ramp in nums, return 0.



Example 1:

Input: nums = [6,0,8,2,1,5]
Output: 4
Explanation: The maximum width ramp is achieved at (i, j) = (1, 5): nums[1] = 0 and nums[5] = 5.
Example 2:

Input: nums = [9,8,1,0,1,9,4,0,4,1]
Output: 7
Explanation: The maximum width ramp is achieved at (i, j) = (2, 9): nums[2] = 1 and nums[9] = 1.


Constraints:

2 <= nums.length <= 5 * 104
0 <= nums[i] <= 5 * 104
 */
public class MaximumWidthRamp {
    static int maxWidthRamp(int[] ramps) {
        Stack<Integer> rampStack = new Stack();
        for (int i = 0; i < ramps.length; i++) {
            if (rampStack.isEmpty() || ramps[rampStack.peek()] >= ramps[i]) {
                rampStack.push(i);
            }
        }

        int j = ramps.length - 1;
        int maxLengthRamp = 0;
        while (j > 0) {
            while (!rampStack.isEmpty() && (ramps[j] >= ramps[rampStack.peek()])) {
                maxLengthRamp = Math.max(maxLengthRamp, j - rampStack.peek());
                rampStack.pop();
            }
            j--;
        }
        return maxLengthRamp;
    }

    public static void main(String[] args) {
        System.out.println(maxWidthRamp(new int[]{6,0,8,2,1,5}));
    }
}
//sol https://medium.com/@yashgirdhar/maximum-width-ramp-problem-b1687a40d0bf
//Time complexity : O(n)
