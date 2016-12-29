CS542 Design Patterns
Fall 2016
PROJECT 2 README FILE

Due Date: Friday, September 30, 2016
Submission Date: Friday, September 30, 2016
Grace Period Used This Project: 0 Days
Grace Period Remaining: 0 Days
Author(s): DHAVAL KAPGATE
e-mail(s): dkapgat1@binghamton.edu

PURPOSE:
	The purpose of this project to assign courses to students based on their preferences. We have 7 courses each having a capacity of 60. 
	We have 80 students who have to be alloted 5 courses each and each student has given preference of cources. 
	We have to allot all the students their cources such that the average preference score (If a student gets her first choice, the preference score is 1. 
	If a student gets her second choice, the preference score is 2, and so on. So for a student the preference score is sum of preference of alloted subjects.) is the 
	least. The allotment of courses to students is done using a few threads.

PERCENT COMPLETE:
	I believe I have completed 100% of this project.

PARTS THAT ARE NOT COMPLETE:
	I beleive I have no parts incomplete. 

BUGS:
	NONE

FILES:
	README.txt, the text file you are presently reading
	build.xml, Build file for ant
	registrationScheduler/driver/Driver.java, the main file associated with the program also contains main
	registrationScheduler/store/FileDisplayInterface.java, the interface for printing output in file
	registrationScheduler/store/StdoutDisplayInterface.java, the interface for printing output on screen
	registrationScheduler/store/ObjectPool.java, the ObjectPool
	registrationScheduler/store/Results.java, file that contains data structures for final results and storage and printing methods 
	registrationScheduler/threadMgmt/Allotment.java, file containing course allotment methods 
	registrationScheduler/threadMgmt/CreateWorkers.java, file containing method to create worker threads
	registrationScheduler/threadMgmt/WorkerThread.java, file containing methods to starts threads
	registrationScheduler/util/FileProcessor.java, the file containing method to read and return line from a file
	registrationScheduler/util/Logger.java, file containing methods to handle Debug states
	
DATA STRUCTURE USED:
	1 Dimensional Arrays are used for storing information of the student and also the final solution.
	2 Priority-queues (operation used are add(O(1)) and poll(O(log(n)))) and 
	2 Linked-Lists (operation used are add(O(1)),removeLast(O(1)) and peekLast(O(1)))(all of size 7) are used for allotment process. 
	Time complexity : O(m*log(n)) (since poll operation occurs m times).
	Space Complexity : O(m*n)
	(where m=80 and n=7)

SAMPLE OUTPUT:
	bingsuns2% ant -buildfile src/build.xml all
	Buildfile: src/build.xml

	prepare:

	registrationScheduler:
		[javac] Compiling 10 source files to /u0/users/3/dkapgat1/cs542/dhaval_kapgate/registrationScheduler/BUILD/classes

	compile_all:

	all:

	BUILD SUCCESSFUL
	Total time: 2 seconds
	bingsuns2% ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=output.txt -Darg2=2 -Darg3=1
	Buildfile: src/build.xml

	jar:
		  [jar] Building jar: /u0/users/3/dkapgat1/cs542/dhaval_kapgate/registrationScheduler/BUILD/jar/registrationScheduler.jar

	run:
		 [java] Student_1 A B C D E 15
		 [java] Student_2 B C D E F 15
		 [java] Student_3 C D E F G 15
		 [java] Student_4 A D E F G 15
		 [java] Student_5 A B E F G 15
		 [java] Student_6 A B C F G 15
		 [java] Student_7 A B C D G 15
		 [java] Student_8 A B C D E 15
		 [java] Student_9 B C D E F 15
		 [java] Student_10 C D E F G 15
		 [java] Student_11 A D E F G 15
		 [java] Student_12 A B E F G 15
		 [java] Student_13 A B C F G 15
		 [java] Student_14 A B C D G 15
		 [java] Student_15 A B C D E 15
		 [java] Student_16 B C D E F 15
		 [java] Student_17 C D E F G 15
		 [java] Student_18 A D E F G 15
		 [java] Student_19 A B E F G 15
		 [java] Student_20 A B C F G 15
		 [java] Student_21 A B C D G 15
		 [java] Student_22 A B C D E 15
		 [java] Student_23 B C D E F 15
		 [java] Student_24 C D E F G 15
		 [java] Student_25 A D E F G 15
		 [java] Student_26 A B E F G 15
		 [java] Student_27 A B C F G 15
		 [java] Student_28 A B C D G 15
		 [java] Student_29 A B C D E 15
		 [java] Student_30 B C D E F 15
		 [java] Student_31 C D E F G 15
		 [java] Student_32 A D E F G 15
		 [java] Student_33 A B E F G 15
		 [java] Student_34 A B C F G 15
		 [java] Student_35 A B C D G 15
		 [java] Student_36 A B C D E 15
		 [java] Student_37 B C D E F 15
		 [java] Student_38 C D E F G 15
		 [java] Student_39 A D E F G 15
		 [java] Student_40 A B E F G 15
		 [java] Student_41 A B C F G 15
		 [java] Student_42 A B C D G 15
		 [java] Student_43 A B C D E 15
		 [java] Student_44 B C D E F 15
		 [java] Student_45 C D E F G 15
		 [java] Student_46 A D E F G 15
		 [java] Student_47 A B E F G 15
		 [java] Student_48 A B C F G 15
		 [java] Student_49 A B C D G 15
		 [java] Student_50 A B C D E 15
		 [java] Student_51 B C D E F 15
		 [java] Student_52 C D E F G 15
		 [java] Student_53 A D E F G 15
		 [java] Student_54 A B E F G 15
		 [java] Student_55 A B C F G 15
		 [java] Student_56 A B C D G 15
		 [java] Student_57 A B C D E 15
		 [java] Student_58 B C D E F 15
		 [java] Student_59 C D E F G 15
		 [java] Student_60 A D E F G 15
		 [java] Student_61 A B E F G 15
		 [java] Student_62 A B C F G 15
		 [java] Student_63 A B C D G 15
		 [java] Student_64 A B C D E 15
		 [java] Student_65 B C D E F 15
		 [java] Student_66 C D E F G 15
		 [java] Student_67 A D E F G 15
		 [java] Student_68 A B E F G 15
		 [java] Student_69 A B C F G 15
		 [java] Student_70 A B C D G 15
		 [java] Student_71 A B C D E 15
		 [java] Student_72 B C D E F 15
		 [java] Student_73 C D E F G 15
		 [java] Student_74 A D E F G 15
		 [java] Student_75 A B E F G 15
		 [java] Student_76 A B C F G 15
		 [java] Student_77 A B C D G 15
		 [java] Student_78 A B C D E 15
		 [java] Student_79 A B E F G 23
		 [java] Student_80 C D E F G 15
		 [java] Average preference_score is: 15.28875
		 [java] Capacity/Availabilty of cources:
		 [java] A   B       C       D       E       F       G
		 [java] 3   3       3       3       2       3       3

	BUILD SUCCESSFUL
	Total time: 1 second
	bingsuns2%

TO COMPILE:
	ant -buildfile src/build.xml all
	
TO RUN:
	ant -buildfile src/build.xml run -Darg0=[input_file] -Darg1=[output_file] -Darg2=[NUM_THREADS] -Darg3=[DEBUG_VALUE]

EXTRA CREDIT:
	N/A

BIBLIOGRAPHY:
	  This serves as evidence that we are in no way intending Academic Dishonesty.
	  Dhaval Kapgate.

ACKNOWLEDGEMENT:
	NONE