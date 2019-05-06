public class CartesianTestCases {
	
	private static Point test1 = new CartesianPoint(0,0);
	private static Point test2 = new CartesianPoint(1,0);
	private static Point test3 = new CartesianPoint(0,1);
	private static Point test4 = new CartesianPoint(2,2);
	private static Point test5 = new CartesianPoint(-2,-2);
	
	public static void main(String [] args){
		checkXCoordinate();
		checkYCoordinate();
		checkRadius();
		checkAngle();
		checkRotate90();
	}
	public static void checkXCoordinate(){
		Check.check(test1.xCoordinate(), 0);
		Check.check(test2.xCoordinate(), 1);
		Check.check(test3.xCoordinate(), 0);
		Check.check(test4.xCoordinate(), 2);
		Check.check(test5.xCoordinate(), -2);
	}
	private static void checkYCoordinate() {
		Check.check(test1.yCoordinate(), 0);
		Check.check(test2.yCoordinate(), 0);
		Check.check(test3.yCoordinate(), 1);
		Check.check(test4.yCoordinate(), 2);
		Check.check(test5.yCoordinate(), -2);
	}
	private static void checkRotate90() {
		Point test1_90=test1.rotate90();
		Point test2_90=test2.rotate90();
		Point test3_90=test3.rotate90();
		Point test4_90=test4.rotate90();
		Point test5_90=test5.rotate90();
		
		Check.check(test1_90.xCoordinate(), 0);
		Check.check(test1_90.yCoordinate(), 0);
		
		Check.check(test2_90.xCoordinate(), 0);
		Check.check(test2_90.yCoordinate(), 1);
		
		Check.check(test3_90.xCoordinate(), -1);
		Check.check(test3_90.yCoordinate(), 0);
		
		Check.check(test4_90.xCoordinate(), -2);
		Check.check(test4_90.yCoordinate(), 2);
		
		Check.check(test5_90.xCoordinate(), 2);
		Check.check(test5_90.yCoordinate(), -2);
	}
	private static void checkAngle() {
		Check.check(test1.angle(), 0);
		Check.check(test2.angle(), 0);
		Check.check(test3.angle(), Math.PI/2);
		Check.check(test4.angle(), Math.PI/4);
		Check.check(test5.angle(), -3*Math.PI/4);
	}
	private static void checkRadius() {
		Check.check(test1.radius(), 0);
		Check.check(test2.radius(), 1);
		Check.check(test3.radius(), 1);
		Check.check(test4.radius(), Math.sqrt(8));
		Check.check(test5.radius(), Math.sqrt(8));
	}
	
}
