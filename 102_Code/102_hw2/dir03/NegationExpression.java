public class NegationExpression
implements Expression
{
   private Expression value;

   public NegationExpression(Expression e)
   {
       this.value=e;
   }

   public double evaluate(Bindings binding)
   {
       return -this.value.evaluate(binding);
   }

    public String toString()
    {
	return ("- "+value);
    }
}
 
