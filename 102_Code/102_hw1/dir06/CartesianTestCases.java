public class CartesianTestCases
{
   public static void main(String args[])
   {
       Point point1 = new CartesianPoint(3.0, 4.0);
       Point point2 = point1.rotate90();
       Check.check(point1.xCoordinate(), 3.0);
       Check.check(point1.yCoordinate(), 4.0);
       Check.check(point1.radius(), 5.0);
       Check.check(point1.angle(), 0.9272952);
       Check.check(point2.xCoordinate(), -4.0);
       Check.check(point2.yCoordinate(), 3.0);
   }
}
