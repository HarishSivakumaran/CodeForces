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
            int t = in.nextInt();
            int maxVal = -2, maxIndex = -2;
            int[] dur = new int[n];

            for (int i = 0; i < n; i++) {
                dur[i] = in.nextInt();
            }

            for (int i = 0; i < n; i++) {
                int entVal = in.nextInt();
                if (dur[i] <= t - i) {
                    if (entVal > maxVal) {
                        maxVal = entVal;
                        maxIndex = i;
                    }
                }
            }

            printWriter.printf((maxIndex + 1) + "\n");

        }

        printWriter.close();

    }

    public static void solve(char[][] arr) {
        int[][] dir = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 } };

        for (int r = 0; r < arr.length; r++) {
            for (int c = 0; c < arr[0].length; c++) {
                if (arr[r][c] != '*') {
                    int givenVal = arr[r][c] == '.' ? 0 : (int) (arr[r][c] - '0');
                    int calc = 0;
                    for (int[] d : dir) {
                        if (r + d[0] < 0 || c + d[1] < 0 ||
                                r + d[0] >= arr.length || c + d[1] >= arr[0].length)
                            continue;
                        if (arr[r + d[0]][c + d[1]] == '*')
                            calc++;
                    }

                    if (givenVal != calc) {
                        printWriter.printf("NO\n");
                        return;
                    }
                }
            }
        }

        printWriter.printf("YES" + "\n");
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
