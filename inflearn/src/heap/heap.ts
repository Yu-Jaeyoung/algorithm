import { BinaryTree } from "./binary.tree.ts";

class Heap {

  root;
  lastInsertedNode;

  constructor () {
    this.root = null;
    this.lastInsertedNode = null;
  }

  insert (data) {
    if (this.lastInsertedNode == null) {
      this.lastInsertedNode = new BinaryTree(data);
      this.root = this.lastInsertedNode;
      return;
    }
    let insertingParent = this.getInsertingParent();
    let newNode = new BinaryTree(data);

    if (insertingParent.getLeftSubTree() == null) {
      insertingParent.setLeftSubTree(newNode);
    } else if (insertingParent.getRightSubTree() == null) {
      insertingParent.setRightSubTree(newNode);
    }

    newNode.setParent(insertingParent);
    this.lastInsertedNode = newNode;

    while (newNode.getParent() != null) {
      if (this.isBigPriority(newNode.getData(), newNode.getParent()
                                                       .getData())) {
        let tempData = newNode.getParent()
                              .getData();

        newNode.getParent()
               .setData(newNode.getData());

        newNode.setData(tempData);

        newNode = newNode.getParent();
      } else {
        break;
      }
    }
  }

  // Minheap
  isBigPriority (
    first,
    second,
  ) {
    return first.priority < second.priority;
  }

  getInsertingParent () {
    if (this.lastInsertedNode.getParent() == null) { // lastInsertedNode 가 루트노드인 경우
      return this.lastInsertedNode;
    } else {
      if (this.lastInsertedNode == this.lastInsertedNode.getParent()
                                       .getLeftSubTree()) { // lastInsertedNode 가 부모노드의 왼쪽 자식노드인 경우
        return this.lastInsertedNode.getParent();
      } else { // lastInsertedNode 가 부모노드의 오른쪽 자식노드인 경우
        let current = this.lastInsertedNode;
        let firstRightSibling = null; // 첫 오른쪽 형제를 기억하기위한 변수

        while (current.getParent()
                      .getParent() != null) { // 루트노드는 형제노드가 없으므로, 부모노드의 부모노드가 null 이 아닐때 까지 반복
          current = current.getParent();
          firstRightSibling = this.getRightSibling(current);

          if (firstRightSibling != null) { // 오른쪽 형제노드가 존재하면 탈출
            break;
          }
        }

        // 부모노드 중 오른쪽 형제가 있는 경우와 없는 경우의 처리
        if (firstRightSibling != null) { // 왼쪽 자식 노드로 계속 내려감
          while (firstRightSibling.getLeftSubTree() != null) {
            firstRightSibling = firstRightSibling.getLeftSubTree();
          }
          return firstRightSibling;
        } else {
          current = this.root;
          while (current.getLeftSubTree() != null) { // 가장 왼쪽 자식노드에 접근
            current = current.getLeftSubTree();
          }

          return current;
        }
      }
    }
  }

  // 오른쪽 형제 노드를 가지고 오는 메서드
  getRightSibling (node) {
    if (node.getParent()
            .getRightSubTree() != node) {
      return node.getParent()
                 .getRightSubTree();
    }

    return null;
  }

  getLeftSibling (node) {
    if (node.getParent()
            .getLeftSubTree() != node) {
      return node.getParent()
                 .getLeftSubTree();
    }

    return null;
  }

  remove () {
    let deletedNode = null;
    if (this.lastInsertedNode == this.root) {
      deletedNode = this.root;
      this.root = null;
      this.lastInsertedNode = null;
      return deletedNode;
    }

    let prevLastInsertedNode = this.getNewLastInsertedNode();
    let tempData = this.root.getData();
    this.root.setData(this.lastInsertedNode.getData());
    this.lastInsertedNode.setData(tempData);

    if (this.lastInsertedNode.getParent()
            .getLeftSubTree() == this.lastInsertedNode) {
      this.lastInsertedNode.getParent()
          .setLeftSubTree(null);
    } else {
      this.lastInsertedNode.getParent()
          .setRightSubTree(null);
    }
    this.lastInsertedNode.setParent(null);

    deletedNode = this.lastInsertedNode;
    this.lastInsertedNode = prevLastInsertedNode;


    // heapify
    let current = this.root;
    // 무조건 한번은 실행되도록 do while 문으로 지정
    do {
      let higherChild = this.getHigherPriorityChild(current.getLeftSubTree(), current.getRightSubTree());

      // 자식노드가 없는 경우
      if (higherChild == null) {
        break;
      } else if (!this.isBigPriority(current.getData(), higherChild.getData())) {
        let tempData = current.getData();
        current.setData(higherChild.getData());
        higherChild.setData(tempData);
        current = higherChild;
      } else {
        break;
      }
    } while (current.getLeftSubTree() != null || current.getRightSubTree() != null);

    return deletedNode;
  }

  getHigherPriorityChild (
    left,
    right,
  ) {
    if (left == null) {
      return right;
    } else if (right == null) {
      return left;
    } else if (this.isBigPriority(left.getData(), right.getData())) {
      return left;
    } else {
      return right;
    }
  }

  // 1. 마지막에 삽입된 노드가 부모노드의 왼쪽 자식노드인 경우
  //    a. 부모노드 중에 왼쪽 형제노드가 존재하는 경우
  //    b. 부모노드 중에 왼쪽 형제노드가 존재하지 않는 경우
  // 2, 마지막에 삽입된 노드가 부모노드의 오른쪽 자식노드인 경우
  getNewLastInsertedNode () {
    let prevLastInsertedNode = null;

    if (this.lastInsertedNode == this.lastInsertedNode.getParent()
                                     .getLeftSubTree()) {
      let current = this.lastInsertedNode;
      let firstLeftSibling = null;
      while (current.getParent()
                    .getParent() != null) {
        current = current.getParent();
        firstLeftSibling = this.getLeftSibling(current);
        if (firstLeftSibling != null) {
          break;
        }
      }

      if (firstLeftSibling != null) {
        while (firstLeftSibling.getRightSubTree() != null) {
          firstLeftSibling = firstLeftSibling.getRightSubTree();
        }
        prevLastInsertedNode = firstLeftSibling;
      } else {
        current = this.root;
        while (current.getRightSubTree() != null) {
          current = current.getRightSubTree();
        }
        prevLastInsertedNode = current;
      }
    } else {
      prevLastInsertedNode = this.lastInsertedNode.getParent()
                                 .getLeftSubTree();
    }

    return prevLastInsertedNode;
  }
}

// let heap = new Heap();
// heap.insert(4);
// heap.insert(2);
// heap.insert(5);
// heap.insert(7);
// heap.insert(1);

// heap.root.inOrderTraversal(heap.root);
// console.log(heap.root);

// console.log("==== remove ====");
// console.log(heap.remove());
// console.log(heap.remove());
// console.log(heap.remove());

class Person {
  name;
  age;
  priority;

  constructor (
    name,
    age,
  ) {
    this.name = name;
    this.age = age;
    this.priority = age;
  }
}

// let heap = new Heap();
// heap.insert(new Person("가", 20));
// heap.insert(new Person("나", 10));
// heap.insert(new Person("다", 30));
//
// console.log(heap.root);

export { Heap };