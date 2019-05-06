import java.util.Scanner;

public class PointRelation
{

	public static void errorMsg()
	{
		System.out.println("Invalid input");
		System.exit(1);
	}

	public static double distance(Point pt1, Point pt2)
	{
		double dist;
		double x;
		double y;

		x = (pt1.xCoordinate() - pt2.xCoordinate());
		y = (pt1.yCoordinate()- pt2.yCoordinate());

		dist = Math.sqrt((x*x) + (y*y));

		return dist;
	}

	public static boolean CheckQuad(Point pt1, Point pt2)
	{	
		boolean same;
		
		boolean pt1Xpos = (pt1.xCoordinate() > 0 || pt1.xCoordinate() == 0 && pt1.yCoordinate() < 0);
		boolean pt1Ypos = (pt1.yCoordinate() > 0 || pt1.yCoordinate() == 0 && pt1.xCoordinate() > 0);
		boolean pt2Xpos = (pt2.xCoordinate() > 0 || pt2.xCoordinate() == 0 && pt2.yCoordinate() < 0);
		boolean pt2Ypos = (pt2.yCoordinate() > 0 || pt2.yCoordinate() == 0 && pt2.xCoordinate() > 0);

		if (pt1Xpos == pt2Xpos && pt1Ypos == pt2Ypos)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public static void main (String [] args)
	{
		Scanner scan = new Scanner(System.in);
		
		int choice;
		double rad;
		double theta;
		double thetaDeg;
		double xCoor;
		double yCoor;
		Point pt1;
		Point pt2;
		
		double dist;
		boolean sameQuadrant;
		
		System.out.print("Which type of point should be created (1 for Cartesian, 2 for Polar)? ");
		choice = scan.nextInt();

		if(choice == 1)
		{
			System.out.print("Enter x-coordinate: ");
			xCoor = scan.nextDouble();
			
			System.out.print("Enter y-coordinate: ");	
			yCoor = scan.nextDouble();	

			pt1 = new CartesianPoint(xCoor, yCoor);
		}
		else if(choice == 2)
		{
			System.out.print("Enter radius: ");
			rad = scan.nextDouble();
			
			System.out.print("Enter angle (in degrees): ");
			thetaDeg = scan.nextDouble();
			theta = Math.toRadians(thetaDeg);

			pt1 = new PolarPoint(rad, theta);
		}
		else
		{
			pt1 = new CartesianPoint(0,0);
			errorMsg();
		}

		System.out.print("Which type of point should be created (1 for Cartesian, 2 for Polar)? ");
		choice = scan.nextInt();

		if(choice == 1)
		{
			System.out.print("Enter x-coordinate: ");
			xCoor = scan.nextDouble();
			
			System.out.print("Enter y-coordinate: ");	
			yCoor = scan.nextDouble();	

			pt2 = new CartesianPoint(xCoor, yCoor);		
		}
		else if(choice == 2)
		{
			System.out.print("Enter radius: ");
			rad = scan.nextDouble();
			
			System.out.print("Enter angle (in degrees): ");
			thetaDeg = scan.nextDouble();
			theta = Math.toRadians(thetaDeg);

			pt2 = new PolarPoint(rad, theta);
		}
		else
		{
			pt2 = new CartesianPoint(0,0);
			errorMsg();
		}

		dist = distance(pt1, pt2);
		sameQuadrant = CheckQuad(pt1, pt2);
		
		System.out.println("Distance between points: " + dist);		
		
		if (sameQuadrant)
		{
			System.out.println("In same quadrant.");
		}
		else
		{
			System.out.println("Not in same quadrant.");
		}	
	}
}
