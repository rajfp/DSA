package matrix;

import java.util.ArrayList;

/*
Given a matrix of size r*c. Traverse the matrix in spiral form.

Example 1:

Input:
r = 4, c = 4
matrix[][] = {{1, 2, 3, 4},
           {5, 6, 7, 8},
           {9, 10, 11, 12},
           {13, 14, 15,16}}
Output:
1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
Explanation:

Example 2:

Input:
r = 3, c = 4
matrix[][] = {{1, 2, 3, 4},
           {5, 6, 7, 8},
           {9, 10, 11, 12}}
Output:
1 2 3 4 8 12 11 10 9 5 6 7
Explanation:
Applying same technique as shown above,
output for the 2nd testcase will be
1 2 3 4 8 12 11 10 9 5 6 7.

Your Task:
You dont need to read input or print anything. Complete the function spirallyTraverse() that takes matrix, r and c as input parameters and returns a list of integers denoting the spiral traversal of matrix.

Expected Time Complexity: O(r*c)
Expected Auxiliary Space: O(r*c), for returning the answer only.
 */
public class SpirallyTraverse {
    public static void main(String[] args) {
        int[][] a = new int[][]{
                {1, 2, 3}

        };
        System.out.println(spirallyTraverse(a, 1, 3));
    }

    static ArrayList<Integer> spirallyTraverse(int a[][], int r, int c) {
        ArrayList<Integer> list = new ArrayList<>();
        int start = 0;
        int j, k, l = 0, m;
        int end = c - 1;
        int top = 0;
        int bottom = r - 1;
        while (top <= bottom && start <= end) {

            for (j = start; j <= end; j++) {
                list.add(a[start][j]);
            }
            j--;
            for (k = top + 1; k <= bottom; k++) {
                list.add(a[k][j]);
            }
            k--;
            if (top != bottom) {
                for (l = j - 1; l >= start; l--) {
                    list.add(a[k][l]);
                }
                l++;
            }
            if (start != end) {
                for (m = k - 1; m > top; m--) {
                    list.add(a[m][l]);
                }
            }
            start++;
            end--;
            bottom--;
            top++;
        }
        return list;
    }
}
