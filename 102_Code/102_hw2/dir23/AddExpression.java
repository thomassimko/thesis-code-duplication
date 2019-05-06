public class AddExpression
   implements Expression
{
	private Expression  lft, rht;
	
    AddExpression(Expression lft, Expression rht)
    {
       this.lft = lft;
       this.rht = rht;
    }
    
    public double evaluate(Bindings binding)
    {
       double left = this.lft.evaluate(binding);
       double right = this.rht.evaluate(binding);
      
       double sum = left + right;
       
       return sum;
    }
    
    public String toString()
    {
    	return "(" + lft + " + " + rht + ")";
    }
}
