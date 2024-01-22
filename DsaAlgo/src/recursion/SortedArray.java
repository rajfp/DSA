package recursion;

public class SortedArray {
    public static void main(String[] args) {

    }

    static boolean sortedArray(int[] a, int index) {
        if (index == a.length)
            return true;
        return a[index] > a[index - 1] && sortedArray(a, index + 1);
    }
}
