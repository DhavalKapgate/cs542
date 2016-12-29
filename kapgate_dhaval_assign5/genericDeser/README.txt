CS542 Design Patterns
Fall 2016
PROJECT 5 README FILE

Due Date: Tuesday, December 13, 2016
Submission Date: Friday, December 9, 2016
Grace Period Used This Project: 0 Days
Grace Period Remaining: 0 Days
Author(s): DHAVAL KAPGATE
e-mail(s): dkapgat1@binghamton.edu

PURPOSE:
	Input file contains information about the type of objects (of First.java or Second.java) to be created.
	Using the information create the required objects and store them in a data structure. After all the objects are created and stored in 
	the data structure perform computations to print the number of unique and total objects of each type of  object created.

PERCENT COMPLETE:
	I believe I have completed 100% of this project.

PARTS THAT ARE NOT COMPLETE:
	I beleive I have no parts incomplete. 

BUGS:
	NONE

FILES:
	README.txt, the text file you are presently reading.
	build.xml, the build file .
	Driver.java, the file containing main function.
	FileProcessor.java, file containing file operations.
	First.java, the java file whose objects are to be stored in Data Structure.
	Second.java, the java file whose objects are to be stored in Data Structure.
	HashMapsObjectAndCount.java, the file containing data structures and its functions used for storing objects.
	HashMapsObjectAndCountIn.java, interface for HashMapsObjectAndCount.java.
	Logger.java, Logger file.
	ObjectCreation.java, the file responsible for setting data members(with objects such as Integer) of each object.
	ObjectCreationIn.java, Interface for ObjectCreation.java.
	PopulateObjects.java, the file responsible for creation of objects and storing them into data structure.
	PopulateObjects.java, interface for PopulateObjects.java	
	
DATA STRUCTURE USED:
	2 HashMaps are used. One for storing the unique objects and other for storing the count of each unique object.
	Time complexity : O(n) (in case of linear polling)
	Space Complexity : O(n)
	wher n is total number of entries in hashmap/buckets.
	
SAMPLE OUTPUT:
	bingsuns2% ant -buildfile build.xml all
	Buildfile: build.xml

	prepare:

	genericDeser:
		[javac] Compiling 2 source files to /u0/users/3/dkapgat1/cs542Assignment5/kapgate_dhaval_assign5/BUILD/classes

	compile_all:

	all:

	BUILD SUCCESSFUL
	Total time: 3 seconds
	bingsuns2% ant -buildfile build.xml run -Darg0=genericDeser/input1.txt -Darg1=1 -Darg2=0
	Buildfile: build.xml

	jar:
		  [jar] Building jar: /u0/users/3/dkapgat1/cs542Assignment5/kapgate_dhaval_assign5/BUILD/jar/genericDeser.jar

	run:
		 [java] Number of unique First objects:359994
		 [java] Total Number of First objects:498623
		 [java] Number of unique Second objects:100643
		 [java] Total Number of Second objects:501377
		 [java] TOTAL TIME: 63374 millisecss

	BUILD SUCCESSFUL
	Total time: 1 minute 6 seconds

TO COMPILE:
	ant -buildfile build.xml all
	
TO RUN:
	ant -buildfile build.xml run -Darg0=[input_file] -Darg1=[NUM_OF_ITERATIONS] -Darg2=[DEBUG_LEVEL]
	
EXTRA CREDIT:
	N/A

BIBLIOGRAPHY:
	This serves as evidence that we are in no way intending Academic Dishonesty.
	Dhaval Kapgate.
	  
ACKNOWLEDGEMENT:
	NONE