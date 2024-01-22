package sorting;

import java.util.ArrayList;
import java.util.List;

/*
Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.



Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]
Example 2:

Input: nums = [1,1]
Output: [2]


Constraints:

n == nums.length
1 <= n <= 105
1 <= nums[i] <= n

 */
public class FindAllNumbersDisappearedInAnArray {
    public static void main(String[] args) {
        System.out.println(findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }

    static public List<Integer> findDisappearedNumbers(int[] a) {
        int i = 0;
        List<Integer> list = new ArrayList<>();
        while (i < a.length) {
            if (a[i] != (i + 1) && (a[i] != a[a[i] - 1])) {
                int t = a[i];
                a[i] = a[a[i] - 1];
                a[t - 1] = t;
            } else
                i++;
        }
        for (int j = 0; j < a.length; j++) {
            if (a[j] != (j + 1))
                list.add(j + 1);
        }
        return list;
    }
}
