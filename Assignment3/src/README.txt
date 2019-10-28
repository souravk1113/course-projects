This is how i have implemented the two hashing approaches:
1.MyHashTable_.java//contains the implementation of double hashing approach
	class present: 1.doublehash//implements the interface MyHashTable
						variables present:
							a.hashtablesize//type int and stores the hash table size
							b.currentsize//type int and store the current number  of entries in the table that is =no. of insert operations-no.of delete operations
							c.hashtable//array of type pair<string,student>: this is the hashtable on which all operations are performed.
							
						methods present:
							a.insert(K key,T student)
								variables present: i//type int and stores the number of steps in insertion.
							//inserts a key(pair<String,String> object(student) to the hashtable.
									//it first generates an index using hash function h1(djb2) based on the concatenation of first+last name of the student, if it no entry is present at the calculated index or 
									the entry present at that index was deleted
									  then it inserts it at the given index otherwise it generates a new index(index=h1+i*h2, where i=0,1,2..) using hash function h2(sdbm).this process of
									   generating a new index is continued
									   until a null position or a deleted position is found in the hash table.
									 // it does not insert if hashtable is full i.e currentsize=hashtablesize
									 //TIME COMPLEXITY:
									 		best case:O(1)// when no collision occurs.
									 		worst case:O(n)// when hashtable is almost full and collision occurs almost every time  and we need to probe over all n elements
									 		average case:O(1).
									 		
							b.delete(K key)
							 	variable present:i//type int and stores the number of steps in deletion.
							 	//deletes an entry from the hashtable when an objext with the given key is found.
							 	//calculates an index based on key and matches the with key of the element present at the index
							 	when a match is found it changes the status of that pair object in hashtable to false and thus marks it as deleted.
							 	//prints E when the object to be deleted is not present or is already deleted.
							 	//TIME COMPLEXITY:
							 			best case:O(1)//when object to be deleted is found at the very first index that is calculated.
						  				worst case:O(n)//when we need to probe through all the elements and then the object to be deleted is found
						  				avg case:O(1)
						  				
						  	c.update(K key,T obj)// find the object with the given key in hashtable and repaces it with the given obj.
						  		variable present:i//type int and stores the number of steps in updation.
						  		//works in the same way as delete i.e continues to probe until the object with the given key is found and then replaces with new pair<key,object>(). 
						  		Time compelexity:
						  			a.best case:O(1)//when th entry to be updates is present at the very first index that is calculated.
						  			b.worst case:O(n)//when we need to probe through almost all elements to find the entry to be updated 
						  			c.avg case:O(1);
						  		// prints E when object is not present
						  	d.contains(K key)://returns false if objext is presnt else returns false
						  		variable present: i//type int and used to rehash
						  		//works in the same way as delete,update i.e continues to generate new index until a match is found , then updates
						  		the entry at that position.
						  		Time Complexity:
						  			a.best case:O(1)//when object to be searched is present at the very first index that is generated.
						  			b.worst case:O(n)//when we need to generate new index almost everytime .
						  			c.averge case:O(1)
						  	e.get(K key)//returns the student object with the given key to the driver class and the driver class 
						  		displays all informtion about the student.
						  		//works similar to contains.
						  		//prints E when object is not present.
						  		variable present:int i: to generate new indexes.
						  		
						  		Time complexity:
						  		a.best case:O(1)//when the match is found at the very first index that is calculated.
						  		b.worst case:O(n)//when we need to rehash almost every time and thus probe through all elements
						  		c.avg case:O(1).
						  	f. address(K key)// returns the index where the obejct with the given key is present .
						  			variable present :i //type int and used to rehash.
						  			//works in the same way as contains.
						  			//"E" is printed when object is not present.
						 			Time complexity:
						 				a.best case:O(1)//when the match is found at the very first index that is calculated.
						 				b.worst case:O(n)//when we need to rehash almost every time and thus probe through all elements
						 				c.avg case:O(1).
						 				
					
					
2.bst.java//contains the implementation of binary search tree.
	class present:bst<K extends comparable<K>,T>
		variables present:a.static int insertcounter//stores number of nodes touched while inserting
						 b.static int updatecounter//stores the number of  nodes touched while updating
						 c.static int deletecounter//stores the number of nodes touched touched while deleting
						 d.static String address// stores the address of a node when required
						 e.node<K,T> root// represents the root of the tree.
		methods present:
			(all comparison between nodes are done on the basis of the first name of the student)
				a.insert(K key,node<K,T> new_node)//calls the recursive function inserthelp 
				b.node<K,T> insert(node<K,T> root,K key, node<K,T> new_node)// this is a recursive helper function
					which takes a root reference and compares the key of the root with the key of the given node to 
					be inserted. if it the key of the node to be inserted is greater then the root key it calls recursive inserthelp on the right of the present 
					root , this time sending root.right as root reference. if key is smaller then same operation is done on root.left
					base case is when a null position is found, the new node is inserted there. since return type of this function
					is node<K,T> the entire tree is modified after insertion.
					#note:if two nodes have the same first name then they are compared on the basis of last name and accordingly placed in the tree.
									
				Time Complexity for insertion in a binary tree:
						worst case:O(n) when the node to be inserted is going to be a leaf node and the tree is such that it forms a single chain.
						average case:O(logn)
					
				c.minimum//returns the minimum node in a subtree.
				d.delete(K key)// deleted the node with the given key by calling the deletehelp and returns the number of nodecs touched in deletion
				e.deletehelp(node<K,T> root,K key)// compares the key with the node and calls recursive deletehelp on root.left or root.right
					depending on whether the key is less than or greater than the root key value.
					when the match is found ->case 1: when the node to be deleted is a leaf node then its value is simply changed to null
											case2: when it has only one children .then this node is replaced with its child.
											case 3: when the node to be deleted has both children -> then its contents(not refrences i.e it still refers to the same children
											 as before and is referred to by the same parent) are replaced with the node which is minimum in the right sub tree
												and the minimum on the right is deleted by calling deletehelp on it . 
								
					Time complexity:same as that of insert.	
				f.update(K key,node<K,T> new_node)//calls update help and returns the number of touched nodes while updating
				g.updatehelp(node<K,T> root,K key,node<K,T> new_node)//compares the key of the root with the given key and accordingly decides whether to
					look in the left of the right sub tree. when key is matched the node is updated. it also increments the update counter each time it 
					touches a node.
					TIME Complexity for updation in a binary tree:
						worst case:O(n) when the node to be inserted is going to be a leaf node and the tree is such that it forms a single chain.
						average case:O(logn)
					
				f .node<K,T>gethelp(node<K,T> root,K key): searches for the node with given key and returns the node to the get function.
					
				g. address(K key)//returns the address of the given key by calling the address help.
				h.addresshelp(node<K,T> root,K key)//compares the nodes and accordingly updates addresscounter thus arriving on a final positon where the key is present 
				i.contains(K key)// calls containshelp and returns true if the key is present otherwise returns false.
					Time complexity:same as insert.	
					
					

