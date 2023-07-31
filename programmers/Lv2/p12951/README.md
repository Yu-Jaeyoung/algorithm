# #12951 / JadenCase 문자열 만들기 / Lv2

[#12951 / JadenCase 문자열 만들기 / Lv2](https://school.programmers.co.kr/learn/courses/30/lessons/12951)

<br>

`solution.js`

```jsx
function solution(s) {
  let answer = s.toLowerCase().split(' ');

  for (let i = 0; i < answer.length; i++) {
    answer[i] = answer[i].slice(0, 1).toUpperCase() + answer[i].slice(1);
  }
  return answer.join(' ');
}
```
- 입력 받은 값을 LowerCase처리해서 split을 진행
- 이후 split된 값을 가지고 JadenCase로 만드는 작업을 진행
- `join(’ ‘)`처리하여 만들어진 문자열을 반환

<br>

![Untitled](https://github.com/Yu-Jaeyoung/algorithm/assets/109587069/e665ff1d-53d8-405e-b430-4002ea85d474)