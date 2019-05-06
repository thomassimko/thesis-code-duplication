
public class PolarPoint implements Point{
	
	private double radius, angle;
	
	public PolarPoint(double radius, double angle){
		this.radius=radius;
		this.angle=angle;
	}

	@Override
	public double xCoordinate() {
		return radius*Math.cos(angle);
	}

	@Override
	public double yCoordinate() {
		return radius*Math.sin(angle);
	}

	@Override
	public double radius() {
		return radius;
	}

	@Override
	public double angle() {
		return angle;
	}

	@Override
	public Point rotate90() {
		return new PolarPoint(radius,angle+Math.PI/2);
	}
}
