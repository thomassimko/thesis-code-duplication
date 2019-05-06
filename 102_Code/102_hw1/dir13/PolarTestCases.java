
public class PolarTest
{
    public static void PolarTest()
    {
       Point crazy = new PolarPoint(2/Math.sin(Math.atan2(2,1)),Math.atan2(2,1));
       Point UhnTiss = new PolarPoint(1,Math.PI/2);

       Check.check(crazy.xCoordinate(),1.0);
       Check.check(UhnTiss.xCoordinate(),0.0);
       Check.check(crazy.yCoordinate(),2.0);
       Check.check(UhnTiss.yCoordinate(),1.0);

       Check.check(crazy.radius(),Math.sqrt(5));
       Check.check(UhnTiss.radius(),1);
       Check.check(crazy.angle(), Math.atan2(2,1));
       Check.check(UhnTiss.angle(), Math.PI/2);

       crazy = crazy.rotate90();
       Check.check(crazy.xCoordinate(),-2);
       Check.check(crazy.yCoordinate(), 1);
       Check.check(crazy.radius(),Math.sqrt(5));
       Check.check(crazy.angle(),Math.atan2(1,-2));
    }

    public static void main(String[] args)
    {
       PolarTest();
    }
}
