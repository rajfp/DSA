package strings;

/*
Given two strings a and b. The task is to find if the string 'b' can be obtained by rotating (in any direction) string 'a' by exactly 2 places.

Example 1:

Input:
a = amazon
b = azonam
Output:
1
Explanation:
amazon can be rotated anti-clockwise by two places, which will make it as azonam.
Example 2:

Input:
a = geeksforgeeks
b = geeksgeeksfor
Output:
0
Explanation:
If we rotate geeksforgeeks by two place in any direction, we won't get geeksgeeksfor.
Your Task:
The task is to complete the function isRotated() which takes two strings as input parameters and checks if given strings can be formed by rotations. The function returns true if string 1 can be obtained by rotating string 2 by two places, else it returns false.

Expected Time Complexity: O(N).
Expected Auxilary Complexity: O(N).
Challenge: Try doing it in O(1) space complexity.
 */
public class CheckIfStringIsRotatedBy2Places {
    public static boolean isRotated(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        if (str1.length() == 1)
            return str1.charAt(0) == str2.charAt(0);
        return (checkIfLeftRotated(str1, str2) || checkIfRightRotated(str1, str2));
    }
    private static boolean checkIfLeftRotated(String str1, String str2) {
        int i = 2, j = 0;
        boolean flag = true;
        while (i < str1.length() && j < str2.length() - 2) {
            if (str1.charAt(i) == str2.charAt(j)) {
                i++;
                j++;
            } else {
                flag = false;
                break;
            }
        }
        return (str1.charAt(0) == str2.charAt(str2.length() - 2) &&
                str1.charAt(1) == str2.charAt(str2.length() - 1) && flag);

    }
    private static boolean checkIfRightRotated(String str1, String str2) {
        int i = 0, j = 2;
        boolean flag = true;
        while (i < str1.length() - 2 && j < str2.length()) {
            if (str1.charAt(i) == str2.charAt(j)) {
                i++;
                j++;
            } else {
                flag = false;
                break;
            }
        }
        return (str2.charAt(0) == str1.charAt(str1.length() - 2) &&
                str2.charAt(1) == str1.charAt(str1.length() - 1) && flag);
    }
}
/*
class GFG {
  //Method to check if string2 is obtained by string1
    static boolean isRotated(String str1, String str2)
    {
        int n = str1.length();
        int m = str2.length();
        if (n != m) //check both the string length equal or not
            return false;
        boolean clockwise = true;
        boolean anticlockwise = true;
      //check clockwise rotation is possible or not
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i)!= str2.charAt((i + 2) % n)) {
                clockwise = false;
                break;
            }
        }
      // check anticlockwise rotation is possible or not
        for (int i = 0; i < m; i++) {
            if (str1.charAt((i + 2) % n)!= str2.charAt(i)) {
                anticlockwise = false;
                break;
            }
        }
        return (clockwise || anticlockwise);
    }
    public static void main (String[] args) {
        String str1 = "geeks";
    String str2 = "eksge";

    System.out.println(isRotated(str1, str2) ? "Yes"
                                             : "No");
}
}
 */
