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
	int w = 729, h = 729;
	public void paint(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.black);
		g.fillRect(0, 0, 1000, 1000);
		
		//Rings cuhhhhhh
//		rings(g, 200, 0, 200);
//		rings1(g, 200, 0, 0);
//		rings2(g, 200, 200, 200);
//		rings3(g, 200, 200, 0);
//		
		
		//serpinski triyangle
		//SierpinskiTriangle(g, 200, 500, 500);
		
		//Squares
		squares(g, 0, 0, 729 );
		
		treelolol(g, 500, 500, 1, 90, 10, 1, 0.5,3,5);
		

	}// end of paint method - put code above for anything dealing with drawing -

	public void treelolol(Graphics g, int x, int y, int r, double sjhdg, double h, double s, double l, int stickpokeys, int depth) {
        if(depth == 0) return;
        if(h > 1) h -= 1;
        int rx = (int) (r * Math.cos(Math.toRadians(sjhdg)));
        int ry = (int) (r * Math.sin(Math.toRadians(sjhdg)));
        
        int[] rgb = hslToRgb(h, s, l);
        g.setColor(new Color(rgb[0], rgb[1], rgb[2]));
        g.drawLine(x, y, x+rx, y-ry);
        double dkjsah = sjhdg + 90;
        for(int i = 0; i < stickpokeys; i++) {
            dkjsah -= 180/(stickpokeys+1);
            treelolol(g, x+rx, y-ry, 2 * r/3, dkjsah, h+0.1, s, l, stickpokeys, depth-1);
        }
    }
	public void SierpinskiTriangle(Graphics g, double x, double y, double size) {
        if(size < 1) return;
        
        int[] rgb = hslToRgb(Math.random(), 1, 0.5);
        g.setColor(new Color(rgb[0], rgb[1], rgb[2]));
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
	
	
	public void squares(Graphics g, int x, int y, double size) {
		if(size<=9)
			return;
		int[] rgb = hslToRgb(Math.random(), 1, 0.5);
        g.setColor(new Color(rgb[0], rgb[1], rgb[2]));
		size /= 3.0;
		g.fillRect(x+(int)size, y+(int)size, (int)size, (int)size);
		squares(g, x, y, size);
		squares(g, (int)(x+size), y, size);
		squares(g, (int)(x+2*size), y, size);
		squares(g, x, (int)(y+size), size);
		squares(g, (int)(x+2*size), (int)(y+size), size);
		squares(g, x, (int)(y+2*size), size);
		squares(g, (int)(x+size),(int)(y+2*size), size);
		squares(g, (int)(x+2*size), (int)(y+2*size), size);
	
	}
	
	//Danials RGB COde!!
	
	public int[] hslToRgb(double h, double s, double l){
	     double r, g, b;
	     if(s == 0){
	     r = g = b = l;
	     }else{
	     double q = l < 0.5 ? l * (1 + s) : l + s - l * s;
	     double p = 2 * l - q;
	     r = hue2rgb(p, q, h + 1.0/3);
	     g = hue2rgb(p, q, h);
	     b = hue2rgb(p, q, h - 1.0/3);
	     }
	     return new int[] {(int)(r * 255), (int)(g * 255), (int)(b * 255)};
	    }
	    
	    double hue2rgb(double p, double q, double t){
	if(t < 0) t += 1;
	if(t > 1) t -= 1;
	if(t < 1.0/6) return p + (q - p) * 6 * t;
	if(t < 1.0/2) return q;
	if(t < 2.0/3) return p + (q - p) * (2.0/3 - t) * 6;
	return p;
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