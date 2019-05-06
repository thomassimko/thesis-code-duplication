public class CartesianPoint implements Point
{
   double x_coord;
   double y_coord;

   public CartesianPoint(double x_coord, double y_coord)
   {
      this.x_coord = x_coord;
      this.y_coord = y_coord;
   }
  
   public double xCoordinate()
   {
      return x_coord;
   }
   
   public double yCoordinate()
   {
      return y_coord;
   }
   
   public double radius()
   {
      return Math.sqrt((x_coord * x_coord) + (y_coord * y_coord));
   }
   
   public double angle()
   {
      return Math.atan2(y_coord, x_coord);
   }

   public Point rotate90()
   {
      Point pt = new CartesianPoint(-1*y_coord, x_coord);
      return pt;
   }
}
