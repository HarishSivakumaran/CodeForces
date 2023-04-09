package Contest-864(div-2);

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

            int r = in.nextInt();
            int c = in.nextInt();

            int x1 = in.nextInt() - 1;
            int y1 = in.nextInt() - 1;

            int x2 = in.nextInt() - 1;
            int y2 = in.nextInt() - 1;

            printWriter.printf(Math.min(noOfBlocks(r, c, x1, y1), noOfBlocks(r, c, x2, y2)) + "\n");

        }

        printWriter.close();

    }

    public static int noOfBlocks(int r, int c, int x, int y) {
        int ans = 0;
        if (x > 0)
            ans++;
        if (x < r - 1)
            ans++;
        if (y > 0)
            ans++;
        if (y < c - 1)
            ans++;

        return ans;
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
