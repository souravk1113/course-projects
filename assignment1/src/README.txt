this is a short decription of how i have solved the problem and implementedted what was required.

class list<T> implements linked list and class Itr implements the iterator for this linked list. this two classes are present in   testingitr.java;
class node implements the interface the Positions_<T> and object of this type is the building block of linked list.
class entity implements interface and the classes course, Dept, and Hostel inherit this class entity. thus obj of all these entity classes contain name and  the list of all students in present in that entity and an iterator for this list.
class coursegrade implements the interfaces CourseGrade_,GradeInfo_ and its object represents a course taken by a students and contains the lettergrade obtained by the student in that particular course andd also contains the courssename and titile.
class students implements interface Student_ and its object is a represnetation of a student. it contains information such as the student's entry no. its hostel , its completed credits and the list of all courses and the respective grades in each . taken by the student.
finally the the class assignment 1 contains the main method, getData and answer queries method and it contains various 
static File object which helps to read the files in the different methods, its also constains the method 
size which calculates the number of lines(linecount) in the third file which then helps to determine the size of the array
which would help print the answer in the reverse format. it also contains the method sortlexo and sortlexo2 which help to
sort some of the result of queries lexographically as required by the problem.
it also has 4 static linked list namely allhostels , alldept,allcourses and all students. allhostels is the list of objects of class  Hostel and each linked list element of allhostels contains the linked list of all students present in that particular hostel. same goes for alldept and allcourses. allstudents is the linked list of objects of type student.
the first two files are read in the getData and the contents of all linked lists are updated accordingly using iterators to iterate through them .
in anserqueries() each line of file is read and is split and stored in a string array , the first word in the array is the query and  based on this the lists are searched and 
the the required result is sorted lexographically( if required) and stored in an String[] array to display the output in reverse afterwards. 
 