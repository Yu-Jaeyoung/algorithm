package src.baekjoon.stack.p10828;

/*push X: 정수 X를 스택에 넣는 연산이다.
pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 스택에 들어있는 정수의 개수를 출력한다.
empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    private static final Stack<Integer> stack = new Stack<>();
    public static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {

        int max = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < max; i++) {
            String lineString = bufferedReader.readLine();
            String[] token = lineString.split(" ", 2);
            makeStack(token);
        }
    }

    private static void makeStack(String[] token) {
        switch (token[0]) {
            case "push" -> stack.push(Integer.parseInt(token[1]));
            case "pop" -> {
                if (stack.isEmpty())
                    System.out.println("-1");
                else
                    System.out.println(stack.pop());
            }

            case "size" -> System.out.println(stack.size());

            case "empty" -> {
                if (stack.empty())
                    System.out.println("1");
                else
                    System.out.println("0");
            }

            case "top" -> {
                if (stack.empty())
                    System.out.println("-1");
                else
                    System.out.println(stack.peek());
            }
        }
    }
}
