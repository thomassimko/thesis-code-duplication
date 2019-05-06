public class PolarTestCases
{
   public static void main(String [] args)
   {
      Point testpt = new PolarPoint(1.0, 0.0);
      Check.check(testpt.xCoordinate(), 1.0);
      Check.check(testpt.yCoordinate(), 0.0);
      Check.check(testpt.radius(), 1.0);
      Check.check(testpt.angle(), 0.0);
      Point rotatept = testpt.rotate90();
      Check.check(rotatept.radius(), 1.0);
      Check.check(rotatept.angle(), 90.0);

      Point testpt2 = new PolarPoint(2.5, 270.0);
      Check.check(testpt2.xCoordinate(), 0.0);
      Check.check(testpt2.yCoordinate(), -2.5);
      Check.check(testpt2.radius(), 2.5);
      Check.check(testpt2.angle(), 270.0);
      Point rotatept2 = testpt2.rotate90();
      Check.check(rotatept2.radius(), 2.5);
      Check.check(rotatept2.angle(), 0.0);
   }
}
