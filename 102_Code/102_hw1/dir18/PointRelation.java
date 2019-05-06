import java.util.*;

public class PointRelation
{
  public static void main(String [] args)
  {
    Scanner in = new Scanner(System.in);
    Point pt1, pt2;

    pt1 = getPoint(in);
    pt2 = getPoint(in);

    System.out.println("Distance between points: " + pointDistance(pt1, 
      pt2) );

    if( sameQuadrant(pt1, pt2) )
      System.out.println("In same quadrant.");
    else
      System.out.println("Not in same quadrant.");
  }

  private static Point getPoint(Scanner in)
  {
    int choice = 0;

    System.out.print("What type of point should be created" + 
      "(1 for Cartesian, 2 for Polar)? ");

    try
    {
      choice = in.nextInt();
    }
    catch(InputMismatchException e)
    {
      System.out.println("InputMismatchException " + e.getMessage());
      System.exit(1);
    }
    catch(NoSuchElementException e)
    {
      System.out.println("NoSuchElementException " + e.getMessage());
      System.exit(1);
    }

    if( choice == 1 )
      return cartesianGenerator(in);
    else if( choice == 2 )
      return polarGenerator(in);
    else
      return new CartesianPoint(0,0);
  }

  private static Point cartesianGenerator(Scanner in)
  {
    double x = 0, y = 0;

    System.out.print("Enter the x-coordinate: ");
    try
    {
      x = in.nextDouble();
    }
    catch(InputMismatchException e)
    {
      System.out.println("InputMismatchException " + e.getMessage());
      System.exit(1);
    }
    catch(NoSuchElementException e)
    {
      System.out.println("NoSuchElementException " + e.getMessage());
      System.exit(1);
    }

    System.out.print("Enter the y-coordinate: ");
    try
    {
      y = in.nextDouble();
    }
    catch(InputMismatchException e)
    {
      System.out.println("InputMismatchException " + e.getMessage());
      System.exit(1);
    }
    catch(NoSuchElementException e)
    {
      System.out.println("NoSuchElementException " + e.getMessage());
      System.exit(1);
    }

    return new CartesianPoint(x,y);
  }

  private static Point polarGenerator(Scanner in)
  {
    double radius = 0, angle = 0;

    System.out.print("Enter the radius: ");
    try
    {
      radius = in.nextDouble();
    }
    catch(InputMismatchException e)
    {
      System.out.println("InputMismatchException " + e.getMessage());
      System.exit(1);
    }
    catch(NoSuchElementException e)
    {
      System.out.println("NoSuchElementException " + e.getMessage());
      System.exit(1);
    }

    System.out.print("Enter the angle (in degrees): ");
    try
    {
      angle = in.nextDouble();
    }
    catch(InputMismatchException e)
    {
      System.out.println("InputMismatchException " + e.getMessage());
      System.exit(1);
    }
    catch(NoSuchElementException e)
    {
      System.out.println("NoSuchElementException " + e.getMessage());
      System.exit(1);
    }

    return new PolarPoint(radius, angle);
  }

  public static double pointDistance(Point pt1, Point pt2)
  {
    double x1 = pt1.xCoordinate();
    double x2 = pt2.xCoordinate();
    double y1 = pt1.yCoordinate();
    double y2 = pt2.yCoordinate();

    double dx = x1 - x2;
    double dy = y1 - y2;

    return Math.sqrt( dx * dx + dy * dy );
  }

  public static boolean sameQuadrant(Point pt1, Point pt2)
  {
    int quad1 = quadrant(pt1);
    int quad2 = quadrant(pt2);

    if( quad1 == quad2 )
      return true;
    return false;
  }

  public static int quadrant(Point pt)
  {
/*    double x = pt.xCoordinate();
    double y = pt.yCoordinate();

    if( x >= 0 )
    {
      if( y >= 0 )
        return 1;
      return 4;
    }
    if( y >= 0 )
      return 2;
    return 3;*/

    int quad = 1;
    double angle = pt.angle();

    while(angle > 90)
    {
      angle -= 90;
      quad++;
    }

    return quad;
  }
}
