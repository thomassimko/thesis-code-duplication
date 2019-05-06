public class CartesianPoint
    implements Point
{
    private double x, y;

    public CartesianPoint(double xCoord, double yCoord)
    {
	this.x = xCoord;
	this.y = yCoord;
    }

    public double xCoordinate()
    {
	return this.x;
    }
    public double yCoordinate()
    {
	return this.y;
    }
    public double radius()
    {
	return Math.sqrt((this.x * this.x) + 
			 (this.y * this.y));
    }
    public double angle()
    {
	return Math.atan2(this.y, this.x);
    }
    public Point rotate90()
    {
	Point p90 = new CartesianPoint(-(this.y), this.x);

	return p90;
    }
}