import java.util.Scanner;

public class PointRelation
{
    public static double distance(Point p1, Point p2)
    {
	return Math.sqrt(((p2.xCoordinate() - p1.xCoordinate()) * (p2.xCoordinate() - p1.xCoordinate())) + ((p2.yCoordinate() - p1.yCoordinate()) * (p2.yCoordinate() - p1.yCoordinate())));
    }

    public static boolean quadrant(Point p1, Point p2)
    {
	boolean p1_x, p1_y, p2_x, p2_y;
	int p1_quad, p2_quad;

	if(p1.xCoordinate() > 0)
	    {
		p1_x = true;
	    }
	else
	    {
		p1_x = false;
	    }

	if(p1.yCoordinate() > 0)
            {
                p1_y = true;
            }
        else
            {
                p1_y = false;
            }

	if(p2.xCoordinate() > 0)
            {
                p2_x = true;
            }
        else
            {
                p2_x = false;
            }

	if(p2.yCoordinate() > 0)
            {
                p2_y = true;
            }
        else
            {
                p2_y = false;
            }
	
	if(p1_x == true && p1_y == true)
	    {
		p1_quad = 1;
	    }
	else if(p1_x == false && p1_y == true)
            {
                p1_quad = 2;
            }
	else if(p1_x == false && p1_y == false)
            {
                p1_quad = 3;
            }
	else if(p1_x == true && p1_y == false)
            {
                p1_quad = 4;
            }
	else
	    {
		p1_quad = 1;
	    }
	
	if(p2_x == true && p2_y == true)
            {
                p2_quad = 1;
            }
	else if(p2_x == false && p2_y == true)
            {
                p2_quad = 2;
            }
	else if(p2_x == false && p2_y == false)
            {
                p2_quad = 3;
            }
	else if(p2_x == true && p2_y == false)
            {
                p2_quad = 4;
            }
	else
	    {
		p2_quad = 1;
	    }

	if(p1_quad == p2_quad)
	    {
		return true;
	    }
	else
	    {
		return false;
	    }
    }

    public static void main(String [] args)
    {
	Scanner user_input = new Scanner(System.in);
	int point_type; 
	double p1_x = 0;
	double p1_y = 0;
	double p2_x = 0;
	double p2_y = 0;
	double dist = 0;
	boolean quad;
	Point p1 = new CartesianPoint(0, 0);
	Point p2 = new PolarPoint(0, 0);

	System.out.print("Which type of point should be created (1 for Cartesion, 2 for Polar)? ");
	point_type = user_input.nextInt();
	
	if(point_type == 1)
	    {
		System.out.print("Enter x-coordinate: ");
		p1_x = user_input.nextDouble();
		System.out.print("Enter y-coordinate: ");
                p1_y = user_input.nextDouble();

		p1 = new CartesianPoint(p1_x, p1_y);

		System.out.print("Which type of point should be created (1 for Cartesion, 2 for Polar)? ");
		point_type = user_input.nextInt();

		if(point_type == 1)
		    {
			System.out.print("Enter x-coordinate: ");
			p2_x = user_input.nextDouble();
			System.out.print("Enter y-coordinate: ");
			p2_y = user_input.nextDouble();
			
			p2 = new CartesianPoint(p2_x, p2_y);

			dist = distance(p1, p2);
			quad = quadrant(p1, p2);

			System.out.println("Distance between points: " + dist);
			if(quad == true)
			    {
				System.out.println("In same quadrant.");
			    }
			else
			    {
				System.out.println("Not in same quadrant.");
			    }
			
		    }
		else if(point_type == 2)
		    {
			System.out.print("Enter radius: ");
			p2_x = user_input.nextDouble();
			System.out.print("Enter angle (in degrees): ");
			p2_y = user_input.nextDouble();

                        p2 = new PolarPoint(p2_x, p2_y);

			dist = distance(p1, p2);
                        quad = quadrant(p1, p2);
			
                        System.out.println("Distance between points: " + dist);
                        if(quad == true)
                            {
                                System.out.println("In same quadrant.");
                            }
                        else
                            {
                                System.out.println("Not in same quadrant.");
			    }
		    }
		else
		    {
			System.out.println("Invalid input.");
			System.exit(1);
		    }

	    }
	else if(point_type == 2)
	    {
		System.out.print("Enter radius: ");
                p1_x = user_input.nextDouble();
                System.out.print("Enter angle (in degrees): ");
                p1_y = user_input.nextDouble();

		p1 = new PolarPoint(p1_x, p1_y);

                System.out.print("Which type of point should be created (1 for Cartesion, 2 for Polar)? ");
                point_type = user_input.nextInt();

                if(point_type == 1)
                    {
                        System.out.print("Enter x-coordinate: ");
                        p2_x = user_input.nextDouble();
                        System.out.print("Enter y-coordinate: ");
                        p2_y = user_input.nextDouble();

			p2 = new CartesianPoint(p2_x, p2_y);

			dist = distance(p1, p2);
                        quad = quadrant(p1, p2);

                        System.out.println("Distance between points: " + dist);
                        if(quad == true)
                            {
                                System.out.println("In same quadrant.");
                            }
                        else
                            {
                                System.out.println("Not in same quadrant.");
                            }

                    }
                else if(point_type == 2)
                    {
			System.out.print("Enter radius: ");
			p2_x = user_input.nextDouble();
			System.out.print("Enter angle (in degrees): ");
			p2_y = user_input.nextDouble();
			
			p2 = new PolarPoint(p2_x, p2_y);
			
			dist = distance(p1, p2);
                        quad = quadrant(p1, p2);

                        System.out.println("Distance between points: " + dist);
                        if(quad == true)
                            {
                                System.out.println("In same quadrant.");
                            }
                        else
                            {
                                System.out.println("Not in same quadrant.");
                            }

                    }
                else
                    {
			System.out.println("Invalid input");
                        System.exit(1);
                    }

	    }
	else
	    {
		System.out.println("Invalid input");
		System.exit(1);
	    }
    }
}