import java.lang.Math;

public class CartesianPoint
    implements Point
{
    private double xCoord;
    private double yCoord;

    public CartesianPoint(double x_coord, double y_coord)
    {
	this.xCoord = x_coord;
	this.yCoord = y_coord;
    }

    public double xCoordinate()
    {
	return xCoord;
    }
    public double yCoordinate()
    {
	return yCoord;
    }
    public double radius()
    {
	double radius;
	radius = Math.sqrt((xCoord*xCoord)+(yCoord*yCoord));
	return radius;
    }
    public double angle()
    {
	double angle;
	angle = Math.atan2(yCoord, xCoord);
	return angle;
    }
    public Point rotate90()
    {
	double angle90, x90, y90;
	double halfPi = 3.14159/2;
	angle90 = angle() + halfPi;
	x90 = radius()*Math.cos(angle90);
	y90 = radius()*Math.sin(angle90);
	Point pt90 = new CartesianPoint(x90, y90);
	return pt90;
    }
}