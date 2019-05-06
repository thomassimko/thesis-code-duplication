public class PolarTestCases
{
   public static void main(String [] args)
   {
      Point c = new PolarPoint(1.0,0.0);
      Point d = new PolarPoint(5.0,90.0);
      Point Zero = new PolarPoint(0,-355);
      
      Check.check(c.xCoordinate(),1.0);
      Check.check(c.yCoordinate(),0.0);
      
      Check.check(d.xCoordinate(),0.0);
      Check.check(d.yCoordinate(),5.0);
      
      Check.check(c.radius(),1.0);
      Check.check(d.radius(),5.0);

      Check.check(c.angle(),0.0);
      Check.check(d.angle(),90.0);

      Check.check(c.rotate90().angle(),Math.PI/2);
      Check.check(d.rotate90().angle(),Math.PI);
      
      
      Check.check(Zero.xCoordinate(),0);
      Check.check(Zero.yCoordinate(),0);
      Check.check(Zero.radius(),0);
      Check.check(Zero.angle(),5);
   }
}
