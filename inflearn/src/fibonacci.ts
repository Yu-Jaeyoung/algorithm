function fibonacciRecursion (n) {
  if (n === 0 || n === 1) {
    return n;
  }
  return fibonacciRecursion(n - 2) + fibonacciRecursion(n - 1);
}

function fibonacciMemoization (
  n,
  memo,
) {
  if (n === 0 || n === 1) {
    return n;
  }

  if (memo[n] == null) {
    memo[n] = fibonacciMemoization(n - 2, memo) + fibonacciMemoization(n - 1, memo);
  }

  return memo[n];
}

function fibonacciTabulation (n) {
  if (n <= 1) {
    return n;
  }

  let table = [ 0, 1 ];

  for (let i = 2; i <= n; i++) {
    table[i] = table[i - 2] + table[i - 1];
  }

  return table[n];
}

let start = new Date();
console.info(fibonacciRecursion(45));
let end = new Date();
console.log(`fibonacciRecursion 함수 실행 시간 : ${ end - start }ms`);

start = new Date();
console.info(fibonacciMemoization(45, {}));
end = new Date();
console.log(`fibonacciMemoization 함수 실행 시간 : ${ end - start }ms`);


start = new Date();
console.info(fibonacciTabulation(45));
end = new Date();
console.log(`fibonacciTabulation 함수 실행 시간 : ${ end - start }ms`);