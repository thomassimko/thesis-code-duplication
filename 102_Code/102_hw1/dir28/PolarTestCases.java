public class PolarTestCases
{
	public static void main (String[]args)
	{
		Point a = new PolarPoint(5.0, 0.6435);
		Check.check(a.radius(), 5.0);
		Check.check(a.angle(), 0.6435);
		Check.check(a.xCoordinate(), 4.0);
		Check.check(a.yCoordinate(), 3.0);
		Check.check(a.rotate90().rotate90().rotate90().rotate90().xCoordinate(), 4.0);
		Check.check(a.rotate90().yCoordinate(), 4.0);
		
		Point b = new PolarPoint(5.0, 5.0);
		Check.check(b.xCoordinate(), 1.4183);
		Check.check(b.yCoordinate(), -4.7946);
		Check.check(b.radius(), 5.0);
		Check.check(b.angle(), 5.0);  
		Check.check(b.rotate90().xCoordinate(), 4.7946);
		Check.check(b.rotate90().yCoordinate(), 1.4183);
		
		Point c = new PolarPoint(5.0, 4.63);
		Check.check(c.xCoordinate(), -0.4114);
		Check.check(c.yCoordinate(), -4.9830);
		Check.check(c.radius(), 5.0);
		Check.check(c.angle(), 4.63);  
		Check.check(c.rotate90().xCoordinate(), 4.9830);
		Check.check(c.rotate90().yCoordinate(), -0.4114);
	}
}