# #12910 / 나누어 떨어지는 숫자 배열 / Lv1

[#12910 / 나누어 떨어지는 숫자 배열 / Lv1](https://school.programmers.co.kr/learn/courses/30/lessons/12910)

### **문제 설명**

array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수, solution을 작성

divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환

### 제한사항
- arr은 자연수를 담은 배열
- 정수 i, j에 대해 i ≠ j 이면 arr[i] ≠ arr[j]
- divisor는 자연수
- array는 길이 1 이상인 배열
<br>

### 입출력 예

| arr | divisor | return |
| --- | --- | --- |
| [5, 9, 7, 10] | 5 | [5, 10] |
| [2, 36, 1, 3] | 1 | [1, 2, 3, 36] |
| [3,2,6] | 10 | [-1] |

<br>

### 입출력 예 설명

#1 <br>
arr의 원소 중 5로 나누어 떨어지는 원소는 5와 10입니다. 따라서 [5, 10]을 리턴

#2 <br>
arr의 모든 원소는 1으로 나누어 떨어집니다. 원소를 오름차순으로 정렬해 [1, 2, 3, 36]을 리턴

#3 <br>
3, 2, 6은 10으로 나누어 떨어지지 않습니다. 나누어 떨어지는 원소가 없으므로 [-1]을 리턴

<br>

`Solution.js`

```jsx
function solution(arr, divisor) {
    let answer = arr.filter(item => item % divisor === 0);
    return answer.length === 0 ? [-1] : answer.sort((a, b) => a - b);
}
```
- Array.prototype.filter를 활용

    → filter 메서드는 자신을 호출한 배열의 모든 요소를 순회하면서 인수로 전달받은 콜백 함수를 반복 호출

    → 콜백 함수의 반환값이 true인 요소로만 구성된 새로운 배열을 반환

- return문에서 answer의 길이를 판단해 0인 경우 조건에서 제시한 [-1]을 반환

- 아닌 경우 Array.prototype.sort를 활용하여 오름차순으로 정렬 후 반환

<br>

![Untitled](https://github.com/Yu-Jaeyoung/algorithm/assets/109587069/de03da1b-3fdb-4222-bf5f-2beafa9c5946)