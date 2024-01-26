package sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 3, 10, 4, 5, 45, 22, 8};
        quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    static void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int p = partition(a, low, high);
            quickSort(a, low, p - 1);
            quickSort(a, p + 1, high);
        }

    }

    static int partition(int[] a, int low, int high) {
        int j = low;
        for (int i = low; i < high; i++) {
            if (a[i] <= a[high]) {
                swap(a, i, j);
                j++;
            }
        }
        swap(a, j , high);
        return j;
    }

    static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
