function solution(phone_number) {
  let visiblePhoneNumber = phone_number.slice(-4);
  return '*'.repeat(phone_number.length - 4) + visiblePhoneNumber;
}