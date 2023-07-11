package src.baekjoon.p2455;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int currentCount = 0, maxCount = 0;

        for (int i = 0; i < 4; i++) {
            StringTokenizer token = new StringTokenizer(bufferedReader.readLine());
            int out = Integer.parseInt(token.nextToken());
            int in = Integer.parseInt(token.nextToken());

            currentCount = currentCount + in - out;

            if (maxCount < currentCount) {
                maxCount = currentCount;
            }
        }
        System.out.print(maxCount);
    }
}