public class PolarTestCases
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
      Point Tacobell = new PolarPoint(1, 0);
      Point Belltaco = new PolarPoint(5, 90);

      Check.check(Tacobell.xCoordinate(), 1);
      Check.check(Belltaco.xCoordinate(), 0);
      
   }
   public static void testYCoordinate()
   {
      Point Tacobell = new PolarPoint(5, 90);
      Point Belltaco = new PolarPoint(6, 45);

      Check.check(Belltaco.yCoordinate(), 6*Math.sqrt(2));      
      Check.check(Tacobell.yCoordinate(), 5);
   
   }
   public static void testRadius()
   {
      Point Tacobell = new PolarPoint(4, 3);
      Point Belltaco = new PolarPoint(53, 2);

      Check.check(Tacobell.radius(), 4);
      Check.check(Belltaco.radius(), 53);
   
   }
   public static void testAngle()
   {
      Point Tacobell = new PolarPoint(0, 1);
      Point Belltaco = new PolarPoint(5, 125);
      Point Yelle = new PolarPoint(4, 24);

      Check.check(Tacobell.angle(), 1);
      Check.check(Belltaco.angle(), 125);
      Check.check(Yelle.angle(), 24);   
   }
   public static void testRotate90()
   {
      Point TacoBell = new PolarPoint(1, 0);
      Point BellTaco = new PolarPoint(0, 90);
      Point AcoTeBle = new PolarPoint(180, 0);

      Check.check(TacoBell.rotate90(), BellTaco);
      Check.check(BellTaco.rotate90(), AcoTeBle);
   
   }
}