3.pair.java://contains class pair<K,T> 
		attributes: key: stores the key in case of an objext of type pair<key,student> and stores the first name of the object in case of a object of type pair<String,String>
					value:store the key.ie the student object in case of pair<String,student> and last name in case of pair<String,String>
					getkey()->returns key
					getvalue()->returns value
					toStirng()-> returns the concatenation of the first+last name.
			#this class inherits the class compare which implements the comparable interface . this class then overrides the compareTo method such that
				compareTo(key key1)// 	 it first compares the first name and returns 1 if the first name of the pair object that has called it is greater than the first name(key) of key1 otherwise it returns -1.
									if somehow the first name(key) of the pair object that has 	called is equal to the firstname(key) of key1 then it compares the lastname(value) of the pair object that has called 
									it with the lastname(value)of key1 and returns 1 or -1 accordingly.( #assumption made both first name and last name will not be equal).
					
					
4.Student_.java:contains the class student which implements the Student_ interface.

5.compare.java:// it contains the class compare which implements the Comparable interface.this class is then inherited by pair which then overrides the compareTo method as explained above. this
					serves as a dummy class which helps me to define compareTo for pair<K,T> so that i am able to use compareTo for generic type K by making it extend Comparable<K>. and the true 
					nature of compareTo for it is used when i finally substitute K with type pair<String,String> which will be valid substitution since pair is also made a subclass of Comparable by making it sublclass of type compare.  
5.separate_hash.java: contains the class separ_hash< which implements the separate hashing approach .
		variables in the class:
					.hashtablesize//type int and stores the tablesize
					.bst<K,T> hashtable// array which represents the hash table in which each cell point to a binary tree
			methods:
				.insert(K key,T obj)// creates a node based on key and object and generates a index using djb2 and inserts this node to hashtable[index] and returns 
					the number of nodes touched in delete.
					Time complexity:
						a.worst case:O(n) where n is the number of keys and this happens when all keys are hashed to 
						the same cell and the tree created is such that its height is n-1.
						b.best case:O(1) when no collision occurs.
						c.average case.:hash is generated in O(1) time and if y is the load factor( =n/N where n is the number of keys present in the hash table and N is the table size)
						 then average case complexity is O(1+y) which can O(N)(when n~N^2)) or any thing depending upon n/N. 
				.delete(K key)// creates a index based on key and delete the that key from the bst present in hashtable[index].
					:TIME complexity of delete in separate chaining:
							a.worst case:O(n) where n is the number of keys and this happens when all keys are hashed to 
						the same cell and the tree created is such that its height is n-1.
						b.best case:O(1) when no collision occurs.
						c.average case.:hash is generated in O(1) time and if y is the load factor( =n/N where n is the number of keys present in the hash table and N is the talbe size)
						 then average case complexity is O(1+y) which can O(N)(when n~N^2)) or anything depending on y.
				.update(K key,T obj)//creates a node and inserts it to the bst present in hashtable[index].
					TIME complexity of update in separate chaining:
						a.worst case:O(n) where n is the number of keys and this happens when all keys are hashed to 
						the same cell and the tree created is such that its height is n-1.
						b.best case:O(1) when no collision occurs.
						c.average case.:hash is generated in O(1) time and if y is the load factor( =n/N where n is the number of keys present in the hash table and N is the talbe size)
						 then average case complexity is O(1+y) which can O(N)(when n~N^2)) or anything depending on n/N.
				.get(K key)// returns  the student with the given key. and thorws notfoundexception if the key is not present .
						time complexity: same as update
				.address (k key)// returns the address of student with the given key and throws not found exception if key not present.
				
6.assignment3.java:// this contains the driver class assignment3. it contains the main mehthods which reads the file and performs all the operations based on the command line arguments. 
				
#note: i have assumed that two keys can never have the same first and last name. and if if you try to insert an already inserted key then it prints E or if any such operations such as update , delete is tried performing 
on the basis of key that is not present then it prints E.
					
					 
						
						 	
						 
 
						  		
						  		