// C - Constructive Problem

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {

    public static void main(String[] args) {

        FastScanner in = new FastScanner(System.in);
        PrintWriter printWriter = new PrintWriter(System.out);

        int cases = in.nextInt();

        for (int z = 0; z < cases; z++) {

            int n = in.nextInt();

            long[] arr = new long[n];
            HashMap<Long, int[]> location = new HashMap();
            long max = 0;

            for (int i = 0; i < n; i++) {
                long curr = in.nextLong();
                arr[i] = curr;
                if (curr > max) {
                    max = curr;
                }
                if (location.containsKey(curr)) {
                    location.get(curr)[1] = i;
                } else {
                    location.put(curr, new int[] { i, i });
                }
            }

            long currMex = findMex(location, n);
            long expMex = currMex + 1;

            if (expMex > n) {
                printWriter.printf("No\n");
                continue;
            }

            if (location.containsKey(expMex)) {
                int[] pos = location.get(expMex);
                for (int j = pos[0]; j <= pos[1]; j++) {
                    long curr = arr[j];
                    int[] curPos = location.get(curr);

                    if (curPos != null && curPos[0] >= pos[0] && curPos[1] <= pos[1]) {
                        location.remove(curr);
                    }
                    if (j >= pos[0] && j <= pos[1]) {
                        curr = currMex;
                    }
                    if (location.containsKey(curr)) {
                        location.get(curr)[1] = j;
                    } else {
                        location.put(curr, new int[] { j, j });
                    }
                }

                long newMex = findMex(location, n);

                printWriter.printf(newMex == expMex ? "Yes\n" : "No\n");

            } else {
                printWriter.printf("Yes\n");
            }

        }
        printWriter.close();
    }

    public static long findMex(HashMap<Long, int[]> location, int n) {
        for (long i = 0; i <= n; i++) {
            if (!location.containsKey(i))
                return i;
        }

        return -1;
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
