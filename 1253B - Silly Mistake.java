public

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {

    static PrintWriter printWriter = null;

    public static void main(String[] args) {

        FastScanner in = new FastScanner(System.in);
        printWriter = new PrintWriter(System.out);
        
        int len = in.nextInt();
        int[] arr = new int[len];
        
        for(int i = 0; i < len; i++){
            arr[i] = in.nextInt();
        }
        
        List<Integer> out = new ArrayList();
        HashSet<Integer> set = new HashSet();
        HashSet<Integer> entry = new HashSet();
        int prev = 0;
        
        for(int i = 0; i < len; i++){
            if(set.contains(arr[i]) || entry.contains(arr[i]) || (arr[i] < 0 && !set.contains(-1*arr[i]))){
                printWriter.println(-1);
                printWriter.close();
                return;
            }
            if(arr[i] < 0){
                set.remove(-1*arr[i]);
                entry.add(-1*arr[i]);
            }else{
                set.add(arr[i]);
            }
            
            if(set.isEmpty()){ 
                out.add(i+1-prev);
                prev = i+1;
                entry.clear();
                
            }
            
        }
        
        if(set.size() == 0){
              
        if(out.size()> 0){
            printWriter.println(out.size());
        }        
        for(int v : out){
            printWriter.printf(v + " ");
        }
        }else{
             printWriter.println(-1);
        }
      
        
        printWriter.close();

    }

    public static int getFaces(String name) {
        switch (name) {
            case "Tetrahedron":
                return 4;
            case "Cube":
                return 6;
            case "Octahedron":
                return 8;
            case "Dodecahedron":
                return 12;
            case "Icosahedron":
                return 20;
        }

        return 0;
    }

    public static void solve(int[] original, int[] partSorted) {

        Stack<int[]> stack = new Stack();
        int l = 0, r = 0;

        boolean misMatch = false;

        for (int i = 0; i < partSorted.length; i++) {
            if (stack.size() > 0 && partSorted[i] < stack.peek()[1]) {
                if (misMatch && stack.size() > r - l + 1) {
                    r = stack.peek()[0] + 1;
                    l = r - stack.size() + 1;
                }
                stack.clear();
                misMatch = false;
            }
            if (original[i] != partSorted[i])
                misMatch = true;
            stack.push(new int[] { i, partSorted[i] });
        }

        if (misMatch && stack.size() > r - l + 1) {
            r = stack.peek()[0] + 1;
            l = r - stack.size() + 1;
        }

        printWriter.printf(l + " " + r + "\n");

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

}{

}
