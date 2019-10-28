import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Buyer<V> extends BuyerBase<V> {
    public Buyer (int sleepTime, int catalogSize, Lock lock, Condition full, Condition empty, PriorityQueue<V> catalog, int iteration) {
        //TODO Complete the Buyer Constructor method
        // ...
    	this.setSleepTime(sleepTime);
    	this.lock=lock;
    	this.full=full;
    	this.empty=empty;
    	this.catalog=catalog;
    	this.setIteration(iteration);
    }
    public void buy() throws InterruptedException {
    	NodeBase<V> n;
	try {
		lock.lock();
		while(catalog.isEmpty()) {
			
			empty.await();
		}
		
			Node<V> temp=(Node<V>)catalog.dequeue();
			n=new Node<V>(temp.getPriority(),temp.getValue());
			full.signalAll();
			 
		
            //TODO Complete the try block for consume method
            // ...
	    System.out.print("Consumed "); // DO NOT REMOVE (For Automated Testing)
	    n.show(); // DO NOT REMOVE (For Automated Testing)
            // ...
	} catch (Exception e) {
            e.printStackTrace();
	} finally {
		lock.unlock();
            //TODO Complete this block
	}
    }
}
