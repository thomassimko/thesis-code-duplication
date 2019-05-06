import java.lang.Math;

public class PolarPoint
	implements Point
{
	private double radius;
	private double angle;
	
	public PolarPoint(double radius, double angle)
	{
		this.radius = radius;
		this.angle = angle;
		while ( this.angle < 0 )
		{
			this.angle = this.angle + 2*Math.PI;
		}
	}
	
	public double xCoordinate()
	{
		if ( this.radius == 0)
			return 0.0;
		else
			return this.radius*Math.cos(this.angle);
	}
	
	public double yCoordinate()
	{
		if ( this.radius == 0.0 )
			return 0.0;
		else
			return this.radius*Math.sin(this.angle);
	}
	
	public double radius()
	{
		if ( this.radius == 0 )
			return 0.0;
		else
			return this.radius;
	}
	
	public double angle()
	{
		return angle;			
	}
	
	public Point rotate90()
	{
		Point a1 = new PolarPoint(this.radius, this.angle+(Math.PI/2));
		return a1;
	}
}