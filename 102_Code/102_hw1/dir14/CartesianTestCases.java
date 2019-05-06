public class CartesianTestCases {
	
	public static void checkCoordinates(CartesianPoint a, CartesianPoint b) {
		Check.check(a.xCoordinate(), b.xCoordinate());
		Check.check(a.yCoordinate(), b.yCoordinate());
	}
	
	public static void main(String[] args) {
		CartesianPoint xy = new CartesianPoint(3,4);
		checkCoordinates(xy, new CartesianPoint(3,4));
		Check.check(xy.radius(), 5);
		Check.check(xy.angle(), Math.atan2(4,3));
		checkCoordinates(xy.rotate90(),new CartesianPoint(4,-3));
	}
}
