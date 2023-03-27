// 1798C - Candy Store

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int totalTestCases = in.nextInt();
        for (int z = 0; z < totalTestCases; z++) {
            int noOfTypes = in.nextInt();
            long[] noOfCandies = new long[noOfTypes];
            long[] pricePerCandy = new long[noOfTypes];

            for (int i = 0; i < noOfTypes; i++) {
                noOfCandies[i] = in.nextLong();
                pricePerCandy[i] = in.nextLong();
            }

            long ans = 1, g = 0, l = 1;

            for (int i = 0; i < noOfTypes; i++) {
                g = gcd(g, noOfCandies[i] * pricePerCandy[i]);
                l = lcm(l, pricePerCandy[i]);
                if (g % l == 0)
                    continue;
                ans++;
                g = noOfCandies[i] * pricePerCandy[i];
                l = pricePerCandy[i];
            }

            System.out.println(ans);

        }

    }

    public static long lcm(long a, long b) {
        return (a * b) / (gcd(a, b));
    }

    public static long gcd(long a, long b) {

        if (b == 0)
            return a;

        return gcd(b, a % b);
    }

}