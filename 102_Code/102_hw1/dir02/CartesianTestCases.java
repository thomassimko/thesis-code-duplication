public class CartesianTestCases
{
   public static void main(String [] args)
   {
      Point testPoint = new CartesianPoint(0.0, 0.0);
      Check.check(testPoint.xCoordinate(), 0.0);
      Check.check(testPoint.yCoordinate(), 0.0);
      Check.check(testPoint.radius(), 0.0);
      Check.check(testPoint.angle(), 0.0);
      Check.check((testPoint.rotate90()).xCoordinate(), 0.0);
      Check.check((testPoint.rotate90()).yCoordinate(), 0.0);
   }
}
