
public class node<T> implements Position_<T>{
		T data;
		node<T> next;
		node(T d){
			this.data=d;
			this.next=null;
		}
	
	public T value(){
		return data;
	}
	public node<T> after(){
		return next;
	}
	}
	