package src.baekjoon.tree.p1068;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Node {
    int nodeNum;

    List childNode = new ArrayList<Node>();

    public int getNodeNum() {
        return nodeNum;
    }

    Node(int nodeNum) {
        this.nodeNum = nodeNum;
    }
}

class Tree {
    int count = 0;
    Node rootNode;

    void createNode(int nodeNum, int parentNodeNum) {
        if (rootNode == null) {
            if (parentNodeNum == -1) {
                rootNode = new Node(nodeNum);
            }
        } else {
            TreeTraversalForCreate(rootNode, nodeNum, parentNodeNum);
        }
    }

    void TreeTraversalForCreate(Node node, int nodeNum, int parentNodeNum) {

        if (node == null) {
            return;
        }

        Node checkNode;

        if (node.nodeNum == parentNodeNum) {
            node.childNode.add(new Node(nodeNum));
            return;
        } else {
            for (int i = 0; i < node.childNode.size(); i++) {
                checkNode = (Node) node.childNode.get(i);
                if (checkNode.nodeNum == parentNodeNum) {
                    checkNode.childNode.add(new Node(nodeNum));
                    return;
                }
            }
        }

        TreeTraversalForCreate();

    }


    void recursiveTreeTraversalForDelete() {
    }

    void checkLeaf() {

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

        tree.deleteNode(deleteNodeNum);

        System.out.println(tree.checkLeaf(tree.rootNode));
    }
}