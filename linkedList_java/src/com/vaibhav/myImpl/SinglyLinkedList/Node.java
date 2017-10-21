package com.vaibhav.myImpl.SinglyLinkedList;

public class Node<T extends Comparable<T>> {
	
	private T data;
	
	//Because a node in Singly linked list has to have the reference of next node as well in addition to the data it stores
	private Node<T> nextNode;
	
	private Node<T> previousNode;

	public Node<T> getPreviousNode() {
		return previousNode;
	}

	public void setPreviousNode(Node<T> previousNode) {
		this.previousNode = previousNode;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node<T> nextNode) {
		this.nextNode = nextNode;
	}

}
