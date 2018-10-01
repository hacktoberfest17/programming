package cc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class bst {

	public class Node {
		int data;
		Node right;
		Node left;

	}

	Node root;

	public bst() {
		Scanner scan = new Scanner(System.in);
		root = getdata(null, scan);
	}

	private Node getdata(Node parent, Scanner scan) {

		Node child = new Node();
		child.data = scan.nextInt();

		// leftchild
		boolean isl = scan.nextBoolean();
		if (isl) {
			child.left = getdata(child, scan);
		}

		// right
		boolean isr = scan.nextBoolean();
		if (isr) {
			child.right = getdata(child, scan);
		}

		return child;
	}

	public void add(int num) {
		Node node = root;
		if (node == null) {
			node = new Node();
			node.data = num;
		} else {
			add(root, num);
		}
	}

	private void add(Node node, int num) {

		if (num > node.data) {
			if (node.right == null) {
				Node nn = new Node();
				nn.data = num;
				node.right = nn;
			} else
				add(node.right, num);
		} else if (num < node.data) {
			if (node.left == null) {
				Node nn = new Node();
				nn.data = num;
				node.left = nn;
			} else
				add(node.left, num);
		}
	}

	public boolean find(int val) {
		return find(root, val);
	}

	private boolean find(Node node, int val) {
		if (node == null)
			return false;

		if (node.data < val) {
			return find(node.right, val);
		} else if (node.data > val) {
			return find(node.right, val);
		} else
			return true;

	}

	public void display() {
		display(root);
	}

	private void display(Node node) {
		if (node == null)
			return;

		if (node.left != null) {
			System.out.print(node.left.data + "=>");
		} else
			System.out.print(".=>");

		System.out.print(node.data);

		if (node.right != null) {
			System.out.print(node.right.data + "<=.");
		} else
			System.out.print("<=.");

		System.out.println();
		display(node.left);
		display(node.right);
	}

	public ArrayList<LinkedList> retlist() {
		ArrayList<LinkedList> list = new ArrayList<>();
		LinkedList<Node> stack1 = new LinkedList<>(), stack2 = new LinkedList<>();

		LinkedList<Integer> l = new LinkedList<>();

		stack1.addLast(root);

		while (stack1.size() != 0) {
			Node rn = new Node();
			rn = stack1.removeFirst();
			l.add(rn.data);
			if (rn.left != null)
				stack2.addLast(rn.left);
			if (rn.right != null)
				stack2.addLast(rn.right);

			if (stack1.size() == 0) {
				list.add(l);
				l = new LinkedList<>();
				stack1 = stack2;
				stack2 = new LinkedList<>();
			}
		}

		return list;
	}

	public static void main(String[] args) {
		bst t = new bst();
		// t.display();
		System.out.println(t.retlist());
	}

}
