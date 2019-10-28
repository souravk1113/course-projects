public interface Student_ { 
   public String fname();      // Return student’s first name 
   public String lname();      // Return student’s last name 
   public String hostel();     // Return student’s hostel name 
   public String department(); // Return student’s department name 
   public String cgpa();       // Return student’s cgpa 
}
class student implements Student_{
	String fname;
	String lname;
	String hostel;
	//K key;
	String department;
	String cgpa;
	student(String fname,String lname,String hostel,String department,String cgpa){
		this.fname=fname;
		this.lname=lname;
		this.hostel=hostel;
		this.department=department;
		this.cgpa=cgpa;
		
	}
	public String fname() {
		return fname;
		}
	public String key() {
		return fname+lname;
	}
	public String lname() {
		return lname;
	}
	public String hostel() {
		return hostel;
	}
	public String cgpa() {
		return cgpa;
	}
	public String department() {
		return department;
	}
	String display() {
		return fname+" "+lname+" "+hostel+" "+department+" "+cgpa+" ";
	}
}