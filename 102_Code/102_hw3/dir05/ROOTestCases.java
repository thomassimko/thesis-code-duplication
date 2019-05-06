public class ROOTestCases
{
   public static void main(String [] args)
   {
      StringList list = new RecursiveOOStringList();
      StringList upper = new RecursiveOOStringList();
      StringList lower = new RecursiveOOStringList();
      StringList pre = new RecursiveOOStringList();
      StringList sub = new RecursiveOOStringList();
      
      list.addToEnd("abc");
      Check.check(list.get(0), "abc");
      
      list.addToEnd("aba");
      Check.check(list.get(1), "aba");
      
      list.addToEnd("def");
      Check.check(list.get(2), "def");

      System.out.println("Test add");
      for(int i = 0; i < list.size(); i++)
      {
         System.out.println(list.get(i));
      }
      Check.check(list.size(), 3);
      
      Check.check(list.indexOf("abc"), 0);
      Check.check(list.indexOf("aba"), 1);
      Check.check(list.indexOf("def"), 2);
      
      list.add(1, "hij");
      
      for(int i = 0; i < list.size(); i++)
      {
         System.out.println(list.get(i));
      }
      
      list.remove(1);
      System.out.println("Test remove");

      for(int i = 0; i < list.size(); i++)
      {
         System.out.println(list.get(i));
      }
      Check.check(list.size(), 3);

      System.out.println("Test Upper");

      upper = list.toUpperCase();
      for(int i = 0; i < upper.size(); i++)
      {
         System.out.println(upper.get(i));
      }

      System.out.println("Test lower");

      lower = upper.toLowerCase();
      for(int i = 0; i < lower.size(); i++)
      {
         System.out.println(lower.get(i));
      }
      
      System.out.println("Test prefix");
      
      pre = list.startsWith("a");
      for(int i = 0; i < pre.size(); i++)
      {
         System.out.println(pre.get(i));
      }
      
      System.out.println("Test substring");

      sub = list.hasSubstring("ab");
      for(int i = 0; i < sub.size(); i++)
      {
         System.out.println(sub.get(i));
      }
   }
}
   