public class PolarPoint
	implements Point
{
	private double radius;
	private double angle;
	
	public PolarPoint(double radius, double angle)
	{
		this.radius = radius;
		this.angle = angle;
		
		if(this.radius<0)
		{
			this.radius = -this.radius;
			this.angle = this.angle - Math.PI;
		}

		while(this.angle<0)
		{
			this.angle = this.angle + (2 * Math.PI);
		}
	}

	public double xCoordinate()
	{
		return this.radius * Math.cos(this.angle);
	}

	public double yCoordinate()
	{
		return this.radius * Math.sin(this.angle);
	}

	public double radius()
	{
		return this.radius;
	}

	public double angle()
	{
		return this.angle;
	}

	public PolarPoint rotate90()
	{
		double new_angle;

		new_angle = this.angle + (Math.PI / 2);

		return new PolarPoint(this.radius, new_angle);
	}
}
