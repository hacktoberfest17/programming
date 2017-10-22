package com.vaibhav.myImpl.SinglyLinkedList;

import com.vaibhav.myImpl.SinglyLinkedList.Node;

public interface List<T extends Comparable<T>> {

	public void insertAtBeginning(T data);
	
	public void insertAtLast(T data);
	
	public void traverseList();
	
	public int sizeofList();
	
	public void remove(T data);
	
	public boolean isEmpty();

	void insertAfterGivenNode(Node<T> prevNode, T data);
	
	Node<T> getHead();
	
	public void removeAt(int pos);
	
	public void swap(T data1, T data2);
	
	
}
