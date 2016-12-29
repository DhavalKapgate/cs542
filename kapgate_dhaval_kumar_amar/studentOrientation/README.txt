CS542 Design Patterns
Fall 2016
PROJECT 3 README FILE

Due Date: Friday, October 28, 2016
Submission Date: Friday, October 28, 2016
Grace Period Used This Project: 0 Days
Grace Period Remaining: 0 Days
Author(s): Dhaval Kapgate and Amar Kumar
e-mail(s): dkapgat1@binghamton.edu and akumar14@binghamton.edu


PURPOSE:

	The purpose of this project is to develop a tool for student orientation program at Binghamton University.
	assuming that our library is used by each student to write his/her Driver code for their specific orientation plan.
	The orientation checklist consists of taking a campus tour, buying books, selecting a dorm, and registering for courses. 
	There is time duration, cost, carbon footprint, and effort associated with each of these activities.
	For the student giving the driver code that include its choices we calculate the total time duration, cost, and effort of the orientation 
	(based on her/his choices).

PERCENT COMPLETE:

	I believe I have completed 100% of this project.

PARTS THAT ARE NOT COMPLETE:

	None

BUGS:

	None

FILES:

	Included with this project are 23 files:

	src/studentOrientation/driver/Driver.java, the main file associated with the program also contains main
	src/studentOrientation/activities/Buying_books.java, interface for Buying books activity
	src/studentOrientation/activities/Campus_tour.java,	interface for Campus tour activity
	src/studentOrientation/activities/Registration.java, interface for Registration activity 
	src/studentOrientation/activities/Select_dorm.java, interface for Selecting a Dorm activity
	src/studentOrientation/activity_attributes/Attributes.java, file containing methods implemented by interfaces Carbon_footprint,Cost,Effort,Duration
	src/studentOrientation/activity_attributes/Carbon_footprint.java, interface for Carbon Footprint of each activity
	src/studentOrientation/activity_attributes/Cost.java, interface for Cost of each activity
	src/studentOrientation/activity_attributes/Duration.java, interface for Duration of each activity
	src/studentOrientation/activity_attributes/Effort.java, interface for Effort of each activity
	src/studentOrientation/enums/ActivityBaseCO2.java, enum file for Carbon footprint for each activity
	src/studentOrientation/enums/ActivityBaseCost.java, enum file for Cost for each activity
	src/studentOrientation/enums/ActivityBaseDuration.java, enum file for Duration for each activity
	src/studentOrientation/enums/ActivityBaseEffort.java, enum file for Effort for each activity
	src/studentOrientation/enums/Buying_Books_Enum.java, enum file for Buying Books
	src/studentOrientation/enums/Campus_tour_Enum.java, enum file for Campus tour
	src/studentOrientation/enums/Registration_Enum.java, enum file for Registration
	src/studentOrientation/enums/Selecting_Dorm_Enum.java, enum file for Selecting a dorm
	src/studentOrientation/util/BU2016Orientationworkshop.java, file containing construct (workskhop)
	src/studentOrientation/util/BU2016Student.java, file containing implementations of interfaces Buying_books,Campus_tour,Registration,Select_dorm
	src/studentOrientation/util/BUStudent.java, abstract base class for BU2016Student.java (containing abstract methods)
	src/studentOrientation/util/Logger.java, file containing methods to handle Debug states
	src/studentOrientation/util/StudentOrientationworkshop, interface for BU2016Orientationworkshop.java
	README.txt, the text file you are presently reading

SAMPLE OUTPUT:

	bingsuns2% ant -buildfile build.xml run
	Buildfile: build.xml

	jar:

	run:
		 [java] Your choices:
		 [java] CAMPUS TOUR: BUS-RIDE
		 [java] BUYING BOOKS: UNIVERSITY BOOKSTORE
		 [java] SELECTING DORM: STANDING IN LONG QUEUE OUTSIDE ADMINISTRARORS OFFICE
		 [java] REGISTERING COURSES: SUBMITTING FORM TO REGISTRARS OFFICE

		 [java] TOTAL:
		 [java] DURATION: 295 minutes
		 [java] CARBON FOOTPRINT: 0.15000000000000002 tonnes of CO2
		 [java] COST: $3122.0
		 [java] EFFORT: 692 calories

	BUILD SUCCESSFUL
	Total time: 1 second


TO COMPILE:

	ant -buildfile build.xml all

TO RUN:

	ant -buildfile build.xml run

EXTRA CREDIT:

	N/A

BIBLIOGRAPHY:

	This serves as evidence that we are in no way intending Academic Dishonesty.
	Dhaval Kapgate
	Amar Kumar

ACKNOWLEDGEMENT:

	None