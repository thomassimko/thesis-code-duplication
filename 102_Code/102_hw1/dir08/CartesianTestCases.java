public class CartesianTestCases
{
    public static void main(String [] args)
    {
	Point p1 = new CartesianPoint(3, 5);
	Point p2 = p1.rotate90();
	Check.check(p1.xCoordinate(), 3);
	Check.check(p1.yCoordinate(), 5);
	Check.check(p1.radius(), 5.83095);
	Check.check(p1.angle(), 1.03037);
	Check.check(p2.xCoordinate(), -5);
	Check.check(p2.yCoordinate(), 3);
	
	Point p3 = new CartesianPoint(5, 7);
	Point p4 = p3.rotate90();
	Check.check(p3.xCoordinate(), 5);
	Check.check(p3.yCoordinate(), 7);
	Check.check(p3.radius(), 8.60232);
	Check.check(p3.angle(), 0.95054);
	Check.check(p4.xCoordinate(), -7);
	Check.check(p4.yCoordinate(), 5);
	
	Point p5 = new CartesianPoint(-2, -4);
	Point p6 = p5.rotate90();
	Check.check(p5.xCoordinate(), -2);
	Check.check(p5.yCoordinate(), -4);
	Check.check(p5.radius(), 4.47213);
	Check.check(p5.angle(), -2.03444);
	Check.check(p6.xCoordinate(), 4);
	Check.check(p6.yCoordinate(), -2);
    }
}