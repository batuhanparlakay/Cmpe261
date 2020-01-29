package assig1;

import java.awt.Color;

import java.awt.FlowLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

//USÝNG JFRAME EXTEND AND ÝMPLENMENT ACTÝONLÝSTENER
	public class A extends JFrame implements ActionListener
	{
	// define global variables
	private JLabel lblFirst,lblSecond,lblThird,lblFour;
	private JTextField txtOne;
	private JButton btnAdd,btnOrder;
	private JRadioButton rdJuice, rdWater,rdTea,rdCoffee;
	private ButtonGroup btnGroups;
	private static JComboBox c1 ;
	private String x;
	double a;
	private String[] selected= {"Apple","Orange","Pineapple"};
	private ArrayList<String> myarraylist = new ArrayList<String>();
	private String ch;
	int quantity;
	public A() {
		
	//set Layout
	setLayout(null);
	init();
	


	

	//comboBox design

	String [] message = {"Small" , "Medium" , "Large"};
	c1 = new JComboBox(message);
	   c1.setLocation(120, 170);
	   c1.setSize(100,30);
	   c1.setSelectedIndex(0);
	   this.add(c1);
	   c1.addActionListener(this);

	// set my GUI parameters
	setSize(600, 600);
	setTitle("Assigment 1");
	setVisible(true);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	getContentPane().setBackground(Color.lightGray);
	setResizable(false);
	}

	// design GUI
	private void init() {

	//initialize global variables
	lblFirst= new JLabel("Select which type of beverage you want to order : ");
	lblFirst.setForeground(Color.black);
	lblFirst.setLocation(120, 80);
	lblFirst.setSize(300,300);
	add(lblFirst);

	// set txtOne
	txtOne= new JTextField();
	txtOne.setLocation(120, 310);
	txtOne.setSize(350, 30);
	add(txtOne);
	txtOne.setToolTipText("Enter Integer Number");

	lblSecond= new JLabel("Select how many glasses you want to order :  ");
	lblSecond.setForeground(Color.black);
	lblSecond.setLocation(120, 150);
	lblSecond.setSize(300,300);
	add(lblSecond);

	lblThird=new JLabel("Select size : ");
	lblThird.setForeground(Color.black);
	lblThird.setLocation(120,100);
	lblThird.setSize(100,100);
	add(lblThird);
	 
	//END OF THE CODE USÝNG RESULT ÝS ÝMPORTANT LABEL FOUR
	lblFour= new JLabel(toString());
     lblFour.setForeground(Color.black);
     lblFour.setLocation(50, 420);
     lblFour.setSize(400,50);
     add(lblFour);
	


	// set Buttons
	btnAdd= new JButton("Add");
	btnAdd.setLocation(120,350);
	btnAdd.setSize(100, 50);
	add(btnAdd);

	btnOrder= new JButton("Order");
	btnOrder.setLocation(370, 350);
	btnOrder.setSize(100, 50);
	add(btnOrder);



	// register buttons to respond actions

	btnAdd.addActionListener(this);
	btnOrder.addActionListener(this);

	// set radio buttons

	btnGroups= new ButtonGroup();
	rdJuice= new JRadioButton("Juice");
	rdJuice.setLocation(120, 250);
	rdJuice.setSize(80, 20);
	add(rdJuice);



	rdWater= new JRadioButton("Water");
	rdWater.setLocation(220, 250);
	rdWater.setSize(80, 20);
	add(rdWater);




	rdTea= new JRadioButton("Tea");
	rdTea.setLocation(320, 250);
	rdTea.setSize(80, 20);
	add(rdTea);




	rdCoffee= new JRadioButton("Coffee");
	rdCoffee.setLocation(420, 250);
	rdCoffee.setSize(80, 20);
	add(rdCoffee);

	//make a group for radio buttons
	btnGroups.add(rdJuice);
	btnGroups.add(rdWater);
	btnGroups.add(rdTea);
	btnGroups.add(rdCoffee);
	rdJuice.setSelected(true);
	
	}
	
    





	public static void main(String[] args) {
	new A();
	
	}
	//METHOD PRÝCE ITEMS MY CODE USÝNG PRÝCE DETERMINATION
	public double price_Items(String order){
        double price= 0;
    if(order.equals("Apple"))
        price=15.0;
    else if(order.equals("Orange"))
        price=18.0;
    else if(order.equals("Pineapple"))
        price=20.0;
    else if(order.equals("Water"))
        price=2.50;
    else if(order.equals("Water with ice"))
        price=3.0;
    else if(order.equals("Tea"))
        price=5.0;
    else if(order.equals("Tea with sugar"))
        price=6.5;
    else if(order.equals("Coffee"))
        price=10.0;
    else if(order.equals("Coffee with milk"))
        price=15.0;

    return price;
    }

// USÝNG QUENTÝTÝY AND SÝZE AFFECT PRODUCT PRÝCE SO USÝNG CODE QUENTÝTY AND SÝZE DETERMÝNED
	  public double price_Item_Calculation(String size,String order,int quantity){
	        double cost =0;
	        if (size.equals("Small"))
	             cost = price_Items(order);
	        else if(size.equals("Medium"))
	            cost = price_Items(order);
	        else if(size.equals("Large"))
	            cost = price_Items(order);

	        return cost*quantity;
	    }
	
	  //OVERRÝDE CALCULATÝON CODE 
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnAdd) && txtOne.getText().isEmpty()== false){
			quantity = Integer.parseInt(txtOne.getText().trim());
            String size = (String) c1.getSelectedItem();
            if (e.getSource().equals(btnAdd) && rdJuice.isSelected() == true) {              //RADÝOBUTTON SELECTED JUÝCE END QUESTÝON WHÝCH FRUÝT AND SELCETÝON ONE OF THE FRUÝT 
            	ch = (String) JOptionPane.showInputDialog(null, "Choose your juice",         
                        "Choose your fruit", JOptionPane.QUESTION_MESSAGE, null, selected, selected[0]);

                lblFour.setText(toString(size,ch,quantity));
            }else if(e.getSource().equals(btnAdd) && rdWater.isSelected() == true){      //RADÝO BUTTON SELECTED WATER AND QUESTÝON SELECTED ICE USÝNG YES NO QUESTÝON AND USÝNG LABEL FOUR BECAUSE RESULT SEE LOWER SCREEN
                int ice =  JOptionPane.showConfirmDialog(null,"Would you want your water with ice?",null,JOptionPane.YES_NO_OPTION);
                if(ice==0)
                	ch = "Water with ice";
                else if(ice==1)
                	ch="Water";

                lblFour.setText(toString(size,ch,quantity)); 
            }else if(e.getSource().equals(btnAdd) && rdTea.isSelected() == true){////RADÝO BUTTON SELECTED TEA AND QUESTÝON SELECTED SUGAR USÝNG YES NO QUESTÝON AND USÝNG LABEL FOUR BECAUSE RESULT SEE LOWER SCREEN
                int sugar =  JOptionPane.showConfirmDialog(null,"Would you want your tea with sugar?",null,JOptionPane.YES_NO_OPTION);
                if(sugar==0)
                	ch = "Tea with sugar";
                else if(sugar==1)
                	ch="Tea";

                lblFour.setText(toString(size,ch,quantity));
            }else if(e.getSource().equals(btnAdd) && rdCoffee.isSelected() == true){//RADÝO BUTTON SELECTED COFFEE AND QUESTÝON SELECTED MÝLK USÝNG YES NO QUESTÝON AND USÝNG LABEL FOUR BECAUSE RESULT SEE LOWER SCREEN
                int milk =  JOptionPane.showConfirmDialog(null,"Would you want your coffee with milk?",null,JOptionPane.YES_NO_OPTION);
                if(milk==0)
                	ch = "Coffee with milk";
                else if(milk==1)
                	ch="Coffee";

                lblFour.setText(toString(size,ch,quantity));
            }
//FÝRSTLY DETERMÝNENT ARRAYLÝST CODE BECAUSE SELECTED PRODUCT THROW ÝN ARRAYLÝST AND IF NOT SELECTED PROGRAM ERROR MESSAGE .
            myarraylist.add(toString(size,ch,quantity) + " - " +price_Item_Calculation(size,ch,quantity) + " TL");
            a +=price_Item_Calculation(size,ch,quantity);
        }else if(e.getSource().equals(btnAdd) && txtOne.getText().isEmpty()==true){
            JOptionPane.showMessageDialog(null," Choose a beverage type and enter and amount.");
        }

        if(e.getSource().equals(btnOrder) && myarraylist.size()>0){

            String list = new String();

            for (int i = 0; i<myarraylist.size();i++)
                list =list +System.lineSeparator() + myarraylist.get(i);

           int check = JOptionPane.showConfirmDialog(null,list,"MESSAGE?",JOptionPane.YES_NO_OPTION);
            if(check==0)
                JOptionPane.showMessageDialog(null," You should pay " + a + " TL");
            else if(check==1)
                JOptionPane.showMessageDialog(null,"CANCEL");

        }

    }



    public String toString(String size,String choice,int amount) {
        if (choice.equals("Apple")||choice.equals("Orange")||choice.equals("Pineapple"))
            return (String) (amount+" glass(es) of " + c1.getSelectedItem()+ " " + choice + " juice selected.");
        else
            return (String) (amount+" glass(es) of " + c1.getSelectedItem()+ " " + choice + " selected.");

    }

}
	
		