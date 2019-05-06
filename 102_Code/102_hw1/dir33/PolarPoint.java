public class PolarPoint
    implements Point
{
    
    private double radius, angle;   
    public PolarPoint(double radius,double angle)
    {
        if(radius > 0)
        {
            this.radius = radius;
            this.angle = Math.toRadians(angle);
        }
        else if(radius == 0)
        {
           this.radius = 0;
           this.angle = 0;
        }
        else
        {
            this.radius = -1*radius;
            this.angle = Math.toRadians(angle + 180);
        }
        
        while(this.angle < 0 && radius != 0)
        {
            this.angle += 2*Math.PI; 
        }
   
    }
  
   public double xCoordinate()
   {
       return radius()*Math.cos(angle());
   }

   public double yCoordinate()
   {
       return radius()*Math.sin(angle());
   }
   
   public double radius()
   {
      return this.radius;
   } 

   public double angle()
   {
      return this.angle;
   }
  
   public Point rotate90()
   {
      return new PolarPoint(radius(),Math.toDegrees(angle() + Math.PI/2));
   }

}
   
