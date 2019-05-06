public class CartesianPoint
   implements Point
{
   private double x_coord;
   private double y_coord;

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
      return (Math.sqrt(this.y_coord*this.y_coord + this.x_coord*this.x_coord));
   }

   public double angle()
   {
      return (Math.atan2(this.y_coord, this.x_coord));
   }

   public Point rotate90()
   {
      Point newPoint = new CartesianPoint(-this.y_coord, this.x_coord);

      return newPoint;
   }
}
