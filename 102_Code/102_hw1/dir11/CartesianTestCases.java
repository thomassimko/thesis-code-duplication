public class CartesianTestCases
{

    public static void testXCoordinate()
    {
	CartesianPoint pt1 = new CartesianPoint(3.0, 4.0);
	CartesianPoint pt2 = new CartesianPoint(0.0, 1.0);
	Check.check(pt1.xCoordinate(), 3.0);
	Check.check(pt2.xCoordinate(), 0.0);
    }
    public static void testYCoordinate()
    {
	CartesianPoint pt1 = new CartesianPoint(3.0, 4.0);
        CartesianPoint pt2 = new CartesianPoint(0.0, 1.0);
	Check.check(pt1.yCoordinate(), 4.0);
	Check.check(pt2.yCoordinate(), 1.0);
    }
    public static void testRadius()
    {
	CartesianPoint pt1 = new CartesianPoint(3.0, 4.0);
        CartesianPoint pt2 = new CartesianPoint(0.0, 1.0);
	Check.check(pt1.radius(), 5.0);
	Check.check(pt2.radius(), 1.0);
    }
    public static void testAngle()
    {
	CartesianPoint pt1 = new CartesianPoint(3.0, 4.0);
        CartesianPoint pt2 = new CartesianPoint(0.0, 1.0);
	Check.check(pt1.angle(), .9272952180);
	Check.check(pt2.angle(), 1.57079632);
    }
    public static void testRotate90()
    {
	CartesianPoint pt1 = new CartesianPoint(3.0, 4.0);
        CartesianPoint pt2 = new CartesianPoint(0.0, 1.0);
	Check.check(pt1.rotate90().xCoordinate(), -4.0);
        Check.check(pt1.rotate90().yCoordinate(), 3);
	Check.check(pt2.rotate90().xCoordinate(), -1);
        Check.check(pt2.rotate90().yCoordinate(), 0);
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