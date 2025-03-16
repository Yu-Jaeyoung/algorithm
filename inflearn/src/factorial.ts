// 함수가 만들어져 있다 가정하고 재귀적으로 작성하기
function factorial (number) {
  if (number == 1 || number == 0) {
    return 1;
  }
  return number * factorial(number - 1);
}

console.log(factorial(5));


function sumOdd (n) {
  if (n == 1) {
    return 1;
  }

  if (n % 2 == 1) {
    return n + sumOdd(n - 1);
  } else {
    return sumOdd(n - 1);
  }
}

console.log(sumOdd(10)); // 25