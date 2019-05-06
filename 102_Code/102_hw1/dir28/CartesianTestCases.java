public class CartesianTestCases
{
	public static void main (String[]args)
	{
		Point a = new CartesianPoint(4.0, 3.0);
		Check.check(a.xCoordinate(), 4.0);
		Check.check(a.yCoordinate(), 3.0);
		Check.check(a.radius(), 5.0);
		Check.check(a.angle(), 0.6435);  
		Check.check(a.rotate90().xCoordinate(), -3.0);
		Check.check(a.rotate90().yCoordinate(), 4.0);
		
		Point b = new CartesianPoint(-5.0, -2.0);
		Check.check(b.xCoordinate(), -5.0);
		Check.check(b.yCoordinate(), -2.0);
		Check.check(b.radius(), 5.3851);
		Check.check(b.angle(), 3.5220);  
		Check.check(b.rotate90().xCoordinate(), 2.0);
		Check.check(b.rotate90().yCoordinate(), -5.0);
		
		Point c = new CartesianPoint(5.0, -2.0);
		Check.check(c.xCoordinate(), 5.0);
		Check.check(c.yCoordinate(), -2.0);
		Check.check(c.radius(), 5.3851);
		Check.check(c.angle(), 5.9026);  
		Check.check(c.rotate90().xCoordinate(), 2.0);
		Check.check(c.rotate90().yCoordinate(), 5.0);
		
		Point d = new CartesianPoint(-5.0, 2.0);
		Check.check(d.xCoordinate(), -5.0);
		Check.check(d.yCoordinate(), 2.0);
		Check.check(d.radius(), 5.3851);
		Check.check(d.angle(), 2.7610);  
		Check.check(d.rotate90().xCoordinate(), -2.0);
		Check.check(d.rotate90().yCoordinate(), -5.0);
	}
}