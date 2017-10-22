#include <iostream>
#include <string.h>
#include "dequeue.h"
using namespace std;

int main() {

    Node *n = new Node(0);
    n->value = 5;
    Dequeue d(n);

    cout << "Value at front: ";
    d.PrintValueAtFront();
    cout << "Value at back: ";
    d.PrintValueAtBack();

    Node *n10 = new Node(10);
    //n->value = 10;
    Node *n1 = new Node(1);
    //n->value = 1;

    d.PushFront(n10);
    d.PushBack(n1);

    cout << "Value at front: ";
    d.PrintValueAtFront();
    cout << "Value at back: ";
    d.PrintValueAtBack();

    string s = "";
    cout << "Type anything then press enter to exit: ";
    cin >> s;
    if (s == "anything") {
        cout << "LOL";
    }

    return 0;
}