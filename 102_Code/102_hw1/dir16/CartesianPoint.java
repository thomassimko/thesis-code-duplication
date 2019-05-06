public class CartesianPoint
   implements Point 
{
   private double x, y;
   
   public CartesianPoint(double x_coordinate, double y_coordinate)
   {
      this.x = x_coordinate;
      this.y = y_coordinate;
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
      return Math.sqrt(x*x + y*y);
   }
   public double angle()
   {
      if (Math.atan2(y,x)<0) 
      {
         return Math.atan2(y,x) + 2*Math.PI;
      }
      return Math.atan2(y,x);
   }
   public Point rotate90()
   {
      Point p2 = new CartesianPoint(-this.y, this.x);
      
      return p2;
   }
}