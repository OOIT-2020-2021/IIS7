package geometry;

public class Test {

	public static void main(String[] args) {

		Point p = new Point();
		p.setX(10);
		p.setY(20);
		p.setSelected(true);

		System.out.println("X coordinate of point p is: " + p.getX() + '\n' + "Y coordinate of point p is: " + p.getY()
				+ '\n' + "Point p is selected: " + p.isSelected());

		double result = p.distance(40, 50);
		System.out.println("Distance between points is: " + result);

		Point p1 = new Point();
		p1.setX(15);
		p1.setY(27);
		p1.setSelected(true);

		// 1. Inicijalizovati x koordinatu tacke p
		// na vrednost y koordinate tacke p1

		p.setX(p1.getY());
		System.out.println("X of p = " + p.getX());

		// 2. Postaviti za pocetnu tacku linije l1 tacku p, a
		// za krajnju tacku linije l1 tacku p1

		Line l1 = new Line();
		l1.setStartPoint(p);
		l1.setEndPoint(p1);

		// 3. Postaviti y koordinatu krajnje tacke l1 na 23
		l1.getEndPoint().setY(23);
		System.out.println("y of end point of l1 = " + l1.getEndPoint().getY());

		// 4. Inicijalizovati x koordinatu pocetne tacke linije l1
		// na vrednost y koordinate krajnje tacke linije l1

		l1.getStartPoint().setX(l1.getEndPoint().getY());

		// 5. Postaviti x koordinatu krajnje tacke l1 na vrednost
		// duzine linije l1 umanjene za vrednost zbira x i y
		// koordinate pocetne tacke linije l1
		
		l1.getEndPoint().setX((int) (l1.length() - (l1.getStartPoint().getX() + l1.getStartPoint().getY())));
		
		// 6. Postaviti x koordinatu tacke gore levo pravougaonika
		// r1 na vrednost 10 i y koordinatu na vrednost 15
		
		Rectangle r1 = new Rectangle();
		r1.setUpperLeftPoint(p);
		r1.getUpperLeftPoint().setX(10);
		r1.getUpperLeftPoint().setY(15);
		System.out.println("x of upper left point of r1 = " + r1.getUpperLeftPoint().getX());
		System.out.println("y of upper left point of r1 = " + r1.getUpperLeftPoint().getY());
		
		// 7. Postaviti centar kruga c1 na koordinate tacke
		// gore levo od r1
		
		Circle c1 = new Circle();
		c1.setCenter(r1.getUpperLeftPoint());
		
		// 8. Postaviti x koordinatu centra kruga c1 na vrednost razlike
		// povrsine pravougaonika r1 i y koordinate pocetne tacke linije l1
		
		r1.setHeight(30);
		r1.setWidth(20);
		c1.getCenter().setX(r1.area() - l1.getStartPoint().getY());
		System.out.println("X of center of c1 = " + c1.getCenter().getX());
		
		
		// Testiranje konstruktora - vezbe 4
		
		Point p2 = new Point(20, 30);
		Point p3 = new Point(15, 18, true);
		Point p4 = new Point(20, 30);
		
		// toString() metoda
		
		System.out.println(p4.toString());
		
		Rectangle r2 = new Rectangle(p3, 20, 40);
		System.out.println(r2);
		
		// == i equals()
		String s1 = new String("Hello World");
		String s2 = new String("Hello World");
		System.out.println(s1 == s2); // poredjenje referenci na objekte
		System.out.println(s1.equals(s2)); // poredjenje vrednosti objekata
		
		int a = 5;
		int b = 5;
		System.out.println(a == b); // poredjenje vrednosti kod primitivnih tipova
		
		Rectangle r3 = new Rectangle(p3, 20, 40);
		Rectangle r4 = new Rectangle(p3, 20, 140);
		System.out.println(r2.equals(r3)); // true
		System.out.println(r2.equals(c1)); // false
		System.out.println(r2.equals(r4)); // false
		
		Donut d = new Donut(p3, 100, 50);
		
		System.out.println(d);
		System.out.println(d.contains(p1));
		System.out.println(d.equals(r2));
		
		Donut d1 = new Donut(p4, 30, 13);
		System.out.println(d.equals(d1));
		
		System.out.println(d.area());
		
		// dinamicko povezivanje
		Circle c3 = new Donut(p1, 50, 30);
		
	}

}
