package binarytree;

// class contain left and right child of tree and key

class Node {
    int key;
    Node left,right;
    
    public Node(int item) {
        key = item;
        left = right = null;
    }
}

// Java Program to introduce to the Binary Tree

class BinaryTree {
    // root of Binary Tree
    Node root;
    
    //constructor
    
    BinaryTree(int key) {
        root = new Node(key);
    }
    
    BinaryTree() {
        root = null;
    }
    
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
    }
}
