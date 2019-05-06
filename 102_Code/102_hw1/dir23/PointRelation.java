/*Programmed by Michael Olivarez*/
import java.util.Scanner;
public class PointRelation
{
   public static double calcDist(Point pt1, Point pt2)
   {
      double dist;
      dist = Math.sqrt((pt2.xCoordinate() - pt1.xCoordinate())*(pt2.xCoordinate() - pt1.xCoordinate())+(pt2.yCoordinate() - pt1.yCoordinate())*(pt2.yCoordinate() - pt1.yCoordinate()));
      return dist;
   }
  
   public static boolean inSameQuadrant(Point pt1, Point pt2)
   {
      int pt1Quad;
      if(pt1.xCoordinate() > 0 && pt1.yCoordinate()>= 0)
      {
         pt1Quad = 1;
      }
      else if(pt1.xCoordinate() == 0 && pt1.yCoordinate() == 0)
      {
         return true;
      }
      else if(pt1.xCoordinate() <= 0 && pt1.yCoordinate() > 0)
      {
         pt1Quad = 2;
      }
      else if(pt1.xCoordinate() < 0 && pt1.yCoordinate() <= 0)
      {
         pt1Quad = 3;
      }
      else
      {
         pt1Quad = 4;
      }
      
      int pt2Quad;

      if(pt2.xCoordinate() > 0 && pt2.yCoordinate()>= 0)
      {
         pt2Quad = 1;
      }
      else if(pt2.xCoordinate() == 0 && pt2.yCoordinate() == 0)
      {
         return true;
      }
      else if(pt2.xCoordinate() <= 0 && pt2.yCoordinate() > 0)
      {
         pt2Quad = 2;
      }
      else if(pt2.xCoordinate() < 0 && pt2.yCoordinate() <= 0)
      {
         pt2Quad = 3;
      }
      else
      {
         pt2Quad = 4;
      }

      
      if(pt1Quad == pt2Quad)
      {
         return true;
      }
      else
      {
         return false;
      }
   }
 
   public static void  main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      double distance;
      boolean SameQuad;
      Point pt1;
      Point pt2;

      System.out.println("Which type of point should be created (1 for Cartesian, 2 for Polar)?");
      int command1 = in.nextInt();
      if(command1 == 1)
      {
         System.out.println("Enter x-coordinate: ");
         double a1 = in.nextDouble();
         System.out.println("Enter y-coordinate: ");
         double b1 = in.nextDouble();
         pt1 = new CartesianPoint(a1,b1);
      }
      else if(command1 == 2)
      {
         System.out.println("Enter radius: ");
         double a1 = in.nextDouble();
         System.out.println("Enter angle (in degrees): ");
         double b1 = in.nextDouble()*180/Math.PI; 
         pt1 = new PolarPoint(a1,b1);        
      }
      else
      {
         System.out.println("ERROR: BAD COMMAND INPUT!");
         System.exit(1);
         return;
      }
      
      System.out.println("Which type of point should be created (1 for Cartesian, 2 for Polar)?");
      int command2 = in.nextInt();
      if(command2 == 1)
      {
         System.out.println("Enter x-coordinate: ");
         double x2 = in.nextDouble();
         System.out.println("Enter y-coordinate: ");
         double y2 = in.nextDouble();
         pt2 = new CartesianPoint(x2,y2);
      }
      else if(command2 == 2)
      {
         System.out.println("Enter radius: ");
         double rad2 = in.nextDouble();
         System.out.println("Enter angle (in degrees): ");
         double deg2 = in.nextDouble()*180/Math.PI;
         pt2 = new PolarPoint(rad2,deg2);
      }
      else
      {
         System.out.println("ERROR: BAD COMMAND INPUT!");
         System.exit(1);
         return;
      }

      /*Now to calculate distance between points*/
      distance = calcDist(pt1,pt2);
      System.out.println("Distance between points: " + distance);
      SameQuad = inSameQuadrant(pt1,pt2);
      if(SameQuad == true)
      {
         System.out.println("In same quadrant");
      }
      else
      {
         System.out.println("Not in same quadrant");
      }
   
   }

}
