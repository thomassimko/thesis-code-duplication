public class Driver{
	public static void main(String [] args){
		StringList test0=new IterativeStringList();
		test0.addToEnd("Hai");
		test0.add(1," just");
		test0.addToEnd(" testing.");
		System.out.println(test0.size());
		for(int i=0;i<3;i++){
			System.out.print(test0.get(i));
		}
		test0.remove(1);
		for(int i=0;i<2;i++){
			System.out.print(test0.get(i));
		}
		System.out.println("/n // /n");
		
		StringList test1=new RecursiveOOStringList();
		test1.addToEnd("Hai");
		test1.add(1," just");
		test1.addToEnd(" testing.");
		System.out.println(test1.size());
		for(int i=0;i<3;i++){
			System.out.print(test1.get(i));
		}
		test1.remove(1);
		for(int i=0;i<2;i++){
			System.out.print(test1.get(i));
		}
		
		System.out.println("/n // /n");
		
		StringList test2=new RecursiveOOStringList();
		test2.addToEnd("Hai");
		test2.add(1," just");
		test2.addToEnd(" testing.");
		System.out.println(test2.size());
		for(int i=0;i<3;i++){
			System.out.print(test2.get(i));
		}
		test2.remove(1);
		for(int i=0;i<2;i++){
			System.out.print(test2.get(i));
		}
	}
}