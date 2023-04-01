import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int noOfCases = in.nextInt();

        for (int z = 0; z < noOfCases; z++) {

            int n = in.nextInt();
            int k = in.nextInt();

            List<Integer> out = new ArrayList();
            solve(n, k, out);
            for (int a : out) {
                System.out.print(a + "\s");
            }
            System.out.print("\n");

        }

    }

    public static void solve(int n, int k, List<Integer> list) {

        if (n <= 0)
            return;

        if (k < n) {
            for (int i = 0; i < n; i++) {
                if (k == i + 1) {
                    list.add(k);
                    list.add(-2 * k);
                    i++;
                } else {
                    list.add(-1);
                }
            }
        } else {
            solve(n - 1, k - n, list);
            list.add(1000);
        }

    }
}