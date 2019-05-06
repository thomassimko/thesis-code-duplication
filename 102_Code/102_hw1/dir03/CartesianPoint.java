import java.lang.Math;

public class CartesianPoint
    implements Point
{
    private double x,y,a,b,h,nx,ny,theta,temp;
    public CartesianPoint(double x_coord, double y_coord)
    {
	this.x=x_coord;
	this.y=y_coord;
    }
    public double  xCoordinate()
    {
	return this.x;
    }
    public double yCoordinate()
    {
	return this.y;
    }
    
    public double radius()
    {
	this.a=this.x*this.x;
	    this.b=this.y*this.y;
	    this.temp=(this.a+this.b);
	    this.h=Math.sqrt(temp);
	    return this.h;
    }
    
    public double angle()
    {
	if (this.x==0 && this.y>=0)
	   return (Math.PI/2);
	if (this.x==0 && this.y<=0)
	   return (3*Math.PI/2);
	this.theta=(Math.atan(this.y/this.x));
	return this.theta;
    }

    public Point rotate90()
    {
	this.ny=this.h*(Math.sin(theta+(Math.PI/2)));
	this.nx=Math.sqrt(this.h*this.h + this.ny*this.ny);
        Point newp = new CartesianPoint(-(this.y),this.x);
	return (newp);
    }
}
