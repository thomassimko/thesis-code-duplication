
public class MultiplyExpression 
      implements Expression
{

		private Expression lft, rht;
		public MultiplyExpression(Expression lft, Expression rht)
		{
			this.lft = lft;
			this.rht = rht;
		}
		
		public double evaluate(Bindings bindings) 
		{
			return lft.evaluate(bindings) * rht.evaluate(bindings);
		}
		
		public String toString()
		{
			return "(" + lft.toString() + " * " + rht.toString() + ")" ;
		}

	}
