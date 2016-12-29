package wordCount.driver;

import wordCount.dsForStrings.AVLImp;
import wordCount.dsForStrings.AVLTree;
import wordCount.util.FileProcessor;
import wordCount.util.Logger;
import wordCount.visitors.BackupVisitor;
import wordCount.visitors.DSProcessingVisitorI;
import wordCount.visitors.PopulateVisitor;
import wordCount.visitors.TestBackupVisitor;
import wordCount.visitors.WordCountVisitor;

public class Driver {
	public static void main(String[] args) {
		try{
			String input="",output="";
			int NUM_ITERATIONS=1,DEBUG_LVL=0;
			if(args.length==4)
			{
				input=args[0];
				output=args[1];
				NUM_ITERATIONS=Integer.parseInt(args[2]);
				DEBUG_LVL=Integer.parseInt(args[3]); 
			}
			else
			{
				System.err.println("Invalid number of arguments");
				System.exit(0);
			}
			if(DEBUG_LVL<0||DEBUG_LVL>=5)
			{
				System.err.println("Invalid debug level");
				System.exit(0);
			}
			Logger.setDebugValue(DEBUG_LVL);
			FileProcessor fp=null;
			
			AVLImp avl=new AVLTree();
			long startTime = System.currentTimeMillis();
			
			//VISITOR 1 and 2
			for(int i=0;i<NUM_ITERATIONS;i++)
			{
				fp=new FileProcessor(input,output);
				DSProcessingVisitorI populateVisitor=new PopulateVisitor(fp);
				DSProcessingVisitorI wordCountVisitor=new WordCountVisitor(fp);
				avl.accept(populateVisitor);
				avl.accept(wordCountVisitor);
			}
			long finishTime = System.currentTimeMillis();
			long total_time = (finishTime-startTime)/NUM_ITERATIONS;
			System.out.println("\nTOTAL TIME: "+total_time+" milliseconds");
			fp.write("");
			if(DEBUG_LVL==2)
				((AVLTree)avl).display(((AVLTree) avl).getRoot());
			
			//visitor 3
			DSProcessingVisitorI backupVisitor=new BackupVisitor();
			avl.accept(backupVisitor);
			AVLImp backupAVL=((BackupVisitor) backupVisitor).getAvlbackup();
			
			if(DEBUG_LVL==3)
				((AVLTree)backupAVL).display(((AVLTree) backupAVL).getRoot());
			
			//visitor 4
			DSProcessingVisitorI testBackupVisitor=new TestBackupVisitor(avl,backupAVL);
			avl.accept(testBackupVisitor);
		}
		catch(NullPointerException e)
		{
			System.exit(0);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.exit(0);
		}
		catch(ArithmeticException e)
		{
			System.exit(0);	
		}
		catch(Exception e)
		{
			System.exit(0);
		}
		finally
		{
			
		}
	}
}
