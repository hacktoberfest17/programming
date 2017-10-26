#! /usr/bin/env python3

class Node:
    def __init__(self, data, next_node=None):
        self.data = data
        self.next_node = next_node

    def __str__(self):
        # in python3.6 we could also use fstrings:
        # return f"data: {self.data}"
        return "data: {}".format(self.data)


class LinkedList:
    def __init__(self, head=None):
        self.head = head

    def insert(self, data):
        """Insert a new node to the beginning of the list"""
        new_node = Node(data, self.head)
        self.head = new_node

    def size(self):
        current_node = self.head
        count = 0
        while current_node is not None:
            count += 1
            current_node = current_node.next_node
        return count

    def delete(self, data):
        """Deletes the first Node thats data matches the argument."""
        current_node = self.head
        previous_node = None
        found = False
        while not found:
            if current_node.data == data:
                found = True
            else:
                previous_node = current_node
                current_node = current_node.next_node
        
        if previous_node is None:
            self.head = current_node.next_node
        else:
            previous_node.next_node = current_node.next_node

    def traverse(self):
        """Print all Nodes in the list"""
        current_node = self.head
        while current_node is not None:
            print(current_node)
            current_node = current_node.next_node


if __name__ == "__main__":
    print("Create one Node and add to list:")
    first_node = Node("I'm first!")
    test_list = LinkedList(first_node)
    test_list.traverse()

    print("\nCreate two more Nodes and insert to the beginning of the list:")
    test_list.insert("I'm second")
    test_list.insert("I'm now first")
    test_list.traverse()

    print("\nDelete the node we first created:")
    print("List size before delete: {}".format(test_list.size()))
    test_list.delete("I'm first!")
    test_list.traverse()
    print("List size after delete: {}".format(test_list.size()))
