public class PolarTestCases
{
   public static void main(String [] args)
   {
      Point pt = new PolarPoint(4.0, Math.PI/2);
      Point pt2 = new PolarPoint(0.0, 0.0);
      Point pt3 = new PolarPoint(-1.3, Math.PI);
      Point pt4 = new PolarPoint(5.0, 3*Math.PI/2);
      Point pt5 = new PolarPoint(2.0, Math.PI/3);

      Check.check(pt.xCoordinate(), 0.0);
      Check.check(pt2.xCoordinate(), 0.0);
      Check.check(pt3.xCoordinate(), 1.3);
      Check.check(pt4.xCoordinate(), 0.0);
      Check.check(pt5.xCoordinate(), Math.cos(Math.PI/3)*2.0);

      Check.check(pt.yCoordinate(), 4.0);
      Check.check(pt2.yCoordinate(), 0.0);
      Check.check(pt3.yCoordinate(), 0.0);
      Check.check(pt4.yCoordinate(), -5.0);
      Check.check(pt5.yCoordinate(), Math.sin(Math.PI/3)*2.0);

      Check.check(pt.radius(), 4.0);
      Check.check(pt2.radius(), 0.0);
      Check.check(pt3.radius(), 1.3);
      Check.check(pt4.radius(), 5.0);
      Check.check(pt5.radius(), 2.0);

      Check.check(pt.angle(), Math.PI/2);
      Check.check(pt2.angle(), 0.0);
      Check.check(pt3.angle(), 2*Math.PI);
      Check.check(pt4.angle(), 3*Math.PI/2);
      Check.check(pt5.angle(), Math.PI/3);

      Check.check(pt.rotate90().radius(), 4.0);
      Check.check(pt2.rotate90().radius(), 0.0);
      Check.check(pt3.rotate90().radius(), 1.3);
      Check.check(pt4.rotate90().radius(), 5.0);
      Check.check(pt5.rotate90().radius(), 2.0);

      Check.check(pt.rotate90().angle(), Math.PI);
      Check.check(pt2.rotate90().angle(), Math.PI/2);
      Check.check(pt3.rotate90().angle(), 2*Math.PI + Math.PI/2);
      Check.check(pt4.rotate90().angle(), 2*Math.PI);
      Check.check(pt5.rotate90().angle(), 5*Math.PI/6);
   }
}

