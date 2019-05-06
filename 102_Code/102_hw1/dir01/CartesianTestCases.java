public class CartesianTestCases
{
   public static void main(String [] args)
   {
      Point a = new CartesianPoint(1.0,1.0);
      Point b = new CartesianPoint(2.0,1.0);
      
      Check.check(a.xCoordinate(),1.0);
      Check.check(a.yCoordinate(),1.0);
      
      Check.check(b.xCoordinate(),2.0);
      Check.check(b.yCoordinate(),1.0);
      
      Check.check(a.radius(),Math.sqrt(2));
      Check.check(b.radius(),Math.sqrt(4+1));

      Check.check(a.angle(),45.0*Math.PI/180);
      Check.check(b.angle(),26.5651*Math.PI/180);
      
      Check.check(a.rotate90().angle(),135.0*Math.PI/180);
      Check.check(b.rotate90().angle(),(26.5651+90)*Math.PI/180);
   }
}
