#include "BinarySearchTree.h"

/*
int main() {
    BSTNode *Tree = BST_CreateNode(123);
    BSTNode *Node = NULL;

    BST_InsertNode(Tree, BST_CreateNode(22));
    BST_InsertNode(Tree, BST_CreateNode(9918));
    BST_InsertNode(Tree, BST_CreateNode(424));
    BST_InsertNode(Tree, BST_CreateNode(17));
    BST_InsertNode(Tree, BST_CreateNode(3));
    BST_InsertNode(Tree, BST_CreateNode(98));
    BST_InsertNode(Tree, BST_CreateNode(34));
    BST_InsertNode(Tree, BST_CreateNode(760));
    BST_InsertNode(Tree, BST_CreateNode(317));
    BST_InsertNode(Tree, BST_CreateNode(1));

    BST_InorderPrintTree(Tree);
    printf("\n");

    printf("Removing 98... \n");

    Node = BST_RemoveNode(Tree, NULL, 98);
    BST_DestroyNode(Node);

    BST_InorderPrintTree(Tree);
    printf("\n");

    printf("Inserting 111...\n");

    BST_InsertNode(Tree, BST_CreateNode(111));
    BST_InorderPrintTree(Tree);
    printf("\n");

    BST_DestroyTree(Tree);

    return 0;
}*/

int main() {
    BSTNode *Tree = BST_CreateNode(55);
    BSTNode *Node = NULL;

    BST_InsertNode(Tree, BST_CreateNode(15));
    BST_InsertNode(Tree, BST_CreateNode(60));
    BST_InsertNode(Tree, BST_CreateNode(8));
    BST_InsertNode(Tree, BST_CreateNode(28));
    BST_InsertNode(Tree, BST_CreateNode(90));
    BST_InsertNode(Tree, BST_CreateNode(3));
    BST_InsertNode(Tree, BST_CreateNode(18));
    BST_InsertNode(Tree, BST_CreateNode(45));
    BST_InsertNode(Tree, BST_CreateNode(41));
    BST_InsertNode(Tree, BST_CreateNode(48));
    BST_InsertNode(Tree, BST_CreateNode(30));
    BST_InsertNode(Tree, BST_CreateNode(50));
    BST_InsertNode(Tree, BST_CreateNode(38));
    BST_InsertNode(Tree, BST_CreateNode(33));
    BST_InsertNode(Tree, BST_CreateNode(32));
    BST_InsertNode(Tree, BST_CreateNode(36));


    BST_InorderPrintTree(Tree);
    printf("\n");

    printf("Removing 28... \n");

    Node = BST_RemoveNode(Tree, NULL, 28);
    BST_DestroyNode(Node);

    BST_InorderPrintTree(Tree);
    printf("\n");

    BST_DestroyTree(Tree);

    return 0;
}