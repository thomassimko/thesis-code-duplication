public class PolarTestCases
{
    public static void testXCoordinates()
    {
	PolarPoint pt1 = new PolarPoint (5, 1.5707963);
        PolarPoint pt2 = new PolarPoint (10, .78539816);
        Check.check(pt1.xCoordinate(), 0);
	Check.check(pt2.xCoordinate(), 7.0710678);
    }
    public static void testYCoordinates()
    {
	PolarPoint pt1 = new PolarPoint (5, 1.5707963);
        PolarPoint pt2 = new PolarPoint (10, .78539816);
	Check.check(pt1.yCoordinate(), 5);
	Check.check(pt2.yCoordinate(), 7.0710678);
    }
    public static void testRadius()
    {
	PolarPoint pt1 = new PolarPoint (5, 1.5707963);
        PolarPoint pt2 = new PolarPoint (10, .78539816);
	Check.check(pt1.radius(), 5);
	Check.check(pt2.radius(), 10);
    }
    public static void testAngle()
    {
	PolarPoint pt1 = new PolarPoint (5, 1.5707963);
        PolarPoint pt2 = new PolarPoint (10, .78539816);
	Check.check(pt1.angle(), 1.5707963);
	Check.check(pt2.angle(), .78539816);
    }
    public static void testRotate90()
    {
	PolarPoint pt1 = new PolarPoint (5, 1.5707963);
        PolarPoint pt2 = new PolarPoint (10, .78539816);
	Check.check(pt1.rotate90().xCoordinate(), -5);
        Check.check(pt1.rotate90().yCoordinate(), 0);
	Check.check(pt2.rotate90().xCoordinate(), -7.0710678);
        Check.check(pt2.rotate90().yCoordinate(), 7.0710678);

    }
    public static void main (String [] args)
    {
	testXCoordinates();
	testYCoordinates();
	testRadius();
	testAngle();
	testRotate90();
    }
}