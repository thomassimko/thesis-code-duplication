import java.lang.Math;

public class CartesianPoint
	implements Point
{
	double x_coord;
	double y_coord;
	double radius;
	
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
		if (x_coord == 0 || y_coord == 0)
			return 0.0;
		else
		{
			radius = Math.sqrt( Math.pow((x_coord-0),2) + Math.pow((y_coord-0),2) );
			return radius;
		}
	}
	
	public double angle()
	{
		if ( x_coord == 0 || y_coord == 0 )
			return 0.0;
		else if ( y_coord < 0 && x_coord < 0)
		{
			return Math.atan(y_coord/x_coord)+Math.PI;
		}
		else if ( x_coord < 0 && y_coord > 0 )
		{
			return Math.atan(y_coord/x_coord)+Math.PI;
		}
		else if ( x_coord > 0 && y_coord < 0 )
		{
			return Math.atan(y_coord/x_coord)+2*Math.PI;
		}
		return Math.atan(y_coord/x_coord);
	}
	
	public Point rotate90()
	{
		Point p1 = new CartesianPoint( (-1)*y_coord, x_coord);
		return p1;
	}
}