import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int noOfCases = in.nextInt();

        for (int z = 0; z < noOfCases; z++) {

            int len = in.nextInt();
            int num = in.nextInt();
            in.nextLine();

            String nums = in.nextLine();
            int i = 0;

            for (; i < nums.length(); i++) {
                if (num > nums.charAt(i) - '0') {
                    break;
                }
            }

            System.out.println(nums.substring(0, i) + num + nums.substring(i, nums.length()));

        }
    }

}