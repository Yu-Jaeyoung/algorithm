import { HashSet } from "./hash.set.ts";

let hashSet = new HashSet();


console.info(`isEmpty: ${ hashSet.isEmpty() }`);

console.info("===== 데이터 삽입 =====");
hashSet.add(1);
hashSet.add(1);
hashSet.add(123);
hashSet.add(512);
hashSet.printAll();
console.info(`isEmpty: ${ hashSet.isEmpty() }`);

console.info("===== 데이터 체크1 =====");
console.info(`isContain: ${ hashSet.isContain(1) }`);

console.info("===== 데이터1 제거 =====");
hashSet.remove(1);
hashSet.printAll();
console.info(`isEmpty: ${ hashSet.isEmpty() }`);

console.info("===== 데이터 체크2 =====");
console.info(`isContain: ${ hashSet.isContain(1) }`);

console.info("===== clear =====");
hashSet.clear();
hashSet.printAll();
console.info(`isEmpty: ${ hashSet.isEmpty() }`);





