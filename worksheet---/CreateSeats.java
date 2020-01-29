
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CreateSeats extends JPanel { //this time we will use jPanel
   private Dimension size = Toolkit.getDefaultToolkit().getScreenSize();//The Dimension class encapsulates the width and height of a component (in integer precision) in a single object. 
   private JTextArea [] JTextArea1;
  
   public CreateSeats(int numberOfSeats) {
       setVisible(true);
       setSize((int) size.getWidth(), (int) size.getHeight());//to be determined by size to be entered
       setLayout(new GridLayout(10, (int) Math.floor(numberOfSeats/10), 10, 10));//The Math.floor() function returns the largest integer less than or equal to a given number.
       setBackground(Color.GRAY);
      
       JTextArea1 = new JTextArea [numberOfSeats];// we are taking numverofSeats
      
       for(int i=0; i<numberOfSeats; i++) { //we determine as we do in the other class
           JTextArea1[i] = new JTextArea();
           JTextArea1[i].setText(" Not booked " );
           JTextArea1[i].setBackground(Color.WHITE);
           JTextArea1[i].setEditable(false);
                    add(JTextArea1[i]);
       }
   }

   public JTextArea[] getTa() {
       return JTextArea1;
   }
   public JTextArea getTaByIndex(int index) {
       return JTextArea1[index];
   }

   public void setTa(JTextArea[] x) {
       this.JTextArea1 = x;
   }

}