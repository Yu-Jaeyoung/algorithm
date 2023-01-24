package src.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        for (int i = 0; i < number; i++) {
            queue.add(i + 1);
        }

        for (int i = 0; i < number-1; i++) {
            queue.poll();
            queue.add(queue.poll());
        }

        System.out.print(queue.peek());
    }
}