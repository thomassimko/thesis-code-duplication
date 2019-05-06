public class PolarPoint implements Point
{
   public double radius;
   public double angle;
   public PolarPoint(double radius, double angle)
   {
      this.radius = radius;
      if(radius < 0)
      {
         this.radius = -radius;
         this.angle = angle + Math.PI;
      }
      this.angle = angle;
      if(angle < 0)
      {
         this.angle = angle + (2*Math.PI);
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
      return this.radius;
   }
   public double angle()
   {
      return this.angle;
   }
   public Point rotate90()
   {
      double r = radius;
      double a = angle + (1.0/2.0)*Math.PI;
      Point p = new PolarPoint(r, a);
      return p;
   }
}
