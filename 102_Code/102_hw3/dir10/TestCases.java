
public class TestCases {

	public static void testIterativeStringList() {
		IterativeStringList testList = new IterativeStringList();
		Check.check(testList.size(), 0);
		testList.addToEnd("Hello");
		Check.check(testList.get(0), "Hello");
		testList.add(0, "Blah");
		Check.check(testList.get(0), "Blah");
		Check.check(testList.get(1), "Hello");
		testList.addToEnd("My eyes burn!");
		Check.check(testList.get(2), "My eyes burn!");
		Check.check(testList.size(), 3);
		Check.check(testList.remove(1), "Hello");
		Check.check(testList.get(0), "Blah");
		Check.check(testList.get(1), "My eyes burn!");
		Check.check(testList.remove(1), "My eyes burn!");
		Check.check(testList.get(0), "Blah");
		testList.addToEnd(" So many test cases");
		testList.addToEnd("Hobo sock");
		Check.check(testList.indexOf("Hobo sock"), 2);
		Check.check(testList.size(), 3);
		IterativeStringList t = testList.toLowerCase();
		Check.check(t.get(0).toString(), "blah");
		Check.check(t.get(1).toString(), " so many test cases");
		Check.check(t.get(2).toString(), "hobo sock");
		IterativeStringList t1 = testList.toUpperCase();
		Check.check(t1.get(0).toString(), "BLAH");
		Check.check(t1.get(1).toString(), " SO MANY TEST CASES");
		Check.check(t1.get(2).toString(), "HOBO SOCK");
		IterativeStringList t2 = testList.startsWith("Bl");
		Check.check(t2.get(0), "Blah");
		IterativeStringList t3 = testList.hasSubstring("a");
		Check.check(t3.get(0), "Blah");
		Check.check(t3.get(1), " So many test cases");
	}
	public static void testRecursiveOOStringList() {
		RecursiveOOStringList testList = new RecursiveOOStringList();
		Check.check(testList.size(), 0);
		testList.addToEnd("Hello");
		Check.check(testList.get(0), "Hello");
		testList.add(0, "Blah");
		Check.check(testList.get(0), "Blah");
		Check.check(testList.get(1), "Hello");
		testList.addToEnd("My eyes burn!");
		Check.check(testList.get(2), "My eyes burn!");
		Check.check(testList.size(), 3);
		Check.check(testList.remove(1), "Hello");
		Check.check(testList.get(0), "Blah");
		Check.check(testList.get(1), "My eyes burn!");
		Check.check(testList.remove(1), "My eyes burn!");
		Check.check(testList.get(0), "Blah");
		testList.addToEnd(" So many test cases");
		testList.addToEnd("Hobo sock");
		Check.check(testList.indexOf("Hobo sock"), 2);
		Check.check(testList.size(), 3);
		RecursiveOOStringList t = testList.toLowerCase();
		Check.check(t.get(0).toString(), "blah");
		Check.check(t.get(1).toString(), " so many test cases");
		Check.check(t.get(2).toString(), "hobo sock");
		RecursiveOOStringList t1 = testList.toUpperCase();
		Check.check(t1.get(0).toString(), "BLAH");
		Check.check(t1.get(1).toString(), " SO MANY TEST CASES");
		Check.check(t1.get(2).toString(), "HOBO SOCK");
		RecursiveOOStringList t2 = testList.startsWith("Bl");
		Check.check(t2.get(0), "Blah");
		RecursiveOOStringList t3 = testList.hasSubstring("a");
		Check.check(t3.get(0), "Blah");
		Check.check(t3.get(1), " So many test cases");
	}
	public static void testRecursiveIOStringList() {
		StringList testList = new RecursiveIOStringList();
		Check.check(testList.size(), 0);
		testList.addToEnd("Hello");
		Check.check(testList.get(0), "Hello");
		testList.addToEnd("Dinosaur");
		Check.check(testList.get(0), "Hello");
		Check.check(testList.get(1), "Dinosaur");
		testList.add(2, "Blue");
		Check.check(testList.get(2), "Blue");
		testList.add(0, "Twinkle");
		Check.check(testList.get(0), "Twinkle");
		testList.add(4, "Zebra");
		Check.check(testList.get(4), "Zebra");
		Check.check(testList.size(), 5);
		testList.get(0);
		Check.check(testList.get(0), "Twinkle");
		StringList t1 = new RecursiveIOStringList();
		t1 = testList.toLowerCase();
		Check.check(t1.get(0), "twinkle");
		Check.check(t1.get(1), "hello");
		Check.check(t1.get(2), "dinosaur");
		Check.check(t1.get(3), "blue");
		Check.check(t1.get(4), "zebra");
		Check.check(t1.size(), 5);
		StringList t2 = new RecursiveIOStringList();
		t2 = testList.toUpperCase();
		Check.check(t2.get(0), "TWINKLE");
		Check.check(t2.get(1), "HELLO");
		Check.check(t2.get(2), "DINOSAUR");
		Check.check(t2.get(3), "BLUE");
		Check.check(t2.get(4), "ZEBRA");
		Check.check(t2.size(), 5);
		StringList t3 = new RecursiveIOStringList();
		t3 = testList.startsWith("Z");
		Check.check(t3.get(0), "Zebra");
		Check.check(t3.size(), 1);
		StringList t4 = new RecursiveIOStringList();
		t4 = testList.hasSubstring("n");
		Check.check(t4.get(0), "Twinkle");
		Check.check(t4.get(1), "Dinosaur");
		Check.check(t4.size(), 2);
		Check.check(testList.remove(0), "Twinkle");
		testList.remove(0);
		for (int i = 0; i < testList.size(); i++) {
			System.out.println(testList.get(i));
		}
		Check.check(testList.get(0), "Hello");
	}
	public static void main (String [] args) {
		testIterativeStringList();
		testRecursiveOOStringList();
		testRecursiveIOStringList();
	}
}
