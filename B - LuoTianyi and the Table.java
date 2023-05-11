// 1809A - Garland

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {

    static int[] cache = null;

    public static void main(String[] args) {

        FastScanner in = new FastScanner(System.in);
        PrintWriter printWriter = new PrintWriter(System.out);

        int cases = in.nextInt();

        for (int z = 0; z < cases; z++) {
            int n = in.nextInt();
            int m = in.nextInt();

            long[] arr = new long[n * m];
            long max1 = Long.MIN_VALUE, max2 = Long.MIN_VALUE, min1 = Long.MAX_VALUE, min2 = Integer.MAX_VALUE;

            for (int i = 0; i < arr.length; i++) {
                arr[i] = in.nextLong();
                if (arr[i] > max1) {
                    max2 = max1;
                    max1 = arr[i];
                } else if (arr[i] > max2) {
                    max2 = arr[i];
                }

                if (arr[i] < min1) {
                    min2 = min1;
                    min1 = arr[i];
                } else if (arr[i] < min2) {
                    min2 = arr[i];
                }
            }
            int val = (Math.min(n, m) - 1);
            long ans1 = (long) (n * m - val - 1) * (max1 - min1)
                    + (long) val * (max1 - min2);

            long ans2 = (long) (n * m - val - 1) * (max1 - min1)
                    + (long) val * (max2 - min1);
            printWriter.println(Math.max(ans1, ans2));

        }
        printWriter.close();

    }

    public static class FastScanner {
        private BufferedReader reader = null;
        private StringTokenizer tokenizer = null;

        public FastScanner(InputStream in) {
            reader = new BufferedReader(new InputStreamReader(in));
            tokenizer = null;
        }

        public String next() {
            if (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public String nextLine() {
            if (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    return reader.readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            return tokenizer.nextToken("\n");
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public int[] nextIntArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        public long[] nextLongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            return a;
        }
    }

}
