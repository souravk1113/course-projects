import java.io.*;
public class assignment3{
	public static void main(String args[])throws IOException {
		int size=Integer.parseInt(args[0]);
		File f1=new File(args[2]);
		FileReader fr=new FileReader(f1);
		BufferedReader br=new BufferedReader(fr);
		String s=br.readLine();
		String[] words=null;
	
		if (args[1].equals("SCBST")){
			
			separ_hash<pair<String,String>,student> dh=new separ_hash<pair<String,String>,student>(size);
			while(s!=null) {
				//System.out.println(s);
				words=s.split(" ");
				if(words[0].equals("insert")) {
					student obj=new student(words[1],words[2],words[3],words[4],words[5]);
					pair<String,String> key=new pair<String,String>(words[1],words[2]);
					if(!dh.contains(key)) {
						
					System.out.println(dh.insert(key, obj));
					}
					else {
						System.out.println("E");
					}
					
				}
				if(words[0].equals("delete")) {
					pair<String,String> key=new pair<String,String>(words[1],words[2]);
					if(dh.contains(key)) {
					System.out.println(dh.delete(key));
					}
					else {
						System.out.println("E");
					}
				}
				if(words[0].equals("update")) {
					student obj=new student(words[1],words[2],words[3],words[4],words[5]);
					pair<String,String> key=new pair<String,String>(words[1],words[2]);
					if(dh.contains(key)) {
					System.out.println(dh.update(key, obj));
					}
					else {
						System.out.println("E");
					}
				}
				if (words[0].equals("contains")){
					pair<String,String> key=new pair<String,String>(words[1],words[2]);
					if(dh.contains(key)) {
						System.out.println("T");
					}
					else {
						System.out.println("F");
					}
				}
				if (words[0].equals("get")){
					pair<String,String> key=new pair<String,String>(words[1],words[2]);
					try {
						System.out.println(dh.get(key).display());
					}
					catch(NotFoundException e) {
						System.out.println(e.getMessage());
					}
				}
					if(words[0].equals("address")) {
						pair<String,String> key=new pair<String,String>(words[1],words[2]);
						try {
							System.out.println(dh.address(key));
						}
						catch(Exception e) {
							System.out.println(e.getMessage());
						}
						
					}
					s=br.readLine();
				}
			
			br.close();
			
		}
		if (args[1].equals("DH")){
			doublehash<pair<String,String>,student> dh=new doublehash<pair<String,String>,student>(size);
			while(s!=null) {
				//System.out.println(s);
				words=s.split(" ");
				if(words[0].equals("insert")) {
					
					student obj=new student(words[1],words[2],words[3],words[4],words[5]);
					pair<String,String> key=new pair<String,String>(words[1],words[2]);
					int c=dh.insert(key, obj);
					if (c>=0) {
					
					System.out.println(c);
					}
					else {
						System.out.println("E");
					}
					
				}
				if(words[0].equals("delete")) {
					pair<String,String> key=new pair<String,String>(words[1],words[2]);
					if(dh.contains(key)) {
					
					System.out.println(dh.delete(key));
				}
					else {
						System.out.println("E");
					}
					}
				if(words[0].equals("update")) {
					student obj=new student(words[1],words[2],words[3],words[4],words[5]);
					pair<String,String> key=new pair<String,String>(words[1],words[2]);
					if(dh.contains(key)) {
					System.out.println(dh.update(key, obj));
				}else {
					System.out.println("E");
				}
					}
				if (words[0].equals("contains")){
					pair<String,String> key=new pair<String,String>(words[1],words[2]);
					if(dh.contains(key)) {
						System.out.println("T");
					}
					else {
						System.out.println("F");
					}
					
				}
				if (words[0].equals("get")){
					pair<String,String> key=new pair<String,String>(words[1],words[2]);
					try {
						System.out.println(dh.get(key).display());
					}
					catch(NotFoundException e) {
						System.out.println(e.getMessage());
					}
				}
					if(words[0].equals("address")) {
						pair<String,String> key=new pair<String,String>(words[1],words[2]);
						try {
							System.out.println(dh.address(key));
						}
						catch(Exception e) {
							System.out.println(e.getMessage());
						}
						
					}
					s=br.readLine();
				}
			
			br.close();
			
		}
	}
}
