public class PolarPoint
   implements Point
{
   private double radius;
   private double angle;

   public PolarPoint(double radius, double angle)
   {
      this.radius = Math.abs(radius);
   
      if(radius < 0)
      {
         angle += 180;
      }
      else
      {
         this.angle = angle;
      }
      while(this.angle < 0)
      {
         this.angle += 360;
      }
   }

   public double xCoordinate()
   {
      return radius*Math.cos(Math.toRadians(angle));
   }
   public double yCoordinate()
   {
      return radius*Math.sin(Math.toRadians(angle));
   }
   public double angle()
   {
      return this.angle;
   }
   public double radius()
   {
      return this.radius;
   }
   public Point rotate90()
   {
      return new PolarPoint(radius, angle + 90);
   }
}
