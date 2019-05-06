public class CartesianTestCases
{
   public static void main(String[] args)
   {
      testXCoordinate();
      testYCoordinate();
      testRadius();
      testAngle();
      testRotate90();
   }
   
   public static void testXCoordinate()
   {
      Point Tacobell = new CartesianPoint(5, 3);

      Check.check(Tacobell.xCoordinate(), 5);
   }
   public static void testYCoordinate()
   {
      Point Tacobell = new CartesianPoint(5, 3);
      
      Check.check(Tacobell.yCoordinate(), 3);
   
   }
   public static void testRadius()
   {
      Point Tacobell = new CartesianPoint(4, 3);
   
      Check.check(Tacobell.radius(), 5);
   
   }
   public static void testAngle()
   {
      Point Tacobell = new CartesianPoint(0, 1);
   
      Check.check(Tacobell.angle(), 90);
   
   }
   public static void testRotate90()
   {
      Point TacoBell = new CartesianPoint(1, 0);
      Point BellTaco = new CartesianPoint(0, 1);
      Point AcoTeBle = new CartesianPoint(-1, 0);

      Check.check(TacoBell.rotate90(), BellTaco);
      Check.check(BellTaco.rotate90(), AcoTeBle);
   
   }
   
}
