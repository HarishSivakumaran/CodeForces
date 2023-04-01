import java.util.*;
import java.lang.Long;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int noOfCases = in.nextInt();
        in.nextLine();

        for (int z = 0; z < noOfCases; z++) {

            String input = in.nextLine();

            int count0 = 0, count1 = 0;

            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == '1')
                    count1++;
            }

            long ans = Long.MAX_VALUE;

            if (input.length() == 1 || count1 == input.length())
                ans = 0;

            for (int i = 0; i < input.length() - 1; i++) {
                count0 += input.charAt(i) == '0' ? 1 : 0;
                count1 -= input.charAt(i) == '1' ? 1 : 0;

                int possibleStrLength = count0 + count1 + (input.charAt(i) == '1' ? 1 : 0)
                        + (input.charAt(i + 1) == '0' ? 1 : 0);
                long cost = (long) ((input.length() - possibleStrLength) * 1000000000001l);
                if (input.charAt(i) > input.charAt(i + 1)) {
                    cost += 1000000000000l;
                }

                ans = Math.min(ans, cost);
            }

            System.out.println(ans);

        }

    }
}