public class CartesianTestCases
{
	public static void main(String [] args)
	{
		Point pt1 = new CartesianPoint(1.0, 1.0);
		Point pt2 = new CartesianPoint(5.0, 2.0);
		Point pt3 = new CartesianPoint(1.5, 3.0);
		Point pt4 = new CartesianPoint(0.0, 0.0);
		Point pt5 = new CartesianPoint(-2.5, -7.0);
		
		Check.check(pt1.xCoordinate(), 1.0);
		Check.check(pt1.yCoordinate(), 1.0);
		Check.check(pt1.radius(), Math.sqrt(2));
		Check.check(pt1.angle(), Math.atan2(1.0,1.0));
		Check.check(pt1.rotate90().xCoordinate(), -1.0);
		Check.check(pt1.rotate90().yCoordinate(),  1.0);
		
		Check.check(pt2.xCoordinate(), 5.0);
		Check.check(pt2.yCoordinate(), 2.0);
		Check.check(pt2.radius(), Math.sqrt(29));
		Check.check(pt2.angle(), Math.atan2(2.0,5.0));
		Check.check(pt2.rotate90().xCoordinate(), -2.0);
		Check.check(pt2.rotate90().yCoordinate(),  5.0);
		
		Check.check(pt3.xCoordinate(), 1.5);
		Check.check(pt3.yCoordinate(), 3.0);
		Check.check(pt3.radius(), Math.sqrt(11.25));
		Check.check(pt3.angle(), Math.atan2(3.0,1.5));
		Check.check(pt3.rotate90().xCoordinate(), -3.0);
		Check.check(pt3.rotate90().yCoordinate(),  1.5);
		
		Check.check(pt4.xCoordinate(), 0.0);
		Check.check(pt4.yCoordinate(), 0.0);
		Check.check(pt4.radius(), 0.0);
		Check.check(pt4.angle(), Math.atan2(0.0,0.0));
		Check.check(pt4.rotate90().xCoordinate(), 0.0);
		Check.check(pt4.rotate90().yCoordinate(), 0.0);
		
		Check.check(pt5.xCoordinate(), -2.5);
		Check.check(pt5.yCoordinate(), -7.0);
		Check.check(pt5.radius(), Math.sqrt(55.25));
		Check.check(pt5.angle(), Math.atan2(-7.0,-2.5));
		Check.check(pt5.rotate90().xCoordinate(), 7.0);
		Check.check(pt5.rotate90().yCoordinate(), -2.5);
		
	}

}
