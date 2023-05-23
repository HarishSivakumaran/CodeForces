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
        
        int r = in.nextInt();
        int c = in.nextInt();
        
        int[] row = new int[r];
        int[] col = new int[c];
        
        for(int i = 0; i < r; i++) row[i] = in.nextInt();
        for(int i = 0; i < c; i++) col[i] = in.nextInt();


        printWriter.printf(solve(row, col)+"\n");
        
        printWriter.close();

    }
    
    public static long solve(int[] r, int[] c){
        int[][] grid = new int[r.length][c.length];
        int excess = 0;
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                //check for col
                int col = i < c[j] ? 1 : i == c[j] ? -1 : 0;
                int row = j < r[i] ? 1 : j == r[i] ? -1 : 0;
                
                if(row != 0 && col != 0 && row != col){
                    return 0;
                }else if (row == 0 && col == 0){
                    excess++;
                }else{
                    grid[i][j] = row != 0 ? row : col;
                }
            }
        }
        
        long out = 1;
        
        while(excess > 0){
            out *= 2;
            out %= 1000000007;
            excess--;
        }
        
        return out;
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
