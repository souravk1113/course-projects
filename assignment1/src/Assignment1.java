import java.io.*;


public class Assignment1{
	static list<Hostel> allhostels=new list<Hostel>();
	static list<Dept> alldept=new list<Dept>();
	static list<course> allcourses=new list<course>();
	static list<stu> allstudents=new list<stu>();
	static File f1;
	static File f2;
	static FileReader fr2;
	static FileReader fr;
	static File f3;
	static File f4;
	static FileReader fr3;
	static FileReader fr4;
	static String str="";
	static String info="";
	static int linecount;
	static String[] queryresult;
	static String part1="";
	public static void main(String args[]) throws IOException  {
	 f1= new File(args[0]);
	fr=new FileReader(f1);
	f2=new File(args[1]);
	f3=new File(args[2]);
	f4=new File(args[2]);
	fr3=new FileReader(f3);
	fr2=new FileReader(f2);
	fr4=new FileReader(f4);
	size();
	getData();
	answerqueries();
	
	}
	private static void getData() throws IOException{
		
		String[] words=null;
		BufferedReader br = new BufferedReader(fr);
		String s=br.readLine();
		BufferedReader br2 =new BufferedReader(fr2);
		String s2=br2.readLine();
		while(s!=null) {
			words=s.split(" ");
			stu obj=new stu();
		    obj.entryno=words[0];
			obj.name=words[1];
			obj.department=words[2];
			obj.hostel=words[3];
			Hostel e=new Hostel();
			allstudents.add(obj);
			e.name=words[3];
			int c=0;
			Itr<Hostel> it=allhostels.positions();
			while (it.curr!=null){
				String oj=it.curr.value().name();
				if (oj.equals(e.name)) {
					it.curr.value().stud.add(obj);
					c=c+1;
				}
				it.next();
			}
			if(c==0) {
				e.stud.add(obj);
				allhostels.add(e);	
			}
			Dept d=new Dept();
			d.name=words[2];
			c=0;
			Itr<Dept> itd=alldept.positions();
			while (itd.curr!=null) {
				if (itd.curr.value().name().equals(d.name)) {
					itd.curr.value().stud.add(obj);
					c=c+1;
				}
				itd.next();
			}
			if(c==0) {
				d.stud.add(obj);
				alldept.add(d);	
			}
			s=br.readLine();	
		}
		
		br.close();
		while (s2!=null) {
		
			words=s2.split(" ");
			course obj3=new course();
			stu obj2=new stu();
			obj2.entryno=words[0];
			
			coursegrade cg=new coursegrade();
			obj3.coursecode=words[1];
			cg.coursecode=words[1];
			cg.lettergrade=words[2];
			
			cg.coursetitle=words[3];
			for(int i=4;i<words.length;i++) {
				cg.coursetitle+=words[i];
				cg.coursetitle+=" ";		
			}
			cg.coursetitle.trim();
			obj3.name=cg.coursetitle;
		GradeInfo_.LetterGrade lg=GradeInfo_.LetterGrade.valueOf(words[2]);
		cg.lg=lg;
			Itr<course> ic=allcourses.positions();
			int c=0;
			while(ic.curr!=null) {
	
				if(ic.curr.value().coursecode().equals(obj3.coursecode())) {
					ic.curr.value().stud.add(obj2);
					c=c+1;
				}
				ic.next();
			}
				if(c==0) {
					obj3.stud.add(obj2);
					allcourses.add(obj3);
					
				}
			Itr<stu> its=allstudents.positions();
			while(its.curr!=null) {
				if(its.curr.value().entryNo().equals(words[0])) {
	
					its.curr.value().courseinfo.add(cg);
				}
				its.next();
			}
				
			s2=br2.readLine();
		}
		
		br2.close();
}
	private static void answerqueries() throws IOException {
		
		int counter=0;
		String[] words=null;
		BufferedReader br=new BufferedReader(fr3);
		String s=br.readLine();
		while(s!=null) {
			
			words=s.split(" ");
			if (words[0].equals("SHARE")){
				str="";
				Itr<stu> it=allstudents.positions();
				Itr<course> ic=allcourses.positions();
				while(it.curr!=null) {
					 
					
					if((it.curr.value().hostel.equals(words[2]))){
						if(!it.curr.value().entryno.equals(words[1])) {
						str+=it.curr.value().entryno+" ";
							
					}
					}
						if( (it.curr.value().department.equals(words[2]))){
							if(!it.curr.value().entryno.equals(words[1])) {
								str+=it.curr.value().entryno+" ";
									
							}
						}
						
					
					it.next();
				}
				

				
					while(ic.curr!=null){
						if(ic.curr.value().coursecode().equals(words[2])) {
							
							Itr<stu> i=ic.curr.value().stud.positions();
							while(i.curr!=null) {
								if(!i.curr.value().entryno.equals(words[1])) {
									str+=i.curr.value().entryno +" ";
								}
								
								i.next();
							}
							
						
				}
				ic.next();
			}
					queryresult[counter]=sortlexo();
		}
			if(words[0].equals("COURSETITLE")) {
				Itr<course> c=allcourses.positions();
				while(c.curr!=null) {
					if(c.curr.value().coursecode.equals(words[1])) {
						queryresult[counter]=c.curr.value().name();
						
					}
					c.next();
				}
			}
			if(words[0].equals("INFO")){
				Itr<stu> is=allstudents.positions();
				while(is.curr!=null) {
					if(is.curr.value().entryno.equals(words[1])) {
						
						Itr<coursegrade> itc=is.curr.value().courseinfo.positions();
						 part1=is.curr.value().entryno+" "+ is.curr.value().name+" "+ is.curr.value().department+" "+ is.curr.value().hostel+" " +is.curr.value().cgpa()+" ";
						while(itc.curr!=null) {
							info+=itc.curr.value().coursecode+" "+itc.curr.value().lettergrade+",";
							itc.next();
						}
					}
					is.next();
				}
				queryresult[counter]=part1+sortlexo2();
				
				
			}
			counter++;
			s=br.readLine();
			}
		br.close();
		for(int i=linecount-1;i>=0;i--) {
			
			System.out.println(queryresult[i]);
		}
	}
	public static String sortlexo() {
		String words[];
		words=str.split(" ");
		String s2="";
		int l=words.length;
		for(int i=0;i<l;i++) {
			for (int j=i+1;j<l;j++) {
				if(words[i].compareTo(words[j])>0) {
					String temp=words[i];
					words[i]=words[j];
					words[j]=temp;
				}
			}
		}
		for(int i=0;i<l;i++) {
			 s2+=words[i]+" ";
		}
		
		return s2.trim();
	}
	public static String sortlexo2() {
		String words[];
		words=info.split(",");
		String s2="";
		int l=words.length;
		for(int i=0;i<l;i++) {
			for (int j=i+1;j<l;j++) {
				if(words[i].compareTo(words[j])>0) {
					String temp=words[i];
					words[i]=words[j];
					words[j]=temp;
				}
			}
		}
		for(int i=0;i<l;i++) {
			 s2+=words[i]+" ";
		}
		
		return s2.trim();
	}
	public static void size() throws IOException {
		BufferedReader br9=new BufferedReader(fr4);
		String s=br9.readLine();
		while(s!=null) {
			linecount++;
			s=br9.readLine();
			
		}
		 br9.close();
		
			 queryresult=new String[linecount];
	
		
	}
}
		
		
		
		
		
		
	
		
	
	
