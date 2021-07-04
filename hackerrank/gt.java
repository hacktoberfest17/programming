package cc;

import java.util.ArrayList;
import java.util.Scanner;

public class gt {
	private class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	int size;
	Node root;

	public gt() {
		Scanner scan = new Scanner(System.in);
		root = getdata(null, 0, scan);
	}

	private Node getdata(Node parent, int numchild, Scanner scan) {
		Node child = new Node();
		child.data = scan.nextInt();

		int grandchild = scan.nextInt();
		for (int i = 0; i < grandchild; ++i) {
			Node gc = getdata(child, grandchild, scan);
			child.children.add(gc);
		}
		return child;
	}

	public void sum() {
		System.out.println(sum(root));
	}

	private int sum(Node node) {

		int sum = node.data;
		for (int i = 0; i < node.children.size(); ++i) {
			sum += sum(node.children.get(i));
		}
		return sum;
	}

	public void display() {
		print(root);
	}

	private void print(Node node) {
		String disp = "";
		disp += node.data + "=>";
		for (int i = 0; i < node.children.size(); ++i) {
			disp += node.children.get(i).data + " ";
		}
		disp += ".";
		System.out.println(disp);

		for (int i = 0; i < node.children.size(); ++i) {
			print(node.children.get(i));
		}
	}

	public static void main(String[] args) {
		gt t = new gt();
		t.display();
		t.sum();
	}

}
