
// E - There Should Be a Lot of Maximums
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {

        Main main = new Main();
        FastScanner in = main.new FastScanner(System.in);
        PrintWriter printWriter = new PrintWriter(System.out);

        int nodes = in.nextInt();

        int[][] edges = new int[nodes - 1][2];

        HashMap<Integer, List<Integer>> adjList = new HashMap();

        for (int z = 0; z < nodes - 1; z++) {
            edges[z] = new int[] { in.nextInt(), in.nextInt() };
            adjList.computeIfAbsent(edges[z][0], v -> new ArrayList()).add(edges[z][1]);
            adjList.computeIfAbsent(edges[z][1], v -> new ArrayList()).add(edges[z][0]);
        }

        HashMap<Integer, HashSet<Integer>> sameValueNodes = new HashMap();

        for (int i = 0; i < nodes; i++) {
            int val = in.nextInt();
            if (!sameValueNodes.containsKey(val)) {
                sameValueNodes.put(val, new HashSet());
            }
            sameValueNodes.get(val).add(i + 1);
        }

        int[] out = new int[nodes - 1];

        for (Map.Entry<Integer, HashSet<Integer>> entry : sameValueNodes.entrySet()) {
            if (entry.getValue().size() < 2)
                continue;
            HashSet<String> path = new HashSet();
            HashSet<Integer> toNodes = (HashSet<Integer>) entry.getValue().clone();
            for (int i : entry.getValue()) {
                toNodes.remove(i);
                findPath(i, -1, adjList, path, toNodes);
                toNodes.add(i);
                break;
            }

            for (int i = 0; i < nodes - 1; i++) {
                if (!path.contains(edges[i][0] + "-" + edges[i][1])
                        && !path.contains(edges[i][1] + "-" + edges[i][0])) {
                    out[i] = Math.max(entry.getKey(), out[i]);

                }
            }

        }

        for (int i : out) {
            printWriter.printf(i + "\n");
        }

        printWriter.close();

    }

    public static boolean findPath(int i, int prev, HashMap<Integer, List<Integer>> adjList, HashSet<String> path,
            HashSet<Integer> toNodes) {
        String pKey = i + "-" + prev;

        path.add(pKey);

        if (toNodes.contains(i))
            return true;

        boolean canBeAdded = false;

        for (int edge : adjList.get(i)) {
            if (edge != prev)
                canBeAdded = findPath(edge, i, adjList, path, toNodes) || canBeAdded;
        }

        if (!canBeAdded) {
            path.remove(pKey);
        }

        return canBeAdded;
    }

    public class FastScanner {
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
