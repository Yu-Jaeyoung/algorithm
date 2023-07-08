package src.baekjoon.p5524;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int lineCount = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < lineCount; i++) {
            System.out.println(bufferedReader.readLine().toLowerCase());
        }
    }
}