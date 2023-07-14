# #1292 / 쉽게 푸는 문제

[#1292](https://www.acmicpc.net/problem/1292)

![Untitled](https://github.com/Yu-Jaeyoung/algorithm/assets/109587069/7007c45b-bfd4-4143-b0bd-0081f3514336)


- 문제를 꼼꼼히 읽자.    → 문제를 잘 읽어보는 것이 포인트

- for문을 활용한 배열 초기화 과정 + 인덱스 번호로 장난치는 것에 유의해 풀이해야 했음

<br>
<br>

`Main.java`

```java
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
```

<br>
<br>

![Untitled 1](https://github.com/Yu-Jaeyoung/algorithm/assets/109587069/9d259a5b-a94f-4d6f-9c52-aacdb0dd35e9)