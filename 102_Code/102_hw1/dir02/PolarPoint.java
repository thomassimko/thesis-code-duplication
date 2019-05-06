public class PolarPoint implements Point
{
   public double radius, angle;
   public PolarPoint(double radius, double angle)
   {
      if(angle < 0)
      {
         this.angle = angle + 2 * Math.PI;
      }
      else
      {
         this.angle = angle;
      }
      if(radius < 0)
      {
         this.radius = Math.abs(radius);
         this.angle = angle + 2 * Math.PI;
      }
      else
      {
         this.radius = radius;
      }
   } 
   public double xCoordinate()
   {
      return(this.radius * Math.cos(this.angle));
   }
   public double yCoordinate()
   {
      return(this.radius * Math.sin(this.angle));
   }
   public double radius()
   {
      return(this.radius);
   }
   public double angle()
   {
      return(this.angle);
   }
   public Point rotate90()
   {
      Point result = new PolarPoint(this.radius, (this.angle + (Math.PI/2)));
      return result;
   }
}
