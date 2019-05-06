public class CartesianTestCases
{
   public static void main(String [] args)
   {
      Point testpt = new CartesianPoint(1.0, 0.0);
      Check.check(testpt.xCoordinate(), 1.0);
      Check.check(testpt.yCoordinate(), 0.0);
      Check.check(testpt.radius(), 1.0);
      Check.check(testpt.angle(), 0.0);
      Point rotatept = testpt.rotate90();
      Check.check(rotatept.xCoordinate(), 0.0);
      Check.check(rotatept.yCoordinate(), 1.0);

      Point testpt2 = new CartesianPoint(3.0, 4.0);
      Check.check(testpt2.xCoordinate(), 3.0);
      Check.check(testpt2.yCoordinate(), 4.0);
      Check.check(testpt2.radius(), 5.0);
      Check.check(testpt2.angle(), 0.927295);
      Point rotatept2 = testpt2.rotate90();
      Check.check(rotatept2.xCoordinate(), -4.0);
      Check.check(rotatept2.yCoordinate(), 3.0);
   }
}
