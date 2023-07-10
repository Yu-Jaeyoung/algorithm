package src.baekjoon.p1264;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;

public class Main {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        while (true) {
            String string = bufferedReader.readLine().toLowerCase();
            if (Objects.equals(string, "#")) {
                return;
            }

            int beforeLength = string.length();
            string = string.replace("a", "");
            string = string.replace("e", "");
            string = string.replace("i", "");
            string = string.replace("o", "");
            string = string.replace("u", "");

            int afterLength = string.length();

            int vowelsCount = beforeLength - afterLength;

            System.out.println(vowelsCount);
        }
    }
}
