public class PolarTestCases
{
   public static void main(String [] args)
   {
      Point p1 = new PolarPoint(2, Math.PI/4);
      Point p2 = p1.rotate90();
		Point p3 = new PolarPoint(-3, -13*Math.PI/6);
		Point p4 = p3.rotate90();
		
		Check.check(p1.xCoordinate(), 1.41421);
		Check.check(p1.yCoordinate(), 1.41421);
		Check.check(p1.radius(), 2);
		Check.check(p1.angle(), 0.78539);
		Check.check(p2.xCoordinate(), -1.41421);
		Check.check(p2.yCoordinate(), 1.41421);
		
		Check.check(p3.xCoordinate(), -2.59807);
		Check.check(p3.yCoordinate(), 1.5);
		Check.check(p3.radius(), 3);
		Check.check(p3.angle(), 2.61799);
		Check.check(p4.xCoordinate(), -1.5);
		Check.check(p4.yCoordinate(), -2.59807);
	}
}


      
