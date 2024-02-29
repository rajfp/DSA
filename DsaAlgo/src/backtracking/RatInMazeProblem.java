package backtracking;

import java.util.ArrayList;
import java.util.Arrays;

/*
Consider a rat placed at (0, 0) in a square matrix of order N * N. It has to reach the destination at (N - 1, N - 1). Find all possible paths that the rat can take to reach from source to destination. The directions in which the rat can move are 'U'(up), 'D'(down), 'L' (left), 'R' (right). Value 0 at a cell in the matrix represents that it is blocked and rat cannot move to it while value 1 at a cell in the matrix represents that rat can be travel through it.
Note: In a path, no cell can be visited more than one time. If the source cell is 0, the rat cannot move to any other cell.

Example 1:

Input:
N = 4
m[][] = {{1, 0, 0, 0},
         {1, 1, 0, 1},
         {1, 1, 0, 0},
         {0, 1, 1, 1}}
Output:
DDRDRR DRDDRR
Explanation:
The rat can reach the destination at
(3, 3) from (0, 0) by two paths - DRDDRR
and DDRDRR, when printed in sorted order
we get DDRDRR DRDDRR.
Example 2:
Input:
N = 2
m[][] = {{1, 0},
         {1, 0}}
Output:
-1
Explanation:
No path exists and destination cell is
blocked.
Your Task:
You don't need to read input or print anything. Complete the function printPath() which takes N and 2D array m[ ][ ] as input parameters and returns the list of paths in lexicographically increasing order.
Note: In case of no path, return an empty list. The driver will output "-1" automatically.

Expected Time Complexity: O((3N^2)).
Expected Auxiliary Space: O(L * X), L = length of the path, X = number of paths.


 */
public class RatInMazeProblem {
    public static void main(String[] args) {
        int[][] a = new int[][]{
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        };
        boolean[][] path = new boolean[a.length][a.length];
        for (boolean[] x : path)
            Arrays.fill(x, true);
        ArrayList<String> list = findPath(a, a.length, path, 0, 0, "");
        if (list.isEmpty())
            list.add("-1");
        System.out.println(list);
    }

    public static ArrayList<String> findPath(int[][] a, int n, boolean[][] pathArray, int row, int col, String path) {

        if (a[row][col] == 0)
            return new ArrayList<>();
        if (row == n - 1 && col == n - 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(path);
            return list;
        }
        if (!pathArray[row][col])
            return new ArrayList<>();
        ;
        pathArray[row][col] = false;
        ArrayList<String> list = new ArrayList<>();
        if (row < n - 1)
            list.addAll(findPath(a, a.length, pathArray, row + 1, col, path + "D"));
        if (row > 0)
            list.addAll(findPath(a, a.length, pathArray, row - 1, col, path + "U"));
        if (col < n - 1)
            list.addAll(findPath(a, a.length, pathArray, row, col + 1, path + "R"));
        if (col > 0)
            list.addAll(findPath(a, a.length, pathArray, row, col - 1, path + "L"));
        pathArray[row][col] = true;
        return list;
    }

//    public static void findPath(int[][] a, int n, boolean[][] pathArray, int row, int col, String path,
//                                ArrayList<String> pathList) {
//
//        if (a[row][col] == 0)
//            return;
//        if (row == n - 1 && col == n - 1) {
//            pathList.add(path);
//            return;
//        }
//        if (!pathArray[row][col])
//            return;
//        pathArray[row][col] = false;
//        if (row < n - 1)
//            findPath(a, a.length, pathArray, row + 1, col, path + "D", pathList);
//        if (row > 0)
//            findPath(a, a.length, pathArray, row - 1, col, path + "U", pathList);
//        if (col < n - 1)
//            findPath(a, a.length, pathArray, row, col + 1, path + "R", pathList);
//        if (col > 0)
//            findPath(a, a.length, pathArray, row, col - 1, path + "L", pathList);
//        pathArray[row][col] = true;
//    }
}
