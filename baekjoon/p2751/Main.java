package src.baekjoon.p2751;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {

        int count = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();


        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            numbers.add(Integer.parseInt(bufferedReader.readLine()));
        }

        Collections.sort(numbers);

        for (int number : numbers) {
            stringBuilder.append(number).append('\n');
        }
        System.out.println(stringBuilder);
    }
}
