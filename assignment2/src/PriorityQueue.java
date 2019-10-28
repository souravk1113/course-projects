
public class PriorityQueue<V> implements QueueInterface<V>{

    private NodeBase<V>[] queue;
    private int capacity, currentSize;
    //TODO Complete the Priority Queue implementation
    // You may create other member variables/ methods if required.
    public PriorityQueue(int capacity) {  
    	this.capacity=capacity;
    	queue= new Node[capacity];
    
    }

    public int size() {
    	return currentSize;
    
    }

    public boolean isEmpty() {
    	return(currentSize==0);

    }
	
    public boolean isFull() {
    	return (currentSize==capacity);
    }

    public void enqueue(Node<V> node) {
    	if(!isFull()) {
    	queue[currentSize]=node;
    	currentSize++;
    	}
    
    }

    // In case of priority queue, the dequeue() should 
    // always remove the element with minimum priority value
    public NodeBase<V> dequeue() {
    	int minindex=0;
    	if (currentSize!=0) {
    	for(int i=0;i<currentSize;i++) {
    		if (queue[i].getPriority()<queue[minindex].getPriority()) {
    			minindex=i;
    		}
    	}
    	NodeBase<V> res=queue[minindex];
    	currentSize--;
    	queue[minindex]=queue[currentSize];
    
    	return res;
    	}
    	else {
    		return null;
    	}
    }

    public void display () {
	if (this.isEmpty()) {
            System.out.println("Queue is empty");
	}
	for(int i=0; i<currentSize; i++) {
            queue[i+1].show();
	}
    }
}

