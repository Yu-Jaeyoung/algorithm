package src.baekjoon.tree.p1068;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

class Node {
    int nodeNum;
    Node left;
    Node right;

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getNodeNum() {
        return nodeNum;
    }


    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    Node(int nodeNum) {
        this.nodeNum = nodeNum;
    }
}

class Tree {
    Node node;

    void createNewTree(int nodeNum, int parentNodeNum) {
        if (node == null) {
            if (parentNodeNum == -1) {
                node = new Node(nodeNum);
            }
        } else {
            recursiveTreeTraversal(node, nodeNum, parentNodeNum);
        }
    }

    void recursiveTreeTraversal(Node node, int nodeNum, int parentNodeNum) {
        if (node == null) {
            return;
        }

        if (node.getLeft() == null && node.getNodeNum() == parentNodeNum) {
            node.setLeft(new Node(nodeNum));
        } else if (node.getRight() == null && node.getNodeNum() == parentNodeNum) {
            node.setRight(new Node(nodeNum));
        } else {
            recursiveTreeTraversal(node.getLeft(), nodeNum, parentNodeNum);
            recursiveTreeTraversal(node.getRight(), nodeNum, parentNodeNum);
        }
    }

    void deleteTreeTraversal(int nodeNum) {
        if (nodeNum == -1) {
            node = null;
        } else {
            deleteNode(node, nodeNum);
        }
    }

    void deleteNode(Node node, int nodeNum) {
        if (node == null) {
            return;
        }

        if (node.getLeft().getNodeNum() == nodeNum) {
            node.setLeft(null);
        } else if (node.getRight().getNodeNum() == nodeNum) {
            node.setRight(null);
        } else {
            deleteNode(node.getLeft(), nodeNum);
            deleteNode(node.getRight(), nodeNum);
        }
    }

    int checkLeaf(Node node) {
        int count = 0;
        if (node != null) {
            if (node.getLeft() == null && node.getRight() == null) {
                count++;
            } else {
                checkLeaf(node.getLeft());
                checkLeaf(node.getRight());
            }
            return count;
        }
        return count;
    }
}


public class Main {
    public static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Tree tree = new Tree();

        int nodeCount = Integer.parseInt(bufferedReader.readLine());
        String lineString = bufferedReader.readLine();


        StringTokenizer token = new StringTokenizer(lineString, " ", false);

        for (int i = 0; i < nodeCount; i++) {
            int parentNodeNum = Integer.parseInt(token.nextToken());
            System.out.println(parentNodeNum);
            tree.createNewTree(i, parentNodeNum);
        }


        int deleteNodeNum = Integer.parseInt(bufferedReader.readLine());

        tree.deleteTreeTraversal(deleteNodeNum);

        System.out.println(tree.checkLeaf(tree.node));
    }
}
