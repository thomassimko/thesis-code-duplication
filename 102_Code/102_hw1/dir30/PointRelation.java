import java.util.ArrayList;
import java.util.Scanner;

public class PointRelation{
	public static void main(String [] args) {
		Scanner scan = new Scanner(System.in);
		
		Point pointA = null, pointB = null;
		System.out.print("Which type of point should be created (1 for Cartesian, 2 for Polar)? ");
		int typeA = 0;
		
		try {
		typeA = Integer.parseInt(scan.next());
		} catch(NumberFormatException e){
			System.out.print("\nNot a valid input.");
	    	System.exit(1);	
		}
		
	    if(typeA == 1) {
	    	double x = 0, y = 0;
	    	
	    	System.out.print("Enter x-coordinate: ");
		    try {
		    	x = Double.parseDouble(scan.next());
		    } catch(NumberFormatException e){
		    	System.out.print("\nNot a valid input.");
		    	System.exit(1);	
		    }
		    
		    System.out.print("Enter y-coordinate: ");
		    try {
		    	y = Double.parseDouble(scan.next());
			} catch(NumberFormatException e){
		    	System.out.print("\nNot a valid input.");
		    	System.exit(1);	
		    }
		    
		    pointA = new CartesianPoint(x,y);
	    }
	    else if(typeA == 2) {
	    	double radius = 0, angle = 0;
	    	
	    	System.out.print("Enter radius: ");
		    try {
		    	radius = Double.parseDouble(scan.next());
		    } catch(NumberFormatException e){
		    	System.out.print("\nNot a valid input.");
		    	System.exit(1);	
		    }
		    
		    System.out.print("Enter angle: ");
		    try {
		    	angle = Math.toRadians(Double.parseDouble(scan.next()));
			} catch(NumberFormatException e){
		    	System.out.print("\nNot a valid input.");
		    	System.exit(1);
		    }
		    
		    pointA = new PolarPoint(radius,angle);
	    }
	    else{
	    	System.out.print("\nNot a valid input.");
	    	System.exit(1);
	    }
	    
	    System.out.print("Which type of point should be created (1 for Cartesian, 2 for Polar)? ");
		
		try {
		typeA = Integer.parseInt(scan.next());
		} catch(NumberFormatException e){
			System.out.print("\nNot a valid input.");
	    	System.exit(1);	
		}
		
	    if(typeA == 1) {
	    	double x = 0, y = 0;
	    	
	    	System.out.print("Enter x-coordinate: ");
		    try {
		    	x = Double.parseDouble(scan.next());
		    } catch(NumberFormatException e){
		    	System.out.print("\nNot a valid input.");
		    	System.exit(1);	
		    }
		    
		    System.out.print("Enter y-coordinate: ");
		    try {
		    	y = Double.parseDouble(scan.next());
			} catch(NumberFormatException e){
		    	System.out.print("\nNot a valid input.");
		    	System.exit(1);	
		    }
		    
		    pointB = new CartesianPoint(x,y);
	    }
	    else if(typeA == 2) {
	    	double radius = 0, angle = 0;
	    	
	    	System.out.print("Enter radius: ");
		    try {
		    	radius = Double.parseDouble(scan.next());
		    } catch(NumberFormatException e){
		    	System.out.print("\nNot a valid input.");
		    	System.exit(1);	
		    }
		    
		    System.out.print("Enter angle: ");
		    try {
		    	angle = Math.toRadians(Double.parseDouble(scan.next()));
			} catch(NumberFormatException e){
		    	System.out.print("\nNot a valid input.");
		    	System.exit(1);
		    }
		    
		    pointB = new PolarPoint(radius,angle);
	    }
	    else{
	    	System.out.print("\nNot a valid input.");
	    	System.exit(1);
	    }	    
	    
		double distance = distance(pointA,pointB);
	    System.out.print("Distance between points: " + distance);
	    if(sameQuad(pointA,pointB)) {
	    	System.out.print("\nIn same quadrant.\n");
	    }
	    else {
	    	System.out.print("\nNot in same quadrant.\n");
	    }
	    
	}
	
	
	
	
	private static double distance(Point pointA, Point pointB) {
		double x1 = pointA.xCoordinate();
		double y1 = pointA.yCoordinate();
		double x2 = pointB.xCoordinate();
		double y2 = pointB.yCoordinate();
		return Math.sqrt(((x2 - x1)*(x2 - x1)) + ((y2 - y1)*(y2 - y1)) );
	}
	private static boolean sameQuad(Point pointA, Point pointB) {
		double x1 = pointA.xCoordinate();
		double y1 = pointA.yCoordinate();
		double x2 = pointB.xCoordinate();
		double y2 = pointB.yCoordinate();
		int c1 = quadrant(x1,y1);
		int c2 = quadrant(x2,y2);
		if(c1 == c2 && (c1 != 0 || c2 != 0) ) {
			return true;
		}
		else {
			return false;
		}
	}
	private static int quadrant(double x, double y) {
		if( x > 0 && y>= 0) {
			return 1;
		}
		else if( x <= 0 && y > 0) {
			return 2;
		}
		else if( x < 0 && y <= 0) {
			return 3;
		}
		else if(x >= 0 && y < 0) {
			return 4;
		}
		else
		{
			return 0;
		}
	}
}