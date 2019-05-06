public class PolarPoint
    implements Point
{
    private double radius, angle;
    
    public PolarPoint(double r, double a)
    {
	while(a < 0)
	    {
		a = a + 2*Math.PI;
	    }
	if(r < 0)
            {
                this.radius = -r;
                this.angle = a + Math.PI;
            }
	else
	    {
		this.radius = r;
		this.angle = a;
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

    public Point rotate90()
    {
	Point p90 = new PolarPoint(this.radius, this.angle + Math.PI/2);
	return p90;
    }
}