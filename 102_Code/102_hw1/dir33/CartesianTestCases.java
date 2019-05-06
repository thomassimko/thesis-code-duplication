public class CartesianTestCases
{
   public static void main(String args[])
   {
      Point a = new CartesianPoint(1.0,2.0);
      Point b = new CartesianPoint(2.0,3.0);

      Check.check(a.xCoordinate(),1.0);
      Check.check(a.yCoordinate(),2.0);

      Check.check(b.xCoordinate(),2.0);
      Check.check(b.yCoordinate(),3.0);

      Check.check(a.radius(),Math.sqrt(5.0));
      Check.check(b.radius(),Math.sqrt(13.0));

      Check.check(a.angle(), Math.atan2(2.0,1.0));
      Check.check(b.angle(), Math.atan2(3.0,2.0));

      Check.check(a.rotate90().angle(), Math.atan2(2.0,1.0) + Math.PI/2);
      Check.check(b.rotate90().angle(), Math.atan2(3.0,2.0) + Math.PI/2);
   }
}                                                                         
