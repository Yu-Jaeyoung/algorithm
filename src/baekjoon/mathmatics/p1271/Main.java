package src.baekjoon.mathmatics.p1271;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String readLine = bufferedReader.readLine();
        StringTokenizer token = new StringTokenizer(readLine);
        BigInteger token_1 = new BigInteger(token.nextToken());
        BigInteger token_2 = new BigInteger(token.nextToken());
        System.out.println(token_1.divide(token_2));
        System.out.print(token_1.remainder(token_2));
    }
}