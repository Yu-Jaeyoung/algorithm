package src.baekjoon.mathmatics.p1267;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int count = Integer.parseInt(bufferedReader.readLine());

        int Y_cost = 30, Y_count = 0, M_cost = 60, M_count = 0;

        StringTokenizer token = new StringTokenizer(bufferedReader.readLine(), " ");
        for (int i = 0; i < count; i++) {

            int time = Integer.parseInt(token.nextToken());

            if ((time % Y_cost) == 0) {
                Y_count = Y_count + (time / Y_cost) + 1;
            } else {
                if (time < Y_cost) {
                    Y_count += 1;
                } else {
                    Y_count = Y_count + (time / Y_cost) + 1;
                }
            }

            if ((time % M_cost) == 0) {
                M_count = M_count + (time / M_cost) + 1;
            } else {
                if (time < M_cost) {
                    M_count += 1;
                } else {
                    M_count = M_count + (time / M_cost) + 1;
                }
            }
        }

        if (Y_count * 10 == M_count * 15)
            System.out.print("Y M " + Y_count * 10);
        else if (Y_count * 10 > M_count * 15)
            System.out.print("M " + M_count * 15);
        else
            System.out.print("Y " + Y_count * 10);
    }
}