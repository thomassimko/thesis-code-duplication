public class PolarPoint
   implements Point
{
   private double r, a;
   public PolarPoint(double radius, double angle)
   {
      this.r=radius;
      this.a=angle;
   }
   public double xCoordinate()
   {
      return (this.r*Math.cos(this.a*(Math.PI/180.0)));
   }
   public double yCoordinate()
   {
      return (this.r*Math.sin(this.a*(Math.PI/180.0)));
   }
   public double radius()
   {
      if(this.r<0.0)
      {
         this.a=this.a+180.0;
         return -(this.r);
      }
      else
      {
         return this.r;
      }
   }
   public double angle()
   {
      while(this.a<0.0)
      {
         this.a=this.a+360.0;
      }
      return this.a;
   }
   public Point rotate90()
   {
      Point p = new PolarPoint(this.r, this.a+90.0);
      return p;
   }
}
