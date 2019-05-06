public class CartesianPoint
implements Point
{
	private double x_coord;
	private double y_coord;
	
	public CartesianPoint(double x_coord, double y_coord) {
		this.x_coord = x_coord;
		this.y_coord = y_coord;
	}
	public double xCoordinate() {
		return this.x_coord;
	}

	public double yCoordinate() {
		return this.y_coord;
	}

	public double radius() { 
		return Math.sqrt((this.x_coord * this.x_coord) + (this.y_coord * this.y_coord));
	}

	public double angle() {
		if(this.y_coord == 0 && this.x_coord == 0) {
			return 0.0;
		}else if(this.y_coord < 0) {
			return Math.atan2(this.y_coord, this.x_coord) + (2 * Math.PI);
		}else {
			return Math.atan2(this.y_coord, this.x_coord);
		}
	}

	public Point rotate90() {
		double x = -this.yCoordinate();
		double y = this.xCoordinate();
		Point rotatedPoint = new CartesianPoint(x,y);
		return rotatedPoint;
	}
}