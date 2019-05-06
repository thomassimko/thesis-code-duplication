public class TestCases
{
   public static void iterativeTests()
   {
      System.out.println("Iterative Tests");
      System.out.println();
      System.out.println("General Tests");
      System.out.println();
      StringList generalTest = new IterativeStringList();
      generalTest.add(0, "test0");
      generalTest.addToEnd("test1");
      generalTest.addToEnd("test3");
      generalTest.add(2, "test2");
      Check.check(generalTest.size(), 4);
      Check.check(generalTest.get(0), "test0");
      Check.check(generalTest.indexOf("test3"), 3);
      for(int i = 0; i < generalTest.size(); i++)
      {
         System.out.println(generalTest.get(i));
      }
      System.out.println();
      
      generalTest.remove(0);
      for(int i = 0; i < generalTest.size(); i++)
      {
         System.out.println(generalTest.get(i));
      }
      Check.check(generalTest.indexOf("test1"), 0);
      System.out.println();
      
      generalTest.remove(2);
      for(int i = 0; i < generalTest.size(); i++)
      {
         System.out.println(generalTest.get(i));
      }
      System.out.println();
      
      System.out.println("Upper to Lower Test");
      StringList testToLower = new IterativeStringList();
      testToLower.addToEnd("TEST0");
      testToLower.addToEnd("TEST1");
      testToLower.addToEnd("TEST2");
      testToLower.addToEnd("TEST3");
      int size = testToLower.size();
      for(int i = 0; i < size; i++)
      {
         System.out.println(testToLower.get(i));
      }
      System.out.println();
      for(int i = 0; i < size; i++)
      {
         StringList lower = new IterativeStringList();
         lower = testToLower.toLowerCase();
         System.out.println(lower.get(i));
      }
      System.out.println();
      
      System.out.println("Lower to Upper Test");
      StringList testToUpper = new IterativeStringList();
      testToUpper.addToEnd("test0");
      testToUpper.addToEnd("test1");
      testToUpper.addToEnd("test2");
      testToUpper.addToEnd("test3");
      for(int i = 0; i < size; i++)
      {
         System.out.println(testToUpper.get(i));
      }
      System.out.println();
      for(int i = 0; i < size; i++)
      {
         StringList upper = new IterativeStringList();
         upper = testToUpper.toUpperCase();
         System.out.println(upper.get(i));
      }
      System.out.println();
      
      System.out.println("Starts With 'Yes' Test");
      StringList testStartsWith = new IterativeStringList();
      testStartsWith.addToEnd("yes");
      testStartsWith.addToEnd("no");
      testStartsWith.addToEnd("yessir");
      testStartsWith.addToEnd("nosir");
      testStartsWith = testStartsWith.startsWith("yes");
      for(int i = 0; i < testStartsWith.size(); i++)
      {
         System.out.println(testStartsWith.get(i));
      }
      System.out.println();
      
      System.out.println("Substring 'Sir' Test");
      StringList testSubstring = new IterativeStringList();
      testSubstring.addToEnd("yes");
      testSubstring.addToEnd("no");
      testSubstring.addToEnd("yessir");
      testSubstring.addToEnd("nosir");
      testSubstring = testSubstring.hasSubstring("sir");
      for(int i = 0; i < testSubstring.size(); i++)
      {
         System.out.println(testSubstring.get(i));
      }
      System.out.println();
      System.out.println();
   }
   public static void recursiveOOTests()
   {
      System.out.println("RecursiveOO Tests");
      System.out.println();
      System.out.println("General Tests");
      System.out.println();
      StringList generalTest = new RecursiveOOStringList();
      generalTest.add(0, "test0");
      generalTest.addToEnd("test1");
      generalTest.addToEnd("test3");
      generalTest.add(2, "test2");
      Check.check(generalTest.size(), 4);
      Check.check(generalTest.get(0), "test0");
      Check.check(generalTest.indexOf("test3"), 3);
      for(int i = 0; i < generalTest.size(); i++)
      {
         System.out.println(generalTest.get(i));
      }
      System.out.println();
      
      generalTest.remove(0);
      for(int i = 0; i < generalTest.size(); i++)
      {
         System.out.println(generalTest.get(i));
      }
      Check.check(generalTest.indexOf("test1"), 0);
      System.out.println();
      
      generalTest.remove(2);
      for(int i = 0; i < generalTest.size(); i++)
      {
         System.out.println(generalTest.get(i));
      }
      System.out.println();
      
      System.out.println("Upper to Lower Test");
      StringList testToLower = new RecursiveOOStringList();
      testToLower.addToEnd("TEST0");
      testToLower.addToEnd("TEST1");
      testToLower.addToEnd("TEST2");
      testToLower.addToEnd("TEST3");
      int size = testToLower.size();
      for(int i = 0; i < size; i++)
      {
         System.out.println(testToLower.get(i));
      }
      System.out.println();
      for(int i = 0; i < size; i++)
      {
         StringList lower = new RecursiveOOStringList();
         lower = testToLower.toLowerCase();
         System.out.println(lower.get(i));
      }
      System.out.println();
      
      System.out.println("Lower to Upper Test");
      StringList testToUpper = new RecursiveOOStringList();
      testToUpper.addToEnd("test0");
      testToUpper.addToEnd("test1");
      testToUpper.addToEnd("test2");
      testToUpper.addToEnd("test3");
      for(int i = 0; i < size; i++)
      {
         System.out.println(testToUpper.get(i));
      }
      System.out.println();
      for(int i = 0; i < size; i++)
      {
         StringList upper = new RecursiveOOStringList();
         upper = testToUpper.toUpperCase();
         System.out.println(upper.get(i));
      }
      System.out.println();
      
      System.out.println("Starts With 'Yes' Test");
      StringList testStartsWith = new RecursiveOOStringList();
      testStartsWith.addToEnd("yes");
      testStartsWith.addToEnd("no");
      testStartsWith.addToEnd("yessir");
      testStartsWith.addToEnd("nosir");
      testStartsWith = testStartsWith.startsWith("yes");
      for(int i = 0; i < testStartsWith.size(); i++)
      {
         System.out.println(testStartsWith.get(i));
      }
      System.out.println();
      
      System.out.println("Substring 'Sir' Test");
      StringList testSubstring = new RecursiveOOStringList();
      testSubstring.addToEnd("yes");
      testSubstring.addToEnd("no");
      testSubstring.addToEnd("yessir");
      testSubstring.addToEnd("nosir");
      testSubstring = testSubstring.hasSubstring("sir");
      for(int i = 0; i < testSubstring.size(); i++)
      {
         System.out.println(testSubstring.get(i));
      }
      System.out.println();
      System.out.println();
   }
   public static void recursiveIOTests()
   {
      System.out.println("RecursiveIO Tests");
      System.out.println();
      System.out.println("General Tests");
      System.out.println();
      StringList generalTest = new RecursiveIOStringList();
      generalTest.add(0, "test0");
      generalTest.addToEnd("test1");
      generalTest.addToEnd("test3");
      generalTest.add(2, "test2");
      Check.check(generalTest.size(), 4);
      Check.check(generalTest.get(0), "test0");
      Check.check(generalTest.indexOf("test3"), 3);
      for(int i = 0; i < generalTest.size(); i++)
      {
         System.out.println(generalTest.get(i));
      }
      System.out.println();
      
      generalTest.remove(0);
      for(int i = 0; i < generalTest.size(); i++)
      {
         System.out.println(generalTest.get(i));
      }
      Check.check(generalTest.indexOf("test1"), 0);
      System.out.println();
      
      generalTest.remove(2);
      for(int i = 0; i < generalTest.size(); i++)
      {
         System.out.println(generalTest.get(i));
      }
      System.out.println();
      
      System.out.println("Upper to Lower Test");
      StringList testToLower = new RecursiveIOStringList();
      testToLower.addToEnd("TEST0");
      testToLower.addToEnd("TEST1");
      testToLower.addToEnd("TEST2");
      testToLower.addToEnd("TEST3");
      int size = testToLower.size();
      for(int i = 0; i < size; i++)
      {
         System.out.println(testToLower.get(i));
      }
      System.out.println();
      for(int i = 0; i < size; i++)
      {
         StringList lower = new RecursiveIOStringList();
         lower = testToLower.toLowerCase();
         System.out.println(lower.get(i));
      }
      System.out.println();
      
      System.out.println("Lower to Upper Test");
      StringList testToUpper = new RecursiveIOStringList();
      testToUpper.addToEnd("test0");
      testToUpper.addToEnd("test1");
      testToUpper.addToEnd("test2");
      testToUpper.addToEnd("test3");
      for(int i = 0; i < size; i++)
      {
         System.out.println(testToUpper.get(i));
      }
      System.out.println();
      for(int i = 0; i < size; i++)
      {
         StringList upper = new RecursiveIOStringList();
         upper = testToUpper.toUpperCase();
         System.out.println(upper.get(i));
      }
      System.out.println();
      
      System.out.println("Starts With 'Yes' Test");
      StringList testStartsWith = new RecursiveIOStringList();
      testStartsWith.addToEnd("yes");
      testStartsWith.addToEnd("no");
      testStartsWith.addToEnd("yessir");
      testStartsWith.addToEnd("nosir");
      testStartsWith = testStartsWith.startsWith("yes");
      for(int i = 0; i < testStartsWith.size(); i++)
      {
         System.out.println(testStartsWith.get(i));
      }
      System.out.println();
      
      System.out.println("Substring 'Sir' Test");
      StringList testSubstring = new RecursiveIOStringList();
      testSubstring.addToEnd("yes");
      testSubstring.addToEnd("no");
      testSubstring.addToEnd("yessir");
      testSubstring.addToEnd("nosir");
      testSubstring = testSubstring.hasSubstring("sir");
      for(int i = 0; i < testSubstring.size(); i++)
      {
         System.out.println(testSubstring.get(i));
      }
      System.out.println();
      System.out.println();
   }
   public static void main(String [] args)
   {
      iterativeTests();
      recursiveOOTests();
      recursiveIOTests();
   }
}