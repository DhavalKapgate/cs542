package wordCount.dsForStrings;

import wordCount.util.Logger;
import wordCount.util.Logger.DebugLevel;
import wordCount.visitors.DSProcessingVisitorI;

/**
 * References:
 * http://algorithms.tutorialhorizon.com/avl-tree-insertion/
 *
 */
public class AVLTree implements AVLImp{
	private Node root;
	
	public AVLTree() {
		Logger.writeMessage("IN AVL Tree CONSTRUCTOR\n",DebugLevel.DEBUG1);		
		root = null;
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public int getBalance(Node root) {
		if (root != null) {
			return (getHeight(root.getLeft()) - getHeight(root.getRight()));
		}
		return 0;
	}

	public int getHeight(Node root) {
		if (root != null) {
			return root.getHeight();
		}
		return 0;
	}

	public Node rightRotate(Node rootY) {
		Node rootX = rootY.getLeft();
		Node T2 = rootX.getRight();

		// Rotation
		rootX.setRight(rootY);
		rootY.setLeft(T2);

		// update their heights
		rootY.setHeight(Math.max(getHeight(rootY.getLeft()), getHeight(rootY.getRight())) + 1);
		rootX.setHeight(Math.max(getHeight(rootX.getLeft()), getHeight(rootX.getRight())) + 1);

		return rootX;
	}

	public Node leftRotate(Node rootX) {
		Node rootY = rootX.getRight();
		Node T2 = rootY.getLeft();

		// Rotation
		rootY.setLeft(rootX);
		rootX.setRight(T2);

		// update their heights
		rootX.setHeight(Math.max(getHeight(rootX.getLeft()), getHeight(rootX.getRight())) + 1);
		rootY.setHeight(Math.max(getHeight(rootY.getLeft()), getHeight(rootY.getRight())) + 1);

		return rootY;
	}

	public Node insert(Node node, String word) {
		if (node == null) {
			return (new Node(word));
		}
		@SuppressWarnings("unused")
		int compare=word.compareTo(node.getWord());
		if(node.getWord().equals(word))
		{
			node.setCount(node.getCount()+1);
			return node;
		}
		else if (word.compareTo(node.getWord())  < 0) {
			node.setLeft(insert(node.getLeft(), word));
		} else {
			node.setRight(insert(node.getRight(), word));
		}
		// update the node height
		node.setHeight(Math.max(getHeight(node.getLeft()), getHeight(node.getRight())) + 1);

		int balDiff = getBalance(node);

		// Left Rotate
		if (balDiff > 1 && word.compareTo(node.getLeft().getWord()) < 0) {
			return rightRotate(node);
		}

		// Right Rotate
		if (balDiff < -1 && word.compareTo(node.getRight().getWord()) > 0) {
			return leftRotate(node);
		}

		// Left Right Rotate
		if (balDiff > 1 && word.compareTo(node.getLeft().getWord()) > 0) {
			node.setLeft(leftRotate(node.getLeft()));
			return rightRotate(node);
		}

		// Right Left Rotate
		if (balDiff < -1 && word.compareTo(node.getRight().getWord()) < 0) {
			node.setRight(rightRotate(node.getRight()));
			return leftRotate(node);
		}
		return node;
	}

	@Override
	public int wordCount(Node root) {
		if(root == null){
			return 0;
		}
		return (root.getCount() + wordCount(root.getLeft()) + wordCount(root.getRight()));
	}

	@Override
	public int charCount(Node root) {
		if(root==null){
			return 0;
		}
		return (root.getWord().length()* root.getCount()) + charCount(root.getLeft()) + charCount(root.getRight());
	}

	@Override
	public int distintCount(Node root) {
		if(root==null){
			return 0;
		}
		return 1 + distintCount(root.getLeft()) + distintCount(root.getRight());
	}


	@Override
	public void display(Node root) {
		if(root!=null){
			display(root.getLeft());
			System.out.print(root.getWord() +"\t");
			System.out.println("Count: " +root.getCount());
			display(root.getRight());
		}
	}

	@Override
	public void accept(DSProcessingVisitorI visitor) {
		visitor.visit(this);
	}
}
