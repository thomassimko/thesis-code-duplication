import java.util.Arrays;
import java.lang.Math;

public class CartesianTestCases
{
   public static void main(String [] args)
   {
       Point p1 = new CartesianPoint(3,4);
       Point p2 = p1.rotate90();
       Check.check(p1.xCoordinate(), 3);
       Check.check(p1.yCoordinate(), 4);
       Check.check(p1.radius(), 5);
       Check.check(p1.angle(), 0.92729);
       Check.check(p2.xCoordinate(), -4);
       Check.check(p2.yCoordinate(), 3);

       Point p3 = new CartesianPoint(1,0);
       Point p4 = p3.rotate90();
       Check.check(p3.xCoordinate(), 1);
       Check.check(p3.yCoordinate(), 0);
       Check.check(p3.radius(), 1);
       Check.check(p3.angle(), 0);
       Check.check(p4.xCoordinate(), 0);
       Check.check(p4.yCoordinate(), 1);

       Point p5 = new CartesianPoint(0,1);
       Point p6 = p5.rotate90();
       Check.check(p5.xCoordinate(), 0);
       Check.check(p5.yCoordinate(), 1);
       Check.check(p5.radius(), 1);
       Check.check(p5.angle(), Math.PI/2);
       Check.check(p6.xCoordinate(), -1);
       Check.check(p6.yCoordinate(), 0);



   }
}
