CS542 Design Patterns
Fall 2016
PROJECT 1 README FILE

Due Date: Tuesday, August 30, 2016
Submission Date: Tuesday, August 30, 2016
Grace Period Used This Project: 0 Days
Grace Period Remaining: 0 Days
Author(s): DHAVAL KAPGATE
e-mail(s): dkapgat1@binghamton.edu

PURPOSE:
  The purpose of this project to assign courses to students based on their preferences. We have 4 courses each having a capacity of 10. 
  We have 12 students who have to be alloted 3 courses each and each student has given preference of cources. 
  We have to allot all the students their cources such that the average preference score (If a student gets her first choice, the preference score is 1. 
  If a student gets her second choice, the preference score is 2, and so on. So for a student the preference score is sum of preference of alloted subjects.) is the 
  least.

PERCENT COMPLETE:
  I believe I have completed 100% of this project.

PARTS THAT ARE NOT COMPLETE:
  I beleive I have no parts incomplete. 

BUGS:
  NONE

FILES:
  Included with this project are 2 files:

  Driver.java, the main file associated with the program also contains main
  README, the text file you are presently reading

DATA STRUCTURE USED:
  2 Dimensional Arrays are used for storing information of the student and also the final solution.
  Time complexity : O(4^n)
  Space Complexity : O(m*n)
  (where m=4 and n=12)

SAMPLE OUTPUT:
bingsuns2% javac Driver.java
bingsuns2% java Driver input.txt output.txt
bingsuns2% cat output.txt
Student_1 A B C 6
Student_2 B C D 6
Student_3 C D A 6
Student_4 D A B 6
Student_5 A B C 6
Student_6 B C D 6
Student_7 C D A 6
Student_8 D A B 6
Student_9 A B C 6
Student_10 B C D 6
Student_11 C D A 6
Student_12 D A B 6

Average preference_score is: 6.0
bingsuns2%

TO COMPILE:
  Just extract the files and then do a "javac *.java".

TO RUN:
  Place the input file in src folder (same folder as Driver.java and README.txt).
  After compiling,do "java Driver input.txt output.txt".
  The open output.txt(in the same folder as input.txt) to check output.

EXTRA CREDIT:
  N/A

BIBLIOGRAPHY:
  This serves as evidence that we are in no way intending Academic Dishonesty.
  Dhaval Kapgate.

ACKNOWLEDGEMENT:
NONE