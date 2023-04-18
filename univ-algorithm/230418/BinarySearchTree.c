#include "BinarySearchTree.h"

BSTNode *BST_CreateNode(ElementType NewData) {
    BSTNode *NewNode = (BSTNode *) malloc(sizeof(BSTNode));
    NewNode->Left = NULL;
    NewNode->Right = NULL;
    NewNode->Data = NewData;

    return NewNode;
}

void BST_DestroyNode(BSTNode *Node) {
    free(Node);
}

void BST_DestroyTree(BSTNode *Tree) {
    if (Tree->Left != NULL) {
        BST_DestroyTree(Tree->Left);
    }

    if (Tree->Right != NULL) {
        BST_DestroyTree(Tree->Right);
    }

    Tree->Left = NULL;
    Tree->Right = NULL;

    BST_DestroyTree(Tree);
}

BSTNode *BST_SearchNode(BSTNode *Tree, ElementType Target) {
    if (Tree == NULL) {
        return NULL;
    }

    if (Target < Tree->Data) {
        return BST_SearchNode(Tree->Left, Target);
    } else if (Target > Tree->Data) {
        return BST_SearchNode(Tree->Right, Target);
    } else {
        return Tree;
    }
}

BSTNode *BST_SearchMinNode(BSTNode *Tree) {
    if (Tree == NULL) {
        return NULL;
    }

    if (Tree->Left == NULL) {
        return Tree;
    } else {
        return BST_SearchMinNode(Tree->Left);
    }
}

void BST_InsertNode(BSTNode *Tree, BSTNode *Child) {
    if (Tree->Data >= Child->Data) {
        if (Tree->Left == NULL) {
            Tree->Left = Child;
        } else {
            BST_InsertNode(Tree->Left, Child);
        }
    } else if (Tree->Data < Child->Data) {
        if (Tree->Right == NULL) {
            Tree->Right = Child;
        } else {
            BST_InsertNode(Tree->Right, Child);
        }
    }
}

BSTNode *BST_RemoveNode(BSTNode *Tree, BSTNode *Parent, ElementType Target) {
    BSTNode *Removed = NULL;

    if (Tree == NULL) {
        return NULL;
    }

    if (Tree->Data > Target) {
        Removed = BST_RemoveNode(Tree->Left, Tree, Target);
    } else if (Tree->Data < Target) {
        Removed = BST_RemoveNode(Tree->Right, Tree, Target);
    } else { // Tree->Data == Target
        Removed = Tree;

        // 자식이 없는 경우
        if (Tree->Left == NULL && Tree->Right == NULL) {
            if (Parent->Left == Tree) { // 부모의 왼쪽 자식이 Tree 인 경우, 해당 자식=Tree를 NULL로 처리
                Parent->Left = NULL;
            } else { // 부모의 오른쪽 자식이 Tree 인 경우, 해당 자식=Tree를 NULL로 처리
                Parent->Right = NULL;
            }
        } // 자식이 둘다 있는 경우, 최소 노드를 찾아 제거한 뒤 삭제되는 노드 위치에 배치
        else {
            if (Tree->Left != NULL && Tree->Right != NULL) {
                BSTNode *MinNode = BST_SearchMinNode(Tree->Right);
                MinNode = BST_RemoveNode(Tree, NULL, MinNode->Data); // Why Parent == NULL?
                Tree->Data = MinNode->Data;
            } // 자식이 한명만 있는 경우
            else {
                BSTNode *Temp = NULL;
                if (Tree->Left != NULL) {
                    Temp = Tree->Left;
                } else {
                    Temp = Tree->Right;
                }

                if (Parent->Left == Tree) {
                    Parent->Left = Temp;
                } else {
                    Parent->Right = Temp;
                }
            }
        }
    }
    return Removed;
}

void BST_InorderPrintTree(BSTNode *Node) {
    if (Node == NULL)
        return;

    BST_InorderPrintTree(Node->Left);

    printf("%d ", Node->Data);

    BST_InorderPrintTree(Node->Right);
}