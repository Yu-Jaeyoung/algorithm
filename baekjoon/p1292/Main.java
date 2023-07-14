package src.baekjoon.p1292;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        StringTokenizer token = new StringTokenizer(bufferedReader.readLine());
        int start = Integer.parseInt(token.nextToken());
        int end = Integer.parseInt(token.nextToken());

        int result = 0;

        int[] sequence = new int[1000];
        int indexNum = 0;
        for (int i = 1; indexNum < 1000; i++) { // 인덱스 번호가 999일때 까지만 초기화
            for (int j = 0; j < i && indexNum < 1000; j++) { // j가 i보다 작고, 인덱스 번호가 999일때 까지만
                sequence[indexNum] = i;
                indexNum++;
            }
        }

        if (start == end) {
            System.out.print(sequence[start - 1]);
        } else if (start > end) {
            System.out.print("0");
        } else {
            for (int i = start - 1; i < end; i++) {
                result += sequence[i];
            }
            System.out.print(result);
        }
    }
}
