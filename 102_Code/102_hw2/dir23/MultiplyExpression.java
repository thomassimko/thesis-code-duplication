public class MultiplyExpression
   implements Expression
{
	private Expression lft, rht;
	
    MultiplyExpression(Expression lft, Expression rht)
    {
    	this.lft = lft;
    	this.rht = rht;
    }
    
    public double evaluate(Bindings binding)
    {
       double left = this.lft.evaluate(binding);
       double right = this.rht.evaluate(binding);
       
       double product = left * right;
       
       return product;
    }
    
    public String toString()
    {
    	return "(" + lft + " * " + rht + ")";
    }
}
