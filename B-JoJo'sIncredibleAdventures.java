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

            String str = in.nextLine();
            long n = str.length();
            str += str;

            boolean hasZeroes = false;
            long contOnes = 0, counter = 0;

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '0') {
                    hasZeroes = true;
                    counter = 0;
                } else {
                    counter++;
                    contOnes = Math.max(contOnes, counter);
                }
            }
            contOnes++;

            if (!hasZeroes) {
                printWriter.printf(n * n + "\n");
            } else {
                printWriter.printf((contOnes * contOnes) / 4 + "\n");
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
