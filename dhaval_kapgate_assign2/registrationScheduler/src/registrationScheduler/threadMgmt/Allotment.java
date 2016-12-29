package registrationScheduler.threadMgmt;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

import registrationScheduler.store.ObjectPool;
import registrationScheduler.store.Results;
import registrationScheduler.util.Logger;
import registrationScheduler.util.Logger.DebugLevel;

class Cource
{
	int seat_count;
	char code;
	int priority;
	public Cource(int seat_count, char code,int priority) {
		super();
		this.seat_count = seat_count;
		this.code = code;
		this.priority=priority;
		Logger.writeMessage("In Constructor of Cource.\n", DebugLevel.DEBUG4);
	}
}
class Cource_by_priority
{
	int priority;
	char code;
	int seat;
	public Cource_by_priority(int priority, char code,int seat) {
		super();
		this.priority = priority;
		this.code = code;
		this.seat=seat;
		Logger.writeMessage("In Constructor of Cource_by_priority.\n", DebugLevel.DEBUG4);
	}
}
class Compare implements Comparator<Cource>{

	@Override
	/**
	 * This is the comparator function for priority queue (student_choice) implemented in allotment().
	 */
	public int compare(Cource o1, Cource o2) {
		return o1.seat_count-o2.seat_count;
	}	
}
class Comparep implements Comparator<Cource_by_priority>{

	@Override
	/**
	 * This is the comparator function for priority queue (student_choice_p) implemented in allotment().
	 */
	public int compare(Cource_by_priority o1, Cource_by_priority o2) {
		return o1.priority-o2.priority;
	}

}
public class Allotment{
	/**
	 * This method performs the actual allotment of courses to a student (chosen by a thread)
	 * @param result		The object of Results whose data structures are modified
	 * @param student_no	The student (index) in consideration
	 */
	public void allotment(Results result,int student_no)
	{	
		synchronized(result)
		{
			int min_seat=0,min2=0,min3=0,min4=0,min5=0,max=0;

			//use priority queue and linkedlist such that linkedlist maintains cources with largest seat at the tail
			Compare order=new Compare();
			PriorityQueue<Cource> student_choice = new PriorityQueue<Cource>(7,order);
			LinkedList<Cource> sorted_student= new LinkedList<Cource>();

			//use priority queue and linkedlist such that linkedlist maintains cources with highest priority at the tail
			Comparep order2=new Comparep();
			PriorityQueue<Cource_by_priority> student_choice_p = new PriorityQueue<Cource_by_priority>(7,order2);
			LinkedList<Cource_by_priority> sorted_student_p= new LinkedList<Cource_by_priority>();

			//place first few according to priority and remaining by capacity
			int capacity_alloc[]=ObjectPool.Borrow();
			student_choice_p.add(new Cource_by_priority(8-result.preference[0],'A',capacity_alloc[0]));
			student_choice_p.add(new Cource_by_priority(8-result.preference[1],'B',capacity_alloc[1]));
			student_choice_p.add(new Cource_by_priority(8-result.preference[2],'C',capacity_alloc[2]));
			student_choice_p.add(new Cource_by_priority(8-result.preference[3],'D',capacity_alloc[3]));
			student_choice_p.add(new Cource_by_priority(8-result.preference[4],'E',capacity_alloc[4]));
			student_choice_p.add(new Cource_by_priority(8-result.preference[5],'F',capacity_alloc[5]));
			student_choice_p.add(new Cource_by_priority(8-result.preference[6],'G',capacity_alloc[6]));

			for(int i=0;i<7;i++)
			{
				Cource_by_priority sp=student_choice_p.poll();
				sorted_student_p.add(sp);
			}

			student_choice.add(new Cource(capacity_alloc[0],'A',8-result.preference[0]));
			student_choice.add(new Cource(capacity_alloc[1],'B',8-result.preference[1]));
			student_choice.add(new Cource(capacity_alloc[2],'C',8-result.preference[2]));
			student_choice.add(new Cource(capacity_alloc[3],'D',8-result.preference[3]));
			student_choice.add(new Cource(capacity_alloc[4],'E',8-result.preference[4]));
			student_choice.add(new Cource(capacity_alloc[5],'F',8-result.preference[5]));
			student_choice.add(new Cource(capacity_alloc[6],'G',8-result.preference[6]));
			for(int i=0;i<7;i++)
			{
				Cource s=student_choice.poll();
				sorted_student.add(s);
				if(i==6)
					min2=s.seat_count;
				else if(i==5)
					min3=s.seat_count;
				else if(i==4)
					min4=s.seat_count;
				else if(i==3)
					min5=s.seat_count;
			}
			Cource least=sorted_student.element();
			min_seat=least.seat_count;
			least=sorted_student.peekLast();
			max=least.seat_count;
			int prefer=0;	
			for(int i=0;i<5;i++)
			{
				int position=0;
				if((80-student_no<60 || (80-student_no-1)-min_seat>1) && min_seat>1 && min2>1 && min3>2 && min4>3 && min5>4 && (max-min_seat)<10)
				{
					Cource_by_priority c=sorted_student_p.removeLast();
					position=c.code-64;
					prefer+=8-c.priority;
				}
				else
				{
					Cource c=sorted_student.removeLast();
					position=c.code-64;
					prefer+=8-c.priority;
				}
				result.pref_scores[student_no]=prefer;
				result.alloted_pref[student_no][position-1]=position;
				capacity_alloc[position-1]--;
				ObjectPool.Return(capacity_alloc);
			}
			Logger.writeMessage(Thread.currentThread().getName()+" took "+result.student[student_no]+" details and updated Results pref_scores and allocted_pref "+"\n\n", DebugLevel.DEBUG2);
			
			sorted_student.clear();
			sorted_student_p.clear();
		}
		float score=0;
		for(int i=0;i<80;i++)
		{
			//System.out.println();
			for(int j=0;j<7;j++)
			{
				score=score+result.alloted_pref[i][j];
			}
		}
		score=score/80;
	}
}
