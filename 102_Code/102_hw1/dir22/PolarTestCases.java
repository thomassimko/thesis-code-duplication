import java.lang.Math;

public class PolarTestCases{
	public static void main(String [] args){
		Point p=new PolarPoint(Math.sqrt(1.0+3.0*3.0),Math.atan(3.0/1.0));
		Point p0=new PolarPoint(0.0,0.0);
		Point p1=new PolarPoint(Math.sqrt(1.0+10.0*10.0),Math.atan(10.0/-1.0));
		
		Check.check(p.xCoordinate(),1.0);
		Check.check(p0.xCoordinate(),0);
		Check.check(p1.xCoordinate(),-1.0);
		
		Check.check(p.yCoordinate(),3.0);
		Check.check(p0.yCoordinate(),0.0);
		Check.check(p1.yCoordinate(),10.0);
		
		Check.check(p.radius(),Math.sqrt(1.0+3.0*3.0));
		Check.check(p0.radius(),0.0);
		Check.check(p1.radius(),Math.sqrt(1.0+10.0*10.0));
		
		Check.check(p.angle(),Math.atan(3.0/1.0));
		Check.check(p0.angle(),0.0);
		Check.check(p1.angle(),Math.atan(10.0/-1.0)+Math.PI*2);
		
		p=p.rotate90();
		p0=p0.rotate90();
		p1=p1.rotate90();
		
		Check.check(p.angle(),Math.atan(3.0/1.0)+Math.PI/2);
		Check.check(p0.angle(),Math.PI/2);
		Check.check(p1.angle(),Math.atan(10.0/-1.0)-1.5*Math.PI/2);
	}
}
		
		
		