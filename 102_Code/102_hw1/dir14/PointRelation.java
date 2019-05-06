import java.util.Scanner;

public class PointRelation {
	
	public static double distance(Point a, Point b) {
		return Math.sqrt(Math.pow((a.xCoordinate()-b.xCoordinate()),2) +
						Math.pow((a.yCoordinate()-b.yCoordinate()),2));
	}
	
	public static String sameQuadrant(Point a, Point b) {
		return (a.xCoordinate()*b.xCoordinate() > 0 &&
				a.yCoordinate()*b.yCoordinate() > 0) ?
				"In the same quadrant" : "Not in the same quadrant";
	}
	
	public static void main(String[] args) {
		Point[] points = new Point[2];
		
		Scanner scn = new Scanner(System.in);

		for (int i = 0; i < 2; i++) {
			System.out.print("Enter 1 for Cartesian Points or 2 for Polar Points: ");
			switch (scn.nextInt()) {
				case 1:
						System.out.print("Please input the X coordinate: ");
						double x = scn.nextDouble();
						System.out.print("Please input the Y coordinate: ");
						double y = scn.nextDouble();
						points[i] = new CartesianPoint(x, y);
						break;
				case 2: 
						System.out.print("Please input the radius: ");
						double r = scn.nextDouble();
						System.out.print("Please input the angle (in degrees): ");
						double a = scn.nextDouble()/180*Math.PI;
						points[i] = new PolarPoint(r, a);
//						System.out.println(points[i].xCoordinate() + " " + points[i].yCoordinate());
						break;
				default:
						System.out.println("You chose a wrong option. Exiting..");
						System.exit(0);
			}
			System.out.println();
		}
		System.out.println("The distance between these 2 points is " + distance(points[0],points[1]));
		System.out.println(sameQuadrant(points[0],points[1]));
	}
}