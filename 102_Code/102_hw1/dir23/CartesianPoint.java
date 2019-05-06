/*Programmed by Michael Olivarez*/
public class CartesianPoint
   implements Point
{
   private double x;
   private double y;

   public CartesianPoint(double x_coord,double y_coord)
   {
     this.x = x_coord;
     this.y = y_coord;
   }

  public double xCoordinate()
  {
    /*Returns the x coordinate*/
    return this.x;
  }

  public double yCoordinate()
  {
    /*Returns the y coordinate*/
    return this.y;
  }

  public double radius()
  {
    /*Returns the distance of the point from the origin*/
    double rad = Math.sqrt(this.x*this.x + this.y*this.y);
    return rad;
  }

  public double angle()
  {
    if(this.x==0 && this.y==0)
    {
       return 0.0;
    }
    else if(this.x==0 && this.y>0)
    { 
      double ang = Math.PI/2; 
      return ang;
    }
    else if(this.x==0 && this.y<0)
    {
      double ang = Math.PI + Math.PI/2;
      return ang;
    }
    else
    {
    /*Returns the angle with respect to positive x axes*/
    double ang = Math.atan2(this.y, this.x);
    /*This angle will be in radians*/          
    return ang;
    }
  }

  public Point rotate90()
  {
    /*Returns a new point that is 90 degrees clockwise from original point*/
    double ex;
    double why;    
    Point oldpt = new CartesianPoint(this.x,this.y);
    double rad = oldpt.radius();
    double angle = oldpt.angle();
    angle = angle + Math.PI/2;
    /* Math.PI/2 = 90 deg;*/
    ex = rad * Math.cos(angle);
    why = rad * Math.sin(angle);    
    Point pt = new CartesianPoint(ex,why);   
    return pt;
  }

  
}
