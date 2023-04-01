public class 1810B-Candies {
    
}
import java.util.*;

public class Main{
    

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int noOfCases = in.nextInt();

        for(int z = 0; z < noOfCases; z++){
            
            int target = in.nextInt();
            
            if(target%2 ==0){
                System.out.println(-1);
                continue;
            }
            
            boolean foundFirstOne = false;
            
           Integer[] list = new Integer[30];
           int j = 0;
            
            for(int i = 29; i >= 1; i--){
                if(((target >> i) & 1) == 1){
                    list[j++] = 2;
                    foundFirstOne = true;
                }else if(foundFirstOne){
                    list[j++] = 1;
                }
            }
            
                
                System.out.println(j);
                
                for(Integer i : list){
                    if(i == null) break;
                    System.out.print(i + " ");
                }
                System.out.print("\n");
            }
            
            
        }

    }
