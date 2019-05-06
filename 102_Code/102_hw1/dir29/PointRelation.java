import java.util.Scanner;

public class PointRelation
{
   public static void main(String [] args)
   {
      Scanner in = new Scanner(System.in);
      Point p1 = new CartesianPoint(0.0, 0.0);
      Point p2 = new CartesianPoint(0.0, 0.0);
      System.out.print("Which type of point should be created (1 for Cartesian, 2 for Polar)? ");
      int type1 = in.nextInt();
      if(type1 == 1 || type1 == 2)
      {
         if(type1 == 1)
         {
            System.out.print("Enter x-coordinate: ");
            double x1 = in.nextDouble();
            System.out.print("Enter y-coordinate: ");
            double y1 = in.nextDouble();
            p1 = new CartesianPoint(x1,y1);
         }
         else
         {
            System.out.print("Enter radius: ");
            double r1 = in.nextDouble();
            System.out.print("Enter angle (in degrees): ");
            double a1 = in.nextDouble();
            p1 = new PolarPoint(r1,a1);
         }
      }
      else
      {
         System.out.println("Error: Please choose either point type Cartesian (1) or type Polar (2).");
         System.exit(1);
      }
      System.out.print("Which type of point should be created (1 for Cartesian, 2 for Polar)? ");
      int type2 = in.nextInt();
      if(type2 == 1 || type2 == 2)
      {
         if(type2 == 1)
         {
            System.out.print("Enter x-coordinate: ");
            double x2 = in.nextDouble();
            System.out.print("Enter y-coordinate: ");
            double y2 = in.nextDouble();
            p2 = new CartesianPoint(x2,y2);
         }
         else
         {
            System.out.print("Enter radius: ");
            double r2 = in.nextDouble();
            System.out.print("Enter angle (in degrees): ");
            double a2 = in.nextDouble();
            p2 = new PolarPoint(r2,a2);
         }
      }
      else
      {
         System.out.println("Error: Please choose either point type Cartesian (1) or type Polar (2).");
         System.exit(1);
      }
      double distance = distanceBetween(p1, p2);
      System.out.println("Distance between points: " + distance);
      if(sameQuadrant(p1,p2) == true)
      {
         System.out.println("In same quadrant.");
      }
      else
      {
         System.out.println("Not in same quadrant.");
      }
   }
   public static double distanceBetween(Point p1, Point p2)
   {
      if((p1.xCoordinate() == p2.xCoordinate()) && (p1.yCoordinate() == p2.yCoordinate()))
      {
         return 0.0; //Ask about why it isn't returning exactly zero.
      }
      else
      {
         return Math.sqrt(((p2.xCoordinate()-p1.xCoordinate())*(p2.xCoordinate()-p1.xCoordinate()))+(p2.yCoordinate()-p1.yCoordinate())*(p2.yCoordinate()-p1.yCoordinate()));
      }
   }
   public static boolean sameQuadrant(Point p1, Point p2)
   {
      if(p1.xCoordinate()>=0 && p2.xCoordinate()>=0 && p1.yCoordinate()>=0 && p2.yCoordinate()>=0)
      {
         return true;
      }
      else if(p1.xCoordinate()>=0 && p2.xCoordinate()>=0 && p1.yCoordinate()<0 && p2.yCoordinate()<0)
      {
         return true;
      }
      else if(p1.xCoordinate()<0 && p2.xCoordinate()<0 && p1.yCoordinate()>=0 && p2.yCoordinate()>=0)
      {
         return true;
      }
      else if(p1.xCoordinate()<0 && p2.xCoordinate()<0 && p1.yCoordinate()<0 && p2.yCoordinate()<0)
      {
         return true;
      }
      else
      {
         return false;
      }
   }
}
