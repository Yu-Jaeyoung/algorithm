import { Deque } from "./deque.ts";

let deque = new Deque();

console.info("===== addFirst =====");
console.info(`isEmpty: ${ deque.isEmpty() }`);
deque.addFirst(1);
deque.addFirst(2);
deque.addFirst(3);
deque.addFirst(4);
deque.addFirst(5);
deque.printAll();
console.info(`isEmpty: ${ deque.isEmpty() }`);
console.info("\n");

console.log("===== removeFirst =====");
deque.removeFirst();
deque.printAll();
deque.removeFirst();
deque.printAll();
deque.removeFirst();
deque.printAll();
deque.removeFirst();
deque.printAll();
deque.removeFirst();
deque.printAll();
console.info(`isEmpty: ${ deque.isEmpty() }`);
console.info("\n");

console.log("===== addLast =====");
deque.addLast(1);
deque.addLast(2);
deque.addLast(3);
deque.addLast(4);
deque.addLast(5);
deque.printAll();
console.info(`isEmpty: ${ deque.isEmpty() }`);
console.info("\n");

console.log("===== removeLast =====");
deque.removeLast();
deque.printAll();
deque.removeLast();
deque.printAll();
deque.removeLast();
deque.printAll();
deque.removeLast();
deque.printAll();
deque.removeLast();
deque.printAll();

console.info(`isEmpty: ${ deque.isEmpty() }`);