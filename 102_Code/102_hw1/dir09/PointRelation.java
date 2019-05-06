import java.util.Scanner;

public class PointRelation
{
   static Scanner scan = new Scanner(System.in);

   public static void exitError()
   {
      System.out.println("Invalid entry.");
      System.exit(1);
   }

   public static Point readCartesian()
   {
      System.out.print("Enter x-coordinate: ");
      if (scan.hasNextDouble() == true)
      {
         double x = scan.nextDouble();
         System.out.print("Enter y-coordinate: ");
         if (scan.hasNextDouble() == true)
         {
            double y = scan.nextDouble();
            return new CartesianPoint(x, y);
         }
         else exitError();
      }
      else exitError();

      return new CartesianPoint(0, 0);
   }

   public static Point readPolar()
   {
      System.out.print("Enter radius: ");
      if (scan.hasNextDouble() == true)
      {
         double r = scan.nextDouble();
         System.out.print("Enter angle (in degrees): ");
         if (scan.hasNextDouble() == true)
         {
            double a = scan.nextDouble();
            return new PolarPoint(r, a);
         }
         else exitError();
      }
      else exitError();

      return new PolarPoint(0, 0);
   }

   public static Point readPoint()
   {
      System.out.print("What type of point should be created (1 for Cartesian, 2 for Polar)? ");
      if (scan.hasNextInt() == true)
      {
         int choice = scan.nextInt();
         if (choice == 1)
         {
            return readCartesian();
         }
         else if (choice == 2)
         {
            return readPolar();
         }
         else exitError();
      }
      else exitError();

      return new CartesianPoint(0, 0);
   }

   public static double calcDistance(Point pt1, Point pt2)
   {
      double dx = pt2.xCoordinate() - pt1.xCoordinate();
      double dy = pt2.yCoordinate() - pt1.yCoordinate();
      return Math.sqrt((dx * dx) + (dy * dy));
   }

   public static int checkQuadrant(Point pt)
   {
      if ((pt.xCoordinate() == 0) && (pt.yCoordinate() == 0))
         return 0;
      else if ((pt.xCoordinate() > 0) && (pt.yCoordinate() >= 0))
         return 1;
      else if ((pt.xCoordinate() <= 0) && (pt.yCoordinate() > 0))
         return 2;
      else if ((pt.xCoordinate() < 0) && (pt.yCoordinate() <= 0))
         return 3;
      else
         return 4;
   }

   public static void checkSameQuadrant(Point pt1, Point pt2)
   {
      int quad1 = checkQuadrant(pt1);
      int quad2 = checkQuadrant(pt2);

     if (quad1 == quad2)
     {
        System.out.println("In same quadrant.");
     }
     else
     {
        System.out.println("Not in same quadrant.");
     } 
   }

   public static void main(String [] args)
   {
      Point pt1, pt2;
     
      pt1 = readPoint();
      pt2 = readPoint();

      System.out.println("Distance between points: " + calcDistance(pt1, pt2));
      checkSameQuadrant(pt1, pt2);      
   }
}
