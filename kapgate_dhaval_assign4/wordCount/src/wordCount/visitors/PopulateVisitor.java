package wordCount.visitors;

import wordCount.dsForStrings.AVLImp;
import wordCount.dsForStrings.AVLTree;
import wordCount.dsForStrings.Node;
import wordCount.util.FileProcessor;
import wordCount.util.Logger;
import wordCount.util.Logger.DebugLevel;

public class PopulateVisitor implements DSProcessingVisitorI{

	FileProcessor fp=null;
	AVLImp avl=null;
	public PopulateVisitor(FileProcessor fproc) {
		Logger.writeMessage("IN PopulateVisitor (Visitor 1) CONSTRUCTOR\n",DebugLevel.DEBUG1);
		
		fp = fproc;
	}

	@Override
	public void visit(Object o) {
		avl=(AVLImp)o;
		String line=null;
		Node root=null;
		while ((line=fp.read())!=null){
			String[] words=line.split("[ |\t]+");
			for(int i=0;i<words.length;i++)
				if(words[i].length()>0)
					root=avl.insert(root,words[i]);
		}
		((AVLTree) avl).setRoot(root);
	}
}
