package bitmagic;

public class ReverseBits {
    public static void main(String[] args) {
        System.out.println(reversedBits(7L));
    }

    static Long reversedBits(Long x) {
        int i = 0;
        Long res = 0L;
        while (i < 32) {
            if ((x & (1L << i)) != 0)
                res = (res << 1) | 1;
            else
                res = res << 1;
            i++;
        }
        return res;
    }
}
