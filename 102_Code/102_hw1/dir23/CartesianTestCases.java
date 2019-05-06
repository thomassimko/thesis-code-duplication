/*Programmed by Michael Olivarez*/
public class CartesianTestCases
{
   public static void test_x_coordinate()
   {
      Point pt = new CartesianPoint(1.0,5.0);
      Check.check(pt.xCoordinate(),1.0);
      Point pt2 = new CartesianPoint(-3.5,2.4);
      Check.check(pt2.xCoordinate(),-3.5);
   }
   
   public static void test_y_coordinate()
   {
      Point pt = new CartesianPoint(1.0,5.0);
      Check.check(pt.yCoordinate(),5.0);
      Point pt2 = new CartesianPoint(3.5,-2.4);
      Check.check(pt2.yCoordinate(),-2.4);
   }

   public static void test_radius()
   {
      Point pt = new CartesianPoint(3.0,4.0);
      Check.check(pt.radius(),5.0);
      Point pt2 = new CartesianPoint(4.0,3.0);
      Check.check(pt2.radius(),5.0);
   }

   public static void test_angle()
   {
      Point pt = new CartesianPoint(0.0,5.0);
      double answer = Math.PI/2;
      Check.check(pt.angle(),answer);
      Point pt2 = new CartesianPoint(4.0,4.0);
             answer = Math.PI/4;
      Check.check(pt2.angle(),answer);
   }

   public static void test_rotate90()
   {
     Point pt = new CartesianPoint(3.0,0.0);
     Point newpt = pt.rotate90();
     Point pt2 = new CartesianPoint(0.0,3.0);
     Check.check(newpt.xCoordinate(),pt2.xCoordinate());
     Check.check(newpt.yCoordinate(),pt2.yCoordinate());

     Point pt3 = new CartesianPoint(2.0,2.0);
           newpt = pt3.rotate90();
     Point pt4 = new CartesianPoint(-2.0,2.0);
     Check.check(newpt.xCoordinate(),pt4.xCoordinate());
     Check.check(newpt.yCoordinate(),pt4.yCoordinate());
     /*rotate it, then check x and y coordinates individually*/
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
