public class CartesianPoint
	implements Point
{
	private double x_coord;
	private double y_coord;
	
	public CartesianPoint(double x_coord, double y_coord)
	{
		this.x_coord = x_coord;
		this.y_coord = y_coord;
	}

	public double xCoordinate()
	{
		return this.x_coord;
	}

	public double yCoordinate()
	{
		return this.y_coord;
	}

	public double radius()
	{
		return Math.sqrt(Math.pow(this.x_coord,2) + Math.pow(this.y_coord,2));
	}

	public double angle()
	{
		return Math.atan2(this.y_coord, this.x_coord);
	}

	public Point rotate90()
	{
		double new_x, new_y;
		
		new_x = -this.y_coord;
		new_y = this.x_coord;

		return new CartesianPoint(new_x, new_y);
	}
}
