package Contest 863;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
    
    static int[] cache = null;
    public static void main(String[] args){
        
        FastScanner in = new FastScanner(System.in);
        PrintWriter printWriter = new PrintWriter(System.out);
        
        int cases = in.nextInt();
        
        cache = new int[50];
        cache[0] = 1;
        cache[1] = 1;
        
        for(int i = 2; i < 50; i++){
            cache[i] = cache[i-1]+cache[i-2];
        }

        
        for(int z = 0; z < cases; z++){
            
            int n = in.nextInt();
            int r = in.nextInt();
            int c = in.nextInt();
            
            if(solvable(n, --r, --c)){
                printWriter.printf("YES\n");
            }else{
                printWriter.printf("NO\n");
            }
        }
        
        printWriter.close();

    }
    
    public static boolean solvable(int n, int r, int c){
        if(n == 1) return true;
        
        if(cache[n] > c && cache[n-1] <= c ) return false;
        
        if(c >= cache[n]) c-=cache[n];
        
        return solvable(n-1, c, r);
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
