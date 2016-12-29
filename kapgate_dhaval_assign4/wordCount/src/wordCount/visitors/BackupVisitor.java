package wordCount.visitors;

import wordCount.dsForStrings.AVLImp;
import wordCount.dsForStrings.AVLTree;
import wordCount.dsForStrings.Node;
import wordCount.util.Logger;
import wordCount.util.Logger.DebugLevel;

public class BackupVisitor implements DSProcessingVisitorI{

	private AVLImp avlbackup;
	private Node root=null,backupRoot=null;
	
	public BackupVisitor() {

		Logger.writeMessage("IN backupVisitor (Visitor 3) CONSTRUCTOR\n",DebugLevel.DEBUG1);		
	
		avlbackup=null;
	}

	@Override
	public void visit(Object o) {
		AVLImp temp=(AVLImp)o;
		root=((AVLTree) temp).getRoot();
		backupRoot=backup(root);
		avlbackup=new AVLTree();
		((AVLTree) avlbackup).setRoot(backupRoot);
	}
	public Node backup(Node root)
	{
		if(root!=null){
			Node current=(Node) root.clone();
			root.registerObserver(current);
			//current.setCount(root.getCount());
			current.setLeft(backup(root.getLeft()));
			current.setRight(backup(root.getRight()));;
			return current;
		}
		return null;
	}

	public AVLTree getAvlbackup() {
		return (AVLTree)avlbackup;
	}

}
