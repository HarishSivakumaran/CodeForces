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
        List<List<Integer>> a = new ArrayList();
        a.add(new ArrayList());
        int curr = 0;
        
        for(int i = 0; i< n; i++){
            curr = in.nextInt();
            a.get(a.size()-1).add(curr);
            if(curr == 0){
                a.add(new ArrayList());
            }
        }
        
        if(curr == 0){
            List<Integer> actions = new ArrayList();
            int index = a.size()-1;
            while(index >= 0){
                if(a.get(index).size() > 0){
                    List<Integer> list = a.get(index);
                    for(int i = 0; i < list.size(); i++) {
                        if(list.get(i) == 1){
                            actions.add(0);
                        }else{
                            actions.add(i);
                        }
                    }
                }
                index--;
            }
            
            printWriter.println("Yes");
            for(int v : actions){
                printWriter.print(v+" ");
            }
            printWriter.println();
            
            return;
        }
        
        
        printWriter.println("NO");
        
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
