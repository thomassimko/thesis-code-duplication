/** Siobhan Foster */
public class CartesianPoint
	implements Point
{ double x;
  double y;
  
  public CartesianPoint(double in1,double in2)
  { x=in1;
	y=in2;
  }
  
  public double xCoord()
  { return x;  }
  
  public double yCoord()
  { return y;  }
  
  public double radius()
  { double hyp;
	hyp= Math.sqrt(x*x+y*y);
	return hyp;
  }
  
  public double angle()
  { double ang;
	ang=Math.atan2(this.y,this.x);
	if(ang>=2*Math.PI)
	{ ang-=2*Math.PI;  }
	return ang;
  }
  
  public Point rot90()
  { double x2,y2;
	x2=this.x*Math.cos(this.angle()) + this.y*Math.sin(this.angle());
	y2=this.y*Math.cos(this.angle()) - this.x*Math.sin(this.angle());
	
	return new CartesianPoint(x2,y2);
  }

}