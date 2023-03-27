// 1798B - Three Sevens

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int totalTestCases = in.nextInt();
        for (int z = 0; z < totalTestCases; z++) {
            int noOfDays = in.nextInt();

            HashSet<Integer> days = new HashSet();
            int[] result = new int[noOfDays];

            HashMap<Integer, Integer> daysSet = new HashMap();

            for (int i = 0; i < noOfDays; i++) {
                days.add(i);
                int noOfParticipants = in.nextInt();

                for (int k = 0; k < noOfParticipants; k++) {
                    int person = in.nextInt();
                    daysSet.put(person, i);
                }

            }

            for (Map.Entry<Integer, Integer> entry : daysSet.entrySet()) {
                result[entry.getValue()] = entry.getKey();
                days.remove(entry.getValue());

            }

            if (days.size() > 0) {
                System.out.print("-1");
            } else {
                for (int ans : result) {
                    System.out.print(ans + "\s");
                }
            }
            System.out.print("\n");

        }

    }

}