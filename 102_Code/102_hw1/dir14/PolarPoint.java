public class PolarPoint implements Point{
	
	double rad, ang;
	
	public PolarPoint(double radius, double angle) {
		if (radius > 0) {
			rad = radius;
		} else {
			rad = radius * -1;
			angle = angle + Math.PI;
		}
		
		while (angle < 0) {
			angle += Math.PI * 2;
		}
		ang = angle;
	}

	public double xCoordinate() {
		return rad*Math.cos(ang);
	}
	
	public double yCoordinate() {
		return rad*Math.sin(ang);
	}
	
	public double radius() {
		return rad;
	}
	
	public double angle() {
		return ang;
	}
	
	public PolarPoint rotate90() {
		return new PolarPoint(rad, ang-Math.PI/2);
	}
}