
public class IOTestCases
{
	public static void main(String [] args)
	{
		StringList n1 = new RecursiveIOStringList();
		
		n1.addToEnd("a");
		n1.addToEnd("b");
		n1.addToEnd("c");
		n1.addToEnd("d");
		n1.addToEnd("e");
		n1.addToEnd("f");
		n1.addToEnd("g");
		
		Check.check(n1.size(), 7);
		
		int size = n1.size();
		
		for(int i = 0; i < size; i++)
		{
			System.out.println(n1.get(i));
		}
		
		System.out.println("1---------------------------------------");
		
		n1.add(2, "+add+");
		
		for(int i = 0; i < n1.size(); i++)
		{
			System.out.println(n1.get(i));
		}
		
		Check.check(n1.size(), 8);
		
		Check.check(n1.indexOf("+add+"), 2);
		
		n1.remove(2);
		
		System.out.println("2---------------------------------------");
		
		for(int i = 0; i < n1.size(); i++)
		{
			System.out.println(n1.get(i));
		}
		
		Check.check(n1.size(), 7);

		System.out.println("3---------------------------------------");
		
		StringList n2 = n1.toUpperCase();
		
		System.out.println("4---------------------------------------");
		
		for(int i = 0; i < n2.size(); i++)
		{
			System.out.println(n2.get(i));
		}
		
		n2 = n1.toLowerCase();
		
		System.out.println("5---------------------------------------");
		
		for(int i = 0; i < n2.size(); i++)
		{
			System.out.println(n2.get(i));
		}
		
		n1.addToEnd("aa");
		n1.addToEnd("ab");
		n1.addToEnd("ac");
		
		System.out.println("6---------------------------------------");
		StringList n3 = n1.startsWith("a");
		
		for(int i = 0; i < n3.size(); i++)
		{
			System.out.println(n3.get(i));
		}
		
		System.out.println("7---------------------------------------");
		StringList n4 = n1.hasSubstring("b");
		
		for(int i = 0; i < n4.size(); i++)
		{
			System.out.println(n4.get(i));
		}
		
	}
}
