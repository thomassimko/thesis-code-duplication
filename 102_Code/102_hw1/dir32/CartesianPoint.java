public class CartesianPoint implements Point
{
  private double xCoordinate;
  private double yCoordinate;
  private double radius;
  private double angle;

  public CartesianPoint(double x_coord, double y_coord)
  {
    this.xCoordinate = x_coord;
    this.yCoordinate = y_coord;
    this.radius = Math.sqrt(x_coord * x_coord + y_coord * y_coord);
    this.angle = Math.atan2(y_coord, x_coord);
  }

  public double xCoordinate()
  {
    return this.xCoordinate;
  }

  public double yCoordinate()
  {
    return this.yCoordinate;
  }

  public double radius()
  {
    return this.radius;
  }

  public double angle()
  {
    if (this.angle > Math.PI * 2)
    {
      return this.angle - Math.PI * 2;
    }
    else
    {
      return this.angle;
    }
  }

  public Point rotate90()
  {
    double rot_90x_coord;
    double rot_90y_coord;
    double rot_90radius;
    double rot_90angle;

    rot_90angle = this.angle + Math.PI/2;
    rot_90radius = this.radius;
    rot_90x_coord = Math.cos(rot_90angle)*rot_90radius;
    rot_90y_coord = Math.sin(rot_90angle)*rot_90radius;

    Point rot_90point = new CartesianPoint(rot_90x_coord, rot_90y_coord);

    return rot_90point;
  }
}
