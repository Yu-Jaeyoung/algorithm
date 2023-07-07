package src.baekjoon.mathmatics.p1001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String readLine = bufferedReader.readLine();
        StringTokenizer token = new StringTokenizer(readLine);
        int token_1 = Integer.parseInt(token.nextToken());
        int token_2 = Integer.parseInt(token.nextToken());
        System.out.print(token_1 - token_2);
    }
}