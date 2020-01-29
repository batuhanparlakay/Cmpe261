package worksheet8;

import java.util.Random;

public class MyBuyer extends Thread {

	private String bname;

	private MyItem It;
	private Random ran = new Random ();
	
	
	public MyBuyer (String bname  , MyItem It) {
		this.bname=bname;
		
		this.It=It;
		}
	
	public void run () {
		
		while(true) {
			
			
		
				try {
					Thread.sleep(1000);
					int p= ran.nextInt(100);
					if(p>20) {
						It.Bid(p+50);}
					else {
						It.Penalty(p);
					}}
				catch (InterruptedException e) {
					e.printStackTrace();
				}}}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public MyItem getIt() {
		return It;
	}

	public void setIt(MyItem it) {
		It = it;
	}

	public Random getRan() {
		return ran;
	}

	public void setRan(Random ran) {
		this.ran = ran;
	}
					
					
	

	
	
	
	
}
