//Implementation for Singly Linkedlist

package com.vaibhav.myImpl.SinglyLinkedList;

import com.vaibhav.myImpl.SinglyLinkedList.Node;
public class LinkedList<T extends Comparable<T>> implements List<T> {

	Node<T> root;//this is the head or the first node.
	
	//Take count of total nodes in the Singly Linked list currently
	int countOfNodes;
	
	public Node<T> getHead()
	{
      return this.root;
	}
	
	@Override
	public void insertAtBeginning(T data) {
	 ++countOfNodes;
		if(this.root==null)
		{
			this.root=new Node<T>();
			this.root.setData(data);
		}
		else{
         Node<T> newNode= new Node<T>();
         newNode.setData(data);
         newNode.setNextNode(root);
         root=newNode;
		}
		
	}

	@Override
	public void insertAfterGivenNode(Node<T> prevNode, T data) {
		++this.countOfNodes;
		if(prevNode==null){
			
			System.out.println("Previous node cannot be null");
			return;
		}
		
		Node<T> newNode= new Node<T>();
		newNode.setData(data);
		newNode.setNextNode(prevNode.getNextNode());
		prevNode.setNextNode(newNode);
		
	}

	@Override
	public void insertAtLast(T data) {
		++this.countOfNodes;
		Node<T> newNode=new Node<T>();
		newNode.setData(data);
		if(this.root==null)
		{
      this.root=newNode;   
		}
		else{
			Node<T> lastNode=new Node<T>();
			lastNode=root;
			
			while(lastNode.getNextNode()!=null)
			{
				lastNode=lastNode.getNextNode();
				
			}
			
			lastNode.setNextNode(newNode);
			newNode.setNextNode(null);
		}
		
		
		
		
	}

	
	
	@Override
	/*public void insert(T data) {
		++countOfNodes;
		
		if(root==null){
			
			root= new Node<T>();
			root.setData(data);
		}
		else{
			
			insertDataBeginning(data);
		}
		
		
	}
*/
/*	private void insertDataBeginning(T data) {
       
		Node<T> newNode=new Node<>();
		newNode.setData(data);
		
		newNode.setNextNode(root);
		this.root=newNode;
		
 	}*/
	
	public void traverseList() {
		Node tmp=this.root;
		System.out.println("Traversing the singly linked list...");
		for(int i=0;i<countOfNodes;i++){
			
			System.out.print(tmp.getData());
			System.out.print("->");
			tmp=tmp.getNextNode();
		}
	}

	@Override
	public int sizeofList() {
		return this.countOfNodes;
	}

	@Override
	public void remove(T data) {
		if(this.root==null) return;
		
		--this.countOfNodes;
		
		if(this.root.getData().compareTo(data)==0){this.root=root.getNextNode();}
		
		else{
			remove(data,root,root.getNextNode());
		}
		
    }
	
	public void removeAt(int Pos)
	{
		if(this.getHead()==null) return;
		
		--this.countOfNodes;
		if(Pos==0){
			//check if there are nodes other than root too, if yes change the pointer of root 
			if(this.root.getNextNode()!=null){
		  this.root=root.getNextNode();
		  return;
			}
			else{
				//if only the root is there, delete it
				this.root=null;
				return;
			}
		}
		
		else{
			Node<T> actualNode=this.root;
			Node<T> prevNode=new Node<>();
			for(int i=1;i<=Pos;i++)
			{
				prevNode=actualNode;
				actualNode=actualNode.getNextNode();
			
			}
			
			//Check if the node to be deleted is not last
			if(actualNode.getNextNode()!=null)
			{
			prevNode.setNextNode(actualNode.getNextNode());
			}
			actualNode=null;
			return;
			
		}
		
	}
	
	//This function will be called when the node to be removed is other than a root node
	public void remove(T data, Node<T> previousNode, Node<T> actualNode){
		
		--this.countOfNodes;
		while(actualNode!=null){
			if(actualNode.getData().compareTo(data)==0)
			{
				previousNode.setNextNode(actualNode.getNextNode());
				actualNode=null;
				return;
			}
			else{
			    previousNode=actualNode;
				actualNode=actualNode.getNextNode();
				return;
			}
			
		}
		
	}

	@Override
	public boolean isEmpty() {
          
		if (this.countOfNodes==0)
 		return true;
		else
			return false;
	}

	@Override
	public void swap(T data1, T data2) {
		
		//if both are equal then no swapping needed
		if(data1.compareTo(data2)==0)
			return;
	
		Node<T> currData1=this.root;
		Node<T> prevData1= null;
		
		Node<T> currData2=this.root;
		Node<T> prevData2= null;
		
		while(currData1!=null && currData1.getData().compareTo(data1)!=0)
		{
			prevData1=currData1;
			currData1=currData1.getNextNode();
		}
	
		while(currData2!=null && currData2.getData().compareTo(data2)!=0)
		{
			prevData2=currData2;
			currData2=currData2.getNextNode();
		}
		
		prevData1.setNextNode(currData2);
		prevData2.setNextNode(currData1);
		Node<T> tmp=currData1.getNextNode();
		currData2.setNextNode(tmp);
		
		tmp=currData2.getNextNode();
		currData1.setNextNode(tmp);
		
	
		
		
	}
}
	
	


