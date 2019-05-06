public class TestCases
{
	public static void main (String[]args)
	{
		StringList list = new IterativeStringList();
		list.addToEnd("hello");
		list.addToEnd("yo");
		list.addToEnd("hi");
		list.add(3, "fourth");
		list.add(3, "newfourth");
		Check.check(list.get(0), "hello");
		Check.check(list.get(1), "yo");
		Check.check(list.get(2), "hi");
		Check.check(list.get(3), "newfourth");
		Check.check(list.get(4), "fourth");
		Check.check(list.remove(0), "hello");
		Check.check(list.remove(0), "yo");
		Check.check(list.remove(0), "hi");
		StringList upper = list.toUpperCase();
		Check.check(upper.get(0), "NEWFOURTH");
		Check.check(upper.get(1), "FOURTH");
		StringList contains = list.hasSubstring("four");
		Check.check(contains.get(0), "newfourth");
		Check.check(contains.get(1), "fourth");
		
		StringList OO = new RecursiveOOStringList();
		OO.addToEnd("hello2");
		Check.check(OO.get(0), "hello2");
		Check.check(OO.remove(0), "hello2");
		OO.addToEnd("hello2");
		OO.addToEnd("hello3");
		OO.addToEnd("hello4");
		OO.add(1, "between");
		Check.check(OO.get(0), "hello2");
		Check.check(OO.get(1), "between");
		Check.check(OO.get(2), "hello3");
		Check.check(OO.remove(1), "between");
		Check.check(OO.get(1), "hello3");
		Check.check(OO.remove(0), "hello2");
		Check.check(OO.get(0), "hello3");
		Check.check(OO.indexOf("hello4"), 1);
		Check.check(OO.remove(1), "hello4");
		Check.check(OO.remove(0), "hello3");
		OO.addToEnd("fourth");
		OO.addToEnd("newfourth");
		OO.addToEnd("hello");
		StringList contains2 = OO.hasSubstring("four");
		Check.check(contains2.get(0), "fourth");
		Check.check(contains2.get(1), "newfourth");
		Check.check(contains2.size(), 2);	
		
		StringList IO = new RecursiveIOStringList();
		IO.addToEnd("hello");
		Check.check(IO.get(0), "hello");
		Check.check(IO.remove(0), "hello");
		IO.addToEnd("zerO");
		IO.addToEnd("onE");
		IO.addToEnd("TWO");
		IO.add(2, "NEW1");
		Check.check(IO.get(0), "zerO");
		Check.check(IO.get(1), "onE");
		Check.check(IO.get(2), "NEW1");
		Check.check(IO.get(3), "TWO");
		Check.check(IO.indexOf("TWO"), 3);
		Check.check(IO.size(), 4);
		Check.check(IO.remove(3), "TWO");
		StringList lower2 = IO.toLowerCase();
		Check.check(lower2.get(0), "zero");
		Check.check(lower2.get(1), "one");
		Check.check(lower2.get(2), "new1");
		StringList IA = new RecursiveIOStringList();
		IA.addToEnd("fourth");
		IA.addToEnd("newfourth");
		IA.addToEnd("hello");
		StringList contains3 = IA.hasSubstring("four");
		Check.check(contains3.get(0), "fourth");
		Check.check(contains3.get(1), "newfourth");
		Check.check(contains3.size(), 2);
	}
}