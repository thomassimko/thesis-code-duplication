public class CartesianPoint implements Point{
	private double x_coord, y_coord;

	public CartesianPoint(double x_coord, double y_coord){
		this.x_coord=x_coord;
		this.y_coord=y_coord;
	}

	@Override
	public double xCoordinate() {
		return x_coord;
	}

	@Override
	public double yCoordinate() {
		return y_coord;
	}

	@Override
	public double radius() {
		return Math.sqrt(Math.pow(x_coord, 2)+Math.pow(y_coord, 2));
	}

	@Override
	public double angle() {
		return Math.atan2(y_coord, x_coord);
	}

	@Override
	public Point rotate90() {
		Point polarPoint = new PolarPoint(this.radius(),this.angle()).rotate90();
		return new CartesianPoint(polarPoint.xCoordinate(),polarPoint.yCoordinate());
	}

}
