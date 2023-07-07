# #1000 / Mathmatics / A + B
<br>
<br>


![Untitled](https://github.com/Yu-Jaeyoung/data-structure/assets/109587069/5fdbbfd4-78c9-459e-80d5-75cedb8599cd)

<br>
<br>

# Java IO 패키지

- 프로그램에서 데이터를 외부에서 읽고 다시 외부로 출력하는 작업은 빈번히 일어남.

- 데이터는 사용자로부터 키보드로 입력될 수도 있고, 파일 또는 네트워크로부터 입력될 수 있음

- 데이터는 모니터로 출력될 수도 있고, 파일로 출력되어 저장될 수도 있으며, 네트워크로 출력되어 전송될 수 있음

- Java에서 **데이터는 스트림(Stream)을 통해 입출력**되므로 **스트림의 특징을 잘 이해하는 것이** **핵심**

- 자바의 기본적인 데이터 입출력 API는 **java.io 패키지**에서 제공하고 있음

> **Java로 작성하는 알고리즘은 실행 성능을 향상시켜 시간 단축하는 것이 핵심이라 생각한다.**
> 

<br>

## 콘솔 입출력

- 콘솔(Console)은 시스템을 사용하기 위해 키보드로 입력을 받고 화면으로 출력하는 소프트웨어

→ 자바는 콘솔로부터 데이터를 입력받을 때 **System.in** 필드를 사용

→ System.in은 InputStream 타입의 필드이므로 InputStream 변수로 참조가 가능
<br>
<br>

## 보조 스트림

- 다른 스트림과 연결되어 여러 가지 편리한 기능을 제공해주는 스트림

- 보조 스트림을 필터(filter) 스트림이라고도함

- 자체적으로 입출력을 수행할 수 없으므로 입력/출력 소스와 바로 연결되는 것과 연결해 입출력을 수행

ex) 콘솔 입력 스트림을 문자 변화 보조 스트림인 InputStreamReader에 연결하는 코드

```java
InputStreamReader reader = new InputStreamReader(System.in);
```
<br>

### 문자 변환 보조 스트림

- 소스 스트림이 바이트 기반 스트림(InputStream, OutputStream, FileInputStream, FileOutputStream)이면서 입출력 데이터가 문자라면 Reader와 Writer로 변환해서 사용하는 것을 고려해야함.

→ Reader와 Writer는 문자 단위로 입출력하기 때문에….

1. 바이트 기반 스트림보다는 편리
2. 문자셋의 종류를 지정할 수 있음→ 다양한 문자를 입출력 가능
<br>
<br>

### 성능 향상 보조 스트림

- 프로그램이 입출력 소스와 직접 작업하지 않고, 메모리 버퍼(Buffer)와 작업함으로써 실행 성능을 향상 진행

`BufferedReader` : 문자 입력 스트림에 연결되어 버퍼를 제공해주는 보조 스트림

<aside>
❗ 위 내용을 기반, Java로 작성하는 알고리즘의 입출력은 항상 아래와 비슷한 형식으로 사용 예정

</aside>
<br>
<br>

`Main.java`

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String readLine = bufferedReader.readLine();
				...
    }
}
```


`Main.java`

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String readLine = bufferedReader.readLine();
        StringTokenizer token = new StringTokenizer(readLine);
        int token_1 = Integer.parseInt(token.nextToken());
        int token_2 = Integer.parseInt(token.nextToken());
        System.out.print(token_1 + token_2);
    }
}
```

- StringTokenizer를 활용해서 입력받은 문자열을 토큰으로 변경

- StringTokenizer의 정의를 보면 아래와 같음

```java
/**
 * Constructs a string tokenizer for the specified string. The
 * tokenizer uses the default delimiter set, which is
 * " \t\n\r\f": the space character, the tab character, 
 * the newline character, the carriage-return character,
 * and the form-feed character. Delimiter characters themselves will
 * not be treated as tokens.
 *
 * Params: str - a string to be parsed.
 * Throws: NullPointerException - if str is null
 */
public StringTokenizer(String str) {
    this(str, " \t\n\r\f", false);
}
```

- 파라미터로 아무런 입력이 없을 시, `" \t\n\r\f"` 를 기준으로 분해 진행

- 생각 하기에는 스택과 같은 형태의 토큰으로 나뉘게 되어, `token.nextToken()`으로 poll 하여 토큰에 접근

- 꺼내진 토큰은 사용 후 제거됨

<br>
<br>

## 실행 결과

![Untitled 1](https://github.com/Yu-Jaeyoung/data-structure/assets/109587069/264628d5-cc9f-4470-a209-44d87b26f766)


<br>

## 체점 결과

![Untitled 2](https://github.com/Yu-Jaeyoung/data-structure/assets/109587069/335816b8-3eb6-4754-9bb3-01ed1b611e5b)
