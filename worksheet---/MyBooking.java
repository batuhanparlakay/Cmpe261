import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService; //thread pool
import java.util.concurrent.Executors; // thread pool

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
// WHAT WE NEED, WE PREPARE THEM BEFORE CREATING CLASS
public class MyBooking extends JFrame implements ActionListener {
private JPanel JPanel1, JPanel2;
private JButton BtnBook, BtnCreate; //Button book and Buttton create
private JTextField TxtSeat, TxtAgent, TxtMaxTime; //create text field
private CreateSeats c1; //Create c1 index
private int MySeats = 0;
//0 from create MySeats

   public MyBooking() {
	  // Use mybooking JFrame with I determine the locations and dimensions of my buttons, my texts, my panels
	  //And compose a java window
	   
	   setTitle("Booking Programing");
       setVisible(true);
       setLayout(new BorderLayout());
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       
       JPanel1 = new JPanel();
       
       JPanel1.setBackground(Color.WHITE); //determine color
      
       TxtSeat = new JTextField("Number of seats");
       TxtSeat.setSize(100, 50); //determine size
       JPanel1.add(TxtSeat, BorderLayout.CENTER);
      
       TxtAgent = new JTextField("Number of agents");
       TxtAgent.setSize(100, 50); //determine size
       JPanel1.add(TxtAgent, BorderLayout.CENTER);
      
       TxtMaxTime = new JTextField("Max waiting time");
       TxtMaxTime.setSize(100, 50); //determine size
       JPanel1.add(TxtMaxTime, BorderLayout.CENTER);
      
       BtnCreate = new JButton("Create seats");
       BtnCreate.setSize(200, 50); //determine size
       BtnCreate.addActionListener(this);
       JPanel1.add(BtnCreate, BorderLayout.CENTER);
      
       BtnBook = new JButton("Book");
       BtnBook.setSize(200, 50); //determine size
       BtnBook.addActionListener(this);
       JPanel1.add(BtnBook, BorderLayout.CENTER);
      
      
       add(JPanel1, BorderLayout.NORTH);
      

   }
  
   public static void main(String[] args) {
       MyBooking mybooking = new MyBooking();
   }


   @Override
   public void actionPerformed(ActionEvent e) {
       if(e.getSource() == BtnCreate) { //First of all, we create MySeats because TxtSeats is a string and we make it int with ParseInt because we need integer value
    	     try {
               MySeats = Integer.parseInt(TxtSeat.getText().toString());
               c1 = new CreateSeats(MySeats);//then we put the newly created index into MySeats
               add(c1, BorderLayout.CENTER);
               revalidate(); // the revalidate() method instruct Layout to recalculate layout and often called once new components are added or removed from Container
           } catch (Exception event) {
               
              System.out.println(" error message , please enter a valid integer number ");
           }  
       }
       if(e.getSource() == BtnBook) {  //likewise Myagent int with parseInt
           int Myagent = Integer.parseInt(TxtAgent.getText().toString());
           System.out.println(TxtMaxTime.getText().toString());
           ExecutorService threadpools = Executors.newFixedThreadPool(Myagent);//can be shut down, which will cause it to reject new tasks. Two different methods are provided for shutting down an ExecutorService
           for(int i=0; i<Myagent; i++) {
               System.out.println(threadpools.toString());//Hence, MYAGENTS WILL RANK US
           }
           for(int i=0; i<MySeats; i++) {
               int count = i;
               // Runnable agent = new Booking(i);IMPORTANT
               threadpools.execute(new Runnable() {
                   @Override
                   public void run() { //CREATE THREAD
                       
                       try {
                    	   //JTextArea with getTaByIndex thus we create agent
                           c1.getTaByIndex(count).setText(" Booked by Agent " + Myagent);
                           c1.getTaByIndex(count).setBackground(Color.RED);
                           System.out.println(count);
                           revalidate();
                           Thread.sleep(500);//sleep wait second (sn)
                       } catch (Exception e) {
                          
                       }
                   }
               });
           }
           threadpools.shutdown();//method is called on an executor service, it stops accepting new tasks, waits for previously submitted tasks to execute, and then terminates the executor
           while (threadpools.isTerminated()) {
            }
           System.out.println("end...");
       }
      
   }
}

