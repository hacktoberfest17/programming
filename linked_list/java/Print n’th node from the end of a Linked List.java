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
    public void printNthFromLast(int n) {
        Node temp = head;
        int len = 0;
        // count the length
        while(temp != null) {
            temp = temp.next;
            len++;
        }
        
        if(len < n) {
            return;
        }
        temp = head;
        for(int i = 1;i<len-n+1;i++) {
            temp = temp.next;
        }
        System.out.println(temp.data);
    }
    public static void main(String args[]) {
        LinkedList ll = new LinkedList();
        ll.push(20);
        ll.push(4);
        ll.push(15);
        ll.push(35);
        ll.printList();
        System.out.println("\nThe Nth ELement last");
        ll.printNthFromLast(4);
        
       
       
    }
}
