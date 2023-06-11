import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {

    static PrintWriter printWriter = null;
    static FastScanner in = null;

    public static void main(String[] args) {

        in = new FastScanner(System.in);
        printWriter = new PrintWriter(System.out);
        
        int c = in.nextInt();
        
        for(int z = 0; z < c; z++){
            solve();
        }
        printWriter.close();

    }
    
    public static void solve(){
        int total = in.nextInt();
        int k = in.nextInt();
        
        long ans = getDiffWays(total, k);
        printWriter.println(ans);
    }
    
    public static long getDiffWays(int amt, int k) {
        if(amt <= 0) return 1;
        
        int max = (int)Math.floor((double)Math.log(amt)/Math.log(2));

        if(max >= k) return (long)Math.pow(2,k);
        
        long ans = (long)Math.pow(2, (max)) + getDiffWays((int)(amt-Math.pow(2,max)), k);
        
        return ans;
        
    }
    
    public static boolean isCanBeCooked(int[] avail, int[] ing, int cookies, int mgPow){
        for(int i = 0; i < avail.length; i++){
            if(avail[i] > ing[i]*cookies) continue;
            if((ing[i]*cookies)-avail[i] <= mgPow){
                mgPow -= ((ing[i]*cookies)-avail[i]);
            }else{
                return false;
            }
        }
        
        return true;
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
