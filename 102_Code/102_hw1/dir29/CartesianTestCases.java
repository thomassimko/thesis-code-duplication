public class CartesianTestCases
{
   public static void main(String [] args)
   {
      Point p = new CartesianPoint(2.0, 2.0);
      Point p90 = p.rotate90();
      Check.check(p.xCoordinate(), 2.0);
      Check.check(p.yCoordinate(), 2.0);
      Check.check(p.radius(), 2.8284271247461903);
      Check.check(p.angle(), 45.0);
      Check.check(p90.xCoordinate(), -2.0);
      Check.check(p90.yCoordinate(), 2.0);
   
      Point p1 = new CartesianPoint(1.0, 3.0);
      Point p901 = p1.rotate90();
      Check.check(p1.xCoordinate(), 1.0);
      Check.check(p1.yCoordinate(), 3.0);
      Check.check(p1.radius(), 3.1622776601683795);
      Check.check(p1.angle(), 71.565);
      Check.check(p901.xCoordinate(), -3.0);
      Check.check(p901.yCoordinate(), 1.0);
      
      Point p2 = new CartesianPoint(0.0,0.0);
      Point p902 = p2.rotate90();
      Check.check(p2.xCoordinate(), 0.0);
      Check.check(p2.yCoordinate(), 0.0);
      Check.check(p2.radius(), 0.0);
      Check.check(p2.angle(), 0.0);
      Check.check(p902.xCoordinate(), 0.0);
      Check.check(p902.yCoordinate(), 0.0);
   }
}
