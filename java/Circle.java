package worksheet;



import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Circle extends JFrame implements ActionListener, KeyListener {
private Color color;
private int radius, x, y,velocityx,dy;
private Timer timer;

public Circle() {

radius =  50;
x = 1;
y = 0;
velocityx = 3;
dy = 0;
timer = new Timer(20, this);
timer.start();

setLayout(null);
setTitle("ANİMATİON");
setSize(400, 400);
setVisible(true);
setResizable(false);
addKeyListener(this);

}



public static void main(String[] args) {
new Circle();

}


public void paint(Graphics g) {


super.paint(g);

g.setColor(color.BLUE);
g.fillOval(x, y, radius, radius);
}


public void actionPerformed(ActionEvent arg0) {

x = velocityx + x;
y = dy + y;

if (x+radius >=400 && y == 0) {
	velocityx = -velocityx;
dy = 3;

}
if (x+radius <= radius && y+radius >= 400) {
	velocityx = -velocityx;
dy = 0;

}
if (y+radius >= 400 && x+radius >= 400) {
	velocityx = -velocityx;
dy = -3;

}
if (x+radius <= 50 && y <= radius) {
	velocityx = -velocityx;
dy = 0;

}

repaint();

}

@Override
public void keyPressed(KeyEvent e) {

if (e.getKeyCode() == KeyEvent.VK_SPACE) {
if(timer.isRunning()) {
timer.stop();
}
else if (timer.isRunning()==false) {
timer.start();




}
}

}

@Override
public void keyReleased(KeyEvent arg0) {
// TODO Auto-generated method stub

}

@Override
public void keyTyped(KeyEvent arg0) {
// TODO Auto-generated method stub

}

}
