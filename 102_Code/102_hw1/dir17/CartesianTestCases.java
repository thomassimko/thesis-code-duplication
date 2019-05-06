public class CartesianTestCases
{
	static Point p1 = new CartesianPoint(1,2);
	static Point p2 = new CartesianPoint(0,0);
	static Point p3 = new CartesianPoint(-3,-4);

	public static void testXCoordinate()
	{
		Check.check(p1.xCoordinate(), 1);
		Check.check(p2.xCoordinate(), 0);
		Check.check(p3.xCoordinate(), -3);
	}

	public static void testYCoordinate()
	{
		Check.check(p1.yCoordinate(), 2);
		Check.check(p2.yCoordinate(), 0);
		Check.check(p3.yCoordinate(), -4);
	}

	public static void testRadius()
	{
		Check.check(p1.radius(), 2.236067);
		Check.check(p2.radius(), 0);
		Check.check(p3.radius(), 5);
	}

	public static void testAngle()
	{
		Check.check(p1.angle(), 1.107148);
		Check.check(p2.angle(), 0);
		Check.check(p3.angle(), -2.214297);
	}

	public static void testRotate90()
	{
		Point r1 = p1.rotate90();
		Point r2 = p2.rotate90();
		Point r3 = p3.rotate90();
		
		Check.check(r1.xCoordinate(), -2);
		Check.check(r1.yCoordinate(), 1);
		Check.check(r2.xCoordinate(), 0);
		Check.check(r2.yCoordinate(), 0);
		Check.check(r3.xCoordinate(), 4);
		Check.check(r3.yCoordinate(), -3);
	}

	public static void main(String [] args)
	{
		testXCoordinate();
		testYCoordinate();
		testRadius();
		testAngle();
		testRotate90();
	}
}
