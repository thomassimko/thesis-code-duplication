public class PolarTestCases
{
    public static void testPolarPoint()
    {
	Point p1 = new PolarPoint(1, Math.PI/2);
	Point p1_answer = new PolarPoint(0, 0);
	Point p2 = new PolarPoint(3, 2*Math.PI);
	Point p2_answer = new PolarPoint(0 ,0);
	Check.check(p1.radius(), 1);
	Check.check(p1.angle(), Math.PI/2);
	Check.check(p1.xCoordinate(), Math.cos(p1.angle()));
	Check.check(p1.yCoordinate(), Math.sin(p1.angle()));
	p1_answer = p1.rotate90();
	Check.check(p1_answer.radius(), 1);
	Check.check(p1_answer.angle(), Math.PI);

	Check.check(p2.radius(), 3);
	Check.check(p2.angle(), 2*Math.PI);
	Check.check(p2.xCoordinate(), 3*Math.cos(p2.angle()));
	Check.check(p2.yCoordinate(), 3*Math.sin(p2.angle()));
	p2_answer = p2.rotate90();
	Check.check(p2_answer.radius(), 3);
	Check.check(p2_answer.angle(), 2*Math.PI + (Math.PI)/2);
    }
}