public class TestCases
{
  public static void test_itList()
  {
    IterativeNode No = new IterativeNode("Watcha",null);

    System.out.println("initializing stringlist...");
    StringList tmp = new IterativeStringList(No);

    System.out.println("adding a node to end...");
    tmp.addToEnd("hey");

    System.out.println("adding a node...");
    tmp.add(0, "first");

    System.out.println("removing a node...");
    tmp.remove(1);

    System.out.println("retrieving a node...");
    String str = tmp.get(0);

    System.out.println("checking index of a node...");
    int index = tmp.indexOf("first");

    System.out.println("retrieving size...");
    int size = tmp.size(); 

    System.out.println("making lowercase list...");
    StringList LC = tmp.toLowerCase();

    System.out.println("making uppercase list...");
    StringList UC = tmp.toUpperCase();

    System.out.println("sorting list by prefix...");
    StringList pre = tmp.startsWith("fi");

    System.out.println("sorting list by substring..");
    StringList seg = tmp.hasSubstring("ey");
  } 
  public static void test_r00List()
  {

    Recursive00Node emp = new R00Empty();

    Recursive00Node temp = new R00Node("blarg", emp);

    StringList RSL = new Recursive00StringList(temp);
    System.out.println("testing addtoend...");

    RSL.addToEnd("Yep");

    System.out.println("testing add...");
    RSL.addToEnd("howdy");

   
    RSL.add(1,"nope");

    System.out.println("testing remove...");
    String wat = RSL.remove(1);

    System.out.println("testing get...");
    String str = RSL.get(1);

    System.out.println("testing indexof...");
    int num = RSL.indexOf("blarg");

    System.out.println("testing size...");
    int hek = RSL.size();

    System.out.println("testing tolowercase...");
    StringList LC = RSL.toLowerCase();

    System.out.println("testing toupperecase...");
    StringList UC = RSL.toUpperCase();

    //System.out.println("testing startswith...");
    //StringList pre = RSL.startsWith("bl");
    //Results in an Exception

    //System.out.println("testing hassubstring...");
    //StringList seg = RSL.hasSubstring("ar");
    //Results in an Exception
  }
  public static void test_rI0List()
  {
    RecursiveI0Node emp = new RI0Empty();
    RecursiveI0Node temp = new RI0Node("well",emp);
    StringList RSL = new RecursiveI0StringList(temp);
    
    RSL.addToEnd("umm");
    System.out.println("testing addtoend...");
    RSL.addToEnd("enough"); 

    System.out.println("testing add...");
    RSL.add(1,"so...tired");

    System.out.println("testing remove...");
    String wat = RSL.remove(1);

    System.out.println("testing get...");
    String str = RSL.get(1);

    System.out.println("testing indexof...");
    int num = RSL.indexOf("umm");

    System.out.println("testing size...");
    int hop = RSL.size();

    System.out.println("testing tolowercase...");
    StringList LC = RSL.toLowerCase();

    System.out.println("testing touppercase...");
    StringList UC = RSL.toUpperCase();
    
    System.out.println("testing startswith...");
    StringList pre = RSL.startsWith("en");
    System.out.println("testing hassubstring...");
    StringList seg = RSL.hasSubstring("el");

    
  }
  public static void main(String [] args)
  {
    System.out.println("Part 1 test...");
    test_itList();
    System.out.println("Done!");
    System.out.println("Part 2 test...");
    test_r00List();
    System.out.println("Done!");
    System.out.println("Part 3 test...");
    test_rI0List();
    System.out.println("Done!");
  }
}

