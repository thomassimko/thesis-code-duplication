public class CartesianTestCases
{
    public static void testCartesianPoint()
    {
	Point p1 = new CartesianPoint(2, 4);
	Point p1_answer = new CartesianPoint(0, 0);
        Point p2 = new CartesianPoint(3, 7);
	Point p2_answer = new CartesianPoint(0, 0);

	Check.check(p1.xCoordinate(), 2);
	Check.check(p1.yCoordinate(), 4);
	Check.check(p1.radius(), Math.sqrt(20));
	Check.check(p1.angle(), Math.atan2(4, 2));
	p1_answer = p1.rotate90();
	Check.check(p1_answer.xCoordinate(), -4);
	Check.check(p1_answer.yCoordinate(), 2);

	Check.check(p2.xCoordinate(), 3);
	Check.check(p2.yCoordinate(), 7);
	Check.check(p2.radius(), Math.sqrt(58));
	Check.check(p2.angle(), Math.atan2(7, 3));
	p2_answer = p2.rotate90();
	Check.check(p2_answer.xCoordinate(), -7);
	Check.check(p2_answer.yCoordinate(), 3);
    }
}