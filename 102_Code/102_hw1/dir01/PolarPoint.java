public class PolarPoint
   implements Point
{
   private double radius;
   private double radians;
   
   public PolarPoint(double radius,double degrees)
   {
      this.radius = radius;
      this.radians = degrees*Math.PI/180;
      if (radius<0)
      {
         this.radius = -this.radius;
         this.radians = this.radians+Math.PI;
      }
      while (this.radians<0)
      {
         this.radians = this.radians + Math.PI*2;
      }
   }
   public double xCoordinate()
   {
      return Math.cos(this.radians)*this.radius;
   }
   public double yCoordinate()
   {
      return Math.sin(this.radians)*this.radius;
   }
   public double radius()
   {
      return this.radius;
   }
   public double angle()
   {
      return this.radians*180/Math.PI;      
   }
   public Point rotate90()
   {
      return new PolarPoint(this.radius,this.radians + Math.PI/2);
   }
}
