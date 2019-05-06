public class CartesianPoint implements Point
{
   public double x_coord;
   public double y_coord;
   public CartesianPoint(double x_coord, double y_coord)
   {
      this.x_coord = x_coord;
      this.y_coord = y_coord;
   }
   public double xCoordinate()
   {
      return this.x_coord;
   }
   public double yCoordinate()
   {
      return this.y_coord;
   }
   public double radius()
   {
      return Math.sqrt((y_coord*y_coord)+(x_coord*x_coord));
   }
   public double angle()
   {
      return Math.atan2(y_coord, x_coord);
   }
   public Point rotate90()
   {
      double x = -y_coord;
      double y = x_coord;
      Point pt = new CartesianPoint(x, y);
      return pt;
   }
}
