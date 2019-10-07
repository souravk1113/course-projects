import java.util.Iterator;
public interface Entity_ { // Entities Classes Hostel, Dept, and Course all have this functionality. 
   public String name();                 // Returns this  entity's name
   public Iterator<Student_> studentList();        // Returns all students of this entity
}
class entity implements Entity_{
	String name;
	list<stu> stud=new list<stu> ();
	public String name() {
		return name;
	}
	public Iterator<Student_> studentList(){
		return null;
	}
}