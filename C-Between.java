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
            int m = in.nextInt();
            HashMap<Integer, List<Integer>> adjList = new HashMap();

            for (int i = 0; i < m; i++) {
                int from = in.nextInt();
                int to = in.nextInt();

                adjList.computeIfAbsent(to, v -> new ArrayList()).add(from);

            }

            buildSequence(adjList, n);

        }

        printWriter.close();

    }

    public static void buildSequence(HashMap<Integer, List<Integer>> adj, int n) {

        int[] occ = new int[n + 1];
        occ[1] = 1;

        Queue<Integer> q = new LinkedList();
        q.add(1);

        while (q.size() > 0) {
            int len = q.size();

            for (int j = 0; j < len; j++) {
                int curr = q.poll();
                if (adj.containsKey(curr)) {
                    for (int k : adj.get(curr)) {
                        if (occ[k] == 0) {
                            occ[k] = occ[curr] + 1;
                            q.add(k);
                        }
                    }
                }
            }
        }

        HashMap<Integer, List<Integer>> occMap = new HashMap();
        int ans = 0;

        for (int i = 1; i <= n; i++) {
            if (occ[i] == 0) {
                printWriter.printf("INFINITE\n");
                return;
            }
            occMap.computeIfAbsent(occ[i], v -> new ArrayList()).add(i);
            ans += occ[i];
        }

        printWriter.printf("FINITE\n");
        printWriter.printf(ans + "\n");

        for (int i = n; i >= 1; i--) {
            for (int j = n; j >= i; j--) {
                if (i % 2 != j % 2 || !occMap.containsKey(j))
                    continue;
                for (int o : occMap.get(j)) {
                    printWriter.printf(o + " ");
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            for (int j = n; j >= i; j--) {
                if (i % 2 != j % 2 || !occMap.containsKey(j))
                    continue;
                for (int o : occMap.get(j)) {
                    printWriter.printf(o + " ");
                }
            }
        }
        printWriter.printf("\n");

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
