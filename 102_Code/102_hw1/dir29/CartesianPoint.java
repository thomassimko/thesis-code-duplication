public class CartesianPoint
   implements Point
{
   private double x, y;
   public CartesianPoint(double x_coord, double y_coord)
   {
      this.x=x_coord;
      this.y=y_coord;
   }
   public double xCoordinate()
   {
      return this.x;
   }
   public double yCoordinate()
   {
      return this.y;
   }
   public double radius()
   {
      return Math.sqrt((this.x*this.x)+(this.y*this.y));
   }
   public double angle()
   {
      return (Math.atan2(this.y, this.x))*(180.0/Math.PI);
   }
   public Point rotate90()
   {
      Point p = new CartesianPoint(-(this.y), this.x);
      return p;
   }
}
