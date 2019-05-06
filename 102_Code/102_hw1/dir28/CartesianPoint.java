public class CartesianPoint
	implements Point
{
	public double x, y, r, a;
	public CartesianPoint(double x_coord, double y_coord)
	{
		this.x = x_coord;
		this.y = y_coord;
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
		if (x == 0 && y == 0)
		{
			return 0.0;
		}
		this.r = Math.sqrt(x*x+y*y);
		return this.r;
	}
	public double angle()
	{
		if (y<0 && x<0)
		{
			this.a = Math.atan(y/x)+Math.PI;
			return this.a;
		}
		else if (x<0 && y>0)
		{
			this.a = Math.atan(y/x)+Math.PI;
			return this.a;
		}
		else if (x>0 && y<0)
		{
			this.a = Math.atan(y/x)+2*Math.PI;
			return this.a;
		}
		this.a = Math.atan(y/x);
		return this.a;
	}
	public Point rotate90()
	{
		Point cart = new CartesianPoint(-y, x);
		return cart;
	}
}