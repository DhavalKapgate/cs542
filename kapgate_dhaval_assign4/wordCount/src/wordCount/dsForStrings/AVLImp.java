package wordCount.dsForStrings;

import wordCount.visitors.DSProcessingVisitorI;

public interface AVLImp {
	public int wordCount(Node root);
	public int charCount(Node root);
	public int distintCount(Node root);
	
	public Node insert(Node node, String word);
	public void display(Node root);
	
	public void accept(DSProcessingVisitorI visitor);
}
