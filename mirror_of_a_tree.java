class Mirror{

	Node root = null;
	Node mRoot = null;
	public void mirror(Node node){

	if(node == null) return ;

	mirror(node.left);

	mirror(node.right);

	Node temp = node.left;
	node.left = node.right;
	node.right = temp;

	}

	public void printTree(Node node){

	if(node == null) return;

	printTree(node.left);

	System.out.print(node.data+" ");

	printTree(node.right);

	}
	public static void main(String[] args){

	Mirror bt = new Mirror();

	        bt.root = new Node(1);
	        bt.root.left = new Node(2);
	        bt.root.right = new Node(3);
	        bt.root.left.left = new Node(4);
	        bt.root.left.right = new Node(5);  
	        bt.root.right.right = new Node(7);
	        bt.root.right.left = new Node(6);

	

 	System.out.println("Original Tree\n");
	bt.printTree(bt.root);

	bt.mirror(bt.root);
	System.out.println();

	System.out.println("Mirror Tree\n");
	bt.printTree(bt.root);

	}

}
