import java.util.Scanner;

class PointRelation
{
   public static Point makePoint()
   {
      double type = 0;
      double x = 0;
      double y = 0;
      double angle = 0;
      double radius = 0;
   
      Scanner sc = new Scanner(System.in);
      System.out.printf("Which type of point should be created(1 for Cartesian, 2 for Polar)? ");
      
      
      if (sc.hasNextInt())
      {
         type = sc.nextInt();
      }  
      else
      {
         System.out.println("Error double");
         type = 1;
         System.exit(1);
      }
      
      if (type == 1)
      {
         System.out.printf("Enter x-coordinate: ");
         if (sc.hasNextDouble())
         {
            x = sc.nextDouble();
         }
         else
         {
            System.out.println("Error double");
            System.exit(1);
         }
         System.out.printf("Enter y-coordinate: ");
         if (sc.hasNextDouble())
         {
            y = sc.nextDouble();
         }
         else
         {
            System.out.println("Error double");
            System.exit(1);
         }   
         return new CartesianPoint(x,y);
      }
      else if (type == 2)
      {
         System.out.printf("Enter radius: ");
         if (sc.hasNextDouble())
         {
            radius = sc.nextDouble();
         }
         else
         {
            System.out.println("Error double");
            System.exit(1);
         }
         System.out.printf("Enter angle: ");
         if (sc.hasNextDouble())
         {
            angle = sc.nextDouble();
         }
         else
         {
            System.out.println("Error double");
            System.exit(1);
         }
         return new PolarPoint(radius,angle);
      }
      else
      {
         return new CartesianPoint(0,0);
      }
   }  
   public static void main(String [] args)
   {  
      double dist;
      
      Point a;
      Point b;
      
      a = makePoint();
      b = makePoint();

      dist = distance(a,b);
      if (dist<.001)
      {
         System.out.println("Distance between points: 0.0");
      }
      else
      {
         System.out.println("Distance between points: "+dist);
      }
      if (isSameQuad(a,b))
      {
         System.out.println("In same quadrant");
      }
      else
      {
         System.out.println("Not in same quadrant");
      }
   
   }
   public static double distance(Point a,Point b)
   {
      double ax = a.xCoordinate();
      double ay = a.yCoordinate();
      double bx = b.xCoordinate();
      double by = b.yCoordinate();
      return Math.sqrt((ax-bx)*(ax-bx)+(ay-by)*(ay-by));
   }
   public static boolean isSameQuad(Point a,Point b)
   {
      if (a.xCoordinate()>=0 && b.xCoordinate()>=0 && a.yCoordinate()>=-.001 && b.yCoordinate()>=-.001)
         return true;
      else if (a.xCoordinate()<=.001 && b.xCoordinate()<=.001 && a.yCoordinate()>=0 && b.yCoordinate()>=0)
         return true;
      else if (a.xCoordinate()<=0 && b.xCoordinate()<=0 && a.yCoordinate()<=.001 && b.yCoordinate()<=.001)
         return true;
      else if (a.xCoordinate()>=-.001 && b.xCoordinate()>=-.001 && a.yCoordinate()>=0 && b.yCoordinate()>=0)
         return true;
      else
         return false;
   }
}
