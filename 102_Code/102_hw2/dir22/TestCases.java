/*Test cases for the implemented classes*/
public class TestCases
{
   public static void test_dblConstExp()
   {
      DoubleConstantExpression DCE = new DoubleConstantExpression(2.0);
      Check.check(DCE.evaluate(new VariableBindings()),2.0);
      
   }
   public static void test_negExp()
   {
      Expression e = new DoubleConstantExpression(2.0);
      NegationExpression NE = new NegationExpression(e);
      Check.check(NE.evaluate(new VariableBindings()),-2.0);
   }
   public static void test_AddExp()
   {
      Expression lft = new DoubleConstantExpression(5.0);
      Expression rht = new DoubleConstantExpression(7.0);
      AddExpression AE = new AddExpression(lft, rht);
      Check.check(AE.evaluate(new VariableBindings()),12.0); 
   }
   public static void test_SubExp()
   {
      Expression lft = new DoubleConstantExpression(8.0);
      Expression rht = new DoubleConstantExpression(3.0);
      SubtractExpression SE = new SubtractExpression(lft, rht);
      Check.check(SE.evaluate(new VariableBindings()),5.0);
   }
   public static void test_MultExp()
   {
      Expression rht = new DoubleConstantExpression(4.0);
      Expression lft = new DoubleConstantExpression(6.0);
      MultiplyExpression ME = new MultiplyExpression(lft, rht); 
      Check.check(ME.evaluate(new VariableBindings()),24.0);
   }
   public static void test_DivExp()
   {
      Expression lft = new DoubleConstantExpression(10.0);
      Expression rht = new DoubleConstantExpression(5.0);
      DivideExpression DE = new DivideExpression(lft, rht);
      Check.check(DE.evaluate(new VariableBindings()),2.0);
   }
   public static void test_Binding()
   {
      Binding bin = new Binding("pi", 3.14);
      Check.check(bin.getval(),3.14);
   }
   public static void test_Assignment()
   {
      Expression e = new DoubleConstantExpression(1.312);
      Assignment Ass = new Assignment("wut?",e);
      Check.check(Ass.evaluate(new VariableBindings()),1.312);
   }
   public static void test_IdExp()
   {
      VariableBindings VB = new VariableBindings();
      VB.addBinding("LULZ",3.4);
      IdentifierExpression IE = new IdentifierExpression("LULZ");
      Check.check(IE.evaluate(VB),3.4);
   }
   public static void main(String [] args)
   {
      test_dblConstExp();
      test_negExp();
      test_AddExp();
      test_SubExp();
      test_MultExp();
      test_DivExp();
      test_Assignment();
      test_IdExp();
      test_Binding();
   }
}
