public class PolarTestCases
{
   public static void main(String [] args)
   {
      Point testPoint = new PolarPoint(4.0, (-45.0)*(Math.PI/180));
      Check.check(testPoint.xCoordinate(), 2.82);
      Check.check(testPoint.yCoordinate(), -2.82);
      Check.check(testPoint.radius(), 4.0);
      Check.check(testPoint.angle(), 5.497);
      Check.check(testPoint.rotate90().radius(), 4.0);
      Check.check(testPoint.rotate90().angle(), 405*(Math.PI/180));
   }
}
