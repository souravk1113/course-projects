class node<K,T>{
	node<K,T> left;
	node<K,T> right;
	T data;
	K key;
	node(K key,T data){
		this.key=key;
		this.data=data;
		left=null;
		right=null;
	}
	
}
class bst<K extends Comparable<K>,T>   {
	static int insertcounter=0;
	static int deletecounter=0;
	static int updatecounter=0;
	static String address="";
	node<K,T> root;
	bst(){
		root=null;
	}
	
	int insert(K key,node<K, T> new_node) {
		//System.out.println(key.toString());
		insertcounter=0;
		
		root=inserthelp(root,key,new_node);
		return insertcounter;		
	}
	node<K,T> inserthelp(node<K,T> root,K key, node<K,T> new_node ) {
	
		
		if(root==null) {
			insertcounter++;
			root=new_node;
		}
		
		else if(key.compareTo(root.key)>0) {
			insertcounter++;
			root.right=inserthelp(root.right,key,new_node);
		}
		else if(key.compareTo(root.key)<0) {
			insertcounter++;
			root.left=inserthelp(root.left,key,new_node);
		}
		return root;
	}
	node<K,T> minimum(node<K,T> root){
		node<K,T> min=root;
		while(root.left!=null) {
			//deletecounter++;
			min=root.left;
			root=root.left;
		}
		//deletecounter++;
		return min;
	}
	node<K,T> deletehelp(node<K,T> root,K key){
		deletecounter++;
		if(root==null) {
			return null;
		}
		else if(key.compareTo(root.key)<0) {
			
			root.left=deletehelp(root.left,key);
			
		}
		else if(key.compareTo(root.key)>0) {
			
			root.right=deletehelp(root.right,key);
		}
		else {
			if(root.right==null&&root.left==null) {
				
				return null;
			}
			
		else if(root.left==null) {
				deletecounter++;
				return root.right;
			}
			else if(root.right==null) {
				deletecounter++;
				return root.left;
			}
			else {
				
				node<K,T> min=minimum(root.right);
				
				root.key=min.key;
				root.data=min.data;
				root.right=deletehelp(root.right,min.key);
			}
			
		}
		return root;
	}
	int delete(K key) {
		deletecounter=0;
		root=deletehelp(root,key);
		return deletecounter;
	}
	int update(K key,node<K, T> new_node) {
		updatecounter=0;
		root=updatehelp(root,key, new_node);
		return updatecounter++;
	}
	node<K,T> updatehelp(node<K,T> root,K key,node<K,T> new_node){
		if (root.key.compareTo(key)==0){
			updatecounter++;
			root.key=key;
			root.data=new_node.data;
			return root;
		}
		else if (key.compareTo(root.key)>0) {
			updatecounter++;
			root.right=updatehelp(root.right,key,new_node);
		}
		else {
			updatecounter++;
			root.left=updatehelp(root.left,key,new_node);
		}
		return root;
		
	}
	boolean contains(K key) {
		return containshelp(root,key);
	}
	boolean containshelp(node<K,T> root,K key) {
		if(root==null) {
			return false;
		}
		if (root.key.compareTo(key)==0){
			
			return true;
		}
		else if (key.compareTo(root.key)>0) {
	
			return containshelp(root.right,key);
		}
		else {
			
			return containshelp(root.left,key);
		}
		
		
	}
	T get(K key) {
		return gethelp(root,key).data;
	}
	node<K,T> gethelp(node<K,T> root,K key) {
		if(root==null) {
			return root;
		}
		if (root.key.compareTo(key)==0){
			
			return root;
		}
		else if (key.compareTo(root.key)>0) {
	
			return gethelp(root.right,key);
		}
		else {
			
			return gethelp(root.left,key);
		}
		
	}
	String address(K key) {
		address="";
		if(contains(key)) {
			
			addresshelp(root,key);
			return address;
		}
		else {
			return "E";
		}
	}
	node<K,T> addresshelp(node<K,T> root,K key) {
		if(root==null) {
			return null;
		}
		if (root.key.compareTo(key)==0){
			return null;
			
		}
		else if (key.compareTo(root.key)>0) {
			address=address+"R";
			return addresshelp(root.right,key);
			
		}
		else {
			address=address+"L";
			return addresshelp(root.left,key);
			
			
		}
	}

}
