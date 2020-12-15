package geometry;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

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
		// p.draw(g);
		
		Line l = new Line(new Point(300, 100), new Point(300, 400), false, Color.DARK_GRAY);
		// l.draw(g);
		
		Circle c = new Circle(new Point(400, 400), 50, false, Color.DARK_GRAY, Color.RED);
		// c.draw(g);
		
		Rectangle r = new Rectangle(new Point(200, 200), 80, 40, false, Color.BLACK, Color.GREEN);
		// r.draw(g);
		
		Donut d = new Donut(new Point(700, 100), 60, 30, false, Color.RED, Color.YELLOW);
		// d.draw(g);
		
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		shapes.add(p);
		shapes.add(l);
		shapes.add(c);
		shapes.add(r);
		shapes.add(d);
		
		Iterator<Shape> it = shapes.iterator();
		// ispisati status selektovanosti svakog oblika
		while(it.hasNext()) {
			System.out.println("Selected: " + it.next().isSelected());
		}
		
		// iscrtati 3. element iz liste shapes
		shapes.get(2).draw(g);
		
		// iscrtati poslednji element iz liste
		shapes.get(shapes.size() - 1).draw(g);
		
		// dodati i iscrtati novu liniju l1 u listu tako da ona bude na 4. poziciji u listi shapes
		Line l1 = new Line(new Point(30, 30), new Point(120, 100), false, Color.RED);
		
		shapes.add(3, l1);
		shapes.get(3).draw(g);
		
		// ukloniti 2. element liste
		shapes.remove(1);
		
		// setovati svaki element liste shapes kao selektovan pomocu iteratora it
		while(it.hasNext()) {
			it.next().setSelected(true);
		}
		
		// iscrtati svaki oblik iz liste shapes pomocu for each
		for(Shape s : shapes) {
			s.draw(g);
		}
		
		// postaviti kao selektovan svaki povrsinski oblik liste shapes
		while(it.hasNext()) {
			if (it.next() instanceof SurfaceShape) {
				it.next().setSelected(true);
			}
		}
		
		
	}
	
}
