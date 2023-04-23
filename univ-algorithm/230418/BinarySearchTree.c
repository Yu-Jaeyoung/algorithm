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

    BST_DestroyNode(Tree);
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

void deleteNodeNoChild(BSTNode *pParentNode, BSTNode *pDelNode) {
    if (pParentNode != NULL) {
        if (pParentNode->Left == pDelNode) {
            pParentNode->Left = NULL;
        } else {
            pParentNode->Right = NULL;
        }
    }
}

void deleteNodeOneChild(BSTNode *pParentNode, BSTNode *pDelNode) {
    BSTNode *pChildNode = NULL;

    if (pDelNode->Left != NULL) {
        pChildNode = pDelNode->Left;
    } else {
        pChildNode = pDelNode->Left;
    }

    if (pParentNode != NULL) {
        if (pParentNode->Left == pDelNode) {
            pParentNode->Left = pChildNode;
        } else {
            pParentNode->Right = pChildNode;
        }
    }
}

void deleteNodeTwoChild(BSTNode *pParentNode, BSTNode *pDelNode) {
    BSTNode *pPredecessor = NULL, *pSuccessor = NULL;

    pPredecessor = pDelNode; // 직후 원소의 직전 원소(부모 원소)의 주소값을 담을 공간
    pSuccessor = pDelNode->Right; // 직후 원소를 담을 공간

    while (pSuccessor->Left != NULL) { // 직후 원소를 찾아가는 과정 + 직전 원소(부모 원소)의 주소값을 저장
        pPredecessor = pSuccessor; // 직후 원소의 주소값을 저장
        pSuccessor = pSuccessor->Left; // 직후 원소의 왼쪽 자식 주소값을 직후 원소에 저장
    }

    pPredecessor->Left = pSuccessor->Right; // 직전 원소(부모 원소)의 왼쪽에 직후 원소의 오른쪽 값을 연결
                                            // 해당 방법이 가능한 이유는 while문에서 이미 직후 원소의 왼쪽 자식이 없음을 확인했기 때문
    pSuccessor->Left = pDelNode->Left; // 직후 원소의 왼쪽을 제거 원소의 왼쪽과 연결
    pSuccessor->Right = pDelNode->Right; // 직후 원소의 오른쪽을 제거 원소의 오른쪽과 연결

    if (pParentNode != NULL) { // 제거 노드의 부모 노드에 직후 원소 값을 붙이는 과정
        if (pParentNode->Left == pDelNode) {
            pParentNode->Left = pSuccessor;
        } else {
            pParentNode->Right = pSuccessor;
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
            deleteNodeNoChild(Parent, Removed);
        } // 자식이 둘다 있는 경우
        else if (Tree->Left != NULL && Tree->Right != NULL) {
            deleteNodeTwoChild(Parent, Removed);
        } else {
            deleteNodeOneChild(Parent, Removed);
        }

    }
    return Removed;
}

void BST_InorderPrintTree(BSTNode *Tree) {
    if (Tree == NULL)
        return;

    BST_InorderPrintTree(Tree->Left);

    printf("%d ", Tree->Data);

    BST_InorderPrintTree(Tree->Right);
}