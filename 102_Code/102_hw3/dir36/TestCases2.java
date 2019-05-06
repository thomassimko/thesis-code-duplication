
public class TestCases2 {
	
	public static void main(String [] args)
	{
	RecursiveOOStringList a1 = new RecursiveOOStringList();

	
	//Check.check(a1.remove(0), null);
	
	Check.check(a1.size(), 0);
	a1.addToEnd("aaa");
	Check.check(a1.get(0), "aaa");
	Check.check(a1.size(), 1);
	a1.addToEnd("bbb");
	Check.check(a1.get(1), "bbb");
	Check.check(a1.size(), 2);
	a1.addToEnd("ccc");
	Check.check(a1.get(2), "ccc");
	Check.check(a1.size(), 3);
	a1.addToEnd("ddd");
	Check.check(a1.get(3), "ddd");
	Check.check(a1.size(), 4);
	a1.addToEnd("eee");
	Check.check(a1.get(4), "eee");
	Check.check(a1.size(), 5);
	
	Check.check(a1.get(0), "aaa");
	Check.check(a1.get(1), "bbb");
	Check.check(a1.get(2), "ccc");
	Check.check(a1.get(3), "ddd");
	Check.check(a1.get(4), "eee");
	
	a1.add(0, "123");
	Check.check(a1.size(), 6);
	Check.check(a1.get(0), "123");
	Check.check(a1.get(1), "aaa");
	Check.check(a1.get(2), "bbb");
	Check.check(a1.get(3), "ccc");
	Check.check(a1.get(4), "ddd");
	Check.check(a1.get(5), "eee");
	//Check.check(a1.get(6), "eee");
	
	a1.add(4, "ZZZ");
	Check.check(a1.size(), 7);
	Check.check(a1.get(0), "123");
	Check.check(a1.get(1), "aaa");
	Check.check(a1.get(2), "bbb");
	Check.check(a1.get(3), "ccc");
	Check.check(a1.get(4), "ZZZ");
	Check.check(a1.get(5), "ddd");
	Check.check(a1.get(6), "eee");
	
	Check.check(a1.indexOf("123"), 0);
	Check.check(a1.indexOf("aaa"), 1);
	Check.check(a1.indexOf("bbb"), 2);
	Check.check(a1.indexOf("ccc"), 3);
	Check.check(a1.indexOf("ZZZ"), 4);
	Check.check(a1.indexOf("ddd"), 5);
	Check.check(a1.indexOf("eee"), 6);
	
	
	Check.check(a1.remove(0), "123");
	Check.check(a1.size(), 6);
	Check.check(a1.get(0), "aaa");
	Check.check(a1.get(1), "bbb");
	Check.check(a1.get(2), "ccc");
	Check.check(a1.get(3), "ZZZ");
	Check.check(a1.get(4), "ddd");
	Check.check(a1.get(5), "eee");
	
	Check.check(a1.remove(5), "eee");
	Check.check(a1.size(), 5);
	Check.check(a1.get(0), "aaa");
	Check.check(a1.get(1), "bbb");
	Check.check(a1.get(2), "ccc");
	Check.check(a1.get(3), "ZZZ");
	Check.check(a1.get(4), "ddd");
	
	a1.add(5, "eee");
	Check.check(a1.size(), 6);
	Check.check(a1.get(0), "aaa");
	Check.check(a1.get(1), "bbb");
	Check.check(a1.get(2), "ccc");
	Check.check(a1.get(3), "ZZZ");
	Check.check(a1.get(4), "ddd");
	Check.check(a1.get(5), "eee");
	
	Check.check(a1.remove(2), "ccc");
	//Check.check(a1.remove(10), "ccc");
	Check.check(a1.size(), 5);
	Check.check(a1.get(0), "aaa");
	Check.check(a1.get(1), "bbb");
	Check.check(a1.get(2), "ZZZ");
	Check.check(a1.get(3), "ddd");
	Check.check(a1.get(4), "eee");
	
	Check.check(a1.indexOf("aaa"), 0);
	Check.check(a1.indexOf("bbb"), 1);
	Check.check(a1.indexOf("ZZZ"), 2);
	Check.check(a1.indexOf("ddd"), 3);
	Check.check(a1.indexOf("eee"), 4);
	Check.check(a1.indexOf("fdf"), 4);
	
	RecursiveOOStringList a2 = new RecursiveOOStringList();
	a2.addToEnd("She was there");
	a2.addToEnd("The boy was home");
	a2.addToEnd("The toy is broken");
	a2.addToEnd("The boy saw tommy");
	a2.addToEnd("I went to San Francisco");
	
	RecursiveOOStringList s2 = (RecursiveOOStringList) a2.toUpperCase();
	Check.check(s2.get(0), "SHE WAS THERE");
	Check.check(s2.get(1), "THE BOY WAS HOME");
	Check.check(s2.get(2), "THE TOY IS BROKEN");
	Check.check(s2.get(3), "THE BOY SAW TOMMY");
	Check.check(s2.get(4), "I WENT TO SAN FRANCISCO");

	StringList s = a2.toLowerCase();
	Check.check(s.get(0), "she was there");
	Check.check(s.get(1), "the boy was home");
	Check.check(s.get(2), "the toy is broken");
	Check.check(s.get(3), "the boy saw tommy");
	Check.check(s.get(4), "i went to san francisco");
	
	StringList s3 = a2.startsWith("The");
	Check.check(s3.get(0), "The boy was home");
	Check.check(s3.get(1), "The toy is broken");
	Check.check(s3.get(2), "The boy saw tommy");

	StringList s4 = a2.hasSubstring("was");
	Check.check(s4.get(0), "She was there");
	Check.check(s4.get(1), "The boy was home");
	
	StringList s5 = a2.hasSubstring("oy");
	Check.check(s5.get(0), "The boy was home");
	Check.check(s5.get(1), "The toy is broken");
	Check.check(s5.get(2), "The boy saw tommy");

	
	}
}
