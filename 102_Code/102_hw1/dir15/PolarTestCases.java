public class PolarTestCases
{
   public static void main(String [] args)
   {
      Point p1 = new PolarPoint(1.0, 90.0);
      Point p2 = new PolarPoint(2.0, 45.0);
      Point p3 = p1.rotate90();
      Point p4 = p2.rotate90();
      Check.check(p1.xCoordinate(), 0);
      Check.check(p1.yCoordinate(), 1.0);
      Check.check(p2.xCoordinate(), 2.0/Math.sqrt(2));
      Check.check(p2.yCoordinate(), 2.0/Math.sqrt(2));
      Check.check(p4.xCoordinate(), -2.0/Math.sqrt(2));
      Check.check(p4.yCoordinate(), 2.0/Math.sqrt(2));
      Check.check(p2.angle(), 45.0);
      Check.check(p4.angle(), 135.0);
      Check.check(p4.radius(), 2.0);
      Check.check(p3.radius(), 1.0);
   }
}
