package wordCount.dsForStrings;

import java.util.ArrayList;

import wordCount.util.Logger;
import wordCount.util.Logger.DebugLevel;

public class Node implements Cloneable,Subject,Observer{
	private Node left;
	private Node right;
	private int height;
	private int count;
	private String word;
	private ArrayList<Node> observerList;
	public Node(String wordIm) {
		Logger.writeMessage("IN Node CONSTRUCTOR\n",DebugLevel.DEBUG1);		
	
		height = 1;
		left=right=null;
		count=1;
		word=wordIm;
		observerList=new ArrayList<Node>();
	}
	
	public Node getLeft() {
		return left;
	}
	
	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
		notifyObserver();
	}

	public String getWord() {
		return word;
	} 

	public void setWord(String word) {
		this.word = word;
		notifyObserver();
	}
	
	/*
	 * returns the cloned Node of the tree node called
	 * @see java.lang.Object#clone()
	 * @return Object (casted as Node by the caller function)  
	 */
	public Object clone()
	{
		Node target=new Node(this.word);
		target.setCount(this.count);
		return target;
	}

	/**
	 * update node content of backup when original node is manipulated 
	 */
	@Override
	public void update(String subjectWord,int subjectCount) {
		word=subjectWord;
		count=subjectCount;
	}
	
	/**
	 * notify all observer that the subject is modified
	 */
	@Override
	public void notifyObserver() {
		for(int i=0;i<observerList.size();i++)
		{	
			Node observer=(Node)observerList.get(i);
			observer.update(this.getWord(),this.getCount());
		}
	}

	/**
	 * remove observer from observer list
	 */
	@Override
	public void removeObserver(Node node) {
		int i=observerList.indexOf(node);
		if(i>=0)
			observerList.remove(i);
	}

	/**
	 * add observer to observer list
	 */
	@Override
	public void registerObserver(Node node) {
		observerList.add(node);
	}

	/**
	 * get observer arraylist
	 * @return arraylist of observer Nodes
	 */
	public ArrayList<Node> getObserverList() {
		return observerList;
	}
}
