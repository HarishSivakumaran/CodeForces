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

            String num = in.nextLine();
            int max = -1;
            HashMap<Character, Integer> count = new HashMap();

            for (int i = 0; i < num.length(); i++) {
                count.put(num.charAt(i), count.getOrDefault(num.charAt(i), 0) + 1);
                max = Math.max(max, count.get(num.charAt(i)));
            }

            if (max < 3) {
                printWriter.printf("4\n");
            } else if (max == 3) {
                printWriter.printf("6\n");
            } else {
                printWriter.printf("-1\n");
            }

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
