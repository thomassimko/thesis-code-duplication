public class CartesianTestCases
{
  public static void main(String [] args)
  {
    Point pt = new CartesianPoint(0, 1);
    Point pt2 = pt.rotate90();

    Check.check(pt.xCoordinate(), 0);
    Check.check(pt.yCoordinate(), 1);
    Check.check(pt.radius(), 1);
    Check.check(pt.angle(), Math.PI/2);
    Check.check(pt2.xCoordinate(), -1);
    Check.check(pt2.yCoordinate(), 0);
    Check.check(pt2.radius(), 1);
    Check.check(pt2.angle(), Math.PI);
  }
}
