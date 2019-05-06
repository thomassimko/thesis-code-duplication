public class TestCasesPart3
{
   public static void main(String[] args)
   {
      RecursiveIOStringList list = new RecursiveIOStringList();

      list.addToEnd("Number one");
      list.addToEnd("Number two");

      Check.check(list.size(), 2);

      list.add(1, "in between");

      Check.check(list.size(), 3);
      Check.check(list.get(0), "Number one");
      Check.check(list.get(1), "in between");
      Check.check(list.get(2), "Number two");
      Check.check(list.indexOf("Number one"), 0);
      Check.check(list.indexOf("in between"), 1);
      Check.check(list.indexOf("Number two"), 2);

      list.remove(1);

      Check.check(list.size(), 2);
      Check.check(list.get(0), "Number one");
      Check.check(list.get(1), "Number two");
      Check.check(list.indexOf("Number one"), 0);
      Check.check(list.indexOf("Number two"), 1);

      StringList uppercaseList = list.toUpperCase();
      StringList lowercaseList = list.toLowerCase();

      Check.check(uppercaseList.size(), 2);
      Check.check(lowercaseList.size(), 2);

      Check.check(uppercaseList.get(0), "NUMBER ONE");
      Check.check(lowercaseList.get(0), "number one");
      Check.check(uppercaseList.get(1), "NUMBER TWO");
      Check.check(lowercaseList.get(1), "number two");

      StringList test = lowercaseList.startsWith("number");
      Check.check(test.get(0), "number one");
      Check.check(test.get(1), "number two");
      Check.check(test.size(), 2);

      StringList test2 = lowercaseList.startsWith("number o");
      Check.check(test.get(0), "number one");
      Check.check(test2.size(), 1);

      StringList test3 = lowercaseList.hasSubstring("er");
      Check.check(test.get(0), "number one");
      Check.check(test.get(1), "number two");
      Check.check(test3.size(), 2);

      StringList test4 = lowercaseList.hasSubstring("wo");
      Check.check(test.get(1), "number two");
      Check.check(test4.size(), 1);
      Check.check(test.size(), 2);

      list.remove(0);

      Check.check(list.size(), 1);
      Check.check(list.get(0), "Number two");
   }
}
