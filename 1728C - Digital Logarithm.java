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
        long n = in.nextLong();
        PriorityQueue<Long> a = new PriorityQueue<Long>((a1,b1)-> Long.compare(b1,a1));
        PriorityQueue<Long> b = new PriorityQueue<Long>((a1,b1)-> Long.compare(b1,a1));

        for(int i = 0; i < n; i++) a.add(in.nextLong());
        for(int i = 0; i < n; i++) b.add(in.nextLong());
        
        long ans = 0;
        
        while(a.size() > 0 || b.size() > 0){
            if(a.peek().equals(b.peek())){
                a.poll();
                b.poll();
                continue;
            }
            
            ans++;
            if(a.peek() > b.peek()){
                a.add((long)String.valueOf(a.peek()).length());
                a.poll();
            }else{
                b.add((long)String.valueOf(b.peek()).length());
                b.poll();
            }
            
        }

        
        printWriter.println(ans);
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
