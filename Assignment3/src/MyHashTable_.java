import java.lang.Math;
class NotFoundException extends Exception {
	NotFoundException(String s){super(s);}
} 
public interface MyHashTable_<K, T> { 
   // Insert new object with given key 
   public int insert(K key, T obj); 
 
   // Update object for given key 
   public int update(K key, T obj); 
 
   // Delete object for given key 
   public int delete(K key); 
 
   // Does an object with this key exist? 
   public boolean contains(K key); 
 
   // Return the object with given key 
   public T get(K key) throws NotFoundException; 
 
   // ”Address” of object with given key (explained below) 
   public String address(K key) throws NotFoundException; 
}
class doublehash<K,T> implements MyHashTable_<K,T>{
	int hashtablesize;
	int currentsize;
	pair<K,T>[] hashtable;
	doublehash(int tablesize){
		hashtablesize=tablesize;
		hashtable=new pair[tablesize];
		currentsize=0;
		
	}	

	public static long sdbm(String str, int hashtableSize) { 
	    long hash = 0; 
	    for (int i = 0; i < str.length(); i++) { 
	        hash = str.charAt(i) + (hash << 6) + (hash << 16) - hash; 
	    } 
	    return Math.abs(hash) % (hashtableSize - 1) + 1; 
	}
	public static long djb2(String str, int hashtableSize) { 
	    long hash = 5381; 
	    for (int i = 0; i < str.length(); i++) { 
	        hash = ((hash << 5) + hash) + str.charAt(i); 
	    } 
	    return Math.abs(hash) % hashtableSize; 
	}
	
		
	public int insert(K key,T obj) {
		int i=0;
		if(contains(key)) {
			return -1;
		}
		if(currentsize>=hashtablesize) {
			return -1;
			
		}
	long index=djb2(key.toString(),hashtablesize);
	
	if(hashtable[(int)index]==null) {
		
		pair<K,T> p=new pair<K,T>(key,obj);
	hashtable[(int)index]=p;
	hashtable[(int)index].status=true;
			i++;
			currentsize++;
			return i;
			
		
	}
	else if(hashtable[(int)index].status==false) {
		
		pair<K,T> p=new pair<K,T>(key,obj);
	hashtable[(int)index]=p;
	hashtable[(int)index].status=true;
			i++;
			currentsize++;
			return i;
			
	}
	
	else  {
	
		long index2=sdbm(key.toString(),hashtablesize);
			boolean var=false;
			
			while(!var) {
				
				long newindex=(index+i*index2)%hashtablesize;
				if (hashtable[(int) newindex]==null) {
					
					hashtable[(int)newindex]=new pair<K,T>(key,obj);
					hashtable[(int)newindex].status=true;
					currentsize++;
					var=true;
				}
				i++;
			}
		}

	
	return (i);
	}
	public int update(K key, T obj) {
		
		int i=0;
		long index=djb2(key.toString(),hashtablesize);
		if(hashtable[(int) index].getkey().toString().equals(key.toString())){
			hashtable[(int)index].value=obj;
			hashtable[(int)index].key=key;
			i++;
			
		}
		else if (hashtable[(int) index]!=null) {
			long index2=sdbm(key.toString(),hashtablesize);
				boolean var=false;
				
				while(!var) {
					long newindex=(index+i*index2)%hashtablesize;
					if (hashtable[(int) newindex].getkey().toString().equals(key.toString()) ){
						hashtable[(int) newindex].value=obj;
						hashtable[(int) newindex].key=key;
						var=true;
					}
					else if(hashtable[(int) newindex]==null) {
						
						break;
					}
					i++;
				}
			}
		
		else {
		
		}
		return (i);
	}
	public boolean contains(K key) {
		int i=1;
		boolean var=false;
		long index=djb2(key.toString(),hashtablesize);
		
		if(hashtable[(int)index]==null) {
			
			return false;
		}
		else if((hashtable[(int) index].getkey().toString().equals(key.toString()))&&hashtable[(int)index].status) {
			return true;
		}
		else if((hashtable[(int) index].getkey().toString().equals(key.toString()))&&hashtable[(int)index].status==false) {
			
			return false;
		}
		else if (hashtable[(int) index]!=null) {
			long index2=sdbm(key.toString(),hashtablesize);
				
				
				while(!var) {
					long newindex=(index+i*index2)%hashtablesize;
					if(hashtable[(int)newindex]==null) {
						
						return false;}
					else if (hashtable[(int) newindex].getkey().toString().equals(key.toString())&&hashtable[(int)newindex].status) {
						var=true;
						return true;
					}
					else if(hashtable[(int) newindex].getkey().toString().equals(key.toString())&&hashtable[(int)newindex].status==false) {
						return false;
					}
					
					i++;
				}
			}
		else {
			return false;
		
		}
		return var;
		
	}
	public int delete(K key)   {
		int i=0;
		boolean var=false;

		long index=djb2(key.toString(),hashtablesize);
		if(hashtable[(int) index].getkey().toString().equals(key.toString())){
			i++;
			hashtable[(int)index].status=false;
			currentsize--;
			return i;
		}
		else if (hashtable[(int) index]!=null) {
			long index2=sdbm(key.toString(),hashtablesize);
				
				
				while(!var) {
					long newindex=(index+i*index2)%hashtablesize;
					if (hashtable[(int) newindex].getkey().toString().equals(key.toString())) {
						hashtable[(int) newindex].status=false;
						currentsize--;
						var=true;
						
					}
					else if(hashtable[(int)newindex]==null){
					
						break;
					}
						
					i++;
				}
			}
		else {
			
		}
		return i;
		
	}
	public T get(K key)throws NotFoundException {
		int i=1;
		boolean var=false;
		long index=djb2(key.toString(),hashtablesize);
		if(hashtable[(int)index]==null) {
			NotFoundException x=new NotFoundException("E");
			throw x;
			
			
		}
		else if(hashtable[(int)index].getkey().toString().equals(key.toString()) &&hashtable[(int)index].status) {
			return hashtable[(int)index].getvalue();
			}
		else if(hashtable[(int)index].getkey().toString().equals(key.toString()) &&hashtable[(int)index].status==false) {
			NotFoundException x=new NotFoundException("E");
			throw x;
			
		}
		
		else  {
			long index2=sdbm(key.toString(),hashtablesize);
				
				
				while(!var) {
					long newindex=(index+i*index2)%hashtablesize;
					 if(hashtable[(int)newindex]==null) {
						NotFoundException x=new NotFoundException("E");
								throw x;
						
					}
					 else if (hashtable[(int) newindex].getkey().toString().equals(key.toString())&&hashtable[(int)newindex].status) {
						return hashtable[(int)newindex].getvalue();
					}
					else if(hashtable[(int)index].getkey().toString().equals(key.toString()) &&hashtable[(int)newindex].status==false) {
						NotFoundException x=new NotFoundException("E");
						throw x;
					}
					
					i++;
				}
			}
		 
		
		return null;
	}
	public String address(K key)throws NotFoundException{
		int i=1;
		boolean var=false;
		long index=djb2(key.toString(),hashtablesize);
		if(hashtable[(int)index]==null) {
			NotFoundException x=new NotFoundException("E");
			throw x;
		}
		else if((hashtable[(int) index].getkey().toString().equals(key.toString()))&&hashtable[(int)index].status) {
			
			return Long.toString(index);
		}
		else if((hashtable[(int) index].getkey().toString().equals(key.toString()))&&hashtable[(int)index].status==false) {
			NotFoundException x=new NotFoundException("E");
			throw x;
		}
		else  {
			long index2=sdbm(key.toString(),hashtablesize);
				
				
				while(!var) {
					long newindex=(index+i*index2)%hashtablesize;
				 if(hashtable[(int)newindex]==null) {
						NotFoundException x=new NotFoundException("E");
						throw x;
				
					}
					else if (hashtable[(int) newindex].getkey().toString().equals(key.toString()) && hashtable[(int)newindex].status) {
						var=true;
						return Long.toString(newindex);
					}
					else if(hashtable[(int) newindex].getkey().toString().equals(key.toString()) && hashtable[(int)newindex].status==false) {
						NotFoundException x=new NotFoundException("E");
						throw x;
				
					}
					i++;
				}
			}
	
		return null;
	
	}
	
	

	}

