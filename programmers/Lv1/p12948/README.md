# #12948 / 핸드폰 번호 가리기 / Lv1

[#12948 / 핸드폰 번호 가리기 / Lv1](https://school.programmers.co.kr/learn/courses/30/lessons/12948)

### **문제 설명**

프로그래머스 모바일은 개인정보 보호를 위해 고지서를 보낼 때 고객들의 전화번호의 일부를 가립니다.

전화번호가 문자열 phone_number로 주어졌을 때, 전화번호의 뒷 4자리를 제외한 나머지 숫자를 전부 `*`으로 가린 문자열을 리턴하는 함수, solution을 완성해주세요.

### 제한 조건

- phone_number는 길이 4 이상, 20이하인 문자열입니다.

### 입출력 예

| phone_number | return |
| --- | --- |
| "01033334444" | "*******4444" |
| "027778888" | "*****8888" |

<br>

`Solution.js`

```jsx
function solution(phone_number) {
  let split_num = phone_number.split('', phone_number.indexOf(phone_number.slice(-4)));
  for (let i = 0; i < split_num.length; i++) {
    split_num[i] = '*';
  }
  return split_num.join('') + phone_number.slice(-4);
}
```

- 처음에 생각한 방법으로, 테스트 케이스에서 실패  

  → 실패한 부분은 indexof를 사용하는 부분에서 중복된 숫자가 입력되는 경우에 잘못된 처리가 일어남

  → 12341234와 같은 입력에 대한 처리가 실패하는 것으로 생각됨

<br>

`Solution.js`

```jsx
function solution(phone_number) {
  let visiblePhoneNumber = phone_number.slice(-4);
  return '*'.repeat(phone_number.length - 4) + visiblePhoneNumber;
}
```

- 최종적으로 생각해낸 방법
- slice를 진행한 뒤, String.prototype.repeat 메소드를 사용해서 `*`를 반복시키는 방법을 사용

<br>

![Untitled](https://github.com/Yu-Jaeyoung/algorithm/assets/109587069/409f2a7b-0072-45b7-a4af-eb503a8d0d53)