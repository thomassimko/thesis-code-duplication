public class Binding
{
   private String bindVar;
   private double bindNum;
   public Binding(String bindVar, double bindNum)
   {
      this.bindVar = bindVar;
      this.bindNum = bindNum;
   }
   public double returnDbl()
   {
      return(this.bindNum);
   }
   public String returnBind()
   {
      return(this.bindVar);
   }
}
