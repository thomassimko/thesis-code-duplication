public class PolarPoint
	implements Point
	{
		private double r;
		private double theta;

		public PolarPoint (double r, double theta)
		{
			if(r < 0)
			{
				this.r = -r;
				if(theta < 0)
				{
					this.theta = -theta + (Math.PI/2);
				}
				else
				{
					this.theta = theta + (Math.PI);
				}
			}
			else
			{
				this.r = r;

				if(theta < 0)
				{
					this.theta = (2*Math.PI) + theta;
				}
				else
				{
					this.theta = theta;
				}
			}
		}

		public double xCoordinate()
		{
			double x;

			if(this.r == 0)
			{
				return 0;
			}
			else
			{
				x = this.r * Math.cos(this.theta);
				return x;
			}
		}

		public double yCoordinate()
		{
			double y;
			
			if(this.r == 0)
			{
				return 0;
			}
			else
			{
				y = this.r * Math.sin(this.theta);
				return y;
			}
		}

		public double radius()
		{
			return this.r;
		}

		public double angle()
		{
			return this.theta;
		}

		public Point rotate90()
		{
			Point result;
			double newTheta;
			
			newTheta= this.angle() + (Math.PI/2);

			result = new PolarPoint(this.r, newTheta);

			return result;
		}
	}
