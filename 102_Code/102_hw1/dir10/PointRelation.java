import java.util.*;

public class PointRelation
{
   public static void main(String [] args)
   {
	   Point p1 = new CartesianPoint(0, 0), p2 = new CartesianPoint(0,0), p3 = new PolarPoint(0, 0), p4 = new PolarPoint(0,0);
      int i;
      double distance; 
      Scanner s = new Scanner(System.in);
		
      System.out.print("Which type of point should be created (1 for Cartesian, 2 for Polar)? ");
      i = s.nextInt();
      if(i == 1)
      {
         p1 = getCartesian(s);
      }
      else if(i == 2)
      {
         p3 = getPolar(s);
			p1 = p3;
      }
      else
      {
         System.out.println("Error: input must be 1 or 2");
         System.exit(1);
      }
      System.out.print("Which type of point should be created (1 for Cartesian, 2 for Polar)? ");
      i = s.nextInt();
      if(i == 1)
      {
         p2 = getCartesian(s);
      }
      else if(i == 2)
      {
         p4 = getPolar(s);
			p2 = p4;
      }
      else
      {
         System.out.println("Error: input must be 1 or 2");
         System.exit(1);
      }
      distance = calcDistance(p1, p2);
      System.out.println("Distance between points: " + distance);
      quadrant(p1, p2);
   }

   public static Point getCartesian(Scanner s)
   {
      double x, y;
      System.out.print("Enter x-coordinate: ");
      x = s.nextDouble();
      System.out.print("Enter y-coordinate: ");
      y = s.nextDouble();
      return new CartesianPoint(x, y);
   }

   public static Point getPolar(Scanner s)
   {
      double r, a;
      System.out.print("Enter radius: ");
      r = s.nextDouble();
      System.out.print("Enter angle (in degrees): ");
      a = s.nextDouble();
      a = a*Math.PI/180;
      return new PolarPoint(r, a);
   }

   public static double calcDistance(Point p1, Point p2)
   {
      return Math.sqrt(Math.pow(p2.xCoordinate()-p1.xCoordinate(), 2) + Math.pow(p2.yCoordinate()-p1.yCoordinate(), 2));
   }
   
   public static void quadrant(Point p1, Point p2)
   {
      if(p1.xCoordinate() > 0 && p1.yCoordinate() >= 0 && p2.xCoordinate() > 0 && p2.yCoordinate() >= 0)
      {
         System.out.println("In same quadrant.");
      }
      else if(p1.xCoordinate() <= 0 && p1.yCoordinate() > 0 && p2.xCoordinate() <= 0 && p2.yCoordinate() > 0)
      {
         System.out.println("In same quadrant.");
      }
      else if(p1.xCoordinate() < 0 && p1.yCoordinate() <= 0 && p2.xCoordinate() < 0 && p2.yCoordinate() <=0)
      {
         System.out.println("In same quadrant.");
      }
      else if(p1.xCoordinate() >= 0 && p1.yCoordinate() < 0 && p2.xCoordinate() >= 0 && p2.yCoordinate() < 0)
      {
         System.out.println("In same quadrant.");
      }
      else
      {
         System.out.println("Not in same quadrant.");
      }
   }
}

