# #120903 / 배열의 유사도 / Lv0

[#120903 / 배열의 유사도 / Lv0](https://school.programmers.co.kr/learn/courses/30/lessons/120903)

### **문제 설명**

두 배열이 얼마나 유사한지 확인

문자열 배열 `s1`과 `s2`가 주어질 때 같은 원소의 개수를 return하도록 solution 함수를 완성할 것

---

### 제한사항

- 1 ≤ `s1`, `s2`의 길이 ≤ 100
- 1 ≤ `s1`, `s2`의 원소의 길이 ≤ 10
- `s1`과 `s2`의 원소는 알파벳 소문자로만 이루어짐
- `s1`과 `s2`는 각각 중복된 원소를 갖지 않음

---

### 입출력 예

| s1 | s2 | result |
| --- | --- | --- |
| ["a", "b", "c"] | ["com", "b", "d", "p", "c"] | 2 |
| ["n", "omg"] | ["m", "dot"] | 0 |

---

### 입출력 예 설명

입출력 예 #1

- "b"와 "c"가 같으므로 2를 return

입출력 예 #2

- 같은 원소가 없으므로 0을 return

<br>

`solution.js`

```jsx
function solution(s1, s2) {
    return s1.filter(item => s2.includes(item)).length;
}
```
- Array.prototype.filter를 사용

- filter 메서드는 자신을 호출한 배열의 모든 요소를 순회하면서 인수로 전달받은 콜백 함수를 반복 호출

- 콜백 함수의 반환값이 true인 요소로만 구성된 새로운 배열을 반환

    → length를 사용해 true인 요소로만 구성된 새로운 배열의 길이를 반환

<br>

![Untitled](https://github.com/Yu-Jaeyoung/algorithm/assets/109587069/ab502cce-1d24-4bd3-a0d3-ce4d1ef85434)