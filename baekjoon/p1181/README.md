# #1181 / 단어 정렬

[1181번: 단어 정렬](https://www.acmicpc.net/problem/1181)

<br>

![Untitled](https://github.com/Yu-Jaeyoung/algorithm/assets/109587069/b823faf4-c5f4-4497-bbea-984fb5ba80ea)

- 조건을 정확히 파악하지 않고 다음과 같이 작성

<br>

`Main.java`

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {

        TreeSet<String> treeSet = new TreeSet<>();
        int addCount = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < addCount; i++) {
            treeSet.add(bufferedReader.readLine());
        }

        for (String string : treeSet) {
            System.out.println(string);
        }
    }
}
```

<br>

![Untitled 1](https://github.com/Yu-Jaeyoung/algorithm/assets/109587069/302ae63a-982b-439d-97e5-55c1e0b3460d)
- 사전 순으로만 정렬이 되어 조건으로 제시된 “길이” 조건이 적용되지 않은 상태

    → 아래와 같이 수정 진행

<br>

`Main.java`

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {

        int wordCount = Integer.parseInt(bufferedReader.readLine());

        List<WordInfo> words = new ArrayList<>();
        Set<String> uniqueWords = new HashSet<>();

        for (int i = 0; i < wordCount; i++) {
            String word = bufferedReader.readLine();
            if (uniqueWords.add(word)) {
                words.add(new WordInfo(word));
            }
        }

        words.sort(new Comparator<WordInfo>() {
            @Override
            public int compare(WordInfo wordInfo1, WordInfo wordInfo2) {
                int lengthCompare = Integer.compare(wordInfo1.length, wordInfo2.length);
                if (lengthCompare != 0) {
                    return lengthCompare;
                } else {
                    return wordInfo1.word.compareTo(wordInfo2.word);
                }
            }
        });

        for (WordInfo wordInfo : words) {
            System.out.println(wordInfo.word);
        }
    }

    static class WordInfo {
        String word;
        int length;

        public WordInfo(String word) {
            this.word = word;
            this.length = word.length();
        }
    }
}
```

- 최초에는 입력 받을 단어의 개수를 받음

- 이후 정렬하게 되는 과정에서 NestedClass로 선언된 WordInfo로 객체를 생성하여 활용

    → 생성자로 입력된 word의 length를 구해 필드 값을 초기화

- List는 중복된 값을 저장하는 것을 허용 → 자체적으로 중복된 값을 제거하는 기능을 가지고있지 않음

- 이때, Set 자료구조를 활용해 중복된 값을 제거하게 사용

    → `if (uniqueWords.add(word))`에서 반환되는 결과, boolean 값으로 저장 여부를 판단

    → Set 자료구조의 add 과정에서 중복된 값이 있으면 false를, (추가되지 않음) 반대의 경우 true를 반환

- List의 sort를 활용하며, 익명 함수를 활용해 정렬 조건을 재정의(Override) 진행

- 먼저 `Integer.compare`를 활용하여 두 길이를 비교하고, 같지 않으면( `!0` ) 먼저 길이 순으로 정렬

- 이후, 길이가 같은 경우에 대해서는 word를 가지고 사전순(오름 차순으로 정렬)으로 정렬

- 마지막으로 향상된 for문을 활용하여 words의 값을 출력

<br>

![Untitled 2](https://github.com/Yu-Jaeyoung/algorithm/assets/109587069/ae98fcca-cbaf-4b8a-a70a-b71a0f7f9af4)