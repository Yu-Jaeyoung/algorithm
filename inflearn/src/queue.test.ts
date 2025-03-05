import { Queue } from "./queue.ts";

let queue = new Queue();

console.log("===== enqueue() 세 번 호출 =====");
queue.enqueue(1);
queue.enqueue(2);
queue.enqueue(3);

console.info(queue.front());

console.info("===== dequeue() 네 번 호출 =====");
console.info(queue.dequeue());
console.info(queue.dequeue());
console.info(queue.dequeue());
console.info(queue.dequeue());

console.log(`isEmpty: ${ queue.isEmpty() }`);
