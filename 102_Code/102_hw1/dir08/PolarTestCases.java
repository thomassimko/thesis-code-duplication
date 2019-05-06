public class PolarTestCases
{
    public static void main(String [] args)
    {
	Point p1 = new PolarPoint(3, Math.PI/4);
	Point p2 = p1.rotate90();
	Check.check(p1.xCoordinate(), 2.12132);
	Check.check(p1.yCoordinate(), 2.12132);
	Check.check(p1.radius(), 3);
	Check.check(p1.angle(), Math.PI/4);
	Check.check(p2.radius(), 3);
	Check.check(p2.angle(), 3*(Math.PI)/4);
	
	Point p3 = new PolarPoint(1, Math.PI/2);
	Point p4 = p3.rotate90();
	Check.check(p3.xCoordinate(), 0);
	Check.check(p3.yCoordinate(), 1);
	Check.check(p3.radius(), 1);
	Check.check(p3.angle(), Math.PI/2);
	Check.check(p4.radius(), 1);
	Check.check(p4.angle(), Math.PI);
	
	Point p5 = new PolarPoint(5, Math.PI);
	Point p6 = p5.rotate90();
	Check.check(p5.xCoordinate(), -5);
	Check.check(p5.yCoordinate(), 0);
	Check.check(p5.radius(), 5);
	Check.check(p5.angle(), Math.PI);
	Check.check(p6.radius(),5);
	Check.check(p6.angle(), 3*(Math.PI)/2);
    }
}