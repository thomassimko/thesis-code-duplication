public class PolarTestCases
{
   public static void main(String args[])
   {
      Point c = new PolarPoint(3.0,90);
      Point d = new PolarPoint(2.0,45);
      Point e = new PolarPoint(-2.0,-135);
      Point f = new PolarPoint(3.0,-270);

      Check.check(c.xCoordinate(),3*Math.cos(Math.PI/2));
      Check.check(c.yCoordinate(),3*Math.sin(Math.PI/2));

      Check.check(d.xCoordinate(),2*Math.cos(Math.PI/4));
      Check.check(d.yCoordinate(),2*Math.sin(Math.PI/4));

      Check.check(e.xCoordinate(),2*Math.cos(Math.PI/4));
      Check.check(e.yCoordinate(),2*Math.sin(Math.PI/4));

      Check.check(f.xCoordinate(),3*Math.cos(Math.PI/2));
      Check.check(f.yCoordinate(),3*Math.sin(Math.PI/2));

      Check.check(c.radius(),3.0);
      Check.check(d.radius(),2.0);
      Check.check(e.radius(),2.0);
      Check.check(f.radius(),3.0);

      Check.check(c.angle(),Math.PI/2);
      Check.check(d.angle(),Math.PI/4);
      Check.check(e.angle(),Math.PI/4);
      Check.check(f.angle(),Math.PI/2);
 
      Check.check(c.rotate90().angle(),Math.PI);
      Check.check(d.rotate90().angle(),3*Math.PI/4);
      Check.check(e.rotate90().angle(),3*Math.PI/4);
      Check.check(f.rotate90().angle(),Math.PI);

   }
}
                                              
