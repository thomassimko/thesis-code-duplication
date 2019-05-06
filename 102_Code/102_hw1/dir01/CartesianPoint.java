public class CartesianPoint
   implements Point
{
   private double y;
   private double x;

   public CartesianPoint(double x,double y)
   {
      this.x = x;
      this.y = y;
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
      if (this.x<.00001 && this.y<.00001)
      {
         return 0;
      }
      return Math.sqrt(x*x+y*y);
   }
   public double angle()
   {
      if (this.x<.00001 && this.y<.00001)
      {
         return 0;
      }
      return Math.atan2(this.y,this.x);
   }
   public Point rotate90()
   {
      return new CartesianPoint(-this.y,this.x);
   }
}
