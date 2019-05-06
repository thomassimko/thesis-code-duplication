public class PolarPoint
implements Point
{
	private double radius;
	private double angle;
	
	public PolarPoint(double radius, double angle) {
		if(radius < 0) {	
			angle = angle - (Math.PI);
		}
		while(angle < 0)
		{
			angle = angle + (2 * Math.PI);
		}
		this.radius = Math.abs(radius);
		this.angle = angle;
	}
	public double xCoordinate() {
		return this.radius * Math.cos(this.angle);
	}

	public double yCoordinate() {
		return this.radius * Math.sin(this.angle);
	}

	public double radius() {
		return this.radius;
	}

	public double angle() {
		return this.angle;
	}

	public Point rotate90() {
		double a = this.angle + (Math.PI / 2);
		Point rotatedPoint = new PolarPoint(this.radius,a);
		return rotatedPoint;
	}
}