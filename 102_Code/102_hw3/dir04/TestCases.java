
public class TestCases {
	public static void TestIter()
	{
		StringList test1 = new IterativeStringList();
		
		test1.addToEnd("Comet");		//1
		test1.addToEnd("Autumn Fire");	//2
		test1.addToEnd("Spring Earth");	//3
		test1.addToEnd("Fluffy");		//4
		test1.addToEnd("Mr. Sparkles with tacos");	//5
		test1.addToEnd("Blossom");		//6
		test1.addToEnd("WOOAAAHH, LION DANCE!!!");  //7
		
		Check.check(test1.get(7), "WOOAAAHH, LION DANCE!!!");
		Check.check(test1.get(3), "Spring Earth");
		Check.check(test1.indexOf("Blossom"), 6);
		Check.check(test1.size(), 7);
		
		StringList test1Low = test1.toLowerCase();		
		Check.check(test1Low.get(3), "spring earth");
		Check.check(test1Low.get(7), "wooaaahh, lion dance!!!");
		
		StringList test1High = test1.toUpperCase();
		Check.check(test1High.get(5), "MR. SPARKLES WITH TACOS");
		Check.check(test1High.get(1), "COMET");
		
		Check.check(test1.remove(2), "Autumn Fire"); //rmv Autumn Fire
		Check.check(test1.remove(2), "Spring Earth"); //rmv Spring Earth
		Check.check(test1.get(1), "Comet");
		Check.check(test1.get(2), "Fluffy");
		Check.check(test1.get(3), "Mr. Sparkles with tacos");
		Check.check(test1.get(4), "Blossom");
		Check.check(test1.get(5), "WOOAAAHH, LION DANCE!!!");
		
		
		test1.add(2, "Spring Earth");
		Check.check(test1.get(1), "Comet");
		Check.check(test1.get(2), "Spring Earth");
		Check.check(test1.get(3), "Fluffy");
		Check.check(test1.get(4), "Mr. Sparkles with tacos");
		Check.check(test1.get(5), "Blossom");
		Check.check(test1.get(6), "WOOAAAHH, LION DANCE!!!");
		
		test1.add(2, "Autumn Fire");
		Check.check(test1.get(1), "Comet");
		Check.check(test1.get(2), "Autumn Fire");
		Check.check(test1.get(3), "Spring Earth");
		Check.check(test1.get(4), "Fluffy");
		Check.check(test1.get(5), "Mr. Sparkles with tacos");
		Check.check(test1.get(6), "Blossom");
		Check.check(test1.get(7), "WOOAAAHH, LION DANCE!!!");
		
		StringList test1Sub = test1.hasSubstring("om");
		Check.check(test1Sub.get(1), "Comet");
		Check.check(test1Sub.get(2), "Blossom");
		
		StringList test1Pre = test1.startsWith("Mr.");
		Check.check(test1Pre.get(1), "Mr. Sparkles with tacos");
	}
	
	public static void TestROO()
	{		
		StringList test1 = new RecursiveOOStringList();
				
		test1.addToEnd("Cal");		//1
		test1.addToEnd("Poly");		//2
		test1.addToEnd("Lion");		//3
		test1.addToEnd("Dance");	//4
		
		Check.check(test1.size(), 4);
		
		Check.check(test1.get(1), "Cal"); 	//1
		Check.check(test1.get(2), "Poly");	//2
		Check.check(test1.get(3), "Lion");	//3
		Check.check(test1.get(4), "Dance");	//4
		
		Check.check(test1.indexOf("Lion"), 3);
		Check.check(test1.indexOf("Cal"), 1);
		
		Check.check(test1.remove(2), "Poly");
		Check.check(test1.get(1), "Cal");	//1
		Check.check(test1.get(2), "Lion");	//2
		Check.check(test1.get(3), "Dance");	//3
		
		test1.add(2, "Poly");
		Check.check(test1.get(1), "Cal");	//1
		Check.check(test1.get(2), "Poly");	//2
		Check.check(test1.get(3), "Lion");	//3
		Check.check(test1.get(4), "Dance");	//4
		
		StringList test1Low = test1.toLowerCase();		
		Check.check(test1Low.get(1), "cal");
		Check.check(test1Low.get(3), "lion");
		
		StringList test1High = test1.toUpperCase();
		Check.check(test1High.get(2), "POLY");
		Check.check(test1High.get(4), "DANCE");
		
		test1.addToEnd("Cal Poly");		//5
		test1.addToEnd("Lion Dance");	//6
		
		Check.check(test1.get(5), "Cal Poly");	//5
		Check.check(test1.get(6), "Lion Dance");//6
		
		StringList test1Pre = test1.startsWith("Ca");
		Check.check(test1Pre.get(1), "Cal");
		Check.check(test1Pre.get(2), "Cal Poly");
		
		StringList test1Pre2 = test1.startsWith("Li");
		Check.check(test1Pre2.get(1), "Lion");
		Check.check(test1Pre2.get(2), "Lion Dance");
		
		StringList test1Sub = test1.hasSubstring("o");
		Check.check(test1Sub.get(1), "Poly");
		Check.check(test1Sub.get(2), "Lion");
		Check.check(test1Sub.get(3), "Cal Poly");
		Check.check(test1Sub.get(4), "Lion Dance");
	}
	
	public static void TestRIO()
	{
	
		StringList test1 = new RecursiveIOList();
	
		
		test1.addToEnd("This");		//1
		test1.addToEnd("Code");		//2
		test1.addToEnd("is");		//3
		test1.addToEnd("Done");	//4
				
		Check.check(test1.size(), 4);
			
		Check.check(test1.get(1), "This"); 	//1
		Check.check(test1.get(2), "Code");	//2
		Check.check(test1.get(3), "is");	//3
		Check.check(test1.get(4), "Done");	//4
				
		Check.check(test1.indexOf("Lion"), 3);
		Check.check(test1.indexOf("Cal"), 1);
		
		Check.check(test1.remove(2), "Code");
		Check.check(test1.get(1), "This");	//1
		Check.check(test1.get(2), "is");	//2
		Check.check(test1.get(3), "Done");	//3
		
		test1.add(2, "Code");
		Check.check(test1.get(1), "This");	//1
		Check.check(test1.get(2), "Code");	//2
		Check.check(test1.get(3), "is");	//3
		Check.check(test1.get(4), "Done");	//4
		
		StringList test1Low = test1.toLowerCase();		
		Check.check(test1Low.get(1), "this");
		Check.check(test1Low.get(2), "code");

		StringList test1High = test1.toUpperCase();
		Check.check(test1High.get(3), "IS");
		Check.check(test1High.get(4), "DONE");
		
		test1.addToEnd("This Code");		//5
		test1.addToEnd("is Done");	//6
		
		Check.check(test1.get(5), "This Code");	//5
		Check.check(test1.get(6), "is Done");//6
		
		StringList test1Pre = test1.startsWith("Th");
		Check.check(test1Pre.get(1), "This");
		Check.check(test1Pre.get(2), "This Code");
		
		StringList test1Pre2 = test1.startsWith("i");
		Check.check(test1Pre2.get(1), "is");
		Check.check(test1Pre2.get(2), "is Done");
		
		StringList test1Sub = test1.hasSubstring("is");
		Check.check(test1Sub.get(1), "This");
		Check.check(test1Sub.get(2), "is");
		Check.check(test1Sub.get(3), "This Code");
		Check.check(test1Sub.get(4), "is Done");
	}
	
	public static void main (String [] args)
	{
		TestIter();
		TestROO();
		//TestRIO();
	}

}
