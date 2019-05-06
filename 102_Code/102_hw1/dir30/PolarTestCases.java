public class PolarTestCases{
	public static void test_zero()
	{
		PolarPoint testP = new PolarPoint(0,0);
		Check.check(testP.xCoordinate(), 0);
		Check.check(testP.yCoordinate(), 0);
		Check.check(testP.radius(), 0);
		Check.check(testP.angle(), 0);
		PolarPoint testP_Rotated = (PolarPoint) testP.rotate90();
		Check.check(testP_Rotated.angle(), Math.PI/2);
	}
	
	public static void test_negativeCoords()
	{
		PolarPoint testP = new PolarPoint(-1,(-3 * Math.PI)/4);
		Check.check(testP.xCoordinate(), Math.sqrt(2)/2);
		Check.check(testP.yCoordinate(), Math.sqrt(2)/2);
		Check.check(testP.radius(), 1);
		Check.check(testP.angle(), (Math.PI)/4);
		PolarPoint testP_Rotated = (PolarPoint) testP.rotate90();
		Check.check(testP_Rotated.angle(), (3 * Math.PI)/4);
	}
	
	public static void test_positiveCoords()
	{
		PolarPoint testP = new PolarPoint(1,Math.PI/2);
		Check.check(testP.xCoordinate(), 0);
		Check.check(testP.yCoordinate(), 1);
		Check.check(testP.radius(), 1);
		Check.check(testP.angle(), Math.PI/2);
		PolarPoint testP_Rotated = (PolarPoint) testP.rotate90();
		Check.check(testP_Rotated.angle(), Math.PI);
	}

	public static void main(String [] args)
	{
		test_zero();
		test_negativeCoords();
		test_positiveCoords();
	}
}