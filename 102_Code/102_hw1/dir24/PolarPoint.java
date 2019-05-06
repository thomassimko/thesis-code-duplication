public class PolarPoint
   implements Point
{
      private double radius;
      private double angle;
      
      PolarPoint(double radius, double angle)
      {  
         if(angle < 0)
         {
            angle = (2 * Math.PI) + angle;
         }
         
         if(radius >= 0)
         {
            radius = radius;
            
            if(angle >= 0)
            { 
               angle = angle;
            }
            
            else
            {
               angle = (2 * Math.PI) + angle;
            }
         }
         
         if(radius < 0)
         {
            radius = radius * -1;
            
            if(angle >= 0)
            {
               angle = angle + Math.PI;
            }
            
            else
            {
               angle = angle + Math.PI;
            }
         }
         
         this.radius = radius;
         this.angle = angle;
      }
      
      public double xCoordinate()
      {
         double x_coord;
      
         x_coord = radius * Math.cos(angle);
      
         return x_coord;
      }
      
      public double yCoordinate()
      {
         double y_coord;
         
         y_coord = radius * Math.sin(angle);
         
         return y_coord;
      }
      
      public double radius()
      {
         
         return radius;
      }
      
      public double angle()
      {         
         return angle;
      }
      
      public Point rotate90()
      {
         angle = angle + (Math.PI / 2);
         
         if(angle >= (2 * Math.PI))
         {
            angle = angle - (2 * Math.PI);
         }
         
         return new PolarPoint(radius, angle);
      }
}
