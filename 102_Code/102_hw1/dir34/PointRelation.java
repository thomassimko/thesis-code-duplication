import java.util.*;

public class PointRelation
{
   
   public static void main(String[] args)
   {
      int pointype;
      double x;
      double y;
      double x2;
      double y2;
      double radius;
      double radius2;
      double angle;
      double angle2;
      double distance;
      boolean same = true;
      Point a = new CartesianPoint(0,0);
      Point b = new CartesianPoint(0,0);
     
      Scanner scan = new Scanner(System.in);
      System.out.print("Which type of point should be created(1 for Cartesian, 2 for Polar)? ");
      pointype = scan.nextInt();

      if((pointype != 1) && (pointype != 2))
      {
         System.out.println("Invalid input");
         System.exit(1);
      }
     
      if(pointype == 1)
      {
         System.out.print("Enter x-coordinate: ");
         x = scan.nextDouble();
           
         System.out.print("Enter y-coordinate: ");
         y = scan.nextDouble();

         a = new CartesianPoint(x, y);
      }
      if(pointype == 2)
      {
         System.out.print("Enter radius: ");
         radius = scan.nextDouble();

         System.out.print("Enter angle (in degrees): ");
         angle = scan.nextDouble();

         a = new PolarPoint(radius, angle);
      }

     
      System.out.print("Which type of point should be created(1 for Cartesian, 2 for Polar)? ");
      pointype = scan.nextInt();
      
      if((pointype != 1) && (pointype != 2))
      {
          System.out.println("Invalid input");
          System.exit(1);
      }

      if(pointype == 1)
      {
         System.out.print("Enter x-coordinate: ");
         x2 = scan.nextDouble();
   
         System.out.print("Enter y-coordinate: ");
         y2 = scan.nextDouble();

         b = new CartesianPoint(x2, y2);
      }

      if(pointype == 2)
      {
         System.out.print("Enter radius: ");
         radius2 = scan.nextDouble();
     
         System.out.print("Enter angle (in degrees): ");
         angle2 = scan.nextDouble();

         b = new PolarPoint(radius2, angle2);
      }
      
      distance = Distance(a, b);
      
      System.out.println("Distance between points: " + distance);
      
      same = Quadrant(a, b);
      if(same == true)
      {
         System.out.println("In same quadrant.");
      }
      if(same == false)
      {
         System.out.println("Not in same quadrant.");
      }
      
   }
   public static boolean Quadrant(Point a, Point b)
   {
      double x1;
      double y1;
      double x2;
      double y2;
      boolean same = false;

      x1 = a.xCoordinate();
      y1 = a.yCoordinate();
     
      x2 = b.xCoordinate();
      y2 = b.yCoordinate();
         
      if((x1 > 0) && (y1 >= 0) && (x2 > 0) && (y2 >= 0))
      {
         same = true;
      }
      if((x1 <= 0) && (y1 > 0) && (x2 <= 0) && (y2 > 0))
      {
         same = true;
      }
      if((x1 < 0) && (y1 <= 0) && (x2 < 0) && (y2 <= 0))
      {
         same = true;
      }
      if((x1 >= 0) && (y1 < 0) && (x2 >= 0) && (y2 < 0))
      {
         same = true;
      }
      
      return same;
   }

   public static double Distance(Point a, Point b)
   {
      double x1;
      double y1;
      double x2;
      double y2;
      double distance;

      x1 = a.xCoordinate();
      y1 = a.yCoordinate();

      x2 = b.xCoordinate();
      y2 = b.yCoordinate();

      distance = Math.sqrt((x2 - x1)*(x2 - x1) + (y2 - y1)*(y2 - y1));
      return distance;
   }
}
