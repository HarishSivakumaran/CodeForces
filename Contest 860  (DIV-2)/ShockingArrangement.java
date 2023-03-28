import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int totalTestCases = in.nextInt();
        for (int z = 0; z < totalTestCases; z++) {
            int len = in.nextInt(), curr = 0;
            List<Integer> pos = new ArrayList();
            List<Integer> neg = new ArrayList();
            List<Integer> ans = new ArrayList();
            for (int i = 0; i < len; i++) {
                curr = in.nextInt();
                if (curr == 0) {
                    ans.add(curr);
                } else if (curr > 0) {
                    pos.add(curr);
                } else {
                    neg.add(curr);
                }
            }

            if (ans.size() == len) {
                System.out.println("No");
                continue;
            }

            int sum = 0, p = 0, n = 0;

            for (int i = ans.size(); i < len; i++) {
                if (sum <= 0) {
                    sum += pos.get(p);
                    ans.add(pos.get(p++));
                } else {
                    sum += neg.get(n);
                    ans.add(neg.get(n++));
                }
            }

            System.out.println("Yes");
            for (int i : ans) {
                System.out.print(i + "\s");
            }
            System.out.print("\n");

        }

    }
}