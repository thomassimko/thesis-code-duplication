import java.lang.Math;
public class PolarPoint implements Point{
	private double radius,angle;
	
	public PolarPoint(double r,double a){
		double rtmp=r;
		double atmp=a;
		if(rtmp<0){
			rtmp=rtmp*-1;
			atmp=atmp+Math.PI;
		}
		if(atmp<0){
			atmp=Math.PI*2+atmp;
		}
		this.radius=rtmp;
		this.angle=atmp;
	}
	public double xCoordinate(){
		return Math.cos(this.angle)*this.radius;
	}
	public double yCoordinate(){
		return Math.sin(this.angle)*this.radius;
	}
	public double radius(){
		return this.radius;
	}
	public double angle(){
		return this.angle;
	}
	public Point rotate90(){
		return new PolarPoint(this.radius,this.angle+Math.PI/2);
	}
}
