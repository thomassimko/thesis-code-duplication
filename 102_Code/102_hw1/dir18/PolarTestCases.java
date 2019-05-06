public class PolarTestCases
{

  public static void testXCoord()
  {
    Point pt = new PolarPoint( Math.sqrt(2), 45 );
    Check.check(pt.xCoordinate(), 1.0);

    pt = new PolarPoint(1.0, 0.0);
    Check.check(pt.xCoordinate(), 1.0);
  }

  public static void testYCoord()
  {
    Point pt = new PolarPoint(Math.sqrt(2), 45 );
    Check.check(pt.yCoordinate(), 1.0);

    pt = new PolarPoint(1.0, 0.0);
    Check.check(pt.yCoordinate(), 0.0);
  }

  public static void testRadius()
  {
    Point pt = new PolarPoint(Math.sqrt(2), 900);
    Check.check(pt.radius(), Math.sqrt(2) );

    pt = new PolarPoint(5.0, -90);
    Check.check(pt.radius(), 5.0);
  }

  public static void testAngle()
  {
    Point pt = new PolarPoint(-1.0, 180);
    Check.check(pt.angle(), 0.0 );

    pt = new PolarPoint(0, 180 );
    Check.check(pt.angle(), 180 );

    pt = new CartesianPoint(0, 0);
    Check.check(pt.angle(), 0);
  }

  public static void testRotate90()
  {
    Point pt = new PolarPoint(1,0);
    Point pt1 = new PolarPoint(1,90);
    Point pt2 = pt.rotate90();

    Check.check(pt1.angle(), pt2.angle() );
    Check.check(pt1.radius(), pt2.radius() );
  }

  public static void main(String [] args)
  {
    testXCoord();
    testYCoord();
    testRadius();
    testAngle();
    testRotate90();
  }
}
