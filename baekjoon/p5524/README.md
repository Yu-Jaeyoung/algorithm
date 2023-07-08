# #5524 / 입실 관리

![Untitled](https://github.com/Yu-Jaeyoung/algorithm/assets/109587069/8c24a84b-9000-49ba-851f-d0956d1eaa38)


- 대소문자 변경 메소드 활용 문제
<br>
<br>

`Main.java`

```jsx
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int lineCount = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < lineCount; i++) {
            System.out.println(bufferedReader.readLine().toLowerCase());
        }
    }
}
```

![Untitled 1](https://github.com/Yu-Jaeyoung/algorithm/assets/109587069/4249a4f6-6df7-4682-8306-f8c53163c8e4)