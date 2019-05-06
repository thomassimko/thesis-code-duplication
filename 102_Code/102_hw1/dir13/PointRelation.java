import java.util.Scanner;

public class PointRelation
{  

   public static void main(String[] args)
   {
      int type;
      double x;
      double y;
      Point point1 = new CartesianPoint(0,0);
      Point point2 = new CartesianPoint(0,0);
      double distan;
      boolean quadrant;

      Scanner in = new Scanner(System.in);

      for (int count=0; count<2; count++){
         System.out.print("Which type of point should be created (1 for Cartesion, 2 for Polar)? ");
         type = in.nextInt();

         if(type==1)
         {
            System.out.print("Enter x-coordinate: ");
            x = in.nextDouble();
            System.out.print("Enter y-coordinate: ");
            y = in.nextDouble();
            if (count==0)
               point1 = new CartesianPoint(x,y);
            else if (count==1)
               point2 = new CartesianPoint(x,y);
            else
            {
               point1 = new CartesianPoint(1,1);
               point2 = new CartesianPoint(1,1);
            }
         }
         else if (type==2)
         {
             System.out.print("Enter radius: ");
             x = in.nextDouble();
             System.out.print("Enter angle (in degrees): ");
             y = in.nextDouble();
             y = y*Math.PI/180;
             if (count==0)
                point1 = new PolarPoint(x,y);
             else if (count==1)
                point2 = new PolarPoint(x,y);
             else
             {
                point1 = new CartesianPoint(1,1);
                point2 = new CartesianPoint(1,1);
             }
         }
         else 
         {
             point1 = new CartesianPoint(1,1);
             point2 = new CartesianPoint(1,1);
             System.out.print("Invalid input.");
             System.exit(1);
         }
      }

      distan = distance(point1, point2);
      System.out.println("Distance between points: "+distan);

      quadrant = quadrant(point1.angle(), point2.angle());
      if (quadrant)
         System.out.println("In same quadrant.");
      else
         System.out.println("Not in same quadrant");
   }
   
   public static double distance(Point point1, Point point2)
   {
       double x;
       double y;
       double x2;
       double y2;

       x = point1.xCoordinate();
       y = point1.yCoordinate();

       x2 = point2.xCoordinate();
       y2 = point2.yCoordinate();
    
       return Math.sqrt((x2-x)*(x2-x)+(y2-y)*(y2-y));
   }

   public static boolean quadrant(double angle1,double angle2)
   {
      while(angle1<0)
      {
         angle1 += (Math.PI*2);
      }
      while(angle1 >= (2*Math.PI))
      {
         angle1 -= (Math.PI*2);
      }
  

      while(angle2<0)
      {
         angle2 += (Math.PI*2);
      }
      while(angle2>=(2*Math.PI))
      {
         angle2 -= (Math.PI*2);
      }
  

      if(angle1<(Math.PI/2) && angle2<(Math.PI/2) && angle1>=0 && angle2>=0)
         return true;
      else if(angle1<(Math.PI) && angle2<(Math.PI) && angle1>=(Math.PI/2) && angle2>=(Math.PI/2))
         return true;
      else if(angle1<(Math.PI*3/2) && angle2<(Math.PI*3/2)  && angle1>=Math.PI && angle2>=Math.PI)
         return true;
      else if(angle1<(Math.PI*2) && angle2<(Math.PI*2) && angle1>=(Math.PI*3/2) && angle2>=(Math.PI*3/2))
         return true;
      else
         return false;
   }
}
