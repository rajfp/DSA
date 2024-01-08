package strings;

/*
Given an integer n, your task is to complete the function convertToRoman which prints the corresponding roman number of n. Various symbols and their values are given below
Note:- There are a few exceptions for some numbers like 4 in roman is IV,9 in roman is IX, similarly, 40 is XL while 90 is XC. Similarly, 400 is CD while 900 is CM

I 1
V 5
X 10
L 50
C 100
D 500
M 1000



Example 1:

Input:
n = 5
Output: V


Example 2:

Input:
n = 3
Output: III


Your Task:
Complete the function convertToRoman() which takes an integer N as input parameter and returns the equivalent roman.



Expected Time Complexity: O(log10N)
Expected Auxiliary Space: O(log10N * 10)


 */
public class ConvertToRoman {
    public static void main(String[] args) {
        convertToRoman(3549);
    }
    private static void convertToRoman(int n) {
        char[] c = new char[10001];
        int i = 0;
        while (n != 0) {
            if (n >= 1000) {
                i = digit('M', n / 1000, c, i);
                n = n % 1000;
            } else if (n >= 500) {
                if (n < 900) {
                    i = digit('D', n / 500, c, i);
                    n = n % 500;
                } else {
                    i = subDigit('C', 'M', c, i);
                    n = n % 100;
                }
            } else if (n >= 100) {
                if (n < 400) {
                    i = digit('C', n / 100, c, i);
                    n = n % 100;
                } else {
                    i = subDigit('C', 'D', c, i);
                    n = n % 100;
                }
            } else if (n >= 50) {
                if (n < 90) {
                    i = digit('L', n / 50, c, i);
                    n = n % 50;
                } else {
                    i = subDigit('X', 'C', c, i);
                    n = n % 10;
                }
            } else if (n >= 10) {
                if (n < 40) {
                    i = digit('X', n / 10, c, i);
                } else {
                    i = subDigit('X', 'L', c, i);
                }
                n = n % 10;
            } else if (n >= 5) {
                if (n < 9) {
                    i = digit('V', n / 5, c, i);
                    n = n % 5;
                } else {
                    i = subDigit('I', 'X', c, i);
                    n = 0;
                }
            }
            else if (n >= 1) {
                if (n < 4) {
                    i = digit('I', n, c, i);
                } else {
                    i = subDigit('I', 'V', c, i);
                }
                n = 0;
            }
        }
        System.out.printf("Roman numeral is: ");
        for (int j = 0; j < i; j++) {
            System.out.printf("%c", c[j]);
        }
    }

    private static int digit(char c, int size, char[] a, int i) {
        for (int j=0;j<size;j++){
            a[i++] = c;
        }
        return i;
    }

    private static int subDigit(char c, char d, char[] a, int i) {
        a[i++] = c;
        a[i++] = d;
        return i;
    }

}
