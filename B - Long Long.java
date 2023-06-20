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
      int[] arr = new int[n];
      long sum = 0, changes = 0;
      for(int i = 0; i < n; i++) {
          arr[i] = in.nextInt();
          sum += Math.abs(arr[i]);
      }
      
      boolean negFound = false;
      
      for(int i = 0; i < n; i++){
          if(negFound && arr[i] > 0){
              negFound = false;
              changes++;
              continue;
          }
          
          if(arr[i] < 0){
              negFound = true;
          }
      }
      
      if(negFound) changes++;
      
      printWriter.println(sum + " " + changes);
        
    }
    
    public static int findMinDuration(StringBuilder s, StringBuilder t, boolean isAlice){
        if(s.toString().equals(t.toString()))return 0;
        
        if(isAlice){
            return alicePlaysOptimally(s, t);
        }else{
            return bobPlaysOptimally(s, t);
        }
    }
    
    public static int bobPlaysOptimally(StringBuilder s, StringBuilder t){
        return 1 + Math.max(findMinDuration(new StringBuilder(s.reverse()), new StringBuilder(t), true), 
        findMinDuration(new StringBuilder(s), new StringBuilder(t.reverse()), true));
    }
    
    public static int alicePlaysOptimally(StringBuilder s, StringBuilder t){
        StringBuilder new1 = new StringBuilder(s), new2 = new StringBuilder(s), newT = new StringBuilder(t);
        int i = 0, l = -1, r = -1;
        for(; i < t.length() && (r == -1 || l == -1); i++){
            if(s.charAt(i) != t.charAt(i) && l == -1) l = i;
            if(s.charAt(i) != t.charAt(t.length()-1-i) && r == -1) r = i;
        }
        new1.setCharAt(l, t.charAt(l));
        if(new1.toString().equals(t.toString())) return 1;
        if(r != -1)
            new2.setCharAt(r, t.charAt(t.length()-1-r));
        
        return 1 + Math.min(findMinDuration(new1, newT, false), findMinDuration(new2, newT, false));
        
    }
    
    public static boolean isPrime(int n){
        if(n == 0 || n == 1) return false;
        
        
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n%i == 0) return false;
        }
        
        return true;
        
    }
    
    public static int getVal(int[] q, List<Integer> val) {
        // minimum admittable value which is greater than or equal to q[0]
        int l = 0, r = val.size()-1;
        while(l <= r){
            int m = l + (r-l)/2;
            if(val.get(m) < q[0]){
                l = m+1;
            } else {
                r = m-1;
            }
        }
        
        int value = l;

        // maximum value which is lesser than or equal to q[1]
        
        l = 0; r = val.size()-1;
        while(l <= r){
            int m = l + (r-l)/2;
            if(val.get(m) <= q[1]){
                l = m+1;
            } else {
                r = m-1;
            }
        }

        return r-value+1;
    }
    
    public static boolean getIfAdmittable(int v, int min, int[][] ranges) {
        int com = 0;
        for(int i = 0; i < ranges.length && ranges[i][0] <= v; i++){
            if(v >= ranges[i][0] && v <= ranges[i][1]){
                com++;
            }
            
            if(com >= min) return true;
        }
        return false;
        // //minimum interval this i falls under
        // int l = 0, r = ranges.length-1;
        // boolean match = false;
        // while(l <= r){
        //     int m = l + (r-l)/2;
        //     if(i >=  ranges[m][0] && i <= ranges[m][1]) {
        //         r = m-1;
        //         match = true;
        //     }else{
        //         // not matching
        //         if(i < ranges[m][0]) {
        //             r = m-1;
        //         }else{
        //             l = m+1;
        //         }
        //     }
        // }
        // int val = l;

        // if(!match){
        //     return false;
        // }
        
        // match = false;
        // l = 0;
        // r = ranges.length-1;
        // while(l <= r){
        //     int m = l + (r-l)/2;
        //     if(i >=  ranges[m][0] && i <= ranges[m][1]) {
        //         l = m+1;
        //         match = true;
        //     }else{
        //         // not matching
        //         if(i < ranges[m][0]) {
        //             r = m-1;
        //         }else{
        //             l = m+1;
        //         }
        //     }
        // }
        
        // if(!match){
        //     return false;
        // }
        

        // return r-val+1 >= min;
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
