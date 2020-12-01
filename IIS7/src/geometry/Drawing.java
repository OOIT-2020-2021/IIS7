package geometry;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Drawing extends JPanel {

	public Drawing() {
		setBackground(Color.WHITE);
	}
	
	public static void main(String[] args) {

		JFrame frame = new JFrame("Drawing");
		frame.setSize(800, 600);
		Drawing drawing = new Drawing();
		frame.getContentPane().add(drawing);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	public void paint(Graphics g) {
		
		Point p = new Point(50, 60, false, Color.BLACK);
		p.draw(g);
		
		Line l = new Line(new Point(300, 100), new Point(300, 400), false, Color.DARK_GRAY);
		l.draw(g);
		
		Circle c = new Circle(new Point(400, 400), 50, false, Color.DARK_GRAY, Color.RED);
		c.draw(g);
		
		Rectangle r = new Rectangle(new Point(200, 200), 80, 40, false, Color.BLACK, Color.GREEN);
		r.draw(g);
		
		Donut d = new Donut(new Point(700, 100), 60, 30, false, Color.RED, Color.YELLOW);
		d.draw(g);
		
	}
	
}
