public class CartesianPoint
	implements Point
	{
		private double x;
		private double y;

		public CartesianPoint (double x_coor, double y_coor)
		{
			this.x = x_coor;
			this.y = y_coor;
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
			double radius;

			if(this.x == 0 && this.y == 0)
			{
				return 0;
			}
			else
			{
				radius = Math.sqrt((this.x * this.x) + (this.y * this.y));

				return radius;
			}
		}

		public double angle()
		{
			double angle;
			if(this.x == 0 && this.y == 0)
			{
				return 0;
			}
			else
			{
				angle = Math.atan2(this.y, this.x);
				return angle;
			}

		}

		public CartesianPoint rotate90()
		{
			CartesianPoint result;
			double newX;
			double newY;

			newX = -this.y;
			newY = this.x;

			result = new CartesianPoint(newX, newY);

			return result;
		}
	}
