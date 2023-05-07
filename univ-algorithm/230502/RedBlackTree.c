#include "RedBlackTree.h"

extern RBTNode *Nil; // 선언 되어있는 외부 변수를 사용하겠다는 의미

RBTNode *RBT_CreateNode(ElementType NewData) {
    RBTNode *NewNode = (RBTNode *) malloc(sizeof(RBTNode));
    NewNode->Parent = NULL;
    NewNode->Left = NULL;
    NewNode->Right = NULL;
    NewNode->Data = NewData;
    NewNode->Color = BlACK;

    return NewNode;
}

void RBT_DestroyNode(RBTNode *Node) {
    free(Node);
}

void RBT_DestroyTree(RBTNode *Tree) {
    if (Tree->Right != Nil)
        RBT_DestroyTree(Tree->Right);

    if (Tree->Left != Nil)
        RBT_DestroyTree(Tree->Left);

    Tree->Left = Nil;
    Tree->Right = Nil;

    RBT_DestroyNode(Tree);
}

RBTNode *RBT_SearchNode(RBTNode *Tree, ElementType Target) {
    if (Tree == Nil)
        return NULL;

    if (Tree->Data > Target)
        return RBT_SearchNode(Tree->Left, Target);
    else if (Tree->Data < Target)
        return RBT_SearchNode(Tree->Right, Target);
    else
        return Tree;
}

RBTNode *RBT_SearchMinNode(RBTNode *Tree) {
    if (Tree == Nil)
        return Nil;

    if (Tree->Left == Nil)
        return Tree;
    else
        return RBT_SearchMinNode(Tree->Left);
}

void RBT_InsertNode(RBTNode **Tree, RBTNode *NewNode) {
    RBT_InsertNodeHelper(Tree, NewNode);

    NewNode->Color = RED;
    NewNode->Left = Nil;
    NewNode->Right = Nil;

    RBT_RebuildAfterInsert(Tree, NewNode);
}

void RBT_InsertNodeHelper(RBTNode **Tree, RBTNode *NewNode) {
    if ((*Tree) == NULL)
        (*Tree) = NewNode;

    if ((*Tree)->Data < NewNode->Data) {
        if ((*Tree)->Right == Nil) {
            (*Tree)->Right = NewNode;
            NewNode->Parent = (*Tree);
        } else
            RBT_InsertNodeHelper(&(*Tree)->Right, NewNode);
    } else if ((*Tree)->Data > NewNode->Data) {
        if ((*Tree)->Left == Nil) {
            (*Tree)->Left = NewNode;
            NewNode->Parent = (*Tree);
        } else
            RBT_InsertNodeHelper(&(*Tree)->Left, NewNode);
    }
}

void RBT_RotateRight(RBTNode **Root, RBTNode *Parent) {
    RBTNode *LeftChild = Parent->Left;

    Parent->Left = LeftChild->Right;

    if (LeftChild->Right != Nil)
        LeftChild->Right->Parent = Parent;

    LeftChild->Parent = Parent->Parent;

    if (Parent->Parent == NULL)
        (*Root) = LeftChild;
    else {
        if (Parent == Parent->Parent->Left)
            Parent->Parent->Left = LeftChild;
        else
            Parent->Parent->Right = LeftChild;
    }

    LeftChild->Right = Parent;
    Parent->Parent = LeftChild;
}

void RBT_RotateLeft(RBTNode **Root, RBTNode *Parent) {
    RBTNode *RightChild = Parent->Right;

    Parent->Right = RightChild->Left;

    if (RightChild->Left != Nil)
        RightChild->Left->Parent = Parent;

    RightChild->Parent = Parent->Parent;

    if (Parent->Parent == NULL)
        (*Root) = RightChild;
    else {
        if (Parent == Parent->Parent->Left)
            Parent->Parent->Left = RightChild;
        else
            Parent->Parent->Right = RightChild;
    }

    RightChild->Left = Parent;
    Parent->Parent = RightChild;
}

void RBT_RebuildAfterInsert(RBTNode **Root, RBTNode *X) {
    while (X != (*Root) && X->Parent->Color == RED) {
        if (X->Parent == X->Parent->Parent->Left) {
            RBTNode *Uncle = X->Parent->Parent->Right;
            if (Uncle->Color == RED) {
                X->Parent->Color = BlACK;
                Uncle->Color = BlACK;
                X->Parent->Parent->Color = RED;

                X = X->Parent->Parent;
            } else {
                if (X == X->Parent->Right) {
                    X = X->Parent;
                    RBT_RotateLeft(Root, X);
                }

                X->Parent->Color = BlACK;
                X->Parent->Parent->Color = RED;

                RBT_RotateRight(Root, X->Parent->Parent);
            }
        } else {
            RBTNode *Uncle = X->Parent->Parent->Left;
            if (Uncle->Color == RED) {
                X->Parent->Color = BlACK;
                Uncle->Color = BlACK;
                X->Parent->Parent->Color = RED;
                X = X->Parent->Parent;
            } else {
                if (X == X->Parent->Left) {
                    X = X->Parent;
                    RBT_RotateRight(Root, X);
                }

                X->Parent->Color = BlACK;
                X->Parent->Parent->Color = RED;
                RBT_RotateLeft(Root, X->Parent->Parent);
            }
        }
    }

    (*Root)->Color = BlACK;
}