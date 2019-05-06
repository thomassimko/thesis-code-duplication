public class PolarTest
{
	public static void main(String [] argc)
	{ Point rp=new PolarPoint(2,Math.PI/4);
	  Point tp=new PolarPoint(1,Math.PI/6);
	  
	  Check.check(rp.xCoord(),1.414213562);
	  Check.check(rp.yCoord(),1.414213562);
	  Check.check(rp.rot90().radius(),2);
	  Check.check(rp.rot90().angle(),Math.PI/2);
	  Check.check(tp.xCoord(),.8660254038);
	  Check.check(tp.yCoord(),.5);
	  Check.check(tp.rot90().radius(),1);
	  Check.check(tp.rot90().angle(),5*Math.PI/12);
	}
}