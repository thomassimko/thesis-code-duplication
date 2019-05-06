import java.util.Scanner;

public class PointRelation {
	public static void main(String [] args){
		Scanner s = new Scanner(System.in);
		Point points[] = new Point[2];
		for(int i=0;i<2;i++){
			System.out.print("Which type of point should be created (1 for Cartesion, 2 for Polar)? ");
			if(!s.hasNextInt())
				break;
			int choice = s.nextInt();
			if(choice==1){
				System.out.print("Enter x-coordinate: ");
				if(!s.hasNextDouble())
					break;
				double x = s.nextDouble();
				System.out.print("Enter y-coordinate: ");
				if(!s.hasNextDouble())
					break;
				points[i] = new CartesianPoint(x,s.nextDouble());
			} else if(choice==2){
				System.out.print("Enter radius: ");
				if(!s.hasNextDouble())
					break;
				double radius = s.nextDouble();
				System.out.print("Enter angle (in degrees): ");
				if(!s.hasNextDouble())
					break;
				points[i] = new PolarPoint(radius,Math.toRadians(s.nextDouble()));
			}else{
				break;
			}
		}
		if(points[0]==null||points[1]==null){
			System.out.println("Invalid input.");
			System.exit(1);
		}
		System.out.println("Distance between points: "+distance(points[0],points[1]));
		if(quadrant(points[0])==quadrant(points[1])){
			System.out.println("In same quadrant.");
		}else{
			System.out.println("Not in same quadrant.");
		}
	}
	private static double distance(Point point1, Point point2){
		return Math.sqrt(Math.pow(point1.xCoordinate()-point2.xCoordinate(), 2)+Math.pow(point1.yCoordinate()-point2.yCoordinate(), 2));
	}
	private static int quadrant(Point point){
		if(point.xCoordinate()>0&&point.yCoordinate()>=0)
			return 1;
		if(point.xCoordinate()<=0&&point.yCoordinate()>0)
			return 2;
		if(point.xCoordinate()<0&&point.yCoordinate()<=0)
			return 3;
		return 4;
	}
}
