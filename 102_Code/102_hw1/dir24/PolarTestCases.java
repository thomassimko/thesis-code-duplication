public class PolarTestCases
{
   public static void testPolarPoint()
   {
   
//      use trigonometry to find x & y
//      with sin, cos, tan

      // pi/2
      Check.check((new PolarPoint(12.0, 1.5708)).xCoordinate(), 0.0);
      // pi/4
      Check.check((new PolarPoint(-15.0, 0.78540)).xCoordinate(), -10.60660);
      // 3pi/4
      Check.check((new PolarPoint(-6.0, 2.35619)).xCoordinate(), 4.24264);
      // 5pi/4
      Check.check((new PolarPoint(8.0, -3.92699)).xCoordinate(), -5.65685);
      // 7pi/4
      Check.check((new PolarPoint(-4.0, -5.49779)).xCoordinate(), -2.82849);
      
      Check.check((new PolarPoint(12.0, 1.5708)).yCoordinate(), 12.0);
      Check.check((new PolarPoint(-15.0, 0.78540)).yCoordinate(), -10.60660);
      Check.check((new PolarPoint(-6.0, 2.35619)).yCoordinate(), -4.24264);
      Check.check((new PolarPoint(8.0, -3.92699)).yCoordinate(), 5.65685);
      Check.check((new PolarPoint(-4.0, -5.49779)).yCoordinate(), -2.82849);
      
      
      Check.check((new PolarPoint(12.0, 1.5708)).radius(), 12.0);
      Check.check((new PolarPoint(-15.0, 0.78540)).radius(), 15.0);
      Check.check((new PolarPoint(-6.0, 2.35619)).radius(), 6.0);
      Check.check((new PolarPoint(8.0, -3.92699)).radius(), 8.0);
      Check.check((new PolarPoint(-4.0, -5.49779)).radius(), 4.0);
      
      
      Check.check((new PolarPoint(12.0, 1.5708)).angle(), 1.5708);
      Check.check((new PolarPoint(-15.0, 0.78540)).angle(), 3.92699);
      Check.check((new PolarPoint(-6.0, 2.35619)).angle(), 5.49778);
      Check.check((new PolarPoint(8.0, -3.92699)).angle(), 2.35619);
      Check.check((new PolarPoint(-4.0, -5.49779)).angle(), 3.92699);
      
      
//      try both x-coor and y-coor separately
//      just add pi/2
//      cos for x, sin for y
//      cos(angle)*radius = xCoor
//      sin(angle)*radius = yCoor

      Check.check((new PolarPoint(12.0, 1.5708)).rotate90().xCoordinate(),
       -12.0);
      Check.check((new PolarPoint(-15.0, 0.78540)).rotate90().xCoordinate(),
       10.60653);
      Check.check((new PolarPoint(-6.0, 2.35619)).rotate90().xCoordinate(),
       4.24264);
      Check.check((new PolarPoint(8.0, -3.92699)).rotate90().xCoordinate(),
       -5.65685);
      Check.check((new PolarPoint(-4.0, -5.49779)).rotate90().xCoordinate(),
       2.82841);
      
      Check.check((new PolarPoint(12.0, 1.5708)).rotate90().yCoordinate(),
       0.00003184);
      Check.check((new PolarPoint(-15.0, 0.78540)).rotate90().yCoordinate(),
       -10.60668);
      Check.check((new PolarPoint(-6.0, 2.35619)).rotate90().yCoordinate(),
       4.24264);
      Check.check((new PolarPoint(8.0, -3.92699)).rotate90().yCoordinate(),
       -5.65685);
      Check.check((new PolarPoint(-4.0, -5.49779)).rotate90().yCoordinate(),
       -2.82845);
      
      Check.check((new PolarPoint(12.0, 1.5708)).rotate90().radius(), 12.0);
      Check.check((new PolarPoint(-15.0, 0.78540)).rotate90().radius(), 15.0);
      Check.check((new PolarPoint(-6.0, 2.35619)).rotate90().radius(), 6.0);
      Check.check((new PolarPoint(8.0, -3.92699)).rotate90().radius(), 8.0);
      Check.check((new PolarPoint(-4.0, -5.49779)).rotate90().radius(), 4.0);
      
      Check.check((new PolarPoint(12.0, 1.5708)).rotate90().angle(), 3.14159);
      Check.check((new PolarPoint(-15.0, 0.78540)).rotate90().angle(), 5.49778);
      Check.check((new PolarPoint(-6.0, 2.35619)).rotate90().angle(), 0.78539);
      Check.check((new PolarPoint(8.0, -3.92699)).rotate90().angle(), 3.92699);
      Check.check((new PolarPoint(-4.0, -5.49779)).rotate90().angle(), 5.49778);
      
   }
   
   public static void main(String[] args)
   {
      testPolarPoint();
   }
}
