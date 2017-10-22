package main

import "fmt"

type Node struct {
    prev *Node
    next *Node
    key interface{}
}

type LinkedList struct {
    head *Node
    tail *Node
}

func (L *LinkedList) Insert(key interface{}) {
    list := &Node{
        next: L.head,
        key: key,
    }
    if L.head != nil {
        L.head.prev = list
    }
    L.head = list

    l := L.head
    for l.next != nil {
        l = l.next
    }
    L.tail = l
}

func (l *LinkedList) Show() {
	list := l.head
	for list != nil {
		fmt.Printf("%+v", list.key)
                if list.next != nil {
                    fmt.Printf(" --> ")
                }
		list = list.next
	}
	fmt.Println()
}

func main() {
	l := LinkedList{}
	l.Insert(1)
	l.Insert(2)
	l.Insert(3)
	l.Insert(4)
	l.Insert(5)
	l.Show()
}
