
// C - Place for a Selfie
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int noOfCases = in.nextInt();

        for (int z = 0; z < noOfCases; z++) {

            int noOfLines = in.nextInt();
            int noOfParabola = in.nextInt();

            long[] linesB = new long[noOfLines];

            for (int i = 0; i < noOfLines; i++) {
                linesB[i] = in.nextLong();
            }

            long possible = -1;

            long a = 0, b = 0, c = 0;

            Arrays.sort(linesB);

            for (int j = 0; j < noOfParabola; j++) {
                a = in.nextLong();
                b = in.nextLong();
                c = in.nextLong();

                int bs = findNextLarger(b, linesB);
                int s = findNextSmaller(b, linesB);

                if (bs < linesB.length && (long) ((b - linesB[bs]) * (b - linesB[bs])) < (long) 4 * a * c) {
                    System.out.println("Yes");
                    System.out.println(linesB[bs]);
                    continue;
                }

                if (s >= 0 && (long) (b - linesB[s]) * (b - linesB[s]) < (long) 4 * a * c) {
                    System.out.println("Yes");
                    System.out.println(linesB[s]);
                    continue;
                }
                System.out.println("No");

            }

            System.out.print("\n");

        }
    }

    public static int findNextLarger(long n, long[] a) {
        int l = 0, r = a.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            if (a[m] >= n) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return l;

    }

    public static int findNextSmaller(long n, long[] a) {
        int l = 0, r = a.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            if (a[m] < n) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return r;

    }
}