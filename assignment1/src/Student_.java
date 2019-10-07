import java.util.Iterator;
public interface Student_ {
   public String name();               	// Returns student's name
   public String entryNo();            	// Returns student's entry number
   public String hostel();             	// Returns student's hostel name
   public String department();         	// Returns student's department name
   public String completedCredits();   	// Returns student's credits earned
   public String cgpa();   		// Returns student's cgpa until the previous semester
   public Iterator<CourseGrade_> courseList();// Returns an iterator for all courses for this student
					      // including those in the current semester	
}
class stu implements Student_{
	String name;
	String entryno;
	String hostel;
	String department;
	String completedcredits;
	String cgpa;
	String entity;
	grades g;
	list<coursegrade> courseinfo=new list<coursegrade>() ;
	public String name() {
		return name;
	}
	public String entryNo() {
		return entryno;
	}
	public String hostel(){
		return hostel;
	}
	public String department() {
		return department;
	}
	public String completedCredits() {
		return completedcredits;
	}
	public String cgpa() {
		double credits=0;
		double zero=0;
		double d=0;
		double earnedpoints=0;
		Itr<coursegrade> it=courseinfo.positions();
		while(it.curr!=null) {
			if(!it.curr.value().lettergrade.equals("I")) {
				credits=credits+3;
			}
			
			earnedpoints=earnedpoints + 3*(GradeInfo_.gradepoint(it.curr.value().lg));
			it.next();
		}
		if( credits!=zero) {
		d=(earnedpoints/credits);}
		
		completedcredits=Double.toString(credits);
		return String.format("%.2f", d);
		
	}
	public Iterator<CourseGrade_> courseList(){
		
		return null;
	}
	
	
	
}