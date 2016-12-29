import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Driver {

	//fixed data
	static int preference[][]=new int[12][4];	//stores preferences of each cource
	static int rev_preference[][]=new int[12][4];   //stores cources according to pref
	static String student[]=new String[12];
	
	//variable data
	static boolean alloted[][]=new boolean[12][4];
	static int alloted_pref[][]=new int[12][4];
	static int best_allot[][]=new int[12][4];
	static float pref_score=1000;
	static String output;	
	
	public static void main(String[] args) {
		int capacity[]={10,10,10,10};
		try{
			if(args.length!=2)
			{
				System.out.println("INVALID ARGUMENTS.");
				System.exit(0);
			}

			output=args[1];
			//file input part
			BufferedReader br=new BufferedReader(new FileReader(args[0]));
			String entry;
			int count=0;
			while((entry = br.readLine()) != null)
			{
				String[] line=entry.split(" ");
				student[count]=line[0];
				for(int i=0;i<4;i++)
				{
					preference[count][i]=Integer.parseInt(line[i+1]);
					rev_preference[count][Integer.parseInt(line[i+1])-1]=i+1;
				}
				count++;
			}
			
			if(count!=12)
			{
				System.out.println("Incomplete information in file");
				System.exit(0);
			}
			
			//we now solve the problem using backtrack method. Thus, creating a tree of maximum depth of 12 and each 
			//intermidiate (non-leaf) node having 4 children. The tree is build to form leaf with least avg. preference
			//score and if we find a leaf that has avg prefernce score of 6 we stop or else find the leaf with least 
			//avg prefernce score.
			allotment(alloted,0,capacity);
			br.close();
			
			File out=new File(args[1]);
			BufferedWriter bw=new BufferedWriter(new FileWriter(out));
			for(int i=0;i<12;i++)
			{
				bw.write(student[i]+" ");
				int pref=0;
				for(int j=0;j<4;j++)
				{
					if(best_allot[i][j]!=0)
					{
						bw.write('A'+best_allot[i][j]-1);
						bw.write(' ');
						pref+=j+1;
					}
				}
				String pref_String=pref+"";
				bw.write(pref_String);
				bw.newLine();
			}
			bw.newLine();
			bw.write("Average preference_score is: "+pref_score);
			bw.newLine();			
			bw.close();
		}
		catch(FileNotFoundException ex)
		{
			System.out.println("FILE NOT FOUND.");
                        System.exit(0);
		}
		catch (Exception e) 
		{
			System.out.println("ERROR ENCOUNTERED.");
			System.exit(0);
		}
	}
	public static void allotment(boolean[][] alloted,int student_no,int[] capacity) {
		if(student_no<12)
		{
			//1110 means picking first 3 highest prefered cources (0 position means that indexed cource not taken)
			//combination priority 1110/////////////////////////////////////////////////////////// 
			alloted[student_no][0]=alloted[student_no][1]=alloted[student_no][2]=true;
			alloted[student_no][3]=false;
			capacity[preference[student_no][0]-1]--;
			capacity[preference[student_no][1]-1]--;
			capacity[preference[student_no][2]-1]--;
			alloted_pref[student_no][0]=rev_preference[student_no][0];
			alloted_pref[student_no][1]=rev_preference[student_no][1];
			alloted_pref[student_no][2]=rev_preference[student_no][2];
			alloted_pref[student_no][3]=0;
			if(capacity[preference[student_no][0]-1]>=0 && capacity[preference[student_no][1]-1]>=0 && capacity[preference[student_no][2]-1]>=0)
				allotment(alloted,student_no+1,capacity);
				
			//revert for next branch
			capacity[preference[student_no][0]-1]++;
			capacity[preference[student_no][1]-1]++;
			capacity[preference[student_no][2]-1]++;
			
			
			//combination priority 1101///////////////////////////////////////////////////////////
			alloted[student_no][0]=alloted[student_no][1]=alloted[student_no][3]=true;
			alloted[student_no][2]=false;
			capacity[preference[student_no][0]-1]--;
			capacity[preference[student_no][1]-1]--;
			capacity[preference[student_no][3]-1]--;
			alloted_pref[student_no][0]=rev_preference[student_no][0];
			alloted_pref[student_no][1]=rev_preference[student_no][1];
			alloted_pref[student_no][3]=rev_preference[student_no][3];
			alloted_pref[student_no][2]=0;
			if(capacity[preference[student_no][0]-1]>=0 && capacity[preference[student_no][1]-1]>=0 && capacity[preference[student_no][3]-1]>=0)
				allotment(alloted,student_no+1,capacity);
			//revert for next branch
			capacity[preference[student_no][0]-1]++;
			capacity[preference[student_no][1]-1]++;
			capacity[preference[student_no][3]-1]++;
			
			
			//combination priority 1011///////////////////////////////////////////////////////////
			alloted[student_no][0]=alloted[student_no][3]=alloted[student_no][2]=true;
			alloted[student_no][1]=false;
			capacity[preference[student_no][0]-1]--;
			capacity[preference[student_no][3]-1]--;
			capacity[preference[student_no][2]-1]--;
			alloted_pref[student_no][0]=rev_preference[student_no][0];
			alloted_pref[student_no][3]=rev_preference[student_no][3];
			alloted_pref[student_no][2]=rev_preference[student_no][2];
			alloted_pref[student_no][1]=0;
			if(capacity[preference[student_no][0]-1]>=0 && capacity[preference[student_no][3]-1]>=0 && capacity[preference[student_no][2]-1]>=0)
				allotment(alloted,student_no+1,capacity);
			//revert for next branch
			capacity[preference[student_no][0]-1]++;
			capacity[preference[student_no][3]-1]++;
			capacity[preference[student_no][2]-1]++;
			
			
			//combination priority 0111///////////////////////////////////////////////////////////
			alloted[student_no][3]=alloted[student_no][1]=alloted[student_no][2]=true;
			alloted[student_no][0]=false;
			capacity[preference[student_no][3]-1]--;
			capacity[preference[student_no][1]-1]--;
			capacity[preference[student_no][2]-1]--;
			alloted_pref[student_no][3]=rev_preference[student_no][3];
			alloted_pref[student_no][1]=rev_preference[student_no][1];
			alloted_pref[student_no][2]=rev_preference[student_no][2];
			alloted_pref[student_no][0]=0;
			if(capacity[preference[student_no][3]-1]>=0 && capacity[preference[student_no][1]-1]>=0 && capacity[preference[student_no][2]-1]>=0)
				allotment(alloted,student_no+1,capacity);
			//revert for next branch
			capacity[preference[student_no][3]-1]++;
			capacity[preference[student_no][1]-1]++;
			capacity[preference[student_no][2]-1]++;
		}
		else	//save the best leaf result
		{
			if(count1(alloted_pref))
				if(count2(alloted_pref))
					if(count3(alloted_pref))
						if(count4(alloted_pref))	
							{
								float pref_sum=0;
								for(int i=0;i<12;i++)
									for(int j=0;j<4;j++)
										if(alloted_pref[i][j]!=0)
											pref_sum=pref_sum+preference[i][alloted_pref[i][j]-1];
								pref_sum=pref_sum/12;
								if(pref_score>pref_sum)
								{
									pref_score=pref_sum;
									for(int i=0;i<12;i++)
										for(int j=0;j<4;j++)
											best_allot[i][j]=alloted_pref[i][j];	
								}
							}	
			if(pref_score==6)	//found the best case possible so we can exit
			{
				File out=new File(output);
				BufferedWriter bw;
				try {
					bw = new BufferedWriter(new FileWriter(out));
				
					for(int i=0;i<12;i++)
					{
						bw.write(student[i]+" ");
						int pref=0;
						for(int j=0;j<4;j++)
						{
							if(best_allot[i][j]!=0)
							{
								bw.write('A'+best_allot[i][j]-1);
								bw.write(' ');
								pref+=j+1;
							}
						}
						String pref_String=pref+"";
						bw.write(pref_String);
						bw.newLine();
					}
					bw.newLine();
					bw.write("Average preference_score is: "+pref_score);
					bw.newLine();
					bw.close();
					System.exit(0);
				} 
				catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Error (after finding best solution) while writing into output file.");
					System.exit(0);
				}
			}
		}
	}
	//these count methods check if a cource is filled
	public static boolean count1(int[][] best_allot)
	{
		int p1=0;
		for(int j=0;j<12;j++)
			for(int i=0;i<4;i++)
				if(best_allot[j][i]==1)
					p1++;
		if(p1<=10)
			return true;
		else 
			return false;
	}
	public static boolean count2(int[][] best_allot)
	{
		int p2=0;
		for(int j=0;j<12;j++)
			for(int i=0;i<4;i++)
				if(best_allot[j][i]==2)
					p2++;
		if(p2<=10)
			return true;
		else 
			return false;
	}
	public static boolean count3(int[][] best_allot)
	{
		int p3=0;
		for(int j=0;j<12;j++)
			for(int i=0;i<4;i++)
				if(best_allot[j][i]==3)
					p3++;
		if(p3<=10)
			return true;
		else 
			return false;
	}
	public static boolean count4(int[][] best_allot)
	{
		int p4=0;
		for(int j=0;j<12;j++)
			for(int i=0;i<4;i++)
				if(best_allot[j][i]==4)
					p4++;
		if(p4<=10)
			return true;
		else 
			return false;
	}
}
