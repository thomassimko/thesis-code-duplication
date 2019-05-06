import java.util.Scanner;
import java.lang.Math;

public class PointRelation
{



    public static void distance(Point pd1,Point pd2)
    {
	double distance;
	distance=Math.sqrt((pd1.xCoordinate()-pd2.xCoordinate())*(pd1.xCoordinate()-pd2.xCoordinate())+(pd1.yCoordinate()-pd2.yCoordinate())*(pd1.yCoordinate()-pd2.yCoordinate()));
	System.out.println("Distance Between Points:" +distance);
    }
    
    public static void samequad(Point psq1, Point psq2)
    {
	if ((psq1.xCoordinate()>=0 && psq2.xCoordinate()>=0) || (psq1.xCoordinate()<0 &&psq2.xCoordinate()<0))
	    {
		if ((psq1.yCoordinate()>=0 && psq2.yCoordinate()>=0) || (psq1.yCoordinate()<0 && psq2.yCoordinate()<0))
		    {
			System.out.println("In Same quadrant");
	            }
		else
		    { 
		    System.out.println("Not in same Quadeant");
		    }
	    }
	    else
		{
		System.out.println("Not in same Quadrant");
		}
     }
	  

    public static void main(String[] args)
    {
    double x, y, choice, radius, angle;
    Scanner scan = new Scanner(System.in);
    System.out.println("Which type of point should be created (1 for Cartesian, 2 for Polar)? ");
    choice = scan.nextDouble();
    Point p1 =new CartesianPoint(0,0);
    Point p2 =new CartesianPoint(0,0);
    if (choice==1)
        {
            System.out.println("Enter x-coordinate: ");
            x = scan.nextDouble();
            System.out.println("Enter y-coordinate: ");
            y = scan.nextDouble();
            p1 =new CartesianPoint(x,y);
        }

    else if (choice==2)
        {
            System.out.println("Enter radius: ");
            radius = scan.nextDouble();
            System.out.println("Enter angle(in degrees): ");
            angle = scan.nextDouble();
            angle = angle*(Math.PI/180);
            x = radius*Math.cos(angle);
            y = radius*Math.sin(angle);
            p1 =new CartesianPoint(x,y);
        }
    else
        {
            System.out.println("Error.");
            System.exit(1);
        }

    System.out.println("Which type of point should be created (1 for Cartesian, 2 for Polar)? ");
    	choice = scan.nextDouble();
    if (choice==1)
	{
	    System.out.println("Enter x-coordinate: ");
	    x = scan.nextDouble();
	    System.out.println("Enter y-coordinate: ");
	    y = scan.nextDouble();
	    p2 =new CartesianPoint(x,y);
	}
    
    else if (choice==2)
	{
	    System.out.println("Enter radius: ");
	    radius = scan.nextDouble();
	    System.out.println("Enter angle(in degrees): ");
	    angle = scan.nextDouble();
	    angle = angle*(Math.PI/180);
	    x = radius*Math.cos(angle);
	    y = radius*Math.sin(angle);
	    p2 =new CartesianPoint(x,y);
	}
    else
	{
	    System.out.println("Error.");
	    System.exit(1);
	}
    distance(p1,p2);
    samequad(p1,p2);
    }
}


    
