import java.util.Scanner;

public class PointRelation 
{
   public static void main(String[] args) 
   { 
      Point p1 = getPoint();
      Point p2 = getPoint();
      
      System.out.println("Distance between points: " + Distance(p1,p2));
      
      if (Quadrant1(p1) == Quadrant2(p2)) 
      {
         System.out.println("In same quadrant.");
      }
      else 
      {
         System.out.println("Not in same quadrant.");
      }
   }
   
   public static double Distance(Point p1, Point p2)
   {
      return Math.sqrt(
         Math.pow(p2.xCoordinate()-p1.xCoordinate(),2) +
         Math.pow(p2.yCoordinate()-p1.yCoordinate(),2));
   }
   
   public static Point getPoint()
   {
      System.out.println("Which type of point should be created? (1 for Cartesian, 2 for Polar)");
      Scanner input = new Scanner(System.in);
            
      int choice = input.nextInt();
            
      if (choice == 1) 
      {
         return getCartesian();   
      }
      else if (choice == 2) 
      {
         return getPolar();
      }
      else 
      {
         System.out.println("Option must be either 1 or 2.");
         System.exit(1);
      }
      return null;
   }
   
   public static Point getCartesian()
   {
      Scanner coordinates = new Scanner(System.in);
      
      System.out.println("Enter x-coordinate: ");
      double xCoor = coordinates.nextDouble();
                                             
      System.out.println("Enter y-coordinate: ");
      double yCoor = coordinates.nextDouble();
                                             
      return new CartesianPoint(xCoor, yCoor);
   }
   
   public static Point getPolar()
   {
      Scanner coordinates = new Scanner(System.in);
      
      System.out.println("Enter radius: ");
      double rad = coordinates.nextDouble();
                                             
      System.out.println("Enter angle (in degrees): ");
      double angle = coordinates.nextDouble();
                                       
      angle = (angle/180)*Math.PI;
                                    
      return new PolarPoint(rad, angle);
   }
   
   public static int Quadrant1(Point p1)
   {
      if(p1.xCoordinate() > 0 && p1.yCoordinate() > 0)
      {
         return 1;
      }
      if(p1.xCoordinate() < 0 && p1.yCoordinate() > 0)
      {
         return 2;
      }
      if(p1.xCoordinate() < 0 && p1.yCoordinate() < 0)
      {
         return 3;
      }
      if(p1.xCoordinate() > 0 && p1.yCoordinate() < 0)
      {
         return 4;
      }
      else 
      {
         return 0;
      }
   }
   
   public static int Quadrant2(Point p2)
   {
      if(p2.xCoordinate() > 0 && p2.yCoordinate() > 0)
      {
         return 1;
      }
      if(p2.xCoordinate() < 0 && p2.yCoordinate() > 0)
      {
         return 2;
      }
      if(p2.xCoordinate() < 0 && p2.yCoordinate() < 0)
      {
         return 3;
      }
      if(p2.xCoordinate() > 0 && p2.yCoordinate() < 0)
      {
         return 4;
      }
      else 
      {
         return 0;
      }
   }
   
   
}