public class PolarPoint
implements Point
{

private double rad;
private double ang;

   public PolarPoint(double radius, double angle)
   {
      if (radius < 0)
      {
         rad = -radius;
         if (angle < 0)
         {
            ang = Math.PI + angle; 
            if (ang >= 2 * Math.PI)
            {
               ang = ang - 2 * Math.PI;
            }
         }
         else
         {
            ang = Math.PI + angle;
            if (ang >= 2 * Math.PI)
            {
               ang = ang - 2 * Math.PI;
            }
         }
      }
      else{
         rad = radius;
         if (angle < 0)
         {
            ang = 2 * Math.PI + angle; 
         }
         else
         {      
            ang = angle;
         }
      }
   }
   public double xCoordinate()
   { 
      double x =  Math.cos(ang) * rad; 
      return x;
   }
   public double yCoordinate()
   {
      double y = Math.sin(ang) *rad;
      return y;
   }
   public double radius()
   {
      return rad;
   }
   public double angle()
   {
      return ang;
   }
   public Point rotate90()
   {
      double ang2 = ang + Math.PI/2;
      if (ang2 >= 2 * Math.PI)
      {
         ang2 = ang2 - 2*Math.PI;
      }
      return new PolarPoint (rad, ang2);
   }
}  
