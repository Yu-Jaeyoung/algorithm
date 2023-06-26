package src.baekjoon.mathmatics.p1008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String readLine = bufferedReader.readLine();
        StringTokenizer token = new StringTokenizer(readLine);
        double token_1 = Double.parseDouble(token.nextToken());
        double token_2 = Double.parseDouble(token.nextToken());
        System.out.print(token_1 / token_2);
    }
}