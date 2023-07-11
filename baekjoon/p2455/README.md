# #2455 / 지능형 기차

![Untitled](https://github.com/Yu-Jaeyoung/algorithm/assets/109587069/d7fc8dbd-acdc-4316-ae64-130328d1bd8e)

- 간단한 산술 문제
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
        int currentCount = 0, maxCount = 0;

        for (int i = 0; i < 4; i++) {
            StringTokenizer token = new StringTokenizer(bufferedReader.readLine());
            int out = Integer.parseInt(token.nextToken());
            int in = Integer.parseInt(token.nextToken());

            currentCount = currentCount + in - out;

            if (maxCount < currentCount) {
                maxCount = currentCount;
            }
        }
        System.out.print(maxCount);
    }
}
```
<br>
<br>

![Untitled 1](https://github.com/Yu-Jaeyoung/algorithm/assets/109587069/7b5efc39-0b54-4bc2-ac09-7abf809a9284)

<br>
<br>

![Untitled 2](https://github.com/Yu-Jaeyoung/algorithm/assets/109587069/34d7877a-5c36-440e-8647-46a0ba2c4fe5)