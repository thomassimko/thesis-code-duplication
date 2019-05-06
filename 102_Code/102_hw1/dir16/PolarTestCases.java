public class PolarTestCases 
{
   public static void main(String[] args) 
   {
      Point pt1 = new PolarPoint(6, 1.57079633);
      Point pt2 = pt1.rotate90();
      
      Check.check(pt1.xCoordinate(), 0);
      Check.check(pt1.yCoordinate(), 6);
      Check.check(pt1.radius(), 6);
      Check.check(pt1.angle(), 1.57079633);
      Check.check(pt2.xCoordinate(), -6);
      Check.check(pt2.yCoordinate(), 0);
   }
}