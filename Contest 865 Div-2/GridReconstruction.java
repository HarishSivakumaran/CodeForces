package Contest 865 Div-2;

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
        
        for(int z = 0; z < cases; z++){
            
            int n = in.nextInt();
            int[][] a = new int[2][n];
            
            for(int i = 0; i < 2; i++){
                for(int j = 0; j < n; j++){
                    
                    if(i == 0 && j == 0){
                        a[i][j] = 2*n-1;
                        continue;
                    }
                    
                    if(i == 1 && j == n-1){
                        a[i][j] = 2*n;
                        continue;
                    }
                    
                    if(i == 0){
                        a[i][j] = j%2 == 0 ? n+(j-1) : j; 
                    }else{
                        a[i][j] = a[i-1][j+1]+1;
                    }
                    
                }
            }
            
             for(int i = 0; i < 2; i++){
                for(int j = 0; j < n; j++){
                     printWriter.printf(a[i][j]+ " ");
                }
                 printWriter.printf("\n");
             }


        }
        
        printWriter.close();

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
