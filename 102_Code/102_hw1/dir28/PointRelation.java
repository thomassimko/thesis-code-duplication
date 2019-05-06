import java.util.Scanner;

public class PointRelation
{
	public static double distance(Point a, Point b)
	{
		return Math.sqrt(Math.pow(a.xCoordinate()-b.xCoordinate(), 2) + Math.pow(a.yCoordinate()-b.yCoordinate(), 2));
	}
	public static boolean sameQuadrant(Point a, Point b)
	{
		if (a.xCoordinate() >= 0 && b.xCoordinate() >= 0 && a.yCoordinate() >= 0 && b.yCoordinate() >= 0)
		{
			return true;
		}
		else if (a.xCoordinate() <= 0 && b.xCoordinate() <= 0 && a.yCoordinate() >= 0 && b.yCoordinate() >= 0)
		{
			return true;
		}
		else if (a.xCoordinate() <= 0 && b.xCoordinate() <= 0 && a.yCoordinate() <= 0 && b.yCoordinate() <= 0)
		{
			return true;
		}
		else if (a.xCoordinate() >= 0 && b.xCoordinate() >= 0 && a.yCoordinate() <= 0 && b.yCoordinate() <= 0)
		{
			return true;
		}
		return false;
	}
	public static void main (String[]args)
	{
		Scanner scan = new Scanner(System.in);
		int i;
		double x, y, r, x2, y2, r2;
		double dist, a, a2;
		Point store, store2;
		
		System.out.print("Which type of point should be created (1 for Cartesian, 2 for Polar)? ");
		i = scan.nextInt();	
		if (i == 1)
		{
			System.out.print("Enter x-coordinate: ");
			if (!scan.hasNextDouble())
			{
				System.out.println("Please enter a double value.");
				System.exit(1);
				x = 0;
			}
			else
			{
				x = scan.nextDouble();
			}
			System.out.print("Enter y-coordinate: ");
			if (!scan.hasNextDouble())
			{
				System.out.println("Please enter a double value.");
				System.exit(1);
				y = 0;
			}
			else
			{
				y = scan.nextInt();
			}
			store = new CartesianPoint(x, y);
		}
		else if (i == 2)
		{
			System.out.print("Enter radius: ");
			if (!scan.hasNextDouble())
			{
				System.out.println("Please enter a double value.");
				System.exit(1);
				r = 0;
			}
			else
			{
				r = scan.nextDouble();
			}
			System.out.print("Enter angle (in degrees): ");
			if (!scan.hasNextDouble())
			{
				System.out.println("Please enter a double value.");
				System.exit(1);
				a = 0;
			}
			else
			{
				a = scan.nextDouble()*2*Math.PI/360;
			}
			store = new PolarPoint((double)r, a);
		}
		else
		{
			System.out.println("Please enter either 1 or 2");
			System.exit(1);
			store = null;
		}
		
		System.out.print("Which type of point should be created (1 for Cartesian, 2 for Polar)? ");
		i = scan.nextInt();
		if (i == 1)
		{
			System.out.print("Enter x-coordinate: ");
		   if (!scan.hasNextDouble())
		   {
				System.out.println("Please enter a double value.");
				System.exit(1);
				x2 = 0;
			}
			else
			{
				x2 = scan.nextDouble();
			}
			System.out.print("Enter y-coordinate: ");
			if (!scan.hasNextDouble())
		   {
				System.out.println("Please enter a double value.");
				System.exit(1);
				y2 = 0;
			}
			else
			{
				y2 = scan.nextDouble();
			}
			store2 = new CartesianPoint((double)x2, (double)y2);
		}
		else if (i == 2)
		{
			System.out.print("Enter radius: ");
			if (!scan.hasNextDouble())
		   {
				System.out.println("Please enter a double value.");
				System.exit(1);
				r2 = 0;
			}
			else
			{
				r2 = scan.nextDouble();
			}
			System.out.print("Enter angle (in degrees): ");
			if (!scan.hasNextDouble())
		   {
				System.out.println("Please enter a double value.");
				System.exit(1);
				a2 = 0;
			}
			else
			{
				a2 = scan.nextDouble()*2*Math.PI/360;
			}
			store2 = new PolarPoint((double)r2, a2);
		}
		else
		{
			System.out.println("Please enter 1 or 2.");
			System.exit(1);
			store2 = null;
		}
		
		dist = distance(store, store2);
		System.out.println("Distance between points: " + dist);
		
		if (sameQuadrant(store, store2))
		{
			System.out.println("In same quadrant.");
		}
		else
		{
			System.out.println("Not in same quadrant.");
		}
	}
}
