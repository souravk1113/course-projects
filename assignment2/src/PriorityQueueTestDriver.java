// Use this driver for the testing the correctness of your priority queue implementation
// You can change the add, remove sequence to test for various scenarios.
public class PriorityQueueTestDriver {
    public static void main(String[] args) {
	PriorityQueue<String> pq = new PriorityQueue<String>(5);
	//pq.add(4, "A");
	//pq.add(10, "B");
	//pq.add(3, "C");
	//pq.add(5, "E");
	//pq.add(2, "F");
	
	//pq.display();
	Node<String> a1=new Node<String>(4,"A");
	Node<String> a2=new Node<String>(10,"B");
	Node<String> a3=new Node<String>(3,"C");
	Node<String> a4=new Node<String>(5,"E");
	Node<String> a5=new Node<String>(2,"F");
	pq.enqueue(a1);
	pq.enqueue(a2);
	pq.enqueue(a3);
	pq.enqueue(a4);
	pq.enqueue(a5);
	int size = pq.size();
	for (int i=0; i<size; i++) {
            Node<String> n = (Node<String>) pq.dequeue();
            n.show();
	}
    }
}
