public class RIOTestCases
{
   public static void main(String [] args)
   {
      StringList list = new RecursiveIOStringList();
      StringList lower = new RecursiveIOStringList();
      StringList pre = new RecursiveIOStringList();
      StringList upper = new RecursiveIOStringList();
      
      list.addToEnd("ABC");
      Check.check(list.get(0), "ABC");
      
      list.addToEnd("ABA");
      Check.check(list.get(1), "ABA");
      
      list.addToEnd("DEF");
      Check.check(list.get(2), "DEF");
      
      Check.check(list.size(), 3);
      
      Check.check(list.indexOf("ABC"), 0);
      Check.check(list.indexOf("ABA"), 1);
      Check.check(list.indexOf("DEF"), 2);
      
      System.out.println("Test add");
      list.add(1, "lol");
      for(int i = 0; i < list.size(); i++)
      {
         System.out.println(list.get(i));
      }
      
      System.out.println("Test lower");
      lower = list.toLowerCase();
      for(int i = 0; i < lower.size(); i++)
      {
         System.out.println(lower.get(i));
      }
      
      System.out.println("Test upper");
      upper = lower.toUpperCase();
      for(int i = 0; i < upper.size(); i++)
      {
         System.out.println(upper.get(i));
      }
      
      System.out.println("Test pre");
      pre = list.startsWith("AB");
      for(int i = 0; i < pre.size(); i++)
      {
         System.out.println(pre.get(i));
      }
      
      System.out.println("Test remove");
      list.remove(0);
      for(int i = 0; i < list.size(); i++)
      {
         System.out.println(list.get(i));
      }
   }
}