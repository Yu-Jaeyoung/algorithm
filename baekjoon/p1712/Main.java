package src.baekjoon.p1712;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        StringTokenizer token = new StringTokenizer(bufferedReader.readLine());

        int FixedCoast = Integer.parseInt(token.nextToken());
        int FlexibleCoast = Integer.parseInt(token.nextToken());
        int price = Integer.parseInt(token.nextToken());

        int FOR_BREAK_EVEN_POINT = price - FlexibleCoast;

        if (FOR_BREAK_EVEN_POINT <= 0) {
            System.out.println("-1");
        } else {
            System.out.println((FixedCoast / FOR_BREAK_EVEN_POINT) + 1);
        }
    }
}