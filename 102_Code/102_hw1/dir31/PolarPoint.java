public class PolarPoint
    implements Point
{ double radius;
  double angle;
  
  public PolarPoint(double r,double a)
  { this.radius=r;
	this.angle=a*Math.PI/180;
  }
  
  public double xCoord()
  { double x;
    x=this.radius*Math.cos(this.angle);
	return x;
  }
  
  public double yCoord()
  { double y;
    y=this.radius*Math.sin(this.angle);
	return y;
  }
  
  public double radius()
  { return this.radius;  }
  
  public double angle()
  { return this.angle;  }
  
  public Point rot90()
  { double ang;
	ang=this.angle+Math.PI/2;
	if(ang>=2*Math.PI)
	{ ang-=2*Math.PI;  }
    return new PolarPoint(this.radius,ang);
  }

}