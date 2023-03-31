// 59A - Word

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String word = in.nextLine();
        int upper = 0, lower = 0;

        for (int i = 0; i < word.length(); i++) {
            char l = word.charAt(i);
            if (l - 'a' >= 0 && l - 'a' < 26) {
                // lowercase
                lower++;
            } else {
                upper++;
            }
        }

        if (lower >= upper) {
            System.out.println(word.toLowerCase());
        } else {
            System.out.println(word.toUpperCase());
        }

    }
}