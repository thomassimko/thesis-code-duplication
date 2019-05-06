public class PolarTestCases {
	
	public static void checkCoordinates(PolarPoint a, PolarPoint b) {
		Check.check(a.xCoordinate(), b.xCoordinate());
		Check.check(a.yCoordinate(), b.yCoordinate());
	}
	
	public static void main(String[] args) {
		PolarPoint xy = new PolarPoint(2,Math.PI/3);
		Check.check(xy.xCoordinate(), 1);
		Check.check(xy.yCoordinate(), Math.sqrt(3));
		Check.check(xy.radius(), 2);
		Check.check(xy.angle(), Math.PI/3);
		checkCoordinates(xy.rotate90(),new PolarPoint(2,Math.PI/6*-1));
	}
}
