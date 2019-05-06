public class CartesianPoint
   implements Point
{
   private double x, y;

   public CartesianPoint(double x_coord, double y_coord)
	{
	   x = x_coord;
		y = y_coord;
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
	   return Math.sqrt(x*x + y*y);
	}
	
	public double angle()
	{
	   if(Math.atan2(y, x) < 0)
		{ 
		   return Math.atan2(y, x) + 2*Math.PI;
		}
	   return Math.atan2(y, x);
	}
	
	public Point rotate90()
	{
           Point p = new CartesianPoint(-y, x);
           return p;
	}
}
	   
