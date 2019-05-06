public class CartesianTestCases
{
	public static void testCartesianPoint()
	{
		CartesianPoint pt1 = new CartesianPoint(1,0);
		CartesianPoint pt2 = new CartesianPoint(3,4);
		CartesianPoint pt3 = new CartesianPoint(0,0);
		CartesianPoint pt4 = new CartesianPoint(-1,-1);
		
		CartesianPoint pt1Rot = new CartesianPoint(0,1);
		CartesianPoint pt2Rot = new CartesianPoint(-4,3);
		CartesianPoint pt3Rot = new CartesianPoint(0,0);
		CartesianPoint pt4Rot = new CartesianPoint(1, -1);
		
		Check.check(pt1.xCoordinate(), 1);
		Check.check(pt2.xCoordinate(), 3);
		Check.check(pt3.xCoordinate(), 0);
		Check.check(pt4.xCoordinate(), -1);
		
		Check.check(pt1.yCoordinate(), 0);
		Check.check(pt2.yCoordinate(), 4);
		Check.check(pt3.yCoordinate(), 0);
		Check.check(pt4.yCoordinate(), -1);
		
		Check.check(pt1.radius(), 1);
		Check.check(pt2.radius(),  5);
		Check.check(pt3.radius(), 0);
		Check.check(pt4.radius(), Math.sqrt(2));
		
		Check.check(pt1.angle(), 0);
		Check.check(pt2.angle(), Math.atan2(4,3)); 
		Check.check(pt3.angle(), 0);
		Check.check(pt4.angle(), Math.atan2(-1,-1));
		
		Check.check(pt1.rotate90().xCoordinate(), pt1Rot.xCoordinate());
		Check.check(pt2.rotate90().xCoordinate(), pt2Rot.xCoordinate());
		Check.check(pt3.rotate90().xCoordinate(), pt3Rot.xCoordinate());
		Check.check(pt4.rotate90().xCoordinate(), pt4Rot.xCoordinate());

		Check.check(pt1.rotate90().yCoordinate(), pt1Rot.yCoordinate());
		Check.check(pt2.rotate90().yCoordinate(), pt2Rot.yCoordinate());
		Check.check(pt3.rotate90().yCoordinate(), pt3Rot.yCoordinate());
		Check.check(pt4.rotate90().yCoordinate(), pt4Rot.yCoordinate());
	}

	public static void main(String [] args)
	{
		testCartesianPoint();
	}
}
