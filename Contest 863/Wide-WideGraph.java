import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
    static int idex = 1, hmax = 0;

    public static void main(String[] args) {

        FastScanner in = new FastScanner(System.in);
        int noOfNodes = in.nextInt();

        HashMap<Integer, List<Integer>> edges = new HashMap();
        int a = 0, b = 0;

        for (int z = 0; z < noOfNodes - 1; z++) {
            a = in.nextInt();
            b = in.nextInt();
            edges.computeIfAbsent(a, v -> new ArrayList()).add(b);
            edges.computeIfAbsent(b, v -> new ArrayList()).add(a);
        }

        int[] height = new int[noOfNodes];
        findMaxHeight(1, -1, edges, height, 0);

        hmax = 0;
        findMaxHeight(idex, -1, edges, height, 0);

        int[] height1 = new int[noOfNodes];

        findMaxHeight(idex, -1, edges, height1, 0);

        for (int i = 0; i < height.length; i++) {
            height[i] = Math.max(height[i], height1[i]);
        }

        Arrays.sort(height);

        int l = 0;
        PrintWriter printWriter = new PrintWriter(System.out);

        for (int i = 1; i <= noOfNodes; i++) {
            while (l < height.length && height[l] < i) {
                l++;
            }
            printWriter.printf("%d ", Math.min(l + 1, noOfNodes));
        }

        printWriter.close();

    }

    public static void findMaxHeight(int i, int par, HashMap<Integer, List<Integer>> edges, int[] height, int h) {

        height[i - 1] = h;
        if (h > hmax) {
            hmax = h;
            idex = i;
        }
        for (int edge : edges.get(i)) {
            if (par != edge) {
                findMaxHeight(edge, i, edges, height, h + 1);
            }
        }

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
