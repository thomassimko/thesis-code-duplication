public class CartesianPoint 
   implements Point
{
   private double x_coord, y_coord;
   public static final double MAX_DEGREES = 180.0;
   public CartesianPoint(double x_coord, double y_coord)
   {
      this.x_coord=x_coord;
      this.y_coord=y_coord;
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
      return Math.sqrt( (this.x_coord*this.x_coord) + (this.y_coord*this.y_coord) );
   }
   public double angle()
   {
      double angle = 0.0;
      if((this.x_coord != 0.0) && (this.y_coord !=0))
      {
         angle = (Math.atan2(this.y_coord, this.x_coord));
      }
      if((this.x_coord < 0) && (this.y_coord < 0))
      {
         angle = angle + 2 * Math.PI;
      }
      if((this.x_coord > 0) && (this.y_coord < 0))
      {
         angle = angle + 2 * Math.PI;
      }
      return(angle);
   }
   public Point rotate90()
   {
      double newX_Coord;
      double newY_Coord;
      double newAngle = (Math.PI/2) + this.angle();
      newX_Coord = (this.radius() * Math.cos(newAngle));
      newY_Coord = (this.radius() * Math.sin(newAngle));
      Point result = new CartesianPoint(newX_Coord, newY_Coord);
      return result;
   }
}

