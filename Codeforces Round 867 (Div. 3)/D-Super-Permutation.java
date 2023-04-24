package Codeforces Round 867(Div.3);

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {

    static PrintWriter printWriter = null;

    public static void main(String[] args) {

        FastScanner in = new FastScanner(System.in);
        printWriter = new PrintWriter(System.out);
        int cases = in.nextInt();

        for (int z = 0; z < cases; z++) {
            int n = in.nextInt();
            solve(n);

        }

        printWriter.close();

    }

    public static void solve(int n) {
        int[] arr = new int[n];
        arr[0] = n;

        for (int i = 1; i <= (n / 2); i++) {
            if (2 * i - 1 < n)
                arr[2 * i - 1] = (n * (i + 1)) - i;
            if (2 * i < n)
                arr[2 * i] = (n * (i + 1)) + i;
        }

        HashSet<Integer> set = new HashSet();
        set.add(n);
        int[] out = new int[n];
        out[0] = n;
        for (int i = 1; i < n; i++) {
            out[i] = arr[i] - arr[i - 1];

            if (set.contains(out[i])) {
                printWriter.printf("-1" + "\n");
                return;
            }
            set.add(out[i]);

        }

        for (int a : out) {
            printWriter.printf(a + " ");
        }

        printWriter.printf("\n");

    }

    public static void solve(int[] original, int[] partSorted) {

        Stack<int[]> stack = new Stack();
        int l = 0, r = 0;

        boolean misMatch = false;

        for (int i = 0; i < partSorted.length; i++) {
            if (stack.size() > 0 && partSorted[i] < stack.peek()[1]) {
                if (misMatch && stack.size() > r - l + 1) {
                    r = stack.peek()[0] + 1;
                    l = r - stack.size() + 1;
                }
                stack.clear();
                misMatch = false;
            }
            if (original[i] != partSorted[i])
                misMatch = true;
            stack.push(new int[] { i, partSorted[i] });
        }

        if (misMatch && stack.size() > r - l + 1) {
            r = stack.peek()[0] + 1;
            l = r - stack.size() + 1;
        }

        printWriter.printf(l + " " + r + "\n");

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
