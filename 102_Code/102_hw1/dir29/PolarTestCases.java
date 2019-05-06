public class PolarTestCases
{
   public static void main(String [] args)
   {
      Point p = new PolarPoint(2.8284271247461903, 45.0);
      Point p90 = p.rotate90();
      Check.check(p.xCoordinate(), 2.0);
      Check.check(p.yCoordinate(), 2.0);
      Check.check(p.radius(), 2.8284271247461903);
      Check.check(p.angle(), 45);
      Check.check(p90.xCoordinate(), -2.0);
      Check.check(p90.yCoordinate(), 2.0);
      
      Point p1 = new PolarPoint(3.1622776601683795, 71.565);
      Point p901 = p1.rotate90();
      Check.check(p1.xCoordinate(), 1.0);
      Check.check(p1.yCoordinate(), 3.0);
      Check.check(p1.radius(), 3.1622776601683795);
      Check.check(p1.angle(), 71.565);
      Check.check(p901.xCoordinate(), -3.0);
      Check.check(p901.yCoordinate(), 1.0);
      
      Point p2 = new PolarPoint(-5.0, -45.0);
      Point p902 = p2.rotate90();
      Check.check(p2.xCoordinate(), -3.5355339059327373);
      Check.check(p2.yCoordinate(), 3.5355339059327373);
      Check.check(p2.radius(), 5.0);
      Check.check(p2.angle(), 135.0);
      Check.check(p902.xCoordinate(), -3.5355339059327373);
      Check.check(p902.yCoordinate(), -3.5355339059327373);
      
      Point p3 = new PolarPoint(0.0, -405.0);
      Point p903 = p3.rotate90();
      Check.check(p3.xCoordinate(), 0.0);
      Check.check(p3.yCoordinate(), 0.0);
      Check.check(p3.radius(), 0.0);
      Check.check(p3.angle(), 315.0);
      Check.check(p903.xCoordinate(), 0.0);
      Check.check(p903.yCoordinate(), 0.0);
   }
}
