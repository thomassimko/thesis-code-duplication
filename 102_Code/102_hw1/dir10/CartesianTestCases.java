public class CartesianTestCases
{
   public static void main(String [] args)
   {
      Point p1 = new CartesianPoint(3, 5);
      Point p2 = p1.rotate90();
		Point p3 = new CartesianPoint(0, 0);
		Point p4 = p3.rotate90();

      Check.check(p1.xCoordinate(), 3);
      Check.check(p1.yCoordinate(), 5);
      Check.check(p1.radius(), 5.83095);
      Check.check(p1.angle(), 1.03037);
      Check.check(p2.xCoordinate(), -5);
      Check.check(p2.yCoordinate(), 3);
		
		Check.check(p3.xCoordinate(), 0);
		Check.check(p3.yCoordinate(), 0);
		Check.check(p3.radius(), 0);
		Check.check(p3.angle(), 0);
		Check.check(p4.xCoordinate(), 0);
		Check.check(p4.yCoordinate(), 0);
   }
}

