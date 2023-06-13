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
        int n = in.nextInt();
        StringBuilder str = new StringBuilder();
        int left = -1, right = -1, first = -1;
        
        for(int i = 0; i < n; i++){
            int curr = in.nextInt();
            
            if(first == -1){
                first = curr;
            }
            
            if(right != -1){
                if(curr >= right && curr <= first){
                    right = curr;
                    str.append("1");
                }else{
                    str.append("0");
                }
                continue;
            }
            
            if(left != -1){
                if(curr < left) {
                    if(curr <= first){
                        right = curr;
                        str.append("1");
                    }else{
                        str.append("0");
                    }
                    continue;
                }
            }
            
            left = curr;
            str.append("1");
        }
        
        printWriter.println(str);
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
