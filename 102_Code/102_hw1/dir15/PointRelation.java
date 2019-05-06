import java.util.*;

public class PointRelation
{
   public static void input_output()
   {
      Point p1 = new CartesianPoint(0, 0);
      Point p2 = new CartesianPoint(0, 0);
      Scanner input = new Scanner(System.in);
      
      System.out.print("Which type of point should be created (1 for Cartesian, 2 for Polar)? ");
      int choice_1 = input.nextInt();
      if(choice_1 == 1)
      {
         System.out.print("Enter x-coordinate: ");
         double x1 = input.nextDouble();
         System.out.print("Enter y-coordinate: ");
         double y1 = input.nextDouble();
         p1 = new CartesianPoint(x1, y1);
      }
      else if(choice_1 == 2)
      {
         System.out.print("Enter radius: ");
         double radius_1 = input.nextDouble();
         System.out.print("Enter angle (in degrees): ");
         double angle_1 = input.nextDouble();
         if(angle_1 < 0)
         {
            angle_1 = angle_1 + 360;
         }
         double theta_1 = Math.toRadians(angle_1);
         p1 = new PolarPoint(radius_1, theta_1);
      }
      else
      {
         System.exit(1);
      }

      System.out.print("Which type of point should be created (1 for Cartesian, 2 for Polar)? ");
      int choice_2 = input.nextInt();
      if(choice_2 == 1)
      {
         System.out.print("Enter x-coordinate: ");
         double x2 = input.nextDouble();
         System.out.print("Enter y-coordinate: ");
         double y2 = input.nextDouble();
         p2 = new CartesianPoint(x2, y2);
      }
      else if(choice_2 == 2)
      {
         System.out.print("Enter radius: ");
         double radius_2 = input.nextDouble();
         System.out.print("Enter angle (in degrees): ");
         double angle_2 = input.nextDouble();
         if(angle_2 < 0)
         {
            angle_2 = angle_2 + 360;
         }
         double theta_2 = Math.toRadians(angle_2);
         p2 = new PolarPoint(radius_2, theta_2);
      }
      else
      {
         System.exit(1);
      }
      compute_distance(p1, p2);
      System.out.println("Distance between points: " + compute_distance(p1, p2));
      distance_quadrant(quadrant(p1, p2));  
   }

   public static double compute_distance(Point p1, Point p2)
   {
      return Math.sqrt(Math.pow(p1.xCoordinate() - p2.xCoordinate(), 2) + Math.pow(p1.yCoordinate() - p2.yCoordinate(), 2));
   }

   public static boolean quadrant(Point p1, Point p2)
   {
      boolean flag;
      if((p1.xCoordinate() >= 0 && p1.yCoordinate() > 0 && p2.xCoordinate() >= 0 && p2.yCoordinate() > 0) || (p1.xCoordinate() > 0 && p1.yCoordinate() >= 0 && p2.xCoordinate() > 0 && p2.yCoordinate() 
>= 0) || (p1.xCoordinate() <= 0 && p1.yCoordinate() < 0 && p2.xCoordinate() <= 0 && p2.yCoordinate() < 0) || (p1.xCoordinate() > 0 && p1.yCoordinate() <= 0 && p2.xCoordinate() > 0 && p2.yCoordinate() <= 
0))
      {
         flag = true;
      }
      else
      {
         flag = false;
      }
      return flag;
   }

   public static void distance_quadrant(boolean flag)
   {
      if(flag)
      {
         System.out.println("In same quadrant.");
      }
      else
      {
         System.out.println("Not in same quadrant.");
      }
   }

   public static void main(String[] args)
   {
      input_output();
   }
}
