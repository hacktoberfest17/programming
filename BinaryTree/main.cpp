#include <iostream>
#include <string>
#include "BinaryTree.h"
using namespace std;

int main() {

    Node *root = new Node(0);
    BinaryTree b(root);

    Node *r1 = new Node(1);
    Node *r2 = new Node(2);
    Node *r3 = new Node(3);
    Node *r4 = new Node(4);
    Node *r5 = new Node(5);

    Node *l1 = new Node(1);
    Node *l2 = new Node(2);
    Node *l3 = new Node(3);
    Node *l4 = new Node(4);
    Node *l5 = new Node(5);

    root->AddBranchRight(r1);
    root->AddBranchLeft(l1);

    r1->AddBranchRight(r3);
    r1->AddBranchLeft(l3);

    r3->AddBranchRight(r5);
    r3->AddBranchLeft(l5);

    l1->AddBranchRight(r2);
    l1->AddBranchLeft(l2);

    r2->AddBranchRight(r4);
    l2->AddBranchLeft(l4);

    b.PrintBranches(root,0);

    string s = "";
    cout << "Type anything then press enter to exit: ";
    cin >> s;
    if (s == "anything") {
        cout << "LOL";
    }

    return 0;
}