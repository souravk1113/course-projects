import java.util.Iterator;


                     // Returns the number of elements in the list
class list<T> implements LinkedList_<T>{
	
	
	
	node<T> start=null;
	node<T> currnode=null;
	node<T> last;
	public Position_<T> add(T e){
		node<T> new_node=new node<T>(e);
		if (start==null){
			start=new_node;
			return start;
		}
		
		else{
			last=start;
			while (last.next!=null){
				last=last.next;

			}
		last.next=new_node;
		return last.next;
		}
	 

	}
	public int count(){
		int c=0;
		node<T> count=start;
		while (count!=null){
			c++;
			count=count.next;
		}
		return c;
	}
	
	public Itr<T>  positions(){
		return new Itr<T>(start);
	}
	
	
	}
class Itr<T> implements Iterator<Position_<T>>{
	node<T> curr=null;
	Itr(node<T> first){
		curr=first;
	}
	public boolean hasNext(){
		if (curr==null){return false;
		}
		
		return (curr.after()!=null);
	}

	public node<T> next() throws NullPointerException{
		curr=curr.after();
		return curr;
	}
	public void remove() {
	}
}
	


			
		
