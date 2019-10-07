public interface CourseGrade_ {		// Tuple of course and grade
   public String coursetitle();   	 // Returns course title 
   public String coursenum();   	 // Returns course code, e.g., COL106 
   public GradeInfo_ grade();   	 // Returns student's letter grade
}
class coursegrade implements CourseGrade_ ,GradeInfo_{
	String coursetitle;
	String coursecode;
	String lettergrade;
	LetterGrade lg;
	
	 
	
	public String coursetitle() {
		return coursetitle;
	}
	public String coursenum() {
		return coursecode;
	}
	public grades grade() {
		return new grades();
	}
	
}