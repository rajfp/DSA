package sorting;

public class HeapSort {

    /*
    O(nlogn)
     */
    public static void main(String[] args) {
        int[] a = new int[]{2, 5, 9, 1, 4, 7, 5, 3};
        buildHeap(a);
        int k = a.length;
        for (int i = 0; i < a.length; i++) {
            int t = a[k - 1];
            a[k - 1] = a[0];
            a[0] = t;
            heapify(a, 0, --k);
        }
        for (int x : a)
            System.out.print(x + " ");
    }

    /*
    O(logn)
     */
    static void heapify(int[] a, int i, int size) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int largest = i;
        if (l < size && a[l] > a[i])
            largest = l;
        if (r < size && a[r] > a[largest])
            largest = r;
        if (largest != i) {
            int t = a[i];
            a[i] = a[largest];
            a[largest] = t;
            heapify(a, largest, size);
        }
    }

    /*
    O(n)
     */
    static void buildHeap(int[] a) {
        for (int i = (a.length - 2) / 2; i >= 0; i--) {
            heapify(a, i, a.length);
        }
    }
}
