// This class implements the Queue
public class Queue<V> implements QueueInterface<V>{

    //TODO Complete the Queue implementation
    private NodeBase<V>[] queue;
    
    private int capacity, currentSize, front, rear;
	
    public Queue(int capacity) { 
    	this.capacity=capacity;
    	front=0;
    	rear=-1;
    	queue=new Node[capacity];
    	currentSize=0;
    }

    public int size() {
    	return currentSize;
    
    }

    public boolean isEmpty() {
    	return (currentSize==0);
    
    }
	
    public boolean isFull() {
    	return (currentSize==capacity);
    
    }

    public void enqueue(Node<V> node) {
    	if(!isFull()) {
    		rear=(rear+1)%capacity;
    		currentSize++;
    		queue[rear]=node;
    	}
    	
    
    }
    public NodeBase<V> dequeue() {
    	if(!isEmpty()) {
    		currentSize--;
    		NodeBase<V> temp=queue[front];
    		front=(front+1)%capacity;
    	return temp;
    		
    		
    	}
    	else {
    		return null;
    	}
    
    }

}

