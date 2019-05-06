public class CartesianTest
{
	public static void main(String [] argc)
	{ Point cp=new CartesianPoint(4,3);
	  Point dp=new CartesianPoint(5,12);
	  
	  Check.check(cp.radius(),5);
	  Check.check(cp.angle(),.6435011088);
	  Check.check(cp.rot90().xCoord(),5);
	  Check.check(dp.radius(),13);
	  Check.check(dp.angle(),1.176005207);
	  Check.check(dp.rot90().xCoord(),13);
	}
}