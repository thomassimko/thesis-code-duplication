public class CartesianTestCases
{
    public static void main(String args[])
    {
	CartesianPoint test1 = new CartesianPoint(0, 0);
	CartesianPoint test2 = new CartesianPoint(3, 4);
	CartesianPoint test1r = test1.rotate90();
	CartesianPoint test2r = test2.rotate90();
	
	Check.check(test1.xCoordinate(), 0);
	Check.check(test1.yCoordinate(), 0);
	Check.check(test1.radius(), 0);
	Check.check(test1.angle(), 0);
	Check.check(test1r.xCoordinate(), 0);
	Check.check(test1r.yCoordinate(), 0);
	
	Check.check(test2.xCoordinate(), 3.0);
	Check.check(test2.yCoordinate(), 4.0);
	Check.check(test2.radius(), 5.0);
	Check.check(test2.angle(), 0.92729518);
	Check.check(test2r.xCoordinate(), -4.0);
	Check.check(test2r.yCoordinate(), 3.0);	
    }
}
