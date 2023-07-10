# #1264 / 모음의 개수

![Untitled](https://github.com/Yu-Jaeyoung/algorithm/assets/109587069/d017cab4-9fea-4cd6-8e62-f83d251329fe)

- 입력받은 값이 “#”인 경우에 대해서는 `Objects.equals(string, ”#”)` 을 활용

- `replace()`문을 활용하여 모음을 지운 뒤, `length()`로 체크하여 return 진행

`Main.java`

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;

public class Main {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        while (true) {
            String string = bufferedReader.readLine().toLowerCase();
            if (Objects.equals(string, "#")) {
                return;
            }

            int beforeLength = string.length();
            string = string.replace("a", "");
            string = string.replace("e", "");
            string = string.replace("i", "");
            string = string.replace("o", "");
            string = string.replace("u", "");

            int afterLength = string.length();

            int vowelsCount = beforeLength - afterLength;

            System.out.println(vowelsCount);
        }
    }
}
```

![Untitled 1](https://github.com/Yu-Jaeyoung/algorithm/assets/109587069/3bcfe4c8-6742-4651-9af7-160eb787d9d4)