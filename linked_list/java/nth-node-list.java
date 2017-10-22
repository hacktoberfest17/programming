package linkedlist;

class LinkedList {
    Node head;
    
    class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            next = null;
        }
    }
    
    public void push(int data) {
        Node new_node = new Node(data);
        new_node.next = head;
        head = new_node;
    }
    public void printList() {
        Node n = head;
        while(n != null) {
            System.out.print(n.data+" ");
            n = n.next;
        }
    }
   public int getNth(int index) {
       Node current = head;
       int count = 0;
       while(current != null) {
           if(count == index) {
               return current.data;
           }
           count++;
           current = current.next;
       }
       assert(false);
       return 0;
   }
    public static void main(String args[]) {
        LinkedList ll = new LinkedList();
        ll.push(2);
        ll.push(3);
        ll.push(4);
        ll.push(5);
        ll.printList();
        System.out.print("ELement at nth index is "+ll.getNth(2));
       
    }
}
