public class PolarTestCases
{
	public static void main (String[] args)
	{
		Point b = new PolarPoint(0,0);
		Check.check(b.xCoordinate(),0);
		Check.check(b.xCoordinate(),0);
		Check.check(b.radius(), 0);
		Check.check(b.angle(), 0);
		Check.check(b.rotate90().xCoordinate(), 0);
		Check.check(b.rotate90().yCoordinate(), 0);
		
		Point c = new PolarPoint(1.0,1.570796327);
		Check.check(c.xCoordinate(), 0);
		Check.check(c.yCoordinate(), 1);
		Check.check(c.radius(), 1);
		Check.check(c.rotate90().xCoordinate(), -1);
		Check.check(c.rotate90().yCoordinate(), 0);
		Check.check(c.angle(), 1.570796327);
		
		Point f = new PolarPoint(5.0, 0.6435);
		Check.check(f.radius(), 5.0);
		Check.check(f.angle(), 0.6435);
		Check.check(f.xCoordinate(), 4.0);
		Check.check(f.yCoordinate(), 3.0);
		Check.check(f.rotate90().rotate90().rotate90().rotate90().xCoordinate(), 4.0);
		Check.check(f.rotate90().yCoordinate(), 4.0);
	}
}