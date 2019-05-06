import java.lang.Math;

public class PolarPoint
    implements Point
{
    private double rad;
    private double ang;

    public PolarPoint(double radius, double angle)
    {
	this.rad = radius;
	this.ang = angle;
	if (this.rad < 0)
	    {
		this.rad = Math.abs(radius);
		this.ang = this.ang + 3.14159625;
	    }
	while (this.ang < 0)
	    {
		if (this.ang < 0)
		    {
			this.ang = this.ang + (2*3.14159625);
		    }
	    }
    }
    public double xCoordinate()
    {
	double x_coordinate;
	x_coordinate = rad*Math.cos(ang);
	return x_coordinate;
    }
    public double yCoordinate()
    {
	double y_coordinate;
	y_coordinate = rad*Math.sin(ang);
	return y_coordinate;
    }
    public double radius()
    {
	return rad;
    }
    public double angle()
    {
	return ang;
    }
    public Point rotate90()
    {
	double angle90, radius90;
	angle90 = ang + (3.14159625/2);
	radius90 = rad;
	Point pt90 = new PolarPoint (radius90, angle90);
	return pt90;
    }
}