public class CartesianTestCases
{
   public static Point pt = new CartesianPoint(3.0, 4.0);
   public static Point pt1 = new CartesianPoint(1.0, 2.0);
   public static Point pt2 = new CartesianPoint(1.0, 5.0);

   public static void testXCoordinate()
   {
      Check.check(pt.xCoordinate(), 3.0);
      Check.check(pt1.xCoordinate(), 1.0);
      Check.check(pt2.xCoordinate(), 1.0);
   }
   public static void testYCoordinate()
   {
      Check.check(pt.yCoordinate(), 4.0);
      Check.check(pt1.yCoordinate(), 2.0);
      Check.check(pt2.yCoordinate(), 5.0);
   }
   public static void testRadius()
   {
      Check.check(pt.radius(), 5.0);
      Check.check(pt1.radius(), Math.sqrt(5));
      Check.check(pt2.radius(), Math.sqrt(26));
   }
   public static void testAngle()
   {
      Check.check(pt.angle(), .9272952180016122);
      Check.check(pt1.angle(), 1.107148717794090);
      Check.check(pt2.angle(), 1.373400766945015);
   }
   public static void testRotate90()
   {
      Check.check(pt.rotate90().xCoordinate(), -4.0);
      Check.check(pt.rotate90().yCoordinate(), 3.0);
      Check.check(pt1.rotate90().xCoordinate(), -2.0);
      Check.check(pt1.rotate90().yCoordinate(), 1.0);
      Check.check(pt2.rotate90().xCoordinate(), -5.0);
      Check.check(pt2.rotate90().yCoordinate(), 1.0);
   }
   public static void main(String [] args)
   {
      testXCoordinate();
      testYCoordinate();
      testRadius();
      testAngle();
      testRotate90();
   }
}
