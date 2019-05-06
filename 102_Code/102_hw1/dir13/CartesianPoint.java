public class CartesianPoint implements Point
{
   private double x;
   private double x2;
   private double y;
   private double y2;
   private double radius;
   private double angle;

   public CartesianPoint(double x_coord, double y_coord)
   {
      this.x = x_coord;
      this.y = y_coord;
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
     this.radius = Math.sqrt(x*x+y*y);
     return this.radius; 
   }

   public double angle()
   {
      this.angle = Math.atan2(this.y,this.x);
      return this.angle;
   }
 
   public Point rotate90()
   {
      this.x2 = (-1)*this.y;
      this.y2 = this.x;
      return new CartesianPoint(x2, y2);
   }
}

