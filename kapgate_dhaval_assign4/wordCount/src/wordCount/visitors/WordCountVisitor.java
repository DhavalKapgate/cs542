package wordCount.visitors;

import wordCount.dsForStrings.AVLImp;
import wordCount.dsForStrings.AVLTree;
import wordCount.util.FileProcessor;
import wordCount.util.Logger;
import wordCount.util.Logger.DebugLevel;

public class WordCountVisitor implements DSProcessingVisitorI{

	AVLImp avl=null;
	FileProcessor fp=null;
	public WordCountVisitor(FileProcessor fpImp) {
		fp=fpImp;
		Logger.writeMessage("IN WordCountVisitor (Visitor 2) CONSTRUCTOR\n",DebugLevel.DEBUG1);		
	}

	@Override
	public void visit(Object o) {
		try{
			avl=(AVLImp)o;
		}
		catch(Exception e)
		{
			System.exit(0);
		}
		int  numberOfWords, numberOfDistinctWords,numberOfCharacters;
		numberOfWords=avl.wordCount(((AVLTree) avl).getRoot());
		numberOfDistinctWords=avl.distintCount(((AVLTree) avl).getRoot());
		numberOfCharacters=avl.charCount(((AVLTree) avl).getRoot());
		fp.write("number of words="+numberOfWords+"\nnumber of distinct words="+numberOfDistinctWords+"\nnumber of characters="+numberOfCharacters+"\n");
		//Logger.writeMessage("number of words="+numberOfWords+"\nnumber of distinct words="+numberOfDistinctWords+"\nnumber of characters="+numberOfCharacters+"\n",DebugLevel.DEBUG0);
	}

}
