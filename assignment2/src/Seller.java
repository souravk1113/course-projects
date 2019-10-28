import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Seller<V> extends SellerBase<V> {
	int catalogSize;
    public Seller (int sleepTime, int catalogSize, Lock lock, Condition full, Condition empty, PriorityQueue<V> catalog, Queue<V> inventory) {
        //TODO Complete the constructor method by initializing the attibutes
        // ...
    	this.setSleepTime(sleepTime);
    	this.catalogSize=catalogSize;
    	this.catalogSize=catalogSize;
    	this.lock=lock;
    	this.full=full;
    	this.empty=empty;
    	this.catalog=catalog;
    	this.inventory=inventory;
    	
    }
    
    public void sell() throws InterruptedException {
	try {
		lock.lock();
		while(catalog.isFull()) {
			
			full.await();
		}
		
			if(inventory.isEmpty()) {
			}
			
			else {
				Node<V> temp=(Node<V>)inventory.dequeue();
				catalog.enqueue(temp);
				empty.signalAll();
				
			}
		
            //TODO Complete the try block for produce method
            // ...
	} catch(Exception e) {
            e.printStackTrace();
	} finally {
		lock.unlock();
            //TODO Complete this block
	}		
    }
}
