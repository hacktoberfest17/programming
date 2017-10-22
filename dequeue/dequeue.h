#include <iostream>
using  namespace std;

class Node {
public:
    Node(unsigned short s)
    {
        Node *p_next = nullptr;
        Node *p_prev = nullptr;
        value = s;
    }
    Node *p_next = nullptr;
    Node *p_prev = nullptr;
    unsigned short value = 0;
};

class Dequeue {
public:

    Dequeue(Node* n) {
        head = n;
        tail = n;
    }
    void PushFront(Node* n){
        n->p_prev = head;
        head = n;
        n->p_next = nullptr;
    }

    void PushBack(Node* n){
        n->p_next = tail;
        tail = n;
        n->p_prev = nullptr;
    }

    void PopFront(){
        Node *temp = head;
        head = head->p_prev;
        head->p_next = nullptr;
        delete temp;
    }

    void PopBack(){
        Node *temp = tail;
        tail = tail->p_next;
        tail->p_prev = nullptr;
        delete temp;
    }

    void PrintValueAtFront(){
        cout << head->value << endl;
    }

    void PrintValueAtBack(){
        cout << tail->value << endl;
    }
private:
    Node *head = nullptr;
    Node *tail = nullptr;
};

