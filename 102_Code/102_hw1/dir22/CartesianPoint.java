import java.lang.Math;
public class CartesianPoint implements Point{
	private double xCoordinate,yCoordinate;
	
	public CartesianPoint(double x,double y){
		this.xCoordinate=x;
		this.yCoordinate=y;
	}
	public double xCoordinate(){
		return this.xCoordinate;
	}
	public double yCoordinate(){
		return this.yCoordinate;
	}
	public double radius(){
		return Math.sqrt(this.xCoordinate*this.xCoordinate+this.yCoordinate*this.yCoordinate);
	}
	public double angle(){
		if(Math.atan(yCoordinate/xCoordinate)>-999999999){
			return Math.atan(yCoordinate/xCoordinate);
		}
		return 0.0;
	}
	public Point rotate90(){
		double x,y;
		x=this.xCoordinate*Math.cos(Math.atan(yCoordinate/xCoordinate)+Math.PI/2);
		y=this.yCoordinate*Math.sin(Math.atan(yCoordinate/xCoordinate)+Math.PI/2);
		return new CartesianPoint(x,y);
	}
}
