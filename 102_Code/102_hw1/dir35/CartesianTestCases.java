public class CartesianTestCases
{
   public static void main(String [] args)
   {
      Point pt = new CartesianPoint(1.0, 1.0);
      Point pt2 = new CartesianPoint(0.0, 1.5);
      Point pt3 = new CartesianPoint(1.2, 0.0);
      Point pt4 = new CartesianPoint(0.0, 0.0);
      Point pt5 = new CartesianPoint(-2.0, 1.0);

      Check.check(pt.xCoordinate(), 1.0);
      Check.check(pt2.xCoordinate(), 0.0);
      Check.check(pt3.xCoordinate(), 1.2);
      Check.check(pt4.xCoordinate(), 0.0);
      Check.check(pt5.xCoordinate(), -2.0);

      Check.check(pt.yCoordinate(), 1.0);
      Check.check(pt2.yCoordinate(), 1.5);
      Check.check(pt3.yCoordinate(), 0.0);
      Check.check(pt4.yCoordinate(), 0.0);
      Check.check(pt5.yCoordinate(), 1.0);

      Check.check(pt.radius(), Math.sqrt(2));
      Check.check(pt2.radius(), 1.5);
      Check.check(pt3.radius(), 1.2);
      Check.check(pt4.radius(), 0.0);
      Check.check(pt5.radius(), Math.sqrt(5));

      Check.check(pt.angle(), Math.atan2(1.0, 1.0));
      Check.check(pt2.angle(), Math.atan2(1.5, 0.0));
      Check.check(pt3.angle(), Math.atan2(0.0, 1.2));
      Check.check(pt4.angle(), Math.atan2(0.0, 0.0));
      Check.check(pt5.angle(), Math.atan2(1.0, -2.0));

      Check.check(pt.rotate90().xCoordinate(), -1.0);
      Check.check(pt2.rotate90().xCoordinate(), -1.5);
      Check.check(pt3.rotate90().xCoordinate(), 0.0);
      Check.check(pt4.rotate90().xCoordinate(), 0.0);
      Check.check(pt5.rotate90().xCoordinate(), -1.0);

      Check.check(pt.rotate90().yCoordinate(), 1.0);
      Check.check(pt2.rotate90().yCoordinate(), 0.0);
      Check.check(pt3.rotate90().yCoordinate(), 1.2);
      Check.check(pt4.rotate90().yCoordinate(), 0.0);
      Check.check(pt5.rotate90().yCoordinate(), -2.0);

   }
}

