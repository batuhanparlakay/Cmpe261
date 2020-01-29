package worksheet8;

import java.util.Scanner;

public class MyTest {

	public static void main (String [] args) {
		
		Scanner scan = new Scanner (System.in);
		System.out.println("Please enter start first price item");
		int p = scan.nextInt();
		
		System.out.println("Please enter start second price item");
		int p1 = scan.nextInt();
		
		
		MyItem m1 = new MyItem(p);
		MyItem m2 = new MyItem (p1);
		
		MyBuyer b1  = new MyBuyer ("batuhan" , m1  );
		MyBuyer b2  = new MyBuyer ("batu" , m1  );
		MyBuyer b3  = new MyBuyer ("tolga" , m1  );
		
		MyBuyer b4  = new MyBuyer ("tunahan" , m2  );
		MyBuyer b5  = new MyBuyer ("nermin" , m2  );
		MyBuyer b6  = new MyBuyer ("muharrem" , m2  );
		
		
		b1.setName(b1.getBname());
		b2.setName(b2.getBname());
		b3.setName(b3.getBname());
		
		b1.start();
		b2.start();
		b3.start();
		b1.yield();
		
		b4.setName(b4.getBname());
		b5.setName(b5.getBname());
		b6.setName(b6.getBname());
		
		
		
		
		
		
		b4.start();
		b5.start();
		b6.start();
		
		
		
		
	}
}
