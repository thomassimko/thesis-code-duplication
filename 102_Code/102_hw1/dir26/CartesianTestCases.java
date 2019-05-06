public class CartesianTestCases
{
	public static void main (String[] args)
	{
		Point a = new CartesianPoint(1,1);
		Check.check(a.xCoordinate(), 1);
		Check.check(a.yCoordinate(), 1);
		Check.check(a.radius(), 1.414213562);
		Check.check(a.rotate90().xCoordinate(), -1);
		Check.check(a.rotate90().yCoordinate(), 1);
		Check.check(a.angle(), 0.7853);
		 
				 
		Point d = new CartesianPoint(0,0);
		Check.check(d.xCoordinate(), 0);
		Check.check(d.yCoordinate(), 0);
		Check.check(d.radius(), 0);
		Check.check(d.angle(), 0);
		Check.check(d.rotate90().xCoordinate(), 0);
		Check.check(d.rotate90().yCoordinate(), 0);
		
		Point e = new CartesianPoint(4.0, 3.0);
		Check.check(e.xCoordinate(), 4.0);
		Check.check(e.yCoordinate(), 3.0);
		Check.check(e.radius(), 5.0);
		Check.check(e.angle(), 0.6435);  
		Check.check(e.rotate90().xCoordinate(), -3.0);
		Check.check(e.rotate90().yCoordinate(), 4.0);
		
		Point c = new CartesianPoint(5.0, -2.0);
		Check.check(c.xCoordinate(), 5.0);
		Check.check(c.yCoordinate(), -2.0);
		Check.check(c.radius(), 5.3851);
		Check.check(c.angle(), 5.9026);  
		Check.check(c.rotate90().xCoordinate(), 2.0);
		Check.check(c.rotate90().yCoordinate(), 5.0);

	}
}

