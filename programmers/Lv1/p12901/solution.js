function solution(a, b) {
  let dateName = ['SUN', 'MON', 'TUE', 'WED', 'THU', 'FRI', 'SAT'];
  return dateName[new Date(2016, a - 1, b).getDay()];
}

function solution2(a, b) {
  let dateName = ['SUN', 'MON', 'TUE', 'WED', 'THU', 'FRI', 'SAT'];
  return dateName[(new Date(2016 + `/${a}` + `/${b}`)).getDay()];
}