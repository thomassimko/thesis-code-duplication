import java.util.*;

public class PointRelation
{
    public static void main(String [] args)
    {
	int readP;
	Scanner Scan = new Scanner(System.in);
	double tempX=0, tempY=0, tempR=0, tempDeg=0, tempA=0, distance;
	Point p1 = new CartesianPoint(tempX, tempY);
	Point p2 = new CartesianPoint(tempX, tempY);
	boolean boo;

	for(int i=1; i<3; i++)
	    {
		System.out.print("Which type of point should be created (1 for Cartesion, 2 for Polar)? ");
		readP = Scan.nextInt();
		
		if(readP == 1)
		    {
			if(i == 1)
			    {
				System.out.print("Enter x-coordinate: ");
				tempX = Scan.nextDouble();
				
				System.out.print("Enter y-coordinate: ");
			        tempY = Scan.nextDouble();
			    
				p1 = new CartesianPoint(tempX, tempY);
			    }
			if(i == 2)
			    {
				System.out.print("Enter x-coordinate: ");
                                tempX = Scan.nextDouble();

                                System.out.print("Enter y-coordinate: ");
                                tempY = Scan.nextDouble();

                                p2 = new CartesianPoint(tempX, tempY);
			    }
		    }
		else if(readP == 2)
		    {
			if(i == 1)
			    {
				System.out.print("Enter radius: ");
				tempR = Scan.nextDouble();

				System.out.print("Enter angle (in degrees): ");
				tempDeg = Scan.nextDouble();
				tempA = tempDeg * (Math.PI) / 180;

				p1 = new PolarPoint(tempR, tempA);
			    }
			if(i == 2)
			    {
				System.out.print("Enter radius: ");
                                tempR = Scan.nextDouble();

                                System.out.print("Enter angle (in degrees): ");
                                tempDeg = Scan.nextDouble();
				tempA = tempDeg * (Math.PI) / 180;

				p2 = new PolarPoint(tempR, tempA);
			    }
		    }
		else
		    {
			System.err.println("Error: Invalid Value");
			System.exit(1);
		    }
	    }
	distance = distancePoints(p1, p2);
	System.out.println("Distance between points: " + distance);
	
	boo = sameQuad(p1, p2);
	if(boo == true)
	    {
		System.out.println("In the same quadrant.");
	    }
	if(boo == false)
	    {
		System.out.println("Not in the same quadrant.");
	    }
    }

    public static double distancePoints(Point a, Point b)
    {
	return Math.sqrt((a.xCoordinate() - b.xCoordinate())*(a.xCoordinate() - b.xCoordinate())
			 + (a.yCoordinate() - b.yCoordinate())*(a.yCoordinate() - b.yCoordinate()));
    }

    public static boolean sameQuad(Point a, Point b)
    {
	// 1 quadrant
	if(a.xCoordinate() > 0 && a.yCoordinate() > 0 && b.xCoordinate() > 0 && b.yCoordinate() > 0)
	    {
		return true;
	    }
	// 2 quadrant
	if(a.xCoordinate() < 0 && a.yCoordinate() > 0 && b.xCoordinate() < 0 && b.yCoordinate() > 0)
	    {
		return true;
	    }
	// 3 quadrant
	if(a.xCoordinate() < 0 && a.yCoordinate() < 0 && b.xCoordinate() < 0 && b.yCoordinate() < 0)
	    {
		return true;
	    }
	// 4 quadrant
	if(a.xCoordinate() > 0 && a.yCoordinate() < 0 && b.xCoordinate() > 0 && b.yCoordinate() < 0)
	    {
		return true;
	    }
	else
	    {
		return false;
	    }
    }
}
