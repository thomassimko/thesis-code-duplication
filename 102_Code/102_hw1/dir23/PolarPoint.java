public class PolarPoint
   implements Point
{
   private double rad;
   private double ang;
   public PolarPoint(double radius, double angle)
   {
      this.rad = radius;
      this.ang = angle;
      if(this.rad < 0)
      {
         this.rad = -1 * this.rad;
         this.ang = this.ang + Math.PI;
      }
      if(this.ang < 0)
      {
         this.ang = this.ang + 2*Math.PI;
      }
   }
   public double xCoordinate()
   {
      if(this.rad==0)
      {
         return 0;
      }
      double xVal = this.rad*Math.cos(ang);
      return xVal;
   }
   public double yCoordinate()
   {
      if(this.rad==0)
      {
         return 0;
      }
      double yVal = this.rad*Math.sin(ang);
      return yVal;
   }
   public double radius()
   {
      return this.rad;
   }
   public double angle()
   {
      return this.ang;
   }
   public Point rotate90()
   {
      double newAng = this.ang + Math.PI/2;
      Point pt = new PolarPoint(this.rad,newAng);
      return pt;
   }
}

