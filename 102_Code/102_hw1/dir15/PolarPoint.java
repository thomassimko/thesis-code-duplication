public class PolarPoint
   implements Point
{
   Point p;
   private double r;
   private double theta;

   public PolarPoint(double radius, double angle)
   {
      this.r = radius;
      this.theta = angle;
   }
   public double xCoordinate()
   {
      //double theta1 = (theta*Math.PI)/180;
      //double theta1 = Math.toRadians(theta);
      return r*Math.cos(theta);
   }
   public double yCoordinate()
   {
      //double theta2 = (theta*Math.PI)/180;
      //double theta2 = Math.toRadians(theta);
      return r*Math.sin(theta);
   }
   public double radius()
   {
      return r;
   }
   public double angle()
   {
      return theta;
   }
   public Point rotate90()
   {
      return new PolarPoint(r, theta+90);
   }
}
