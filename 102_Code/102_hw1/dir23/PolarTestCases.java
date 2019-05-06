/*Programmed by Michael Olivarez*/
public class PolarTestCases
{
   public static void test_x_coordinate()
   {
      Point pt = new PolarPoint(5.0,0.0);
      Check.check(pt.xCoordinate(),5.0);
      Point pt2 = new PolarPoint(0.0,0.0);
      Check.check(pt2.xCoordinate(),0.0);
   }

   public static void test_y_coordinate()
   {
      Point pt = new PolarPoint(5.0,Math.PI/2);
      Check.check(pt.yCoordinate(),5.0);
      Point pt2 = new PolarPoint(0.0,0.0);
      Check.check(pt2.yCoordinate(),0.0);
   }

   public static void test_radius()
   {
      Point pt = new PolarPoint(5.0,Math.PI/6);
      Check.check(pt.radius(),5.0);
     
      Point pt2 = new PolarPoint(0.0,2*Math.PI/6);
      Check.check(pt2.radius(),0.0);
   }
   
   public static void test_angle()
   {
      Point pt = new PolarPoint(5.0,Math.PI/2);
      Check.check(pt.angle(),Math.PI/2);
     
      Point pt2 = new PolarPoint(10.3,Math.PI/6);
      Check.check(pt2.angle(),Math.PI/6);
      
   }

   public static void test_rotate90()
   {
      Point pt = new PolarPoint(5.0,0.0);
      Point newpt = pt.rotate90();
      Point pt2 = new PolarPoint(5.0,Math.PI/2);
      Check.check(newpt.radius(),pt2.radius());
      Check.check(newpt.angle(),pt2.angle());
      
      Point pt3 = new PolarPoint(2.5,Math.PI/4);
            newpt = pt3.rotate90();
      Point pt4 = new PolarPoint(2.5,3*Math.PI/4);
      Check.check(newpt.radius(),pt4.radius());
      Check.check(newpt.angle(),pt4.angle());
   }
   public static void main(String [] args)
   {
      test_x_coordinate();
      test_y_coordinate();
      test_radius();
      test_angle();
      test_rotate90();
   }
}
