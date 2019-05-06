public class CartesianTestCases
{
   public static void testCartesianPoint()
   {
      Point point1 = new CartesianPoint(0.5, 3.0);
      Point point2 = new CartesianPoint(6.4, 2.5);
      Point point3 = new CartesianPoint(18.6, 10.3);
      Point point4 = new CartesianPoint(-1.6, 5.3);
      Point point5 = new CartesianPoint(8.1, -10.3);
      Point point6 = new CartesianPoint(-18.6, -10.3);

      Check.check(point1.xCoordinate(), .5);
      Check.check(point2.xCoordinate(), 6.4);
      Check.check(point3.xCoordinate(), 18.6);
      Check.check(point4.xCoordinate(), -1.6);
      Check.check(point5.xCoordinate(), 8.1);
      Check.check(point6.xCoordinate(), -18.6);

      Check.check(point1.yCoordinate(), 3.0);
      Check.check(point2.yCoordinate(), 2.5);
      Check.check(point3.yCoordinate(), 10.3);
      Check.check(point4.yCoordinate(), 5.3);
      Check.check(point5.yCoordinate(), -10.3);
      Check.check(point6.yCoordinate(), -10.3);

      Check.check(point1.radius(), 3.0414);
      Check.check(point2.radius(), 6.87095);
      Check.check(point3.radius(), 21.2615);
      Check.check(point4.radius(), 5.53624);
      Check.check(point5.radius(), 13.1034);
      Check.check(point6.radius(), 21.2615);

      Check.check(point1.angle(), 1.4056);
      Check.check(point2.angle(), .3724);
      Check.check(point3.angle(), .5057);
      Check.check(point4.angle(), 1.86398);
      Check.check(point5.angle(), 5.3787868);
      Check.check(point6.angle(), 3.6473207);

      Check.check(point1.rotate90().xCoordinate(), -3.0);
      Check.check(point2.rotate90().xCoordinate(), -2.5);
      Check.check(point3.rotate90().xCoordinate(), -10.3);
      Check.check(point4.rotate90().xCoordinate(), -5.3);
      Check.check(point5.rotate90().xCoordinate(), 10.3);
      Check.check(point6.rotate90().xCoordinate(), 10.3);

      Check.check(point1.rotate90().yCoordinate(), .5);
      Check.check(point2.rotate90().yCoordinate(), 6.4);
      Check.check(point3.rotate90().yCoordinate(), 18.6);
      Check.check(point4.rotate90().yCoordinate(), -1.6);
      Check.check(point5.rotate90().yCoordinate(), 8.1);
      Check.check(point6.rotate90().yCoordinate(), -18.6);

      Check.check(point1.rotate90().radius(), 3.0414);
      Check.check(point2.rotate90().radius(), 6.87095);
      Check.check(point3.rotate90().radius(), 21.2615);
      Check.check(point4.rotate90().radius(), 5.53624);
      Check.check(point5.rotate90().radius(), 13.1034);
      Check.check(point6.rotate90().radius(), 21.2615);

      Check.check(point1.rotate90().angle(), 2.976444);
      Check.check(point2.rotate90().angle(), 1.943195);
      Check.check(point3.rotate90().angle(), 2.076524);
      Check.check(point4.rotate90().angle(), 3.4347796);
      Check.check(point5.rotate90().angle(), .66639787);
      Check.check(point6.rotate90().angle(), 5.218117);
   }
   public static void main(String[] args)
   {
      testCartesianPoint();
   }   
}
