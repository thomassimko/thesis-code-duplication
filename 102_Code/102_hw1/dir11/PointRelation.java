import java.util.Scanner;
import java.lang.Math;

public class PointRelation
{
    public static double DistanceCalc(Point pt1, Point pt2)
    {
	double distance, x_distance, y_distance;
	x_distance = Math.abs(pt1.xCoordinate() - pt2.xCoordinate());
	y_distance = Math.abs(pt1.yCoordinate() - pt2.yCoordinate());
	distance = Math.sqrt((x_distance * x_distance) + (y_distance * y_distance));
	return distance;
    }
    public static void quadrantTest (Point pt1, Point pt2)
    {
	int pt1QuadLoc, pt2QuadLoc;;
	if (pt1.xCoordinate() >= 0)
	    {
		if (pt1.yCoordinate() > 0)
		    {
			pt1QuadLoc = 1;
		    }
		else
		    {
			pt1QuadLoc = 2;
		    }
	    }
	else if (pt1.xCoordinate() < 0)
	    {
		if (pt1.yCoordinate() > 0)
		    {
			pt1QuadLoc = 4;
		    }
		else
		    {
			pt1QuadLoc = 3;
		    }
	    }
	else
	    {
		pt1QuadLoc = 0;
	    }
	if (pt2.xCoordinate() >= 0)
            {
                if (pt2.yCoordinate() > 0)
                    {
                        pt2QuadLoc = 1;
                    }
                else
		    {
			pt2QuadLoc = 2;
                    }
            }
	else if (pt2.xCoordinate() < 0)
            {
		if (pt2.yCoordinate() > 0)
                    {
                        pt2QuadLoc = 4;
                    }
                else
                    {
			pt2QuadLoc = 3;
                    }
	    }
	else
            {
                pt2QuadLoc = 0;
	    }
	if (pt1QuadLoc == pt2QuadLoc || pt1QuadLoc == 0 || pt2QuadLoc == 0)
	    {
		System.out.println("In same quadrant.");
	    }
	else
	    {
		System.out.println("Not in same quadrant.");
	    }
    }

    public static void main(String [] args)
    {
	int cartesian = 1;
	int polar = 2;
	int choice, choice2, flag;
	double x_val, x_val2, y_val, y_val2, rad, rad2, ang, ang2, distance, ang3, ang4;
	Point pt1 = null;
	Point pt2 = null;
	Scanner scan = new Scanner(System.in);
	System.out.print("Which type of point should be created (1 for Cartesion, 2 for Polar)? ");
	choice = scan.nextInt();
	if (choice == cartesian)
	    {
		System.out.print("Enter x-coordinate: ");
		x_val = scan.nextDouble();
		System.out.print("Enter y-coordinate: ");
		y_val = scan.nextDouble();
		pt1 = new CartesianPoint(x_val, y_val);
	    }
	else if (choice == polar)
	    {
		System.out.print("Enter radius: ");
                rad = scan.nextDouble();
		System.out.print("Enter angle (in degrees): ");
		ang = scan.nextDouble();
		ang3 = (ang * 3.141529625) / 180;
		pt1 = new PolarPoint(rad, ang3);
	    }
	else
	    {
		System.out.println("Sorry, invalid type. Please try again.");
		System.exit(1);
	    }
	System.out.print("Which type of point should be created (1 for Cartesion, 2 for Polar)? ");
	choice2 = scan.nextInt();
	if (choice2 == cartesian)
            {
                System.out.print("Enter x-coordinate: ");
                x_val2 = scan.nextDouble();
                System.out.print("Enter y-coordinate: ");
                y_val2 = scan.nextDouble();
		pt2 = new CartesianPoint(x_val2, y_val2);
            }
        else if (choice2 == polar)
            {
                System.out.print("Enter radius: ");
                rad2 = scan.nextDouble();
                System.out.print("Enter angle (in degrees): ");
                ang2 = scan.nextDouble();
		ang4 = (ang2 * 3.14159265) / 180;
		pt2 = new PolarPoint(rad2, ang4);
            }
	else
	    {
		System.out.println("Sorry, invalid type. Please try again.");
                System.exit(1);
	    }
	distance = DistanceCalc(pt1, pt2);
	System.out.println("Distance between points: " + distance);
	quadrantTest(pt1, pt2);

    }
}