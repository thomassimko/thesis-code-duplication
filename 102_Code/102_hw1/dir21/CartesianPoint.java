public class CartesianPoint
   implements Point
{
   private double xCord;
   private double yCord;
   
   CartesianPoint(double x_coord, double y_coord)
   {
      this.xCord = x_coord;
      this.yCord = y_coord;
   }
   
   public double xCoordinate()
   {
      return this.xCord;
   }
   
   public double yCoordinate()
   {
      return this.yCord;
   }
   
   public double radius()
   {
     return Math.sqrt(this.xCord*this.xCord + this.yCord*this.yCord);
   }
   
   public double angle()
   {
      return Math.atan2(this.yCord, this.xCord);
   }
   
   public Point rotate90()
   {
      double x90;
      double y90;
      x90 = this.yCord * -1;
      y90 = this.xCord;
      return new CartesianPoint(x90, y90);
   }

}