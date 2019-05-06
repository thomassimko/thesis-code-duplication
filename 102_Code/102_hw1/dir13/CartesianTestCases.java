public class CartesianTest
{
    public static void CartesianTest()
    {
       Point crazy = new CartesianPoint(1,2);
       Point UhnTiss = new CartesianPoint(5,-9);

       Check.check(crazy.xCoordinate(),1.0);
       Check.check(UhnTiss.xCoordinate(),5.0);
       Check.check(crazy.yCoordinate(),2.0);
       Check.check(UhnTiss.yCoordinate(),-9.0);

       Check.check(crazy.radius(),Math.sqrt(5));
       Check.check(UhnTiss.radius(),Math.sqrt(25+81));
       Check.check(crazy.angle(), Math.atan2(2,1));
       Check.check(UhnTiss.angle(), Math.atan2(-9,5));

       crazy = crazy.rotate90();
       Check.check(crazy.xCoordinate(),-2);
       Check.check(crazy.yCoordinate(), 1);
       Check.check(crazy.radius(),Math.sqrt(5));
       Check.check(crazy.angle(),Math.atan2(1,-2));
    }

    public static void main(String[] args)
    {
       CartesianTest();
    }
}
