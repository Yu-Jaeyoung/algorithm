class BinaryTree {

  data;
  leftSubTree;
  rightSubTree;

  constructor (
    data,
    leftTree = null,
    rightTree = null,
  ) {
    this.data = data;
    this.leftSubTree = leftTree;
    this.rightSubTree = rightTree;
  }

  getData () {
    return this.data;
  }

  setData (data) {
    this.data = data;
  }

  getLeftSubTree () {
    return this.leftSubTree;
  }

  setLeftSubTree (tree) {
    this.leftSubTree = tree;
  }

  getRightSubTree () {
    return this.rightSubTree;
  }

  setRightSubTree (tree) {
    this.rightSubTree = tree;
  }

  preOrderTraversal (tree) {
    if (tree == null) return;

    console.log(tree.data);
    this.preOrderTraversal(tree.getLeftSubTree());
    this.preOrderTraversal(tree.getRightSubTree());
  }

  inOrderTraversal (tree) {
    if (tree == null) return;

    this.inOrderTraversal(tree.getLeftSubTree());
    console.log(tree.data);
    this.inOrderTraversal(tree.getRightSubTree());
  }

  postOrderTraversal (tree) {
    if (tree == null) return;

    this.postOrderTraversal(tree.getLeftSubTree());
    this.postOrderTraversal(tree.getRightSubTree());
    console.log(tree.data);
  }
}

export { BinaryTree };