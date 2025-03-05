import { DoublyLinkedList } from "./doubly.linked.list.ts";

class Queue {
  constructor () {
    this.list = new DoublyLinkedList();
  }

  list;

  enqueue (data) {
    this.list.insertAt(0, data);
  }

  dequeue () {
    try {
      return this.list.deleteLast();
    } catch (e) {
      return null;
    }
  }

  front () {
    return this.list.tail;
  }

  isEmpty () {
    return (this.list.count == 0);
  }
}

export { Queue };