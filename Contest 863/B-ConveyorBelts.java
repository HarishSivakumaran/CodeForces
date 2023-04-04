import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int noOfCases = in.nextInt();

        for (int z = 0; z < noOfCases; z++) {

            long n = in.nextLong();
            long t = 1, l = 1, b = n, r = n;

            long a1 = in.nextLong();
            long a2 = in.nextLong();

            long circle1 = Math.min(
                    Math.min(Math.abs(t - a1), Math.abs(b - a1)),
                    Math.min(Math.abs(l - a2), Math.abs(r - a2)));
            a1 = in.nextInt();
            a2 = in.nextInt();

            long circle2 = Math.min(
                    Math.min(Math.abs(t - a1), Math.abs(b - a1)),
                    Math.min(Math.abs(l - a2), Math.abs(r - a2)));

            System.out.println(Math.abs(circle1 - circle2));

        }
    }

}