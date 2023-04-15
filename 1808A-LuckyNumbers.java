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

            long l = in.nextLong();
            long r = in.nextLong();

            // long diff = r-l;

            // if(diff >= 90){
            // printWriter.printf(9 +"\n");
            // }

            if (r < 10) {
                printWriter.printf(r + "\n");
                continue;
            }

            long max = 0, maxValu = 0;

            while (l <= r) {
                long currdiff = getMaxDiff(l);
                if (currdiff >= max) {
                    maxValu = l;
                    max = currdiff;
                }
                if (currdiff == 9)
                    break;
                l++;
            }

            printWriter.printf(maxValu + "\n");

        }
        printWriter.close();
    }

    public static long getMaxDiff(long num) {
        long min = 9, max = 0;

        while (num > 0) {
            long md = num % 10;
            num /= 10;

            if (md > max) {
                max = md;
            }

            if (md < min) {
                min = md;
            }
        }

        return max - min;
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
