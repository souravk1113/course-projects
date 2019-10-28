public class pair<K,T> extends compare<K,T> {
	K key;
	T value;
	boolean status;
	pair(K key,T value){
		this.key=key;
		this.value=value;
		status=true;
	}
	K getkey() {
		return key;
	}
	T getvalue() {
		return value;
	}
	public String toString() {
		return key.toString()+value.toString();
	}
	@Override
	public int compareTo(pair<K,T> key1) {
		if(!key.toString().equals(key1.key.toString())) {
		return (key.toString().compareTo(key1.key.toString()));
		}
		else {
		return (value.toString().compareTo(key1.value.toString()));
		// TODO Auto-generated method stub
		}
	}

	
}