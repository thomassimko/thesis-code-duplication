import java.lang.Math;

public class CartesianPoint
   implements Point
{     
      private double x_coord;
      private double y_coord;
      
      CartesianPoint(double x_coord, double y_coord)
      {
         this.x_coord = x_coord;
         this.y_coord = y_coord;
      }
      
      public double xCoordinate()
      {
         return x_coord;
      }
      
      public double yCoordinate()
      {
         return y_coord;
      }
      
      public double radius()
      {
         double a;
         double b;
         double radius;
         
         a = x_coord;
         b = y_coord;
         
         radius = Math.sqrt((a * a) + (b * b));
         
         return radius;
      }
      
      public double angle()
      {
         double angle = 0.0;
         
         
         // Quadrant I
         if(x_coord >= 0 && y_coord >= 0)
         {
            angle = Math.atan2(y_coord, x_coord);   
         }
         
         // Quadrant II
         if(x_coord < 0 && y_coord >= 0)
         {  
            angle = Math.atan2(y_coord, x_coord);
         }
         
         // Quadrant III
         if(x_coord < 0 && y_coord < 0)
         {
            angle = Math.atan2(y_coord, x_coord) + Math.PI + Math.PI;
         }
         
         // Quadrant IV
         if(x_coord >= 0 && y_coord < 0)
         {
            angle = Math.atan2(y_coord, x_coord) + Math.PI + Math.PI;
         }
         
         return angle;
      }
      
      public Point rotate90()
      {
         double temp_coord;
         
         temp_coord = x_coord;
         x_coord = -y_coord;
         y_coord = temp_coord;
         
         return new CartesianPoint(x_coord, y_coord);
      }
}
