package array;

/*
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.



Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2

 */
public class MajorityElement {
    //Assuming majority element always exists in array. Otherwise we have to run one more loop to check whether the
    // candidate is majority element
    public int majorityElement(int[] a) {
        int count = 1, res = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[res] == a[i])
                count++;
            else
                count--;
            if (count == 0) {
                res = i;
                count = 1;
            }
        }
        return a[res];
    }
}
