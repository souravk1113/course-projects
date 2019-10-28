import java.lang.Math;
class separ_hash<K extends Comparable<K>,T> implements MyHashTable_<K,T>{
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
	int hashtablesize;
	bst<K,T>[] hashtable;
	separ_hash(int tablesize){
		hashtablesize=tablesize;
		hashtable=new bst[tablesize];
		for(int i=0;i<tablesize;i++) {
		hashtable[i]=new bst<K,T>();}
	}	
	

	@Override
	public int insert(K key, T obj) {
		long index=djb2(key.toString(),hashtablesize);
		node<K,T> new_node=new node<K,T>(key,obj);
		return hashtable[(int)index].insert(key, new_node);
		
		
		
	}

	@Override
	public int update(K key, T obj) {
		long index=djb2(key.toString(),hashtablesize);
		node<K,T> new_node=new node<K,T>(key,obj);
		return hashtable[(int)index].update(key,new_node);
		
	}

	@Override
	public int delete(K key) {
		long index=djb2(key.toString(),hashtablesize);
		
		return hashtable[(int)index].delete(key);
	
	}
	@Override
	public boolean contains(K key) {
		long index=djb2(key.toString(),hashtablesize);
		return hashtable[(int)index].contains(key);
	}

	@Override
	public T get(K key) throws NotFoundException {
		long index=djb2(key.toString(),hashtablesize);
		if( !hashtable[(int)index].contains(key)) {
			NotFoundException x=new NotFoundException("E");
			throw x;
		}
		else {
			return hashtable[(int)index].get(key);
		}
	}

	@Override
	public String address(K key) throws NotFoundException {
		long index=djb2(key.toString(),hashtablesize);
		if( !hashtable[(int)index].contains(key)) {
			NotFoundException x=new NotFoundException("E");
			throw x;
		}
		else if (hashtable[(int)index].contains(key)){
			return Long.toString(index)+"-"+ hashtable[(int)index].address(key);
		}
		else {
			return "E";
		}
	}
	
}