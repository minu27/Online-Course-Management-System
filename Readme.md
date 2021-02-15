# Learning System - Blackboard application

## Project Summary

My project is a Learning System - Blackboard application which deals with the management of data and communication between students, instructors, and teaching assistants. This application is a Maven web application using Payara Server. The domain of the application is the Education System, which is divided into major components like Student, Instructor, Teaching Assistant, Course, and Assignments. It has several controllers and services which manage the flow of application and data. It also has a Pbkdf2PasswordHash security configuration which will authenticate the login to the application for the different types of users. The users use their email id to login to the application.

Blackboard allows the Student to take courses and assignments for those courses. This application has three different types of user, Student, Instructor, Teaching Assistant. The instructor has all the privileges to perform create, read, update, and delete the assignments of a course. The Teaching Assistant has the privilege to view and edit the assignments. Students also can view and edit a few fields of assignment data.

## Design

The application starts with the login page. The new accounts cannot be created on the login page, it is the instructor's task to create new students. The different users i.e. the instructors, teaching assistants, and students can log in through the login page and access the application.
log in as an instructor -The instructor can create new students and make changes to the existing students.  As each instructor handles a course for the students, the instructor can set the Course to the new students and make necessary changes to the existing courses and assignments details using the action links 'View', 'Edit', 'Remove' next to each assignment. Similarly, the instructor can add new students and make the required changes using the action links next to each student.  
log in as a teaching assistant - The teaching assistant can view the course information that he would be grading assignments for along with the students list enrolled for that course. The teaching assistant can add marks and grades to the students enrolled and update them or change them as required using the action links 'View', 'Edit', 'Remove' next to each assignment. 
log in as a student -The student can view the courses they have enrolled and the instructors for each course. The student can add courses using the 'Add Courses to Student' button below each table. The student has the advantage of making changes to the assignments using the action links 'View', 'Edit', 'Remove' next to each assignment. 


## Layers and their functionality 


1. The persistence layers include the entities of the application i.e. instructor, teaching assistant, student, course, assignments with necessary getters, and setters.


2. The security layer includes the User and Group classes. The applications consist of three users as mentioned i.e. instructor, teaching assistant, student, and three groups i.e. STUDENT_GROUP, INSTRUCTOR_GROUP, and TEACHINGASSISTANT_GROUP to link users to their roles so that only the respective users can access their services.


3. The service layer consists of the EJB's for each entity with different services as follows:
- The Students Service extends the Abstract EJB with the findAll() method to get the necessary data along with the findByEmailId() method for the login purpose.
- The Instructor Service extends the Abstract EJB with the findAll() method to get the necessary data along with the findByEmailId() method for the login purpose.
- The Teaching Assistant Service extends the Abstract EJB with the findAll() method to get the necessary data along with the findByEmailId() method for the login purpose.
- The Course Service extends the Abstract EJB with the findAll() method to get the necessary data along with methods to add courses to students.
- The Assignment Service extends the Abstract EJB with findAll() to get the required data and other methods to add, update, and remove the assignment.
- The User and Group service with findAll() methods to find the necessary data which matches with the emailId.



4. The application consists of various Controllers such as -
- The StudentController, InstructorController, StudentAssignmentController, InstructorAssignmentController, and TaCourseController classes which have the postconstruct and initialization methods to initialize their values for the front-end of the application and get the required data from the EJB classes.
- The InstructorConverter class to select a single value from the dropdown that we call on the JSF page.
- The Login Controller to manage the login and logout operations.


5. The Web Pages folder consists of the XHTML files for the instructor, teaching assistant, and student. These XHTML pages are linked with the init() method of the controllers to perform the actions like view, edit, delete. The login and error XHTML files are also included.



## Requirements

Installation:

- Download the latest OpenJDK 11 from https://adoptopenjdk.net/, and set the JAVA_HOME environment variable to the JDK path.
- Download Apache NetBeans 11.2 from https://netbeans.apache.org/download/index.html.
- Download the Payara Server 194, which is compatible with Jakarta EE 8 from https://www.payara.fish/software/downloads/ add it to the NetBeans as a server.
- Download the MySQL Workbench 

Database:

- Create a new MySQL database schema named itmd4515
- Then create a username as itmd4515 and set password also as itmd4515
- For the itmd4515 schema apply all the Schema Privileges from the Management tab

Compile and Runtime:

- Unzip the file ‘mvaity-fp.zip’ using the zip file manager
- Now select File → Open Project on NetBeans, and select my project file from the desired location
- Now right click on the project and select Run. Also start the MySQL server for my project to get the tables
- You can see the output in the payara server, and the application opens up on the default browser that you have set in NetBeans.

Test Scripts:

1.Login as Instructor – Email ID: sspyrison@hawk.iit.edu            Password: Spyrison123

After login as the instructor, go to the instructor tab on the navbar to reach the instructor section having student details. Click on the ‘Add Students’ button present beside each student record to select assignments for students. The assignments of the course taken by that student will be displayed which can be viewed, edited, and removed.



2. Login as Teaching Assistant – Email ID: rgeller@hawk.iit.edu            Password: Ross123

After login as a teaching assistant, go to the teaching assistant tab on the navbar to see student details in a tabular form. Click on Add course for students link which will land you to a form for adding the students to a particular course.



3.Log in as Student – Email ID: mvaity@hawk.iit.edu          Password: Minal123

After login as a student, go to the student tab on the navbar to see all the courses available to select. On clicking on one of the ‘course’ buttons, you will then see assignments of that course which the student can view and edit.


## Screenshots

Login page for all users

! [] (images/LoginPage.png)

