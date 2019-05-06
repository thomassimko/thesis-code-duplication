public class PolarTestCases
{
	public static void main(String [] args)
	{
		Point pt1 = new PolarPoint(1.0, Math.PI);
		Point pt2 = new PolarPoint(5.0, Math.PI/2);
		Point pt3 = new PolarPoint(-1.0, Math.PI * 5/4);
		Point pt4 = new PolarPoint(0.0, 0.0);
		Point pt5 = new PolarPoint(1.0, Math.PI * 7/4);
		
		Check.check(pt1.xCoordinate(), -1.0);
		Check.check(pt1.yCoordinate(), 0.0);
		Check.check(pt1.radius(), 1.0);
		Check.check(pt1.angle(), Math.PI);
		Check.check(pt1.rotate90().radius(), 1.0);
		Check.check(pt1.rotate90().angle(),Math.PI*3/2);
		
		Check.check(pt2.xCoordinate(), 0.0);
		Check.check(pt2.yCoordinate(), 5.0);
		Check.check(pt2.radius(), 5.0);
		Check.check(pt2.angle(), Math.PI/2);
		Check.check(pt2.rotate90().radius(), 5.0);
		Check.check(pt2.rotate90().angle(), Math.PI);
		
		Check.check(pt3.xCoordinate(), .7071);
		Check.check(pt3.yCoordinate(), .7071);
		Check.check(pt3.radius(), 1.0);
		Check.check(pt3.angle(), Math.PI * 9/4);
		Check.check(pt3.rotate90().radius(), 1.0);
		Check.check(pt3.rotate90().angle(), Math.PI*11/4);
		
		Check.check(pt4.xCoordinate(), 0.0);
		Check.check(pt4.yCoordinate(), 0.0);
		Check.check(pt4.radius(), 0.0);
		Check.check(pt4.angle(), 0.0);
		Check.check(pt4.rotate90().radius(), 0.0);
		Check.check(pt4.rotate90().angle(), Math.PI/2);

		
		Check.check(pt5.xCoordinate(), .7071);
		Check.check(pt5.yCoordinate(), -.7071);
		Check.check(pt5.radius(), 1.0);
		Check.check(pt5.angle(), Math.PI * 7/4);
		Check.check(pt5.rotate90().radius(), 1.0);
		Check.check(pt5.rotate90().angle(), Math.PI * 9/4);
		
	}

}
