public class PolarPoint implements Point
{
   double radius;
   double angle;
   
   public PolarPoint(double radius, double angle)
   {
      if (radius < 0)
      {
         this.radius = -1 * radius;
      }
      else this.radius = radius;
      if (angle < 0)
      {
         while (angle <0)
         {
            angle = angle+360;
            this.angle = angle;
         }
      }
      else this.angle = angle;
   }

   public double xCoordinate()
   {
      return radius * Math.cos(this.angle());
   }
   
   public double yCoordinate()
   {
      return radius * Math.sin(this.angle());
   }

   public double radius()
   {
      return radius;
   }

   public double angle()
   {
      return angle * (3.14159/180);
   }

   public Point rotate90()
   {
      Point pt = new PolarPoint(radius, angle +90);
      return pt; 
   }
}
