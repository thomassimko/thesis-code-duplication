public class PolarPoint
    implements Point
{
    private double x;
    private double y;
    private double angle;
    private double radius;

    public PolarPoint(double radius, double angle)
    {
	this.radius = radius;
	this.angle = angle;
    }
    public double xCoordinate()
    {
	x = radius * Math.cos(angle);
	return x;
    }
    public double yCoordinate()
    {
	y = radius * Math.sin(angle);
	return y;
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
	Point rotatedPoint = new PolarPoint(radius, this.angle + Math.PI/2);
	return rotatedPoint;
    }
}