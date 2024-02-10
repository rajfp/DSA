package dynamicprogramming;

public class NthFibonacciNumber {
    public static void main(String[] args) {
        System.out.println(nthFibonacci(1));
    }

    static int nthFibonacci(int n) {
        if (n == 1 || n == 2)
            return 1;
        int[] a = new int[n + 1];
        a[0] = 1;
        a[1] = 1;
        for (int i = 2; i < n; i++) {
            a[i] = (a[i - 1] + a[i - 2]) % 1000000007;
        }
        return a[n - 1];
    }
}
