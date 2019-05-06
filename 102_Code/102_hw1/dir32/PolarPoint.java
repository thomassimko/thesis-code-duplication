public class PolarPoint implements Point
{
  private double xCoordinate;
  private double yCoordinate;
  private double radius;
  private double angle;

  public PolarPoint(double radius, double angle)
  {
    this.angle = Math.toRadians(angle);

    if(radius < 0)
    {
      this.radius = radius * -1;
      this.angle = this.angle + Math.PI;
    }
    else
    {
      this.radius = radius;

      if(angle < 0)
      {
        this.angle = this.angle + Math.PI * 2;
      }
      else
      {
        this.angle = this.angle;
      }      
    }

    this.xCoordinate = Math.cos(this.angle)*this.radius;
    this.yCoordinate = Math.sin(this.angle)*this.radius;
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
    double rot_90radius;
    double rot_90angle;

    rot_90angle = Math.toDegrees(this.angle + Math.PI/2);
    rot_90radius = this.radius;

    Point rot_90point = new PolarPoint(rot_90radius, rot_90angle);

    return rot_90point;
  }
}
