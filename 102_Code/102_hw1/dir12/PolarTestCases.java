public class PolarTestCases
{
    public static void main(String args[])
    {
	Point p1 = new PolarPoint(0, 0);
	Point p1r = p1.rotate90();
	Point p2 = new PolarPoint(5.0, 53.1301024147736);//0.927295218
	Point p2r = p2.rotate90();
	Point p3 = new PolarPoint(-5.0, 237.324840764);
        Point p4 = new PolarPoint(5.0, -302.675159236);
	
	Check.check(p1.xCoordinate(), 0);
	Check.check(p1.yCoordinate(), 0);
	Check.check(p1.radius(), 0);
	Check.check(p1.angle(), 0);
	Check.check(p1r.radius(), 0);
	Check.check(p1r.angle(), 90.0);

	Check.check(p2.xCoordinate(), 3.0);
	Check.check(p2.yCoordinate(), 4.0);
	Check.check(p2.radius(), 5.0);
	Check.check(p2.angle(),53.1301024147736);
	Check.check(p2r.radius(), 5.0);
        Check.check(p2r.angle(), 143.1301024147736);
    
	Check.check(p3.radius(), 5.0);
	Check.check(p3.angle(), 57.324840764);

	Check.check(p4.angle(), 57.324840764);
    }
}