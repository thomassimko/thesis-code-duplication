public class PolarTestCases
{
    public static void main(String args[])
    {
	Point pp1 = new PolarPoint(3, 90);
        Check.check(pp1.xCoordinate(), 0);
        Check.check(pp1.yCoordinate(), 3);
        Check.check(pp1.radius(), 3);
        Check.check(pp1.angle(), 1.5707963);
        Check.check(pp1.rotate90().xCoordinate(), -3);
        Check.check(pp1.rotate90().yCoordinate(), 0);
    }
}
