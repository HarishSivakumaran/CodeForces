
// 1635B - Avoid Local Maximums
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int noOfCases = in.nextInt();

        for (int j = 0; j < noOfCases; j++) {
            int arrLen = in.nextInt();
            int[] arr = new int[arrLen];
            for (int i = 0; i < arrLen; i++) {
                arr[i] = in.nextInt();
            }

            boolean increasing = false;
            int prev = Integer.MAX_VALUE, res = 0;

            for (int i = 0; i < arrLen; i++) {

                if (increasing) {
                    if (prev > arr[i]) {
                        res++;
                        arr[i] = Math.max(prev, (i < arrLen - 1) ? arr[i + 1] : prev);
                    }
                }

                increasing = prev < arr[i];

                prev = arr[i];
            }
            System.out.println(res);
            for (int z : arr) {
                System.out.print(z + "\s");
            }
            System.out.print("\n");
        }

    }
}