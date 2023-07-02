package src.baekjoon.mathmatics.p1330;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        String lineString = bufferedReader.readLine();
        String[] token = lineString.split(" ", 2);

        if (Integer.parseInt(token[0]) == Integer.parseInt(token[1])) {
            System.out.println("==");
        } else if (Integer.parseInt(token[0]) < Integer.parseInt(token[1])) {
            System.out.println("<");
        } else {
            System.out.println(">");
        }
    }
}