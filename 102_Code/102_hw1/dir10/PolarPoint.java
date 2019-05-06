public class PolarPoint
   implements Point
{
   private double r, a;
	
	public PolarPoint(double radius, double angle)
	{
	   r = radius;
      a = angle;
	   if(r < 0)
      {
         r = -r;
         a = a + Math.PI;
      } 
      while(a < 0)
      {
         a = a + 2*Math.PI;
      }
	}
	
	public double xCoordinate()
	{
		return r * Math.cos(a);
	}
	
	public double yCoordinate()
	{
      return r * Math.sin(a);
	}
	
	public double radius()
	{
	   return r;
	}
	
	public double angle()
	{
	   return a;
	}
	
	public Point rotate90()
	{
      Point p = new PolarPoint(r, a+Math.PI/2);
		return p;
	}
}
