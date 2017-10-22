package com.vaibhav.myImpl.SinglyLinkedList;

public class ApplicationTest {

	public static void main(String[] args) {

		//SinglyLinkedList
		List<Integer> l=new LinkedList<Integer>();
		
		l.insertAtBeginning(1);
		l.insertAtBeginning(31);
		l.insertAtBeginning(21);
		l.insertAtLast(50);
		
		l.insertAfterGivenNode(l.getHead().getNextNode(),100);
		
	    l.traverseList();
		
		System.out.println("The size for the list is"+" "+l.sizeofList());

		l.removeAt(2);
		
		System.out.println("After Removal....");
		
	    l.traverseList();
		
		System.out.println("The size for the list is"+" "+l.sizeofList());
		
		l.swap(21, 50);
		System.out.println("After Swapping...");
		l.traverseList();
		/*l.remove(21);
		l.traverseList();*/
	}

}
