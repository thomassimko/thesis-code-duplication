   import java.util.Scanner;
   import java.lang.Math;


   public class PointRelation
   {
      
      public static void main (String[] args)
      {
         int type;
         int quadrant;
         double x;
         double y;
         double r;
         double angle;
         double distance;
         Point a;
         Point b;
      
         Scanner scanner = new Scanner(System.in);
      
         System.out.print("Which type of point should be created (1 for Cartesian, 2 for Polar)? ");
         type = scanner.nextInt();
         if (type == 1)
         {
            System.out.print("Enter x-coordinate: ");
				if ( !scanner.hasNextDouble() )
				{
					System.out.println("Error");
					System.exit(-1);
					x = 0;
				}
				else
				{
            	x = scanner.nextDouble();
				}
            System.out.print("Enter y-coordinate: ");
				if ( !scanner.hasNextDouble() )
				{
					System.out.println("Error");
					System.exit(-1);
					y = 0;
				}
				else
				{
            	y = scanner.nextDouble();
				}
            a = new CartesianPoint(x, y);
         }
         else if ( type == 2)
         {
            System.out.print("Enter radius: ");
				if ( !scanner.hasNextDouble() )
				{
					System.out.println("Error");
					System.exit(-1);
					r = 0;
				}
				else
				{
            	r = scanner.nextDouble();
				}
            System.out.print("Enter angle (in degrees): ");
				if ( !scanner.hasNextDouble() )
				{
					System.out.println("Error");
					System.exit(-1);
					angle = 0;
				}
				else
				{
            	angle = scanner.nextDouble();
					angle = angle*(Math.PI/180);
				}
            a = new PolarPoint(r,angle);
         } 
         else
         {
            System.out.println("Error");
            System.exit(-1);
            a = null;
         }
      
         System.out.print("Which type of point should be created (1 for Cartesian, 2 for Polar)? ");
         type = scanner.nextInt();
         if (type == 1)
         {
            System.out.print("Enter x-coordinate: ");
            x = scanner.nextDouble();
            System.out.print("Enter y-coordinate: ");
            y = scanner.nextDouble();
            b = new CartesianPoint(x, y);
         }
         else if ( type == 2)
         {
            System.out.print("Enter radius: ");
            r = scanner.nextDouble();
            System.out.print("Enter angle (in degrees): ");
            angle = scanner.nextDouble();
				angle = angle*(Math.PI/180);
            b = new PolarPoint(r,angle);               
         } 
         else
         {
            System.out.println("Error");
            System.exit(-1);
            b = null;
         }
         
         distance = calcDistance(a, b);
         System.out.println("Distance between points: "+distance);
         quadrant = calcQuadrant(a,b);
         if (quadrant == 1)
            System.out.println("In same quadrant.");
         else
            System.out.println("Not in same quadrant.");
      }
      
      public static double calcDistance(Point a, Point b)
      {
         return Math.sqrt( Math.pow((b.xCoordinate()-a.xCoordinate()),2) + Math.pow((b.yCoordinate()-a.yCoordinate()),2) );
      }
      public static int calcQuadrant(Point a, Point b)
      {
         if ( a.xCoordinate() >= 0 && b.xCoordinate() >= 0 )
            if ( a. yCoordinate() >= 0 && b.yCoordinate() >= 0 )
               return 1;
         if ( a.xCoordinate() <= 0 && b.xCoordinate() <= 0 )
            if (a.yCoordinate() >= 0 && b.yCoordinate() >= 0 )
               return 1;
         if (a.xCoordinate() <= 0 && b.xCoordinate() <= 0 )
            if (a.yCoordinate() <= 0 && b.yCoordinate() <= 0)
               return 1;
         if (a.xCoordinate() >= 0 && b.xCoordinate() >= 0 )
            if (a.yCoordinate() <= 0 && b.yCoordinate() <= 0 )
               return 1;
         return 0;
      }
   }
		