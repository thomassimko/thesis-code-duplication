public class PolarTestCases
{
	public static void testPolarPoint()
	{	
		PolarPoint pt1 = new PolarPoint(1, Math.PI);
		PolarPoint pt2 = new PolarPoint(2, (-2*Math.PI)/3);
		PolarPoint pt3 = new PolarPoint(-2, (3*Math.PI)/4);

		PolarPoint pt1Rot = new PolarPoint(1, (3*Math.PI)/2);
		PolarPoint pt2Rot = new PolarPoint(2, -(Math.PI)/6);
		PolarPoint pt3Rot = new PolarPoint(-2, (5*Math.PI)/4);
		
		Check.check(pt1.xCoordinate(), -1);
		Check.check(pt2.xCoordinate(), -2*Math.sin(Math.PI/6));
		Check.check(pt3.xCoordinate(), 2*Math.sin(Math.PI/4));
		
		Check.check(pt1.yCoordinate(), 0);
		Check.check(pt2.yCoordinate(), -2*Math.cos(Math.PI/6));
		Check.check(pt3.yCoordinate(), -2*Math.cos(Math.PI/4));
		
		Check.check(pt1.radius(), 1);
		Check.check(pt2.radius(), 2);
		Check.check(pt3.radius(), 2);
		
	   Check.check(pt1.angle(), Math.PI);
		Check.check(pt2.angle(), (4*Math.PI)/3); 
		Check.check(pt3.angle(),  (7*Math.PI)/4);
				
		Check.check(pt1.rotate90().radius(), pt1Rot.radius());
		Check.check(pt2.rotate90().radius(), pt2Rot.radius());
		Check.check(pt3.rotate90().radius(), pt3Rot.radius());

		Check.check(pt1.rotate90().angle(), pt1Rot.angle());
		Check.check(pt2.rotate90().angle(), pt2Rot.angle());
		Check.check(pt3.rotate90().angle(), pt3Rot.angle());
	}

	public static void main(String [] args)
	{
		testPolarPoint();
	}
	
}
