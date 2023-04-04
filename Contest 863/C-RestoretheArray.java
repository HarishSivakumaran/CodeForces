import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int noOfCases = in.nextInt();

        for (int z = 0; z < noOfCases; z++) {

            int n = in.nextInt();

            long[] out = new long[n];
            boolean added = false;

            long curr = 0;
            int l = 0;

            for (int i = 0; i < n - 1; i++) {
                curr = in.nextLong();

                if (added && curr < out[l - 1]) {
                    out[l - 1] = curr;
                }

                if (l > 0 && !added && curr > out[l - 1]) {
                    added = true;
                    l++;
                }
                out[l++] = curr;
            }

            for (long i : out) {
                System.out.print(i + " ");
            }
            System.out.print("\n");

        }
    }

}