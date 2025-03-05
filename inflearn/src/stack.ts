import { LinkedList } from "./linked.list.ts";

class Stack {
  constructor () {
    this.list = new LinkedList ();
  }

  list;

  push (data) {
    this.list.insertAt (0, data);
  }

  pop () {
    try {
      return this.list.deleteAt (0);
    } catch (e) {
      return null;
    }
  }

  peek () {
    return this.list.getNodeAt (0);
  }

  isEmpty () {
    return (this.list.count == 0);
  }
}

export { Stack };