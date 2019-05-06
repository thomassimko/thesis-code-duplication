public class IdentifierExpression
implements Expression
{
   private String val;

   public IdentifierExpression(String value)
   {
       this.val=value;
   }

    public double evaluate(Bindings binding)
    {
	return binding.lookupBinding(this.val);
    }

    public String toString()
    {
	return this.val;
    }
}
