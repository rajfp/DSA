package strings;

/*
Given two strings 'str1' and 'str2', check if these two strings are isomorphic to each other.

If the characters in str1 can be changed to get str2, then two strings, str1 and str2, are isomorphic. A character must be completely swapped out for another character while maintaining the order of the characters. A character may map to itself, but no two characters may map to the same character.

Example 1:

Input:
str1 = aab
str2 = xxy
Output:
1
Explanation:
There are two different characters in aab and xxy, i.e a and b with frequency 2 and 1 respectively.
Example 2:

Input:
str1 = aab
str2 = xyz
Output:
0
Explanation:
There are two different characters in aab but there are three different charactersin xyz. So there won't be one to one mapping between str1 and str2.
Your Task:
You don't need to read input or print anything.Your task is to complete the function areIsomorphic() which takes the string str1 and string str2 as input parameter and  check if two strings are isomorphic. The function returns true if strings are isomorphic else it returns false.

Expected Time Complexity: O(|str1|+|str2|).
Expected Auxiliary Space: O(Number of different characters).
Note: |s| represents the length of string s.
 */
public class IsomorphicStrings {
    public static void main(String[] args) {
        System.out.println(areIsomorphic("aab", "xyz"));
    }

    public static boolean areIsomorphic(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;
        int[] a = new int[256];
        int[] b = new int[256];
        for (int i = 0; i < str1.length(); i++) {
            if (a[str1.charAt(i)] == 0 && b[str2.charAt(i)] == 0) {
                a[str1.charAt(i)] = str2.charAt(i);
                b[str2.charAt(i)] = str1.charAt(i);
            } else {
                if ((a[str1.charAt(i)] != 0 && a[str1.charAt(i)] != str2.charAt(i))
                        ||(b[str2.charAt(i)] != 0 && b[str2.charAt(i)] != str1.charAt(i)))
                    return false;
            }
        }
        return true;
    }
}
/*
public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                if(map.get(s.charAt(i))!= t.charAt(i))
                return false;
            }
            else{
                if(map.containsValue(t.charAt(i)))
                    return false;
                map.put(s.charAt(i),t.charAt(i));
            }
        }
        return true;
    }
 */
