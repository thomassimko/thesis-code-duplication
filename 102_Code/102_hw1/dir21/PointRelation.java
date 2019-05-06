import java.util.Scanner;

public class PointRelation
{
   public static void main(String [] args)
   {
       Scanner scanner = new Scanner(System.in);
		 Point p1 = new CartesianPoint(0,0);
		 Point p2 = new CartesianPoint(0,0);

      
      System.out.print("Which type of point should be created (1 for Cartesion, 2 for Polar)? ");
      int pType1 = scanner.nextInt();
      
      if (pType1 == 1)
      {
         
         System.out.print("Enter x-coordinate: ");
         double xp1 = scanner.nextDouble();
      
         System.out.print("Enter y-coordinate: ");
         double yp1 = scanner.nextDouble();
         
         p1 = new CartesianPoint(xp1, yp1);
         
      }
      else if (pType1 == 2)
      {
      
         System.out.print("Enter radius: ");
         double rp1 = scanner.nextDouble();
      
         System.out.print("Enter angle: ");
         double ap1 = scanner.nextDouble() * Math.PI/180;
         
         p1 = new PolarPoint(rp1, ap1);
         
      }
	  else{
		    System.out.println("Error, incorrect input.");
			System.exit(1);
		}
      
      System.out.print("Which type of point should be created (1 for Cartesion, 2 for Polar)? ");
      int pType2 = scanner.nextInt();
      
      if (pType2 == 1)
      {
         
         System.out.print("Enter x-coordinate: ");
         double xp2 = scanner.nextDouble();
      
         System.out.print("Enter y-coordinate: ");
         double yp2 = scanner.nextDouble();
         
         p2 = new CartesianPoint(xp2, yp2);
         
      }
      else if (pType2 == 2)
      {
      
         System.out.print("Enter radius: ");
         double rp2 = scanner.nextDouble();
      
         System.out.print("Enter angle: ");
         double ap2 = scanner.nextDouble() * Math.PI/180;
         
         p2 = new PolarPoint(rp2, ap2);
         
      }
	  else{
	     System.out.println("Error, incorrect input.");
	     System.exit(1);
	  }
      
      double coordDistance = distance(p1, p2);
    
      System.out.println("Distance between points: " + coordDistance);
      
      quadrant(p1, p2);
      
   }
   
    public static double distance(Point pat1, Point pat2)
    {
       double xdif = pat1.xCoordinate() - pat2.xCoordinate();
       double ydif = pat1.yCoordinate() - pat2.yCoordinate();
       
       return Math.sqrt(xdif * xdif + ydif * ydif);
       
    }
      
    public static void quadrant(Point pat1, Point pat2)
    {
       int pete1, pete2;
       
       if((pat1.xCoordinate() > 0) && (pat1.yCoordinate() >= 0))
       {
          pete1 = 1;
       }
       else if((pat1.xCoordinate() <= 0) && (pat1.yCoordinate() > 0))
       {
          pete1 = 2;
       }
       else if((pat1.xCoordinate() < 0) && (pat1.yCoordinate() <= 0))
       {
          pete1 = 3;
       }
       else if((pat1.xCoordinate() >= 0) && (pat1.yCoordinate() < 0))
       {
          pete1 = 4;
       }
       else{
          pete1 = 5;
       }
       
       if((pat2.xCoordinate() > 0) && (pat2.yCoordinate() >= 0))
       {
          pete2 = 1;
       }
       else if((pat2.xCoordinate() <= 0) && (pat2.yCoordinate() > 0))
       {
          pete2 = 2;
       }
       else if((pat2.xCoordinate() < 0) && (pat2.yCoordinate() <= 0))
       {
          pete2 = 3;
       }
       else if((pat2.xCoordinate() >= 0) && (pat2.yCoordinate() < 0))
       {
          pete2 = 4;
       }
       else{
          pete2 = 5;
       }
       
       if (pete1 == pete2)
       {
          System.out.println("In same quadrant.");
       }
       else{
          System.out.println("Not in same quadrant.");
       }
      
    }
   
}
