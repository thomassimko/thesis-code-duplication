public class PolarTestCases
{
  public static void main(String [] args)
  {
    Point pt3 = new PolarPoint(1, 90);
    Point pt4 = pt3.rotate90();

    Check.check(pt3.xCoordinate(), 0);
    Check.check(pt3.yCoordinate(), 1);
    Check.check(pt3.radius(), 1);
    Check.check(pt3.angle(), Math.PI/2);
    Check.check(pt4.xCoordinate(), -1);
    Check.check(pt4.yCoordinate(), 0);
    Check.check(pt4.radius(), 1);
    Check.check(pt4.angle(), Math.PI);
  }
}


