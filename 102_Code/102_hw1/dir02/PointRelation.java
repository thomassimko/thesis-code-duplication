import java.util.*;
import java.util.Scanner;
public class PointRelation
{
   public static double distance(Point point1, Point point2)
   {
      double x1 = point1.xCoordinate();
      double x2 = point2.xCoordinate();
      double y1 = point1.yCoordinate();
      double y2 = point2.yCoordinate();
      double x = (x1 - x2);
      double y = (y1 - y2);
      return(Math.sqrt(x*x + y*y));
   }
   public static boolean quad(Point point1, Point point2)
   {
      boolean status = true;
      double x1 = point1.xCoordinate();
      double x2 = point2.xCoordinate();
      double y1 = point1.yCoordinate();
      double y2 = point2.yCoordinate();
      if((x1 > 0) && (x2 < 0))
      {
         status = false;
      }
      if((x1 < 0) && (x2 > 0))
      {
         status = false;
      }
      if((y1 > 0) && (y2 < 0))
      {
         status = false;
      }
      if((y2 > 0) && (y1 < 0) )
      {
         status = false;
      }    
      return(status);
   }
   public static void main(String [] args)
   {
      int type = 0;
      int j = 0;
      Point p1 = new CartesianPoint(1.0, 1.0);
      Point p2 = p1;
      double radius;
      double angle;
      double x;
      double y;
      Scanner in = new Scanner(System.in);
      for(j = 0; j < 2; j++)
      {
         System.out.print("1 for Cartesian 2 for Polar: ");
         try
         {
            type = in.nextInt();
         }
         catch(InputMismatchException e)
         {
            System.out.println("Invalid data type.");
            System.exit(1);
         }
         if( (type != 1) && (type != 2) )
         {
            System.out.println(type + " is not a valid option.");
            System.exit(1);
         }
         if(type == 1)
         {
            System.out.print("Enter x coordinate ");
            x = in.nextDouble();
            System.out.print("Enter y coordinate ");
            y = in.nextDouble();
            if(j == 1)
            {
               p1 = new CartesianPoint(x, y);
            }
            else
            {
               p2 = new CartesianPoint(x, y);
            } 
         }
         else if(type == 2)
         {
            System.out.print("Enter radius ");
            radius = in.nextDouble();
            System.out.print("Enter angle ");
            angle = in.nextDouble();
            if(j == 1)
            {
               p1 = new PolarPoint(radius, ((angle*Math.PI)/180));
            }
            else
            {
               p2 = new PolarPoint(radius, ((angle*Math.PI)/180));
            }
         }
      }
      double point_distance = distance(p1, p2);
      System.out.println("The distance between the two points is: " + point_distance);
      if(quad(p1, p2))
      {
         System.out.println("In same quadrant");
      }
      else
      {
         System.out.println("Not in same quadrant");
      }
   }
}
