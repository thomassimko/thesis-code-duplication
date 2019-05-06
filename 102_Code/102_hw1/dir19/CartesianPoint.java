public class CartesianPoint
    implements Point
{
    private double x;
    private double y;
    private double radius;
    private double angle;

    public CartesianPoint(double xCoord, double yCoord)
    {
	x = xCoord;
	y = yCoord;
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
	radius = Math.sqrt((x*x)+(y*y));
	return radius;
    }
    public double angle()
    {
	angle = Math.atan2(y, x);
	return angle;
    }
    public Point rotate90()
    {
	Point rotatedPoint = new CartesianPoint(-y, x);
	return rotatedPoint;
    }
}