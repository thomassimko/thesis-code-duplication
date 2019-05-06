public class SubtractExpression
   implements Expression
{
	private Expression lft, rht;
	
    SubtractExpression(Expression lft, Expression rht)
    {
    	this.lft = lft;
    	this.rht = rht;
    }
    
    public double evaluate(Bindings binding)
    {
    	double left = this.lft.evaluate(binding);
    	double right = this.rht.evaluate(binding);
    	
    	double difference = left - right;
    	
        return difference;
    }
    
    public String toString()
    {
    	return "(" + lft + " - " + rht + ")";
    }
}
