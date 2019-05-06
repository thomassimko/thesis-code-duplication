public class DivideExpression
   implements Expression
{
	private Expression lft, rht;
	
	DivideExpression(Expression lft, Expression rht)
    {
		this.lft = lft;
		this.rht = rht;
    }
    
    public double evaluate(Bindings binding)
    {
    	double divisor = this.lft.evaluate(binding);
    	double dividend = this.rht.evaluate(binding);
    	
    	double quotient = divisor / dividend;
    	
        return quotient;
    }
    
    public String toString()
    {
    	return "(" + lft + " / " + rht + ")";
    }
}
