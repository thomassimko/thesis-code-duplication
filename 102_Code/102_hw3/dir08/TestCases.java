public class TestCases
{
   public static void testList(StringList test)
   {
      test.addToEnd("Abc");
      test.addToEnd("deF");
      test.addToEnd("cba");
      test.addToEnd("fed");
      Check.check(test.size(), 4);
      Check.check(test.get(0), "Abc");
      Check.check(test.get(1), "deF");
      Check.check(test.get(2), "cba");
      Check.check(test.get(3), "fed");
      Check.check(test.indexOf("Abc"), 0);
      Check.check(test.indexOf("deF"), 1);
      Check.check(test.indexOf("cba"), 2);
      Check.check(test.indexOf("fed"), 3);  

      Check.check(test.remove(2), "cba");
      Check.check(test.size(), 3);
      Check.check(test.get(2), "fed");
      Check.check(test.get(0), "Abc");

      test.add(1, "ABC");
      Check.check(test.size(), 4);
      Check.check(test.get(0), "Abc");
      Check.check(test.get(1), "ABC");
      Check.check(test.get(2), "deF");
      Check.check(test.get(3), "fed");
      test.add(0, "front");
      Check.check(test.size(), 5);
      Check.check(test.indexOf("front"), 0);
      Check.check(test.indexOf("fed"), 4);
      Check.check(test.get(3), "deF");
      test.add(5, "end");
      Check.check(test.size(), 6);
      Check.check(test.get(5), "end");
      Check.check(test.indexOf("ABC"), 2);
      Check.check(test.get(1), "Abc");

      Check.check(test.remove(0), "front");
      Check.check(test.size(), 5);
      Check.check(test.get(0), "Abc");
      Check.check(test.get(1), "ABC");
      Check.check(test.get(4), "end");
      Check.check(test.remove(4), "end");
      Check.check(test.size(), 4);
      Check.check(test.get(0), "Abc");
      Check.check(test.get(2), "deF");
      Check.check(test.indexOf("fed"), 3);

      StringList lowerTest = test.toLowerCase();
      Check.check(lowerTest.size(), 4);
      Check.check(lowerTest.get(0), "abc");
      Check.check(lowerTest.get(1), "abc");
      Check.check(lowerTest.get(2), "def");
      Check.check(lowerTest.get(3), "fed");

      StringList upperTest = test.toUpperCase();
      Check.check(upperTest.size(), 4);
      Check.check(upperTest.get(0), "ABC");
      Check.check(upperTest.get(1), "ABC");
      Check.check(upperTest.get(2), "DEF");
      Check.check(upperTest.get(3), "FED");

      lowerTest.addToEnd("abcdef");
      StringList prefixTest = lowerTest.startsWith("ab");
      Check.check(prefixTest.size(), 3);
      Check.check(prefixTest.get(0), "abc");
      Check.check(prefixTest.get(1), "abc");
      Check.check(prefixTest.get(2), "abcdef");

      StringList substringTest = lowerTest.hasSubstring("de");
      Check.check(substringTest.size(), 2);
      Check.check(substringTest.get(0), "def");
      Check.check(substringTest.get(1), "abcdef");      
   }

   public static void main(String[] args)
   {
      StringList a = new IterativeStringList();
      testList(a);
      StringList b = new RecursiveOOStringList();
      testList(b);
      StringList c = new RecursiveIOStringList();
      testList(c);
   }
}
