//
// Created by WillCPP on 10/18/17.
//

#ifndef BINARYTREE_H
#define BINARYTREE_H

#include <iostream>
using namespace std;

class Node {
public:
    Node(unsigned short s)
    {
        Node *p_right = nullptr;
        Node *p_left = nullptr;
        value = s;
    }
    void AddBranchRight(Node *n) {
        p_right = n;
    }
    void AddBranchLeft(Node *n) {
        p_left = n;
    }

    Node *p_right = nullptr;
    Node *p_left = nullptr;
    unsigned short value = 0;
};

class BinaryTree {
public:
    BinaryTree(Node *n) {
        root = n;
    }

    void PrintBranches(Node* n, unsigned short s) {
        unsigned short count = s;
        for (unsigned short i = 0; i < count; i++) {
            cout << ".";
        }
        cout << n->value << endl;
        if(n->p_right != nullptr) {
            cout << "Right:";
            PrintBranches(n->p_right, s+1);
        }
        if(n->p_left != nullptr) {
            cout << "Left:";
            PrintBranches(n->p_left, s+1);
        }
    }

private:
    Node *root;
};


#endif
