package linkedlist;

class LinkedList {
    Node head;
    
    static class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            next = null;
        }
    }
    
    public void deleteNode(int position) {
        if(head == null) {
            return;
        }
        Node temp = head;
        if(position == 0) {
            head = temp.next;
            return;
        }
        for(int i=0;temp!=null && i<position-1;i++) {
            temp = temp.next;
        }
        
        if(temp == null || temp.next == null) {
            return;
        }
        Node next = temp.next.next;
        temp.next = next;
    }
    
    public void add(int data) {
        Node new_node = new Node(data);
        new_node.next = head;
        head = new_node;
    }
    public void printList() {
        Node n = head;
        while(n!=null) {
            System.out.print(n.data+" ");
            n = n.next;
        }
    }
    public static void main(String args[]) {
        LinkedList ll = new LinkedList();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.printList();
        System.out.println();
        ll.deleteNode(2);
        ll.printList();
    }
}
