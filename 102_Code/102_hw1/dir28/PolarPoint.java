public class PolarPoint
	implements Point
{
	public double x, y, r, a;
	public PolarPoint(double radius, double angle)
	{
		this.r = radius;
		this.a = angle;
		while (this.a < 0)
		{
			this.a = this.a + 2*Math.PI;
		}
	}
	public double radius()
	{
		if (this.r == 0.0)
		{
			return 0.0;
		}
		if (this.r < 0)
		{
			return -this.r;
		}
		return this.r;
	}
	public double angle()
	{
		return this.a;
	}
	public double xCoordinate()
	{
		return r*Math.cos(a);
	}
	public double yCoordinate()
	{
		return r*Math.sin(a);
	}
	public Point rotate90()
	{
		Point b = new PolarPoint(this.r, this.a + Math.PI/2);
		return b;
	}
}