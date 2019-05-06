public class PolarPoint
  implements Point
{
  private double rad = 0;
  private double theta = 0;

  public PolarPoint()
  {
    this.rad = 1;
    this.theta = 0;
  }

  public PolarPoint(double radius, double angle)
  {
    this.rad = Math.abs( radius );
    this.theta = angle;

    if( radius < 0 )
    {
      this.theta += 180;
    }

    while( this.theta >= 360 )
    {
      this.theta -= 360;
    }
    while( this.theta < 0 )
    {
      this.theta += 360;
    }

    this.theta = Math.toRadians(this.theta);
  }

  public double xCoordinate()
  {
    return this.rad * Math.cos( this.theta );
  }

  public double yCoordinate()
  {
    return this.rad * Math.sin( this.theta );
  }

  public double radius()
  {
    return rad;
  }

  public double angle()
  {
    return Math.toDegrees( this.theta );
  }

  public Point rotate90()
  {
    return new PolarPoint( this.rad, Math.toDegrees(this.theta) + 90 );
  }
}
