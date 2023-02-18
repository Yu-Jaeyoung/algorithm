package src.baekjoon.tree.p1068;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Node {
    int nodeNum;

    int childNodeCount = 0;
    List<Node> childNode = new ArrayList<Node>();

    Node(int nodeNum) {
        this.nodeNum = nodeNum;
    }
}

class Tree {
    Node rootNode;

    void createNode(int nodeNum, int parentNodeNum) {
        if (rootNode == null) {
            if (parentNodeNum == -1) {
                rootNode = new Node(nodeNum);
            }
        } else {
            treeTraversalForCreate(rootNode, nodeNum, parentNodeNum);
        }
    }

    void treeTraversalForCreate(Node node, int nodeNum, int parentNodeNum) {

        Node forCheckNode;

        if (node.nodeNum == parentNodeNum) {
            node.childNode.add(new Node(nodeNum));
            node.childNodeCount++;
            return;
        } else {
            for (int i = 0; i < node.childNodeCount; i++) {
                forCheckNode = node.childNode.get(i);
                if (forCheckNode.nodeNum == parentNodeNum) {
                    forCheckNode.childNode.add(new Node(nodeNum));
                    forCheckNode.childNodeCount++;
                    return;
                } else {
                    treeTraversalForCreate(forCheckNode, nodeNum, parentNodeNum);
                }
            }
        }
    }


    void treeTraversalForDelete(Node node, int parentNodeNum) {
        Node forCheckNode;

        if (node.nodeNum == parentNodeNum) {
            node.childNode.clear();
            node.childNodeCount = 0;
        } else {
            for (int i = 0; i < node.childNodeCount; i++) {
                forCheckNode = node.childNode.get(i);
                if (forCheckNode.nodeNum == parentNodeNum) {
                    forCheckNode.childNode.clear();
                    forCheckNode.childNodeCount = 0;
                    return;
                } else {
                    treeTraversalForDelete(forCheckNode, parentNodeNum);
                }
            }
        }
    }

    int checkLeaf(Node node) {
        Node forCheckNode;
        int count = 0;
        if (node != null) {
            for (int i = 0; i < node.childNodeCount; i++) {
                forCheckNode = node.childNode.get(i);
                if (forCheckNode.childNodeCount == 0) {
                    count++;
                } else {
                    checkLeaf(forCheckNode);
                }
            }
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


        StringTokenizer token = new StringTokenizer(lineString);

        for (int i = 0; i < nodeCount; i++) {
            int parentNodeNum = Integer.parseInt(token.nextToken());
            tree.createNode(i, parentNodeNum);
        }

        int deleteNodeNum = Integer.parseInt(bufferedReader.readLine());

        tree.treeTraversalForDelete(tree.rootNode, deleteNodeNum);

        System.out.println(tree.checkLeaf(tree.rootNode));
    }
}