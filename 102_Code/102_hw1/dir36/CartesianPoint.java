public class CartesianPoint
   implements Point
{

public double x;
public double y;
   
   public CartesianPoint(double x_coord, double y_coord)
   {
      x = x_coord;
      y = y_coord;
   }
   public double xCoordinate()
   { 
      return x;
   }
   public double yCoordinate()
   {
      return y;
   }
   public double radius()
   {
      double distance =  Math.sqrt(x * x + y * y);
      return distance;
   }
   public double angle()
   {
      double ang= 0;

      if (x >= 0 && y >= 0)
      {
         ang = Math.atan2(y, x);
      }
      else
      {
         if( x < 0 && y >= 0)
         {
            ang = Math.atan2(y,x);
         }
         else
         {
            if( x < 0 && y < 0)
            {
               ang = Math.atan2(y,x) + 2 * Math.PI;
            }
            else
            {
               if ( x > 0 && y < 0)
               {
                  ang = Math.atan2(y,x) + 2 * Math.PI;
               }
            }
         }
      }
      return ang;
   }
   public Point rotate90()
   {
      double y2, x2;
      y2 = y;
      x2 = x;

      return new CartesianPoint(-y2, x2);
   }
}  
