public class CartesianTestCases 
{
   public static void main(String[] args) 
   {
      Point p1 = new CartesianPoint(5,2);
      Point p2 = p1.rotate90();
      
      Check.check(p1.xCoordinate(), 5);
      Check.check(p1.yCoordinate(), 2);
      Check.check(p1.radius(), 5.38516);
      Check.check(p1.angle(), 0.380506212);
      Check.check(p2.xCoordinate(), -2);
      Check.check(p2.yCoordinate(), 5);   
   }
}