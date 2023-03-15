import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Driver extends JPanel implements ActionListener {

	/* Attributes a.k.a. Instance Variables */
	int w = 800, h = 800;

	public void paint(Graphics g) {
		super.paintComponent(g);
		
		//Rings cuhhhhhh
//		rings(g, 200, 0, 200);
//		rings1(g, 200, 0, 0);
//		rings2(g, 200, 200, 200);
//		rings3(g, 200, 200, 0);
		
		
		//serpinski triyangle
		//SierpinskiTriangle(g, 200, 500, 250);
		

	}// end of paint method - put code above for anything dealing with drawing -

	public void clover(Graphics g, int radius, int x, int y) {

		
	

	}
	public void SierpinskiTriangle(Graphics g, double x, double y, double size) {
        if(size < 1) return;
        
        g.setColor(Color.PINK);
        g.drawLine((int)x, (int)y, (int)(x+size),(int)y);
        g.drawLine((int)x, (int)y, (int)(x+size/2), (int)(y-size/21.732));
        g.drawLine((int)(x+size), (int)y, (int)(x+size/2), (int)(y-size/21.732));
        SierpinskiTriangle(g, x, y, size/2);
        SierpinskiTriangle(g, x+size/4, (int)(y-size/4*1.732), size/2);
        SierpinskiTriangle(g, x+size/2, y, size/2);
    }

	public void rings(Graphics g, int radius, int x, int y) {
		// each method call draws one part of the fractal
		g.drawOval(x, y, radius, radius);
		if(radius>1) {
			rings(g, radius-8, x+8, y);
		}

	}
	public void rings1(Graphics g, int radius, int x, int y) {
		// each method call draws one part of the fractal
		g.drawOval(x, y, radius, radius);
		if(radius>1) {
			rings(g, radius-8, x+8, y+8);
		}

	}
	
	public void rings2(Graphics g, int radius, int x, int y) {
		// each method call draws one part of the fractal
		g.drawOval(x, y, radius, radius);
		if(radius>1) {
			rings(g, radius-8, x, y);
		}

	}
	public void rings3(Graphics g, int radius, int x, int y) {
		// each method call draws one part of the fractal
		g.drawOval(x, y, radius, radius);
		if(radius>1) {
			rings(g, radius, x, y);
		}

	}
	/**
	 * Update the positions of the ball and paddle. Update the scores, counter
	 * and time
	 */
	public void update() {

	}// end of update method - put code above for any updates on variable

	// ==================code above ===========================

	@Override
	public void actionPerformed(ActionEvent arg0) {
		update();
		repaint();
	}

	public static void main(String[] arg) {
		Driver d = new Driver();
	}

	/* Instantiate any attributes here (instance variables */
	public Driver() {

		JFrame f = new JFrame();
		f.setTitle("Pong");
		f.setSize(w, h);
		f.setBackground(Color.BLACK);
		f.setResizable(false);

		f.add(this);
		t = new Timer(17, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);

	}

	Timer t;

}