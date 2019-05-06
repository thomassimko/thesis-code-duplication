import java.util.Scanner;

public class PointRelation
{
   public static double distance(Point a, Point b)
   {
      double d;
      d = Math.sqrt(Math.pow((a.xCoordinate()-b.xCoordinate()),2) 
         + Math.pow((a.yCoordinate()-b.yCoordinate()),2));
      return d;
   }
   public static boolean sameQuad(Point c, Point d)
   {
      char i = '-', j = '-', k = '-', l ='-';
      if(c.xCoordinate() > 0)
      {
         i = '+';
      }
      if(d.xCoordinate() > 0)
      {
         j = '+';
      }
      if(c.yCoordinate() > 0)
      {
         k = '+';
      }
      if(d.yCoordinate() > 0)
      {
         l = '+';
      }
      if(c.yCoordinate() == 0 && c.xCoordinate() > 0)
      {
         i = '+';
         k = '+';
      }
      else if(c.yCoordinate() == 0 && c.xCoordinate() < 0)
      {
         i = '-';
         k = '-';
      }
      if(d.yCoordinate() == 0 && d.xCoordinate() > 0)
      {
         j = '+';
         l = '+';
      }
      else if(d.yCoordinate() == 0 && d.xCoordinate() < 0)
      {
         i = '-';
         k = '-';
      }
      if(c.xCoordinate() == 0 && c.yCoordinate() > 0)
      {
         i = '-';
         k = '+';
      }
      else if(c.xCoordinate() == 0 && c.yCoordinate() < 0)
      {
         i = '+';
         k = '-';
      }
      if(d.xCoordinate() == 0 && d.yCoordinate() > 0)
      {
         i = '-';
         k = '+';
      }
      else if(d.xCoordinate() == 0 && d.yCoordinate() < 0)
      {
         i = '+';
         k = '-';
      }
      if(i == j && k == l)
      {
         return true;
      }
      else
      {
         return false;
      }
   }
   public static void main(String [] args)
   {
      Scanner scan = new Scanner(System.in);
      double x1, x2, y1, y2, r1, r2, a1, a2, d1;
      Point pt1 = new CartesianPoint(0.0, 0.0);
      Point pt2 = new CartesianPoint(0.0, 0.0);
      System.out.print("Which type of point should be created (1 for Cartesian, 2 for Polar)? ");
      int choice1 = scan.nextInt();
      if(choice1 == 1)
      {
         System.out.print("Enter x-coordinate: ");
         x1 = scan.nextDouble();
         System.out.print("Enter y-coordinate: ");
         y1 = scan.nextDouble();
         pt1 = new CartesianPoint(x1, y1);
      }
      else
      {
         System.out.print("Enter radius: ");
         r1 = scan.nextDouble();
         System.out.print("Enter angle (in degrees): ");
         a1 = scan.nextDouble();
         a1 = a1*(Math.PI/180.0);
         pt1 = new PolarPoint(r1, a1);
      }
      System.out.print("Which type of point should be created (1 for Cartesian, 2 for Polar)? ");
      int choice2 = scan.nextInt();
      if(choice2 == 1)
      {
         System.out.print("Enter x-coordinate: ");
         x2 = scan.nextDouble();
         System.out.print("Enter y-coordinate: ");
         y2 = scan.nextDouble();
         pt2 = new CartesianPoint(x2, y2);
      }
      else
      {
         System.out.print("Enter radius: ");
         r2 = scan.nextDouble();
         System.out.print("Enter angle (in degrees): ");
         a2 = scan.nextDouble();
         a2 = a2*(Math.PI/180.0);
         pt2 = new PolarPoint(r2, a2);
      }
      d1 = distance(pt1, pt2);
      System.out.print("Distance between points: " + d1);
      boolean same = sameQuad(pt1, pt2);
      if(same == true)
      {
         System.out.print("\nIn same quadrant.\n");
      }
      else
      {
         System.out.print("\nNot in same quadrant.\n");
      }
   }
}
