package src.baekjoon.p1236;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        StringTokenizer token = new StringTokenizer(bufferedReader.readLine());

        int rowSecurityExist = 0;
        int columnSecurityExist = 0;
        int row = Integer.parseInt(token.nextToken());
        int column = Integer.parseInt(token.nextToken());
        String[][] castle = new String[row][column];

        for (int i = 0; i < row; i++) {
            String[] split = bufferedReader.readLine().split("");
            System.arraycopy(split, 0, castle[i], 0, column);
        }

        // 행을 기준으로 판단
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (castle[i][j].equals("X")) {
                    rowSecurityExist++;
                    break;
                }
            }
        }

        // 열 기준으로 판단
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                if (castle[j][i].equals("X")) {
                    columnSecurityExist++;
                    break;
                }
            }
        }

        System.out.println(Math.max(row - rowSecurityExist, column - columnSecurityExist));
    }
}