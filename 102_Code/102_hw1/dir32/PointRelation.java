import java.util.Scanner;

public class PointRelation
{
  public static void main(String [] args)
  {
    Scanner sc = new Scanner(System.in);
    int pt1;
    int pt2;
    double prompt1;
    double prompt2;
    double prompt3;
    double prompt4;
    Point p1 = new CartesianPoint(0,0);
    Point p2 = new CartesianPoint(0,0);
    
    System.out.print("Which type of point should be created (1 for Cartesion, 2 for Polar)? ");
    
    pt1 = sc.nextInt();

    if (pt1 == 1)
    {
      System.out.print("Enter x-coordinate: ");
      prompt1 = sc.nextDouble();
      System.out.print("Enter y-coordinate: ");
      prompt2 = sc.nextDouble();

      p1 = new CartesianPoint(prompt1, prompt2);
    }
    else if (pt1 == 2)
    {
      System.out.print("Enter radius: ");
      prompt1 = sc.nextDouble();
      System.out.print("Enter angle in degrees: ");
      prompt2 = sc.nextDouble();

      p1 = new PolarPoint(prompt1, prompt2);
    }
    else
    {
      System.out.println("Invalid imput");
      System.exit(1);
    }

    System.out.print("Which type of point should be created (1 for Cartesion, 2 for Polar)? ");
    
    pt2 = sc.nextInt();

    if (pt2 == 1)
    {
      System.out.print("Enter x-coordinate: ");
      prompt3 = sc.nextDouble();
      System.out.print("Enter y-coordinate: ");
      prompt4 = sc.nextDouble();

      p2 = new CartesianPoint(prompt3, prompt4);
    }
    else if (pt2 == 2)
    {
      System.out.print("Enter radius: ");
      prompt3 = sc.nextDouble();
      System.out.print("Enter angle in degrees: ");
      prompt4 = sc.nextDouble();

      p2 = new PolarPoint(prompt3, prompt4);
    }
    else
    {
      System.out.println("Invalid imput");
      System.exit(1);
    }

    System.out.println("Distance between points: " + distance(p1,p2));

    double quad;

    quad = quadrant(p1,p2);

    if (quad == 1)
    {
      System.out.println("In same quadrant.");
    }
    else
    {
      System.out.println("Not in same quadrant.");
    }
  }

  private static double distance(Point p1, Point p2)
  {
    double x_diff;
    double y_diff;
    double distance;

    x_diff = p1.xCoordinate() - p2.xCoordinate();
    y_diff = p1.yCoordinate() - p2.yCoordinate();

    distance = Math.sqrt(x_diff * x_diff + y_diff * y_diff);

    return distance;
  }

  private static int quadrant(Point p1, Point p2)
  {
    double p1x = p1.xCoordinate();
    double p1y = p1.yCoordinate();
    double p2x = p2.xCoordinate();
    double p2y = p2.yCoordinate();

    int p1quad;
    int p2quad;

    if(p1x > 0 && p1y >= 0)
    {
      p1quad = 1;
    }
    else if(p1x <= 0 && p1y > 0)
    {
      p1quad = 2;
    }
    else if(p1x < 0 && p1y <= 0)
    {
      p1quad = 3;
    }
    else
    {
      p1quad = 4;
    }

    if(p2x > 0 && p2y >= 0)
    {
      p2quad = 1;
    }
    else if(p2x <= 0 && p2y > 0)
    {
      p2quad = 2;
    }
    else if(p2x < 0 && p2y <= 0)
    {
      p2quad = 3;
    }
    else
    {
      p2quad = 4;
    }

    if (p1quad == p2quad)
    {
      return 1;
    }
    else
    {
      return 0;
    }
  }
}
