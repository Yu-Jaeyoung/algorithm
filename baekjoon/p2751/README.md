# #2751 / 수 정렬하기 2

[https://www.acmicpc.net/problem/2751](https://www.acmicpc.net/problem/2751)

`Main.java`

```java
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
```

<br>

![Untitled](https://github.com/Yu-Jaeyoung/algorithm/assets/109587069/d2d68f32-6076-46c0-ae20-0e498f16c030)