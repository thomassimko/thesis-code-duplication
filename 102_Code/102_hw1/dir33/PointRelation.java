import java.util.Scanner;
public class PointRelation
{
   
    public static void main(String[] args)
    {
        double distance;
        int input;
        boolean isSame;
        Point a = makePoint();
        Point b = makePoint();
        distance = distance(a,b);
        System.out.println("Distance between points: " + distance);
        isSame = sameQuadrant(a,b);
        if(isSame)
           System.out.println("In same quadrant.");
        else
           System.out.println("Not in same quadrant");           
    }


   private static Point makePoint()
   {
       int input = 0;
       double x = 0,y = 0,r = 0,theta = 0;
       Scanner scanner = new Scanner(System.in);       

       System.out.printf("Which type of point should be created (1 for Cartesian, 2 for Polar)? ");
       if(scanner.hasNextInt())
          input = scanner.nextInt();

       if(input == 1)
       {
           System.out.printf("Enter x-coordinate: ");

           if(scanner.hasNextDouble())
              x = scanner.nextDouble();
           else
           {
              System.out.println("Invalid type. This will close now.");
              System.exit(1);
           }
           System.out.printf("Enter y-coordinate: ");

           if(scanner.hasNextDouble())
              y = scanner.nextDouble();
           else
           {
              System.out.println("Invalid type. This will close now.");
              System.exit(1);
           }
           Point cartesian = new CartesianPoint(x,y);
           return cartesian;
       }
       else if(input == 2)
       {
           System.out.printf("Enter radius: ");

           if(scanner.hasNextDouble())
              r = scanner.nextDouble();
           else
           {
              System.out.println("Invalid type. This will close now.");
              System.exit(1);
           }
           System.out.printf("Enter angle (in degrees): ");

           if(scanner.hasNextDouble())
              theta = scanner.nextDouble();
           else
              {
                 System.out.println("Invalid type. This will close now.");
                 System.exit(1);
              }

           Point polar = new PolarPoint(r, theta);
           return polar;
          
       }
       else
       {
           System.out.println("Not an option. System termination imminent");
           System.exit(1);
           Point elsePoint = new CartesianPoint(0,0);
           return elsePoint; 
       }

   }

   private static double distance(Point a, Point b)
   {
      double x1,y1,x2,y2;
      x1 = a.xCoordinate();
      y1 = a.yCoordinate();
      x2 = b.xCoordinate();
      y2 = b.yCoordinate();
      return Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2));
   }
   
   private static boolean sameQuadrant(Point a, Point b)
   {
      double x1,y1,x2,y2;
      x1 = a.xCoordinate();
      y1 = a.yCoordinate();
      x2 = b.xCoordinate();
      y2 = b.yCoordinate();
      if (x1 > 0 &&  x2 > 0 && y1 >= -0.000001 && y2 >= -0.000001)
          return true;
      else if(x1 <= 0.000001 && x2 <= 0.000001 && y1 > 0 && y2 > 0)
          return true;
      else if(x1 >= -0.000001 && x2 >= -0.000001 && y1 < 0 && y2 < 0)   
          return true;
      else if(x1 < 0 && x2 < 0 && y1 <= 0.000001 && y2 <= 0.000001)
          return true;
      else 
          return false;
   }
}
