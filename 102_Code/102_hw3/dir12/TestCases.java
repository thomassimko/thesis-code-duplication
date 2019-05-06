
public class TestCases {

	public static void main(String[] args) {

		StringList n = new IterativeStringList();
		
		Check.check(n.size(), 0);

		n.addToEnd("why");	
		n.addToEnd("does");	//0
		n.addToEnd("this");		//1
		n.addToEnd("work");		
		n.addToEnd("?");
		
		Check.check(n.remove(3),"work");
		Check.check(n.remove(3),"?");
		Check.check(n.remove(0),"why");

		
		n.add(2, "work"); //2
		n.add(3, "?");    //3
		
		Check.check(n.get(1),"this");
		Check.check(n.get(3),"?");
		
		Check.check(n.size(),4);
		
		Check.check(n.indexOf("does"),0);
		Check.check(n.indexOf("this"),1);
		Check.check(n.indexOf("work"),2);
		Check.check(n.indexOf("?"),3);
		
		StringList q = n.toUpperCase();
		
		Check.check(q.get(0),"DOES");
		Check.check(q.get(1),"THIS");
		Check.check(q.get(2),"WORK");
		Check.check(q.get(3),"?");
		
		q = n.toLowerCase();
		
		Check.check(q.get(2),"work");

		q = n.startsWith("th");
		Check.check(q.get(0),"this");
		q = n.startsWith("d");
		Check.check(q.get(0),"does");
		
		q = n.hasSubstring("s");
		Check.check(q.get(0),"does");
		Check.check(q.get(1),"this");
		
		n = new RecursiveOOStringList();
		
		Check.check(n.size(), 0);
		
		n.addToEnd("I");	//0
		n.addToEnd("won");	//1
		n.addToEnd("the");	
		n.addToEnd("game");		//2
		
		Check.check(n.size(), 4);
		
		n.add(3, "element");		
		n.add(0, "did");		
		n.add(6,"?");	//3
		
		Check.check(n.remove(3),"the");
		Check.check(n.remove(3),"element");
		Check.check(n.remove(0),"did");
		
		Check.check(n.get(0),"I");
		Check.check(n.get(1),"won");
		Check.check(n.get(2),"game");
		Check.check(n.get(3),"?");
		
		Check.check(n.indexOf("game"), 2);
		Check.check(n.indexOf("won"), 1);
		Check.check(n.indexOf("I"), 0);
		Check.check(n.indexOf("?"), 3);
		
		q = n.toLowerCase();
		
		Check.check(q.indexOf("i"), 0);
		Check.check(q.get(3),"?");
		
		q = n.hasSubstring("e");
		
		Check.check(q.get(0),"game");
		
		n = new RecursiveIOStringList();
		
		n.addToEnd("Nothing");	//0
		n.addToEnd("can");	//1
		n.addToEnd("do");  //2
		
		Check.check(n.size(), 3);
		Check.check(n.get(2),"do");

	}

}
