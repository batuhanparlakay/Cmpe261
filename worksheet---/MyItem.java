package worksheet8;

import java.util.concurrent.locks.ReentrantLock;

public class MyItem {

	private double price=1000;
	private double bid=0;
	private ReentrantLock reentrantlock = new  ReentrantLock() ;
	
	
	public MyItem (int price) {
		this.price=price;
	}
	
	public void Penalty (double x) {
		reentrantlock.lock();
		bid-=x;
		System.out.println (" The bid was penalty "  + bid );
		reentrantlock.unlock();
		
		
	}
	
	public void Bid(double y) {
		reentrantlock.lock();
		bid+=y;
		System.out.println (Thread.currentThread().getName() +  " bids " + bid);
		
	
	
	
		if(bid>=price) {
			System.out.println (Thread.currentThread().getName() + " wins for this item ");
			try {
				Thread.currentThread().join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	
		try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		reentrantlock.unlock();
	
}
	
	
		
	}

