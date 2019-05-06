public class PolarTestCases {
   public static void testPolarPoint()
   {
      Point point1 = new PolarPoint(1.4142, .785398);
      Point point2 = new PolarPoint(-1.4142, .785398);
      Point point3 = new PolarPoint(18.6, -.785398);
      Point point4 = new PolarPoint(-18.6, -1.0471);
      Point point5 = new PolarPoint(0, 0);
      Point point6 = new PolarPoint(5.6, 2.35629);
      Point point7 = new PolarPoint(3.5, 4.188790);
      Point point8 = new PolarPoint(6.3, 5.235988);

      Check.check(point1.xCoordinate(), 1.0);
      Check.check(point2.xCoordinate(), -.999990573);
      Check.check(point3.xCoordinate(), 13.1522);
      Check.check(point4.xCoordinate(), -9.30157);
      Check.check(point5.xCoordinate(), 0);
      Check.check(point6.xCoordinate(), -3.9601775);
      Check.check(point7.xCoordinate(), -1.74999957);
      Check.check(point8.xCoordinate(), 3.15000322);

      Check.check(point1.yCoordinate(), 1.0);
      Check.check(point2.yCoordinate(), -.999990247);
      Check.check(point3.yCoordinate(), -13.1522);
      Check.check(point4.yCoordinate(), 16.1072);
      Check.check(point5.yCoordinate(), 0);
      Check.check(point6.yCoordinate(), 3.9594184);
      Check.check(point7.yCoordinate(), -3.0310897);
      Check.check(point8.yCoordinate(), -5.4559593);

      Check.check(point1.radius(), 1.4142);
      Check.check(point2.radius(), 1.4142);
      Check.check(point3.radius(), 18.6);
      Check.check(point4.radius(), 18.6);
      Check.check(point5.radius(), 0);
      Check.check(point6.radius(), 5.6);
      Check.check(point7.radius(), 3.5);
      Check.check(point8.radius(), 6.3);

      Check.check(point1.angle(), .785398);
      Check.check(point2.angle(), 3.926990654);
      Check.check(point3.angle(), 5.497787);
      Check.check(point4.angle(), 2.09449);
      Check.check(point5.angle(), 0);
      Check.check(point6.angle(), 2.35629);
      Check.check(point7.angle(), 4.188790);
      Check.check(point8.angle(), 5.235988);

      Check.check(point1.rotate90().xCoordinate(), -1.0);
      Check.check(point2.rotate90().xCoordinate(), .999990247);
      Check.check(point3.rotate90().xCoordinate(), 13.1522);
      Check.check(point4.rotate90().xCoordinate(), -16.1072);
      Check.check(point5.rotate90().xCoordinate(), 0);

      Check.check(point1.rotate90().yCoordinate(), 1.0);
      Check.check(point2.rotate90().yCoordinate(), -.999990573);
      Check.check(point3.rotate90().yCoordinate(), 13.1521);
      Check.check(point4.rotate90().yCoordinate(), -9.30157);
      Check.check(point5.rotate90().yCoordinate(), 0);

      Check.check(point1.rotate90().radius(), 1.4142);
      Check.check(point2.rotate90().radius(), 1.4142);
      Check.check(point3.rotate90().radius(), 18.6);
      Check.check(point4.rotate90().radius(), 18.6);
      Check.check(point5.rotate90().radius(), 0);

      Check.check(point1.rotate90().angle(), 2.35619);
      Check.check(point2.rotate90().angle(), 5.497786981);
      Check.check(point3.rotate90().angle(), .78539802);
      Check.check(point4.rotate90().angle(), 3.665288);
      Check.check(point5.rotate90().angle(), 1.57075);

   }
   public static void main(String[] args)
   {
      testPolarPoint();
   }   
}
