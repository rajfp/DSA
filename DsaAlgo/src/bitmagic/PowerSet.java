package bitmagic;

public class PowerSet {
    public static void main(String[] args) {
        powerSet("abc");
    }

    static void powerSet(String s) {
        int n = s.length();
        int size = 1 << n;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0)
                    System.out.print(s.charAt(j));
            }
            System.out.println();
        }

    }
}
