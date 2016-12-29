package wordCount.visitors;

import wordCount.dsForStrings.AVLImp;
import wordCount.dsForStrings.AVLTree;
import wordCount.dsForStrings.Node;
import wordCount.util.FileProcessor;
import wordCount.util.Logger;
import wordCount.util.Logger.DebugLevel;

public class TestBackupVisitor implements DSProcessingVisitorI{
	
	String file1="before_update.txt",file2="after_update.txt",file3="updated_tree.txt";
	FileProcessor fp1=null,fp2=null,fp3=null;
	AVLImp avlSubject=null,avlBackupObserver=null;
	public TestBackupVisitor(AVLImp subject,AVLImp observer) {

		Logger.writeMessage("IN testBackupVisitor (Visitor 4) CONSTRUCTOR\n",DebugLevel.DEBUG1);		
	
		fp1=new FileProcessor(file1);
		fp2=new FileProcessor(file2);
		fp3=new FileProcessor(file3);
		
		avlSubject=subject;
		avlBackupObserver=observer;
	}
	@Override
	public void visit(Object o) {
		print(((AVLTree) avlBackupObserver).getRoot(),fp1);
		changeCount(((AVLTree) avlSubject).getRoot());
		print(((AVLTree) avlBackupObserver).getRoot(),fp2);
		print(((AVLTree) avlSubject).getRoot(),fp3);
	}
	public void print(Node root,FileProcessor fp) {
		if(root!=null){
			print(root.getLeft(),fp);
			fp.write(root.getWord() +" Count: " +root.getCount()+"\n");
			print(root.getRight(),fp);
		}
	}
	public void changeCount(Node root) {
		if(root!=null){
			changeCount(root.getLeft());
			root.setCount(root.getCount()+1);
			changeCount(root.getRight());
		}
	}
	
	
}
