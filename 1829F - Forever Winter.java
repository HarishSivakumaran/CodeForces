import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {

    static PrintWriter printWriter = null;
    static HashMap<String, Long> map = new HashMap();

    public static void main(String[] args) {

        FastScanner in = new FastScanner(System.in);
        printWriter = new PrintWriter(System.out);

        int c = in.nextInt();

        for (int z = 0; z < c; z++) {

            int n = in.nextInt();
            int e = in.nextInt();

            int[] edges = new int[n + 1];
            for (int i = 0; i < e; i++) {
                edges[in.nextInt()]++;
                edges[in.nextInt()]++;
            }

            HashMap<Integer, Integer> map = new HashMap();
            HashMap<Integer, Integer> map1 = new HashMap();

            for (int i : edges) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> e1 : map.entrySet()) {
                map1.put(e1.getValue(), e1.getKey());
            }
            int max = -1;
            for (Map.Entry<Integer, Integer> e1 : map.entrySet()) {
                max = Math.max(2, e1.getKey());
                if (e1.getKey() > 1 && map1.containsKey(e1.getKey())) {
                    max = -1;
                    printWriter.println(e1.getKey() + " " + (map1.get(e1.getKey()) - 1));
                    break;
                }
            }

            if (max > -1) {
                printWriter.println(max + " " + (max - 1));

            }

        }

        printWriter.close();

    }

    public static long solve(long[] arr, int l, int r, int moves, long[] preSum) {
        if (l > r)
            return 0l;

        String key = l + "-" + r + "-" + moves;

        if (map.containsKey(key))
            return map.get(key);

        if (moves == 0) {
            long lef = 0;
            if (l - 1 >= 0)
                lef = preSum[l - 1];
            return preSum[r] - lef;
        }

        long max = -1;

        // remove min
        max = Math.max(max, solve(arr, l + 2, r, moves - 1, preSum));

        // remove max
        max = Math.max(max, solve(arr, l, r - 1, moves - 1, preSum));

        map.put(key, max);

        return max;

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
