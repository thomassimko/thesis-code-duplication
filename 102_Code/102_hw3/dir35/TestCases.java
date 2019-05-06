public class TestCases
{
   public static void main(String[] args)
   {
      StringList iter = new IterativeStringList();

      iter.addToEnd("Test1");
      iter.addToEnd("Test2");
      iter.add(1, "Test in between");

      Check.check(iter.size(), 3);

      iter.remove(0);

      Check.check(iter.size(), 2);

      Check.check(iter.get(0), "Test in between");
      Check.check(iter.get(1), "Test2");

      Check.check(iter.indexOf("Test in between"), 0);
      Check.check(iter.indexOf("Test2"), 1);

      StringList newLowerCaseList = iter.toLowerCase();

      Check.check(newLowerCaseList.get(0), "test in between");
      Check.check(newLowerCaseList.get(1), "test2");

      Check.check(newLowerCaseList.indexOf("test in between"), 0);
      Check.check(newLowerCaseList.indexOf("test2"), 1);

      StringList newUpperCaseList = iter.toUpperCase();

      Check.check(newUpperCaseList.get(0), "TEST IN BETWEEN");
      Check.check(newUpperCaseList.get(1), "TEST2");

      Check.check(newUpperCaseList.indexOf("TEST IN BETWEEN"), 0);
      Check.check(newUpperCaseList.indexOf("TEST2"), 1);

      StringList test = newLowerCaseList.startsWith("test");
      Check.check(test.size(), 2);

      StringList test2 = newLowerCaseList.startsWith("test2");
      Check.check(test2.size(), 1);

      StringList test3 = newLowerCaseList.hasSubstring("en");
      Check.check(test3.size(), 1);

      StringList test4 = newLowerCaseList.hasSubstring("e");
      Check.check(test4.size(), 2);

      iter.remove(1);

      Check.check(iter.size(), 1);
      Check.check(iter.get(0), "Test in between");
   }
}
