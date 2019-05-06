public class CartesianPoint
   implements Point
{
   Point p;
   private double x;
   private double y;

   public CartesianPoint(double x_coord, double y_coord)
   {
      this.x = x_coord;
      this.y = y_coord;
   }
   public double xCoordinate()
   {
      return x;      
   }
   public double yCoordinate()
   {
      return y;
   }
   public double radius()
   {
      return Math.sqrt((x*x) + (y*y));
   }
   public double angle()
   {
      return (Math.atan2(y, x)*180)/Math.PI;
   }
   public Point rotate90()
   {
      return new CartesianPoint(-y, x);
   }   
}
