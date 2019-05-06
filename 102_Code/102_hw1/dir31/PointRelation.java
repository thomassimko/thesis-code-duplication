import java.util.Scanner;

public class PointRelation
{
  public static double distance(Point p1,Point p2)
  { if(p1.xCoord()-p2.xCoord()==0)
    { return Math.abs(p1.yCoord()-p2.yCoord());  }
	else
	{ return ((p1.yCoord()-p2.yCoord())/(p1.xCoord()-p2.xCoord()));  }
  }
  
  public static int quad(Point pon)
  { if((pon.angle()>=0) && (pon.angle()<=(Math.PI/2)))
    { return 1;  }
	else if(pon.angle()>(Math.PI/2) && pon.angle()<=Math.PI)
	{ return 2;  }
	else if(pon.angle()>Math.PI && pon.angle()<=(3*Math.PI/2))
	{ return 3;  }
	else
	{ return 4;  }
  }
  
  public static boolean SameQuad(Point p1,Point p2)
  { if(quad(p1)==quad(p2))
    { return true;  }
	return false;
  }
  
  public static Point callPoint()
  { double x,y,ans;
    Scanner scan=new Scanner(System.in);
    System.out.print("Which type of point should be created (1 for Cartesian, 2 for Polar)?");
	ans=scan.nextInt();
	if(ans==1)
	{ scan=new Scanner(System.in);
	  System.out.print("Enter x-coordinate:");
	  x=scan.nextDouble();
	  scan=new Scanner(System.in);
	  System.out.print("Enter y-coordinate:");
	  y=scan.nextDouble();
	  
	  return new CartesianPoint(x,y);
	}
	else
	{ scan=new Scanner(System.in);
	  System.out.print("Enter radius:");
	  x=scan.nextDouble();
	  scan=new Scanner(System.in);
	  System.out.print("Enter angle(in degrees):");
	  y=scan.nextDouble();
	  
	  return new PolarPoint(x,y);
	}
  }
  
  public static void main(String [] argc)
  { Point point1= callPoint();
	Point point2= callPoint();

	double dist;
	dist=distance(point1,point2);
	System.out.println("Distance between points: "+dist);
	
	if(SameQuad(point1,point2))
	{ System.out.println("In same quadrant.");  }
	else
	{ System.out.println("Not in same quadrant.");  }
	
  }
}