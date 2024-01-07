package strings;

/*
Given two strings of lowercase alphabets and a value K, your task is to complete the given function which tells if  two strings are K-anagrams of each other or not.

Two strings are called K-anagrams if both of the below conditions are true.
1. Both have same number of characters.
2. Two strings can become anagram by changing at most K characters in a string.

Example:

Input:
str1 = "fodr", str2="gork"
k = 2
Output:
1
Explanation: Can change fd to gk
Your Task:
Since this is a function problem, you don't need to take any input. Just complete the given function areKAnagrams that returns true if the strings can be turned into K-anagrams, else return false.
 */
public class AreKAnagrams {
    public static void main(String[] args) {
        System.out.println(areKAnagrams("mijpllztvx", "wlwtvvqwfn", 6));
    }

    static boolean areKAnagrams(String s1, String s2, int k) {
        if (s1.length() != s2.length())
            return false;
        int[] a = new int[26];
        int[] b = new int[26];
        int sum = 0;
        for (int i = 0; i < s1.length(); i++) {
            a[s1.charAt(i) - 'a']++;
            b[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if(a[i]>b[i])
                sum+=(a[i]-b[i]);
        }
        return (sum <= k);
    }
}
