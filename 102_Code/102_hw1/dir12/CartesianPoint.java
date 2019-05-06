public class CartesianPoint
    implements Point
{
    private double x_coord, y_coord;
    
    public CartesianPoint()
    {
	x_coord = 0;
	y_coord = 0;
    }
    
    public CartesianPoint(double x_coord, double y_coord)
    {
	this.x_coord = x_coord;
	this.y_coord = y_coord;
    }
    
    public double xCoordinate()
    {
	//returns the x-coordinate
	return this.x_coord;
    }
    
    public double yCoordinate()
    {
	//returns y-coordinate
	return this.y_coord;
    }

    public double radius()
    {
	//returns the distance from the origin to the point
	return Math.sqrt(((x_coord) * (x_coord)) + ((y_coord) * (y_coord)));
    }

    public double angle()
    {
	//returns the counterclockwise angle (in rad) from the x-axis
	return Math.atan2(y_coord, x_coord);
    }

    public CartesianPoint rotate90()
    {
	//returns newly created Point representing a 90 degress (ccw) rotation of this point about the origin
	if(x_coord > 0 && y_coord > 0)
	    {
		return new CartesianPoint(this.y_coord * -1, this.x_coord);
	    }
	else if(x_coord < 0 && y_coord > 0)
	    {
		return new CartesianPoint(this.y_coord * -1, this.x_coord * -1); 
	    }
	else if(x_coord < 0 && y_coord < 0)
	    {
		return new CartesianPoint(this.y_coord, this.x_coord);
	    }
	else if(x_coord > 0 && y_coord < 0)
	    {
		return new CartesianPoint(this.y_coord, this.x_coord * -1);
	    }
	else
	    {
		return new CartesianPoint(0, 0);
	    }
    }
}