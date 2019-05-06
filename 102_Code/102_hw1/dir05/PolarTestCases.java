public class PolarTestCases
{
   public static Point pt = new PolarPoint(1.0, 2.0*Math.PI);
   public static Point pt1 = new PolarPoint(4.0, -45*(Math.PI/180.0));
   public static Point pt2 = new PolarPoint(0.0, Math.PI);

   public static void testRadius()
   {
      Check.check(pt.radius(), 1.0);
      Check.check(pt1.radius(), 4.0);
      Check.check(pt2.radius(), 0.0);
   }
   public static void testAngle()
   {
      Check.check(pt.angle(), 2.0*Math.PI);
      Check.check(pt1.angle(), 7.0*(Math.PI/4.0));
      Check.check(pt2.angle(), Math.PI);
   }
   public static void testXCoord()
   {
      Check.check(pt.xCoordinate(), 1.0);
      Check.check(pt1.xCoordinate(), 2*Math.sqrt(2));
      Check.check(pt2.xCoordinate(), 0.0);
   }
   public static void testYCoord()
   {
      Check.check(pt.yCoordinate(), 0.0);
      Check.check(pt1.yCoordinate(), -2*Math.sqrt(2));
      Check.check(pt2.yCoordinate(), 0.0);
   }
   public static void testRotate90()
   {
      Check.check(pt.rotate90().radius(), 1.0);
      Check.check(pt.rotate90().angle(), 2.0*Math.PI+(1.0/2.0)*Math.PI);
      Check.check(pt1.rotate90().radius(), 4.0);
      Check.check(pt1.rotate90().angle(), 7.0*(Math.PI/4.0)+(1.0/2.0)*Math.PI);
      Check.check(pt2.rotate90().radius(), 0.0);
      Check.check(pt2.rotate90().angle(), Math.PI+(1.0/2.0)*Math.PI);
   }
   public static void main(String [] args)
   {
      testRadius();
      testAngle();
      testXCoord();
      testYCoord();
      testRotate90();
   }
}
