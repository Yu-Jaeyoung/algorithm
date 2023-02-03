package src.tree.p1991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
    char data;
    Node rightNode;
    Node leftNode;

    public char getData() {
        return data;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    Node(char data) {
        this.data = data;
    }
}

class Tree {
    Node node;

    public void createBinaryTree(char data, char leftData, char rightData) {
        if (node == null) {
            node = new Node(data);
            if (leftData == '.') {
                node.setLeftNode(null);
            } else {
                node.setLeftNode(new Node(leftData));
            }

            if (rightData == '.') {
                node.setRightNode(null);
            } else {
                node.setRightNode(new Node(rightData));
            }
        } else {
            recursiveTreeTraversal(node, data, leftData, rightData);
        }
    }

    public void recursiveTreeTraversal(Node node, char data, char leftData, char rightData) {
        if (node == null) {
            return;
        } else if (node.getData() == data) {
            if (leftData == '.') {
                node.setLeftNode(null);
            } else {
                node.setLeftNode(new Node(leftData));
            }

            if (rightData == '.') {
                node.setRightNode(null);
            } else {
                node.setRightNode(new Node(rightData));
            }
        } else {
            recursiveTreeTraversal(node.getLeftNode(), data, leftData, rightData);
            recursiveTreeTraversal(node.getRightNode(), data, leftData, rightData);
        }
    }

    public void preorderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.data);
            preorderTraversal(node.leftNode);
            preorderTraversal(node.rightNode);
        }
    }

    public void inorderTraversal(Node node) {
        if (node != null) {
            inorderTraversal(node.leftNode);
            System.out.print(node.data);
            inorderTraversal(node.rightNode);
        }
    }

    public void postorderTraversal(Node node) {
        if (node != null) {
            postorderTraversal(node.leftNode);
            postorderTraversal(node.rightNode);
            System.out.print(node.data);
        }
    }
}

public class Main {
    public static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Tree tree = new Tree();
        //System.out.print("노드 개수 입력 : ");
        int nodeCount = Integer.parseInt(String.valueOf(bufferedReader.readLine()));

        for (int i = 0; i < nodeCount; i++) {
            //System.out.print("입력 : ");
            String lineString = bufferedReader.readLine();

            StringTokenizer token = new StringTokenizer(lineString, " ", false);
            char data = token.nextToken().charAt(0);
            char leftData = token.nextToken().charAt(0);
            char rightData = token.nextToken().charAt(0);

            tree.createBinaryTree(data, leftData, rightData);
        }
        tree.preorderTraversal(tree.node);
        System.out.println();
        tree.inorderTraversal(tree.node);
        System.out.println();
        tree.postorderTraversal(tree.node);
    }
}