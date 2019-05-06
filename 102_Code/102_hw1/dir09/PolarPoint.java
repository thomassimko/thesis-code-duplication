public class PolarPoint
   implements Point
{
   private double r;
   private double a;

   PolarPoint(double radius, double angle)
   {
      if (radius < 0.0)
      {
         radius = Math.abs(radius);
         if (a >= 180.0)
         {
            angle -= 180.0;
         }
         else
         {
            angle += 180.0;
         }
      }

      if (angle < 0.0)
      {
         angle += 360.0;
      }
 
      this.r = radius;
      this.a = angle;
   }

   public double xCoordinate()
   {
      return this.r * Math.cos(Math.toRadians(this.a));
   }

   public double yCoordinate()
   {
      return this.r * Math.sin(Math.toRadians(this.a));
   }

   public double radius()
   {
      return this.r;
   }

   public double angle()
   {
      return this.a;
   }

   public Point rotate90()
   {
      Point newpoint;
      if (this.a + 90.0 >= 360.0)
      {
         newpoint = new PolarPoint(this.r, this.a + 90.0 - 360.0);
      } 
      else
      {
         newpoint = new PolarPoint(this.r, this.a + 90.0);
      }
      return newpoint;
   }
}
