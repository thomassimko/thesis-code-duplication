import java.util.Scanner;

public class PointRelation
{

   public static void PointDistance(Point p1, Point p2)
      {
         double x1 = p1.xCoordinate();
         double y1 = p1.yCoordinate();
         double x2 = p2.xCoordinate();
         double y2 = p2.yCoordinate();
         
         double distance = Math.sqrt(((x2 - x1)*(x2 - x1)) +
          ((y2 - y1)*(y2 - y1)));
         
         
         System.out.println("Distance between points: " + distance);
         
         return ;
      }
   
      public static void QuadrantCheck(Point p1, Point p2)
      {
         
         double x1 = p1.xCoordinate();
         double y1 = p1.yCoordinate();
         double x2 = p2.xCoordinate();
         double y2 = p2.yCoordinate();
         
         if(x1 > 0 && y1 > 0 && x2 > 0 && y2 > 0)
         {
            System.out.println("In same quadrant.");
         }
         
         else
         {
            if(x1 < 0 && y1 > 0 && x2 < 0 & y2 > 0)
            {
               System.out.println("In same quadrant.");
            }
            
            else
            {
               if(x1 < 0 && y1 < 0 && x2 < 0 && y2 < 0)
               {
                  System.out.println("In same quadrant.");
               }
               
               else
               {
                  if(x1 > 0 && y1 < 0 && x2 > 0 && y2 < 0)
                  {
                     System.out.println("In same quadrant.");
                  }
                  
                  else
                  {
                     System.out.println("Not in same quadrant.");
                  }
               }
            }
         }
         return ;
      }

   public static void main(String[] args)
   {
      
      Scanner sc = new Scanner(System.in);
      
      
      System.out.print("Which type of of point should be created (1 for Cartesian, 2 for Polar)? ");
      int i = sc.nextInt();
      
      double x, y, r, a;
      Point p1, p2;
      
      if(i == 1)
      {
         System.out.print("Enter x-coordinate: ");
         x = sc.nextInt();
         
         System.out.print("Enter y-coordinate: ");
         y = sc.nextInt();
         
         p1 = new CartesianPoint(x, y);
         
      }
      
      else
      {
         if(i == 2)
         {
            System.out.print("Enter radius: ");
            r = sc.nextInt();
            
            System.out.print("Enter angle (in degrees): ");
            a = sc.nextInt();
            
            a = a * (Math.PI / 180);
            
            p1 = new PolarPoint (r, a);
         }
      
         else
         {
            System.out.println("Invalid value..get it right next time.");
            System.exit(1);
            return;
         }
      }
      
      System.out.print("Which type of of point should be created (1 for Cartesian, 2 for Polar)? ");
      i = sc.nextInt();
      
      if(i == 1)
      {
         System.out.print("Enter x-coordinate: ");
         x = sc.nextInt();
         
         System.out.print("Enter y-coordinate: ");
         y = sc.nextInt();
         
         p2 = new CartesianPoint(x, y);
         
      }
      else
      {
         if(i == 2)
         {
            System.out.print("Enter radius: ");
            r = sc.nextInt();
         
            System.out.print("Enter angle (in degrees): ");
            a = sc.nextInt();
         
            a = a * (Math.PI / 180);
         
            p2 = new PolarPoint (r, a);
         }
         else
         {
            System.out.println("Invalid value..get it right next time.");
            System.exit(1);
            return;
         }
      }
      
      PointDistance(p1, p2);
      
      QuadrantCheck(p1, p2);
   }
}
