public class PolarPoint
   implements Point 
{
   private double radius;
   private double angle;
   
   public PolarPoint(double radius, double angle)
   {
      this.radius = radius;
      this.angle = angle;
      
      if(radius < 0)
      {
         radius = -radius;
         angle = angle + Math.PI;
      }
      if (angle<0) 
      {
         while (angle < 0)
         {
            angle = angle + 2*Math.PI;
         }
      }

   }
   
   public double xCoordinate()
   {
      return Math.cos(angle)*radius;
   }
   
   public double yCoordinate()
   {
      return Math.sin(angle)*radius;
   }
   
   public double radius()
   {
      return radius;
   }
   
   public double angle()
   {
      return angle;
   }
   
   public Point rotate90()
   {
      Point p2 = new PolarPoint(radius, angle+((Math.PI)/2));
      
      return p2;
   }
}