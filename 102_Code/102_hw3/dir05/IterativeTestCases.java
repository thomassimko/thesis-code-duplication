public class IterativeTestCases
{
   private static StringList sl = new IterativeStringList();
   private static StringList s = new IterativeStringList();
   private static StringList l = new IterativeStringList();
   private static StringList pre = new IterativeStringList();
   private static StringList sub = new IterativeStringList();
   private static IterativeNode n = new IterativeNode("abc", null);
   private static IterativeNode n1 = new IterativeNode("def", n);
   private static IterativeNode n2 = new IterativeNode("hij", n1);

   public static void testAdd()
   {   
      sl.addToEnd(n.getElement());
      sl.addToEnd(n1.getElement());
      Check.check(sl.get(0), "abc");
      Check.check(sl.get(1), "def");
   }
   public static void testGet()
   {
      sl.add(1, n2.getElement());
      Check.check(sl.get(1), "hij");
      Check.check(sl.size(), 3);
      
      System.out.println("Test Get");
      for(int i = 0; i < sl.size(); i++)
      {
         System.out.println(sl.get(i));
      }
   }
   public static void testToUpperCase()
   {
      s = sl.toUpperCase();
      System.out.println("Test UpperCase");
      for(int i = 0; i < s.size(); i++)
      {
         System.out.println(s.get(i));
      }
   }
   public static void testToLowerCase()
   {
      l = sl.toLowerCase();
      System.out.println("Test LowerCase");
      for(int i = 0; i < l.size(); i++)
      {
         System.out.println(l.get(i));
      }
   }
   public static void testRemove()
   {
      sl.remove(1);
      System.out.println("Test Remove");
      for(int i = 0; i < sl.size(); i++)
      {
         System.out.println(sl.get(i));
      }
   }
   public static void testIndexOf()
   {
      Check.check(sl.indexOf("abc"), 0);
      Check.check(sl.indexOf("def"), 1);
   }
   public static void testSize()
   {
      Check.check(sl.size(), 2);
   }
   public static void testStartsWith()
   {
      pre = sl.startsWith("a");
      System.out.println("Test StartsWith");
      for(int i = 0; i < pre.size(); i++)
      {
         System.out.println(pre.get(i));
      }
   }
   public static void testSubstring()
   {
      sl.addToEnd("aba");
      sub = sl.hasSubstring("ab");
      System.out.println("Test Substring");
      for(int i = 0; i < sub.size(); i++)
      {
         System.out.println(sub.get(i));
      }
   }
   public static void main(String [] args)
   {
      testAdd();
      testGet();
      testToUpperCase();
      testToLowerCase();
      testRemove();
      testIndexOf();
      testSize();
      testStartsWith();
      testSubstring();
   }
}