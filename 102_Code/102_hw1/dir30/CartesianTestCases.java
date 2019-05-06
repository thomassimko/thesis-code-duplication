public class CartesianTestCases{
	public static void test_zero()
	{
		CartesianPoint testC = new CartesianPoint(0,0);
		Check.check(testC.xCoordinate(), 0);
		Check.check(testC.yCoordinate(), 0);
		Check.check(testC.radius(), 0);
		Check.check(testC.angle(), 0);
		CartesianPoint testC_Rotated = (CartesianPoint) testC.rotate90();
		Check.check(testC_Rotated.angle(), 0);
	}
	
	public static void test_negativeCoords()
	{
		CartesianPoint testC = new CartesianPoint(-1,-1);
		Check.check(testC.xCoordinate(), -1);
		Check.check(testC.yCoordinate(), -1);
		Check.check(testC.radius(), Math.sqrt(2));
		Check.check(testC.angle(), (5*Math.PI)/4);
		CartesianPoint testC_Rotated = (CartesianPoint) testC.rotate90();
		Check.check(testC_Rotated.angle(), (7*Math.PI)/4);
	}
	
	public static void test_positiveCoords()
	{
		CartesianPoint testC = new CartesianPoint(1,1);
		Check.check(testC.xCoordinate(), 1);
		Check.check(testC.yCoordinate(), 1);
		Check.check(testC.radius(), Math.sqrt(2));
		Check.check(testC.angle(), (Math.PI)/4);
		CartesianPoint testC_Rotated = (CartesianPoint) testC.rotate90();
		Check.check(testC_Rotated.angle(), (3*Math.PI)/4);
	}

	public static void main(String [] args)
	{
		test_zero();
		test_negativeCoords();
		test_positiveCoords();
	}
}