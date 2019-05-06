public class CartesianPoint
        implements Point
{
    private double x, y;
    public CartesianPoint(double x, double y)
    {
       this.x = x;
       this.y = y;
    }

    public double xCoordinate()
    {
        return x;
    }
    public double yCoordinate()
    {
       return y;
    }
    public double radius()
    {
       return Math.sqrt(x*x + y*y);
    }
    public double angle()
    {
       return Math.atan2(y, x);
    }
    public Point rotate90()
    {
              return new CartesianPoint(-y, x);
    }
}
    
