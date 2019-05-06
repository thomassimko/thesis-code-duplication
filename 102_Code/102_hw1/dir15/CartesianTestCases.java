public class CartesianTestCases
{
   public static void main(String [] args)
   {
      Point p1 = new CartesianPoint(1, 0);
      Point p2 = new CartesianPoint(0, 1);
      Point p3 = p1.rotate90();
      Point p4 = p2.rotate90();
      Point p5 = new CartesianPoint(1, 1);
      Check.check(p1.xCoordinate(), 1.0);
      Check.check(p1.yCoordinate(), 0);
      Check.check(p3.xCoordinate(), 0);
      Check.check(p3.yCoordinate(), 1.0);
      Check.check(p4.xCoordinate(), -1.0);
      Check.check(p4.yCoordinate(), 0);
      Check.check(p1.radius(), 1.0);
      Check.check(p1.angle(), 0);
      Check.check(p2.radius(), 1.0);
      Check.check(p2.angle(), 90.0);
      Check.check(p5.radius(), Math.sqrt(2));
      Check.check(p5.angle(), 45.0);
   }
}

