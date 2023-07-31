function solution(s) {
  let answer = s.toLowerCase().split(' ');

  for (let i = 0; i < answer.length; i++) {
    answer[i] = answer[i].slice(0, 1).toUpperCase() + answer[i].slice(1);
  }
  return answer.join(' ');
}