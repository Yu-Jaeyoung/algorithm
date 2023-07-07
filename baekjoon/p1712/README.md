# #1712 / 손익분기점
<br>

<img width="1170" alt="Untitled" src="https://github.com/Yu-Jaeyoung/algorithm/assets/109587069/73e6299e-b60d-433e-b07a-44edaeca8ec9">
<br>
<br>

- 간단한 산술 문제

- 함정이 있다면, 0으로 나누어지는 부분에 대한 예외처리를 해야했다.
<br>
<br>


`Main.java`

```jsx
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        StringTokenizer token = new StringTokenizer(bufferedReader.readLine());

        int FixedCoast = Integer.parseInt(token.nextToken());
        int FlexibleCoast = Integer.parseInt(token.nextToken());
        int price = Integer.parseInt(token.nextToken());

        int FOR_BREAK_EVEN_POINT = price - FlexibleCoast;

        if (FOR_BREAK_EVEN_POINT <= 0) {
            System.out.println("-1");
        } else {
            System.out.println((FixedCoast / FOR_BREAK_EVEN_POINT) + 1);
        }
    }
}
```

## 체점 결과

<img width="1051" alt="Untitled 1" src="https://github.com/Yu-Jaeyoung/algorithm/assets/109587069/91d6604d-0aca-4e9a-a385-7f441d2c1bc1">