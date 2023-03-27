
// 1798A - Showstopper
import java.util.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int totalTestCases = in.nextInt();
        for (int i = 0; i < totalTestCases; i++) {
            int arrLength = in.nextInt();
            int[] a = new int[arrLength];
            int[] b = new int[arrLength];
            for (int j = 0; j < arrLength; j++) {
                a[j] = in.nextInt();
            }
            for (int j = 0; j < arrLength; j++) {
                b[j] = in.nextInt();
            }

            int[] max = { a[arrLength - 1], b[arrLength - 1] };
            String res = "YES";

            for (int j = arrLength - 2; j >= 0; j--) {
                if ((max[0] >= a[j] && max[1] >= b[j]) || (max[0] >= b[j] && max[1] >= a[j]))
                    continue;
                res = "NO";
                break;
            }

            System.out.println(res);

        }

    }
}