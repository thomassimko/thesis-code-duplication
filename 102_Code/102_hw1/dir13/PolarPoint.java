public class PolarPoint implements Point
{
   private double radius;
   private double angle;
   private double x;
   private double y;
   
   public PolarPoint(double radius, double angle)
   {
      this.radius=radius;
      this.angle=angle;
   }

   public double xCoordinate()
   {
      this.x = this.radius*Math.cos(this.angle);
      return this.x;
   }

   public double yCoordinate()
   {
      this.y = this.radius*Math.sin(this.angle);
      return this.y;
   }
   public double radius()
   {
      this.radius = radius;
      return this.radius;
   }

   public double angle()
   {
      this.angle = angle;
      return this.angle;
   }

   public Point rotate90()
   {
      this.angle = this.angle+(Math.PI/2);
      return new PolarPoint(this.radius, this.angle);
   }
}
