package matrix;

/*
Given a square matrix of size N x N. The task is to rotate it by 90 degrees in anti-clockwise direction without using any extra space.

Example 1:

Input:
N = 3
matrix[][] = {{1, 2, 3},
              {4, 5, 6}
              {7, 8, 9}}
Output:
Rotated Matrix:
3 6 9
2 5 8
1 4 7
Example 2:

Input:
N = 2
matrix[][] = {{1, 2},
              {3, 4}}
Output:
Rotated Matrix:
2 4
1 3

Your Task:
You dont need to read input or print anything. Complete the function rotateby90() which takes the matrix as input parameter and rotates it by 90 degrees in anti-clockwise direction without using any extra space. You have to modify the input matrix in-place.

Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(1)

 */
public class RotateMatrixAntiClockwise90 {

    public static void main(String[] args) {
        int[][] a = new int[][]{
                {
                        1, 2, 3
                },
                {
                        4, 5, 6
                },
                {
                        7, 8, 9
                }
        };

        for (int[] value : a) {
            reverse(value);
        }
        matrixRotate(a);


        for (int[] ints : a) {
            for (int j = 0; j < a.length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }

    static void matrixRotate(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j <= i; j++) {
                int t = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = t;
            }
        }
    }

    static void reverse(int[] a) {
        for (int i = 0, j = a.length - 1; i < j; i++, j--) {
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
        }
    }
}
