public class PolarTestCases
{
	static Point p1 = new PolarPoint(1,3.141592);
	static Point p2 = new PolarPoint(0,0);
	static Point p3 = new PolarPoint(-2,1);

	public static void testXCoordinate()
	{
		Check.check(p1.xCoordinate(), -1);
		Check.check(p2.xCoordinate(), 0);
		Check.check(p3.xCoordinate(), -1.080604);
	}

	public static void testYCoordinate()
	{
		Check.check(p1.yCoordinate(), 0);
		Check.check(p2.yCoordinate(), 0);
		Check.check(p3.yCoordinate(), -1.682941);
	}

	public static void testRadius()
	{
		Check.check(p1.radius(), 1);
		Check.check(p2.radius(), 0);
		Check.check(p3.radius(), 2);
	}

	public static void testAngle()
	{
		Check.check(p1.angle(), 3.141592);
		Check.check(p2.angle(), 0);
		Check.check(p3.angle(), 4.141592);
	}

	public static void testRotate90()
	{
		Point r1 = p1.rotate90();
		Point r2 = p2.rotate90();
		Point r3 = p3.rotate90();
	
		Check.check(r1.radius(), 1);
		Check.check(r1.angle(), 4.712388);
		Check.check(r2.radius(), 0);
		Check.check(r2.angle(), 1.570796);
		Check.check(r3.radius(), 2);
		Check.check(r3.angle(), 5.712388);
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
