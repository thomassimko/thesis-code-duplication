
public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IterativeStringList test = new IterativeStringList();
		
		test.addToEnd("hello");
		Check.check(test.size(), 1);
		test.addToEnd("yo");
		Check.check(test.size(), 2);
		test.addToEnd("asdf");
		Check.check(test.size(), 3);
		Check.check(test.get(0), "hello");
		Check.check(test.get(1), "yo");
		Check.check(test.get(2), "asdf");

		test.remove(0);
		Check.check(test.size(),2);
		Check.check(test.get(0), "hello");
		
		test.add(0,"hello");
		Check.check(test.get(0), "hello");
		Check.check(test.size(), 3);
		
		Check.check(test.toUpperCase().get(0), "HELLO");
		Check.check(test.hasSubstring("he").size(), 2);
		

		StringList test2 = new RecursiveIOStringList();
		test2.add(0, "hello");
		Check.check(test2.size(), 1);
		test2.addToEnd("YO");
		Check.check(test2.size(), 2);
		test2.addToEnd("asdf");
		Check.check(test2.size(), 3);
		test2.add(2, "fdsa");
		Check.check(test2.size(), 4);
		Check.check(test2.get(0), "hello");
		Check.check(test2.get(1), "YO");
		Check.check(test2.indexOf("hello"), 0);
		Check.check(test2.indexOf("YO"), 1);
		Check.check(test2.indexOf("asdf"), 3);
		test2.remove(0);
		Check.check(test2.get(0), "YO");
		
		StringList temp = test2.toLowerCase();
		System.out.println(temp.get(0));
		temp = test2.toUpperCase();
		System.out.println(temp.get(1));
		temp = test2.hasSubstring("as");
		System.out.println(temp.get(0));
		
	
		StringList test1 = new Recursive00StringList();
		test1.addToEnd("asdf");
		test1.add(0, "HELLO");
		test1.add(1, "yo");		
		Check.check(test1.size(), 3);
		Check.check(test1.get(1), "yo");
		test1.addToEnd("gjslgjfj");
		Check.check(test1.indexOf("HELLO"), 0);
		Check.check(test1.indexOf("yo"), 1);
		Check.check(test1.indexOf("asdf"), 2);
		Check.check(test1.get(2), "asdf");
		Check.check(test1.get(0), "HELLO");
		
		
		StringList temp1 = new Recursive00StringList();
		temp1 = test1.toLowerCase();
		System.out.println(temp1.get(0));
		StringList temp2 = test1.hasSubstring("HELLO");
		
		temp2 = test1.hasSubstring("asd");
		Check.check(temp2.size(), 1);
		
		



		
	}

}
