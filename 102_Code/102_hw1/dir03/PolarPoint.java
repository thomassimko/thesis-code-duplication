import java.lang.Math;

public class PolarPoint
    implements Point
{
    private double rad,ang,x,y,nang;
   
    public PolarPoint(double radius, double angle)
    {
	this.rad=radius;
	this.ang=angle;
	if (this.rad<0)
        {
	   this.rad=Math.abs(this.rad);
	   this.ang=this.ang+(Math.PI);
        }
        if (this.ang<0)
        {
	   this.ang=this.ang+(Math.PI*2);
        }
	if(this.ang>Math.PI*2)
        {
	   this.ang=this.ang-(Math.PI*2);
	}
    }
    
    public double xCoordinate()
    {
	this.x=rad*Math.cos(ang);
	    return this.x;
    }
    
    public double yCoordinate()
    {
	this.y=rad*Math.sin(ang);
	    return this.y;
    }

    public double radius()
    {
	return this.rad;
    }

    public double angle()
    {
	return this.ang;
    }

    public Point rotate90()
    {
	this.nang=this.ang+(Math.PI/2);
        Point newp =new PolarPoint(this.rad,this.nang);
	return(newp);
    }
}
    
