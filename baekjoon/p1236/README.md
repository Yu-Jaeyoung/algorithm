# #1236 / 성 지키기

![Untitled](https://github.com/Yu-Jaeyoung/algorithm/assets/109587069/ec9b5371-a5f3-42e4-a593-d51b2082036f)

**- 행과 열을 비교하여 필요한 최소 경비수를 구하면 되는 문제**

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

        int rowSecurityExist = 0;
        int columnSecurityExist = 0;
        int row = Integer.parseInt(token.nextToken());
        int column = Integer.parseInt(token.nextToken());
        String[][] castle = new String[row][column];

        for (int i = 0; i < row; i++) {
            String[] split = bufferedReader.readLine().split("");
            for (int j = 0; j < column; j++) {
                castle[i][j] = split[j];
            }
        }

        // 행을 기준으로 판단
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (castle[i][j].equals("X")) {
                    rowSecurityExist++;
                    break;
                }
            }
        }

        // 열 기준으로 판단
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                if (castle[j][i].equals("X")) {
                    columnSecurityExist++;
                    break;
                }
            }
        }

        System.out.println(Math.max(row - rowSecurityExist, column - columnSecurityExist));
    }
}
```

**- 문제를 풀면서 항상 “C언어”같이 푼다는 느낌이 여전히 들고 있음**

- **Java 제공 라이브러리와 자바의 특성 등을 적극적으로 활용 필요..**

- 코드 검토 간 배열을 만드는 과정에서 System.arraycopy를 변경하여 성능 개선을 진행/확인하였음.

`Main.java`

```java
public class Main {
		...
    public static void main(String[] args) throws Exception {
	      ...
        for (int i = 0; i < row; i++) {
            String[] split = bufferedReader.readLine().split("");
            **System.arraycopy(split, 0, castle[i], 0, column);**
        }
		...     
    }
}
```

<br>
<br>

![Untitled 1](https://github.com/Yu-Jaeyoung/algorithm/assets/109587069/7b8e0229-c408-4216-98c0-09034ff363e5)
