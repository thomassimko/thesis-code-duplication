public class PolarPoint
    implements Point
{
    double radius;
    double angle;
    
    public PolarPoint()
    {
	radius = 0;
	angle = 0;
    }
    
    public PolarPoint(double radius, double angle)
    {
	this.radius = radius;
	this.angle = angle;
	if(this.radius < 0)
	    {
		this.radius = (this.radius * (-1));
		this.angle = this.angle - 180.0;
	    }

	if(this.angle < 0)
	    {
		this.angle = this.angle + 360;
	    }
	//this.angle = this.angle * (Math.PI/180);
    }

    public double xCoordinate()
    {
	return Math.cos(this.angle * (Math.PI/180)) * this.radius;
	//cos(angle) * distance
    }

    public double yCoordinate()
    {
	return Math.sin(this.angle * (Math.PI/180)) * this.radius;
	//sin(angle) * distance
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
	return new PolarPoint(this.radius, this.angle + 90);
    }
}