package src.baekjoon.tree.p1068;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    int count = 0;
    Node node;

    void createNewTree(int nodeNum, int parentNodeNum) {
        if (node == null) {
            if (parentNodeNum == -1) {
                node = new Node(nodeNum);
            }
        } else {
            recursiveTreeTraversalForCreate(node, nodeNum, parentNodeNum);
        }
    }

    void recursiveTreeTraversalForCreate(Node node, int nodeNum, int parentNodeNum) {
        if (node == null) {
            return;
        }

        if (node.getNodeNum() == parentNodeNum) {
            if (node.getLeft() == null) {
                node.setLeft(new Node(nodeNum));
                return;
            } else if (node.getRight() == null) {
                node.setRight(new Node(nodeNum));
                return;
            } else {
                System.out.println("left, right node full");
            }
        } else {
            recursiveTreeTraversalForCreate(node.getLeft(), nodeNum, parentNodeNum);
            recursiveTreeTraversalForCreate(node.getRight(), nodeNum, parentNodeNum);
        }
    }

    void deleteTree(int nodeNum) {
        if (nodeNum == 0) {
            node = null;
        } else {
            recursiveTreeTraversalForDelete(node, nodeNum);
        }
    }

    void recursiveTreeTraversalForDelete(Node node, int nodeNum) {
        if (node == null) {
            return;
        }

        if (node.getLeft() != null && node.getLeft().getNodeNum() == nodeNum) {
            node.setLeft(null);
        } else if (node.getRight() != null && node.getRight().getNodeNum() == nodeNum) {
            node.setRight(null);
        } else {
            recursiveTreeTraversalForDelete(node.getLeft(), nodeNum);
            recursiveTreeTraversalForDelete(node.getRight(), nodeNum);
        }
    }

    int checkLeaf(Node node) {
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
            tree.createNewTree(i, parentNodeNum);
        }

        int deleteNodeNum = Integer.parseInt(bufferedReader.readLine());

        tree.deleteTree(deleteNodeNum);

        System.out.println(tree.checkLeaf(tree.node));
    }
}