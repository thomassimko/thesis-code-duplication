public class CartesianPoint implements Point {
	private double xCoord,yCoord;
	
	public CartesianPoint(double x_coord, double y_coord) {
		xCoord = x_coord;
		yCoord = y_coord;
	}
	
	public double xCoordinate() {
		return xCoord;
	}
	
	public double yCoordinate() {
		return yCoord;
	}
	
	public double radius() {
		return Math.sqrt(xCoord*xCoord+yCoord*yCoord);
	}
	
	public double angle() {
		return Math.atan2(yCoord,xCoord);
	}
	
	public CartesianPoint rotate90() {
		return new CartesianPoint(yCoord * -1, xCoord);
	}
}
