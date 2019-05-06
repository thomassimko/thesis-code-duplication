import java.util.Scanner;

public class PointRelation
{
    public static void main(String [] args)
    {
	Scanner choiceReader = new Scanner(System.in);
	Scanner pointReader = new Scanner(System.in);
	int choice;
	double x, x2;
	double y, y2;
	double radius;
	double angle;
	double distance;
	int counter1=0, counter2=0;
	Point p1 = new CartesianPoint(0, 0);
	Point p2 = new CartesianPoint(0, 0);

	CartesianTestCases.testCartesianPoint();
	PolarTestCases.testPolarPoint();

	System.out.print("Which type of point should be created (1 for Cartesian, 2 for Polar)? ");
	choice = choiceReader.nextInt();
	if(choice == 1)
	{
	    System.out.print("Enter x-coordinate: ");
	    x = pointReader.nextDouble();
	    System.out.print("Enter y-coordinate: ");
	    y = pointReader.nextDouble();
	    p1 =  new CartesianPoint(x, y);
	}
	else if(choice == 2)
	{
	    System.out.print("Enter radius: ");
	    radius = pointReader.nextDouble();
	    System.out.print("Enter angle (in degrees): ");
	    angle = pointReader.nextDouble();
	    if(angle<0){
		angle = angle + 360;
	    }
	    p1 = new PolarPoint(radius, (Math.PI/180)*angle);
	}
	else
	{
	    System.out.println("Invalid choice.");
	    return;
	}

	System.out.print("Which type of point should be created (1 for Cartesian, 2 for Polar)? ");
	choice = choiceReader.nextInt();
	if(choice == 1)
	{
	    System.out.print("Enter x-coordinate: ");
	    x2 = pointReader.nextDouble();
	    System.out.print("Enter y-coordinate: ");
	    y2 = pointReader.nextDouble();
	    p2 = new CartesianPoint(x2, y2);
	}
	else if(choice == 2)
	{
	    System.out.print("Enter radius: ");
	    radius = pointReader.nextDouble();
	    System.out.print("Enter angle (in degrees): ");
	    angle =pointReader.nextDouble();
	    if(angle<0){
		angle = angle + 360;
	    }
	    p2 = new PolarPoint(radius, (Math.PI/180)*angle);
	}
	else
	{
	    System.out.println("Invalid choice.");
	    return;
	}

	distance = distance_func(p1, p2);
	System.out.println("Distance between points: " + distance);

	if(quadrant(p1, p2) == true){
	    System.out.println("Same quadrant.");
	}
	else{
	    System.out.println("Not in the same quadrant.");
	}
    }
    private static double distance_func(Point p1, Point p2)
    {
	double x1, x2;
	double y1, y2;

	x1 = p1.xCoordinate();
	y1 = p1.yCoordinate();
	x2 = p2.xCoordinate();
	y2 = p2.yCoordinate();

	return Math.sqrt(((x1-x2)*(x1-x2))+((y1-y2)*(y1-y2)));
    }
    private static boolean quadrant(Point p1, Point p2)
    {
	if(p1.xCoordinate() >= 0 && p1.yCoordinate() >= 0 && p2.xCoordinate() >= 0 && p2.yCoordinate() >=0){
	    return true;
	}
	else if(p1.xCoordinate() <= 0 && p1.yCoordinate() >= 0 && p2.xCoordinate() <= 0 && p2.yCoordinate() >= 0){
	    return true;
	}
	else if(p1.xCoordinate() <= 0 && p1.yCoordinate() <= 0 && p2.xCoordinate() <= 0 && p2.yCoordinate() <= 0){
	    return true;
	}
	else if(p1.xCoordinate() >= 0 && p1.yCoordinate() <= 0 && p2.xCoordinate() >= 0 && p2.yCoordinate() <= 0){
	    return true;
	}
	else{
	    return false;
	}
    }
}