public class PolarPoint
  implements Point
{
   private double radius;
   private double angle;
   
   PolarPoint(double radius, double angle)
   {
   
      if (radius < 0)
      {
         radius = radius * -1.0;
         angle = angle + Math.PI;
      }
		
		if (angle < 0)
		{
		   while( angle < 0)
			{
		      angle = angle + 2*Math.PI;
			}
		}
      
      this.radius = radius;
      this.angle = angle;
   }
   
    public double xCoordinate()
   {
      return Math.cos(this.angle)*this.radius;
   }
   
   public double yCoordinate()
   {
      return Math.sin(this.angle)*this.radius;  
   }
   
   public double radius()
   {
     return this.radius;
   }
   
   public double angle()
   {
      return this.angle;
   }
   
   public Point rotate90()
   {
      double radius90, angle90;
      angle90 = this.angle + Math.PI/2;
      
      return new PolarPoint(this.radius, angle90);
   }
}