
public class TestCases {

	public static void main(String[] args) {
		StringList test = new IterativeStringList();
		test.addToEnd("d");
		test.addToEnd("Cake");
		test.addToEnd("bAke");
		test.addToEnd("A");
		System.out.println(test.size() + "\n");
		test.add(1, "test");
		for (int i = 0; i < test.size(); i++)
			System.out.println(test.get(i));
		System.out.println("\n" + test.indexOf("Cake")+"\n");
		System.out.println(test.indexOf("c")+"\n");
		test.remove(1);
		for (int i = 0; i < test.toUpperCase().size(); i++)
			System.out.println(test.toUpperCase().get(i));
		System.out.println();
		for (int i = 0; i < test.toLowerCase().size(); i++)
			System.out.println(test.toLowerCase().get(i));
		System.out.println();
		for (int i = 0; i < test.hasSubstring("Ake").size(); i++)
			System.out.println(test.hasSubstring("Ake").get(i));
		System.out.println();
		
		test = new RecursiveIOStringList();
		test.addToEnd("d");
		test.addToEnd("Cake");
		test.addToEnd("bAke");
		test.addToEnd("A");
		System.out.println(test.size() + "\n");
		test.add(1, "test");
		for (int i = 0; i < test.size(); i++)
			System.out.println(test.get(i));
		System.out.println("\n" + test.indexOf("Cake")+"\n");
		System.out.println(test.indexOf("c")+"\n");
		test.remove(1);
		for (int i = 0; i < test.toUpperCase().size(); i++)
			System.out.println(test.toUpperCase().get(i));
		System.out.println();
		for (int i = 0; i < test.toLowerCase().size(); i++)
			System.out.println(test.toLowerCase().get(i));
		System.out.println();
		for (int i = 0; i < test.hasSubstring("Ake").size(); i++)
			System.out.println(test.hasSubstring("Ake").get(i));
		System.out.println();
		
		test = new RecursiveOOStringList();
		test.addToEnd("d");
		test.addToEnd("Cake");
		test.addToEnd("bAke");
		test.addToEnd("A");
		System.out.println(test.size() + "\n");
		test.add(1, "test");
		for (int i = 0; i < test.size(); i++)
			System.out.println(test.get(i));
		System.out.println("\n" + test.indexOf("Cake")+"\n");
		System.out.println(test.indexOf("c")+"\n");
		test.remove(1);
		for (int i = 0; i < test.toUpperCase().size(); i++)
			System.out.println(test.toUpperCase().get(i));
		System.out.println();
		for (int i = 0; i < test.toLowerCase().size(); i++)
			System.out.println(test.toLowerCase().get(i));
		System.out.println();
		for (int i = 0; i < test.hasSubstring("Ake").size(); i++)
			System.out.println(test.hasSubstring("Ake").get(i));
		System.out.println();
	}

}
