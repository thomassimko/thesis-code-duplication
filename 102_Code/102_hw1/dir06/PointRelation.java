import java.util.Scanner;

public class PointRelation
{
   public static void main(String args[])
   {
      Point pt1 = getPoint();
      Point pt2 = getPoint();
      double dis = distance(pt1, pt2);
      System.out.println("Distance between points: "+dis);
      if (sameQuad(pt1, pt2))
      {
         System.out.println("In same quadrant.");
      }
      else System.out.println("Not in same quadrant.");
   }

   public static Point getPoint()
   {
      Scanner scan = new Scanner(System.in);
      System.out.print("Which type of point should be created (1 for Cartesian, 2 for Polar)?");
      int pointType = scan.nextInt();
      if (pointType == 1)
      {
         System.out.print("Enter x-coordinate:");
         double x1coordinate = scan.nextDouble();
         System.out.print("Enter y-coordinate:");
         double y1coordinate = scan.nextDouble();
         Point point = new CartesianPoint(x1coordinate, y1coordinate);
         return point;
      }
      if (pointType == 2)
      {
         System.out.print("Enter radius:");
         double radius = scan.nextDouble();
         System.out.print("Enter angle (in degrees):");
         double angle = scan.nextDouble();
         Point point = new PolarPoint(radius, angle);
         return point;
      } 
      else System.exit(1);
      return null;
   }
   
   public static double distance(Point pt1, Point pt2)
   {
      return Math.sqrt(Math.pow(pt2.xCoordinate()-pt1.xCoordinate(),2)+Math.pow(pt2.yCoordinate()-pt1.yCoordinate(), 2));
   } 

   public static boolean sameQuad(Point pt1, Point pt2)
   {
      if (pt1.xCoordinate() > 0 && pt2.xCoordinate() > 0)
      {
         if (pt1.yCoordinate() > 0 && pt2.yCoordinate() > 0)
         {
            return true;
         }
         if (pt1.yCoordinate() < 0 && pt2.yCoordinate() < 0)
         {
           return true;
         }
         else return false;
      }
      if (pt1.xCoordinate() < 0 && pt2.xCoordinate() < 0)
      {
         if (pt1.yCoordinate() > 0 && pt2.yCoordinate() > 0)
         {
            return true;
         }
         if (pt1.yCoordinate() < 0 && pt2.yCoordinate() < 0)
         {
            return true;
         }
         else return false;
      }
      else return false;
   }
}
