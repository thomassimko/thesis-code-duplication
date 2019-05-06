import java.util.Scanner;

public class PointRelation
{
   public static void main(String[] args)
   {
      double degree2, distance2;
      int degree, x_coord, y_coord, radius, result, result2;
      Point point1;
      Point point2;

      Scanner in = new Scanner(System.in);
      System.out.print("Which type of point should be created");
      System.out.print(" (1 for Cartesion, 2 for Polar)? ");
      result = in.nextInt();
      if ( result == 1)
      {
          System.out.print("Enter x-coordinate: ");
          x_coord = in.nextInt();
          System.out.print("Enter y-coordinate: ");
          y_coord = in.nextInt();
          point1 = new CartesianPoint(x_coord, y_coord);
      }
      else
      {
         if (result ==2)
         {
             System.out.print("Enter radius: ");
             radius = in.nextInt();
             System.out.print("Enter angle (in degrees): ");
             degree = in.nextInt();
             degree2 = degree * Math.PI / 180;
             point1 = new PolarPoint(radius, degree2);
         }
         else
         {
            System.out.println("Invalid value. Try again next time.");
            System.exit(1);
            return;
         }
      }
      System.out.print("Which type of point should be created");
      System.out.print(" (1 for Cartesion, 2 for Polar)? ");
      result = in.nextInt();
      if ( result == 1)
      {
          System.out.print("Enter x-coordinate: ");
          x_coord = in.nextInt();
          System.out.print("Enter y-coordinate: ");
          y_coord = in.nextInt();
          point2 = new CartesianPoint(x_coord, y_coord);
      }
      else
      {
         if (result ==2)
         {
             System.out.print("Enter radius: ");
             radius = in.nextInt();
             System.out.print("Enter angle (in degrees): ");
             degree = in.nextInt();
             degree2 = degree * Math.PI / 180;
             point2 = new PolarPoint(radius, degree2);
         }
         else
         {
            System.out.println("Invalid value. Try again next time.");
            System.exit(1);
            return;
         }
      }
    distance2 = distance(point1, point2);
    System.out.println("Distance between points: " + distance2);

    result2 = samequad(point1, point2);

      if (result2 == 1)
      {
         System.out.println("In same quadrant");
      }
      else
      {
         System.out.println("Not in same quadrant");
      }
   }

   public static double distance(Point pointA, Point pointB)
   {
      double distance_x = pointA.xCoordinate() - pointB.xCoordinate();
      double distance_y = pointA.yCoordinate() - pointB.yCoordinate();
      double distance =  Math.sqrt(distance_x * distance_x + 
                         distance_y * distance_y);
      return distance;
   }

   public static int samequad(Point pointA, Point pointB)
   {
      if (pointA.xCoordinate() < 0 && pointB.xCoordinate() < 0 && 
          pointA.yCoordinate() < 0 && pointB.yCoordinate() < 0)
      {
         return 1;
      }
      else
      {
         if (pointA.xCoordinate() < 0 && pointB.xCoordinate() < 0 &&
             pointA.yCoordinate() > 0 && pointB.yCoordinate() > 0)
         {
            return 1;
         }
         else
         {
            if (pointA.xCoordinate() > 0 && pointB.xCoordinate() > 0 && 
               pointA.yCoordinate() < 0 && pointB.yCoordinate() < 0)
            {
               return 1;
            }
            else
            {
               if (pointA.xCoordinate() > 0 && pointB.xCoordinate() > 0 && 
                   pointA.yCoordinate() > 0 && pointB.yCoordinate() > 0)
               {
                  return 1;
               }
               else
               {
                  return 0;
               }
            }
         }
      }
   }
}
