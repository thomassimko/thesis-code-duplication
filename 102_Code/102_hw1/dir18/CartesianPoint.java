public class CartesianPoint
  implements Point
{
  private double x = 0;
  private double y = 0;

  public CartesianPoint()
  {
    this.x = 1;
    this.y = 1;
  }

  public CartesianPoint(double x_coord, double y_coord)
  {
    this.x = x_coord;
    this.y = y_coord;
  }

  public double xCoordinate()
  {
    return this.x;
  }

  public double yCoordinate()
  {
    return this.y;
  }

  public double radius()
  {
    return Math.sqrt( this.x * this.x + this.y * this.y );
  }

  public double angle()
  {
    return Math.toDegrees( Math.atan2( this.y, this.x ) );
  }

  public Point rotate90()
  {
    return new CartesianPoint( -1 * this.y, this.x );
  }
}
