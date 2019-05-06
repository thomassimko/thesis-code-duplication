import java.util.Scanner;
import java.lang.Math;
import java.util.ArrayList;
import java.util.List;

public class PointRelation
{
   public static double calcDistance(Point point1, Point point2)
   {
      return (Math.sqrt((point2.xCoordinate()-point1.xCoordinate())*
         (point2.xCoordinate()-point1.xCoordinate())          
         + (point2.yCoordinate()-point1.yCoordinate())*
         (point2.yCoordinate()-point1.yCoordinate())));
   }

   public static int findQuadrant(Point point)
   {
      if (point.angle() >= 0 && point.angle() < Math.PI/2)
      {
         return 1;
      }
      else if (point.angle() >= Math.PI/2 && point.angle() < Math.PI)
      {
         return 2;
      }
      else if (point.angle() >= Math.PI && point.angle() < 3*Math.PI/2)
      {
         return 3;
      }
      else
      {
         return 4;
      }
   }

   public static boolean inSameQuadrant(Point point1, Point point2)
   {
      if (findQuadrant(point1) == findQuadrant(point2))
      {
         return true;
      }

      return false; 
   }

   public static void main(String [] args)
   {
      List<Point> points = new ArrayList<Point>();
      int pointType;

      for (int i = 0; i < 2; i++)
      {
         System.out.print("Which type of point should be created (1 for Cartesian, 2 for Polar)? ");
         Scanner scanner = new Scanner(System.in);

         pointType = scanner.nextInt();

         if (pointType == 1)
         {
            System.out.print("Enter x-coordinate: ");
            double x_coord = scanner.nextDouble();

            System.out.print("Enter y-coordinate: ");
            double y_coord = scanner.nextDouble();

            points.add(i, new CartesianPoint(x_coord, y_coord));
         }

         else if (pointType == 2)
         {
            System.out.print("Enter radius: ");
            double radius = scanner.nextDouble();

            System.out.print("Enter angle (in degrees): ");
            double angle = scanner.nextDouble()*(Math.PI/180);

            points.add(i, new PolarPoint(radius, angle));
         }

         else
         {
            System.out.println("Invalid value entered");
            System.exit(1);
         }
      }

      double distance = PointRelation.calcDistance (points.get(0), points.get(1));

      System.out.println("Distance between points: " + distance);

      if (PointRelation.inSameQuadrant(points.get(0), points.get(1)))
      {
         System.out.println("In same quadrant.");
      }
      else
      {
         System.out.println("Not in same quadrant.");
      }
   }
}
