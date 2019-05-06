public class CartesianTestCases
{
   public static void testCartesianPoint()
   {
      Check.check((new CartesianPoint(1.0, 1.0)).xCoordinate(), 1.0);
      Check.check((new CartesianPoint(-1.0, 4.0)).xCoordinate(), -1.0);
      Check.check((new CartesianPoint(-3.0, -2.0)).xCoordinate(), -3.0);
      Check.check((new CartesianPoint(5.0, -2.0)).xCoordinate(), 5.0);
      Check.check((new CartesianPoint(0.0, 0.0)).xCoordinate(), 0.0);
      
      Check.check((new CartesianPoint(1.0, 1.0)).yCoordinate(), 1.0);
      Check.check((new CartesianPoint(-1.0, 4.0)).yCoordinate(), 4.0);
      Check.check((new CartesianPoint(-3.0, -2.0)).yCoordinate(), -2.0);
      Check.check((new CartesianPoint(5.0, -2.0)).yCoordinate(), -2.0);
      Check.check((new CartesianPoint(0.0, 0.0)).yCoordinate(), 0.0);
      
      Check.check((new CartesianPoint(1.0, 1.0)).radius(), 1.41421);
      Check.check((new CartesianPoint(-1.0, 4.0)).radius(), 4.12310);
      Check.check((new CartesianPoint(-3.0, -2.0)).radius(), 3.60555);
      Check.check((new CartesianPoint(5.0, -2.0)).radius(), 5.38516);
      Check.check((new CartesianPoint(0.0, 0.0)).radius(), 0.0);
      
      Check.check((new CartesianPoint(1.0, 1.0)).angle(), 0.78539);
      Check.check((new CartesianPoint(-1.0, 4.0)).angle(), 1.81577);
      Check.check((new CartesianPoint(-3.0, -2.0)).angle(), 3.72959);
      Check.check((new CartesianPoint(5.0, -2.0)).angle(), 5.90267);      
      Check.check((new CartesianPoint(0.0, 0.0)).angle(), 0.0);
      
      
//      try both x-coor and y-coor separately
      Check.check((new CartesianPoint(1.0, 1.0)).rotate90().
         xCoordinate(), -1.0);
      Check.check((new CartesianPoint(-1.0, 4.0)).rotate90().
         xCoordinate(), -4.0);
      Check.check((new CartesianPoint(-3.0, -2.0)).rotate90().
         xCoordinate(), 2.0);
      Check.check((new CartesianPoint(5.0, -2.0)).rotate90().
         xCoordinate(), 2.0);
      Check.check((new CartesianPoint(0.0, 0.0)).rotate90().
         xCoordinate(), 0.0);
      
      Check.check((new CartesianPoint(1.0, 1.0)).rotate90().
         yCoordinate(), 1.0);
      Check.check((new CartesianPoint(-1.0, 4.0)).rotate90().
         yCoordinate(), -1.0);
      Check.check((new CartesianPoint(-3.0, -2.0)).rotate90().
         yCoordinate(), -3.0);
      Check.check((new CartesianPoint(5.0, -2.0)).rotate90().
         yCoordinate(), 5.0);
      Check.check((new CartesianPoint(0.0, 0.0)).rotate90().
         yCoordinate(), 0.0);
   }
   
   public static void main(String[] args)
   {
      testCartesianPoint();
   }
}
