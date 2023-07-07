package src.baekjoon.tree.p5639;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node {
    int data;
    Node leftNode;
    Node rightNode;

    public Node getLeftNode() {
        return leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public int getData() {
        return data;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    Node(int data) {
        this.data = data;
    }
}

class Tree {

    Node node;

    void createBinaryTree(int data) {
        if (node == null) {
            node = new Node(data);
        } else {
            recursiveBinaryTreeTraversal(node, data);
        }
    }

    void recursiveBinaryTreeTraversal(Node node, int data) {
        if (data <= node.getData()) {
            if (node.getLeftNode() == null) {
                node.setLeftNode(new Node(data));
                return;
            } else {
                recursiveBinaryTreeTraversal(node.getLeftNode(), data);
            }
        } else if (data > node.getData()) {
            if (node.getRightNode() == null) {
                node.setRightNode(new Node(data));
                return;
            } else {
                recursiveBinaryTreeTraversal(node.getRightNode(), data);
            }
        }
    }

    public void postOrderTraversal(Node node) {
        if (node != null) {
            postOrderTraversal(node.leftNode);
            postOrderTraversal(node.rightNode);
            System.out.println(node.getData());
        }
    }
}

public class Main {
    public static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Tree tree = new Tree();

        boolean check = true;

        while (check) {
            try {
                String inputData = bufferedReader.readLine();
                int nodeData = Integer.parseInt(inputData);
                if (nodeData == 0) {
                    check = false;
                }
                tree.createBinaryTree(nodeData);
            } catch (NumberFormatException e) {
                check = false;
            }
        }
        tree.postOrderTraversal(tree.node);
    }

}
