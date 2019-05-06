import java.util.Arrays;
import java.lang.Math;

public class PolarTestCases
{
   public static void main(String [] args)
   {
      Point p1 = new PolarPoint(1,0);
      Point p2 = p1.rotate90();
      Check.check(p1.xCoordinate(), 1);
      Check.check(p1.yCoordinate(), 0);
      Check.check(p1.radius(), 1);
      Check.check(p1.angle(), 0);
      Check.check(p2.radius(), 1);
      Check.check(p2.angle(), Math.PI/2 );

      Point p3 = new PolarPoint(1,Math.PI/2);
      Point p4 = p3.rotate90();
      Check.check(p3.xCoordinate(), 0);
      Check.check(p3.yCoordinate(), 1);
      Check.check(p3.radius(), 1);
      Check.check(p3.angle(), Math.PI/2);
      Check.check(p4.radius(),1 );
      Check.check(p4.angle(),Math.PI );

   }
}
