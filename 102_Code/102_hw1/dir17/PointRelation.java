import java.util.Scanner;

public class PointRelation
{
	public static int getQuadrant(Point p)
	{
		if(p.xCoordinate() > 0 && p.yCoordinate() >= 0)
		{
			return 1;
		}
		else if(p.xCoordinate() <= 0 && p.yCoordinate() > 0)
		{
			return 2;
		}
		else if(p.xCoordinate() < 0 && p.yCoordinate() <= 0)
		{
			return 3;
		}
		else   /* p.xCoordinate() >= 0 && p.yCoordinate() < 0 */
		{
			return 4;
		}
	}
	
	public static boolean sameQuadrant(Point p1, Point p2)
	{
		return PointRelation.getQuadrant(p1) == PointRelation.getQuadrant(p2);
	}
	
	public static double distance(Point p1, Point p2)
	{
		double x_diff = p1.xCoordinate() - p2.xCoordinate();
		double y_diff = p1.yCoordinate() - p2.yCoordinate();
		
		return Math.sqrt(Math.pow(x_diff, 2) + Math.pow(y_diff, 2));
	}
	
	public static Point getCartesian(Scanner scan)
	{
		double x_coord, y_coord;
		
		System.out.print("Enter x-coordinate: ");
		x_coord = scan.nextDouble();
		System.out.print("Enter y-coordinate: ");
		y_coord = scan.nextDouble();

		return new CartesianPoint(x_coord, y_coord);
	}

	public static Point getPolar(Scanner scan)
	{
		double radius, degrees;
		
		System.out.print("Enter radius: ");
		radius = scan.nextDouble();
		System.out.print("Enter angle (in degrees): ");
		degrees = scan.nextDouble();

		return new PolarPoint(radius, Math.toRadians(degrees));
	}
	
	public static Point getPoint(int type, Scanner scan)
	{
		if(type == 1)
		{
			return PointRelation.getCartesian(scan);
		}
		else /* type == 2 */
		{
			return PointRelation.getPolar(scan);
		}
	}

	public static boolean isInvalidType(int type)
	{
		return !(type == 1 || type == 2);
	}

	public static void main(String [] args)
	{
		int i;
		int [] type = new int[2];
		Point [] p = new Point[2];
		
		Scanner scan = new Scanner(System.in);

		for(i=0; i<2; i++)
		{
			System.out.print("Which type of point should be created (1 for Cartesian, 2 for Polar)? ");
			type[i] = scan.nextInt();
		
			if(PointRelation.isInvalidType(type[i]))
			{
				System.out.println("Invalid type.");
				System.exit(1);
			}

			p[i] = PointRelation.getPoint(type[i], scan);
		}

		System.out.print("Distance bewteen points: ");
		System.out.println(PointRelation.distance(p[0],p[1]));
		
		if(PointRelation.sameQuadrant(p[0],p[1]))
		{
			System.out.println("In same quadrant.");
		}
		else
		{
			System.out.println("Not in same quadrant.");
		}
	}
}
