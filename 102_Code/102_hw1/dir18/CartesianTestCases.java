public class CartesianTestCases
{

  public static void testXCoord()
  {
    Point pt = new CartesianPoint(1.0, 1.0);
    Check.check(pt.xCoordinate(), 1.0);

    pt = new CartesianPoint(9.0, 1.0);
    Check.check(pt.xCoordinate(), 9.0);    
  }

  public static void testYCoord()
  {
    Point pt = new CartesianPoint(1.0, 1.0);
    Check.check(pt.yCoordinate(), 1.0);

    pt = new CartesianPoint(1.0, 9.0);
    Check.check(pt.yCoordinate(), 9.0);
  }

  public static void testRadius()
  {
    Point pt = new CartesianPoint(1.0, 1.0);
    Check.check(pt.radius(), Math.sqrt(2) );

    pt = new CartesianPoint(3.0, 4.0);
    Check.check(pt.radius(), 5.0);
  }

  public static void testAngle()
  {
    Point pt = new CartesianPoint(1.0, 1.0);
    Check.check(pt.angle(), Math.PI / 4 );

    pt = new CartesianPoint(0, 17.0);
    Check.check(pt.angle(), Math.PI / 2);

    pt = new CartesianPoint(0, 0);
    Check.check(pt.angle(), 0);
  }

  public static void testRotate90()
  {
    Point pt = new CartesianPoint(1,0);
    Point pt1 = new CartesianPoint(0,1);
    Point pt2 = pt.rotate90();

    Check.check(pt1.xCoordinate(), pt2.xCoordinate() );
    Check.check(pt1.yCoordinate(), pt2.yCoordinate() );
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
