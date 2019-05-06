
public class TestCases {
	public static void test() {
		
		//Part 1 Test Cases
		IterativeStringList carList = new IterativeStringList();
		
		carList.addToEnd("Honda");
		carList.addToEnd("Nissan");
		carList.addToEnd("Mitsubishi");
		carList.addToEnd("Toyota");
		carList.addToEnd("BMW");
		carList.addToEnd("Volkswagen");
		carList.addToEnd("Acura");
		Check.check(carList.size(), 7);
		Check.check(carList.get(0), "Honda");
		Check.check(carList.get(1), "Nissan");
		Check.check(carList.get(2), "Mitsubishi");
		Check.check(carList.get(3), "Toyota");
		Check.check(carList.get(4), "BMW");
		Check.check(carList.get(5), "Volkswagen");
		Check.check(carList.get(6), "Acura");
		
		carList.add(0, "Mini");
		Check.check(carList.get(0), "Mini");
		Check.check(carList.get(1), "Honda");
		Check.check(carList.get(2), "Nissan");
		Check.check(carList.get(3), "Mitsubishi");
		Check.check(carList.get(4), "Toyota");
		Check.check(carList.get(5), "BMW");
		Check.check(carList.get(6), "Volkswagen");
		Check.check(carList.get(7), "Acura");
		Check.check(carList.size(), 8);
		
		carList.add(5, "Porshe");
		Check.check(carList.get(5), "Porshe");
		Check.check(carList.get(6), "BMW");
		Check.check(carList.get(7), "Volkswagen");
		Check.check(carList.get(8), "Acura");
		Check.check(carList.size(), 9);
		
		Check.check(carList.remove(0), "Mini");
		Check.check(carList.size(), 8);
		Check.check(carList.get(0), "Honda");
		
		Check.check(carList.remove(3), "Toyota");
		Check.check(carList.size(), 7);
		Check.check(carList.get(3), "Porshe");
		
		Check.check(carList.indexOf("BMW"), 4);
		Check.check(carList.indexOf("Volkswagen"), 5);
		Check.check(carList.indexOf("Acura"), 6);
		
		IterativeStringList carList1 = (IterativeStringList) carList.toLowerCase();
		for(int i=0; i<carList.size(); i++) {
			System.out.println(carList1.get(i));
		}
		System.out.println("-------");
		
		IterativeStringList carList2 = (IterativeStringList) carList.toUpperCase();
		for(int i=0; i<carList.size(); i++) {
			System.out.println(carList2.get(i));
		}
		System.out.println("-------");
		
		IterativeStringList shoeList = new IterativeStringList();
		shoeList.addToEnd("Addidas");
		shoeList.addToEnd("Vans");
		shoeList.addToEnd("Nike");
		shoeList.addToEnd("Converse");
		shoeList.addToEnd("Creative Recreation");
		shoeList.addToEnd("Supra");
		shoeList.addToEnd("Puma");
		shoeList.addToEnd("Fila");
		shoeList.addToEnd("Reebock");
		shoeList.addToEnd("AddiZZdas");
		shoeList.addToEnd("VaZZns");
		shoeList.addToEnd("NiZZke");
		shoeList.addToEnd("ConZZverse");
		shoeList.addToEnd("CreaZZtive Recreation");
		shoeList.addToEnd("SupZZra");
		shoeList.addToEnd("PumZZa");
		shoeList.addToEnd("FiZZla");
		shoeList.addToEnd("ReeZZbock");
		
		IterativeStringList shoeList1 = (IterativeStringList) shoeList.startsWith("C");
		for(int i=0; i<shoeList1.size(); i++) {
			System.out.println(shoeList1.get(i));
		}
		System.out.println("-------");
		
		IterativeStringList shoeList2 = (IterativeStringList) shoeList.toLowerCase();
		shoeList2 = (IterativeStringList) shoeList2.hasSubstring("zz");
		for(int i=0; i<shoeList2.size(); i++) {
			System.out.println(shoeList2.get(i));
		}
		System.out.println("-------");
		
		
		
		
		
		
		
		//Part 2 Test Cases
		RecursiveOOStringList cerealList = new RecursiveOOStringList();
		cerealList.addToEnd("Fruity Pebbles");
		cerealList.addToEnd("Frosted Flakes");
		cerealList.addToEnd("Wheaties");
		cerealList.addToEnd("Coco Puffs");
		cerealList.addToEnd("Cheerios");
		cerealList.addToEnd("Krave");
		cerealList.addToEnd("Pops");
		Check.check(cerealList.size(), 7);
		Check.check(cerealList.get(0), "Fruity Pebbles");
		Check.check(cerealList.get(1), "Frosted Flakes");
		Check.check(cerealList.get(2), "Wheaties");
		Check.check(cerealList.get(3), "Coco Puffs");
		Check.check(cerealList.get(4), "Cheerios");
		Check.check(cerealList.get(5), "Krave");
		Check.check(cerealList.get(6), "Pops");
		Check.check(cerealList.indexOf("Fruity Pebbles"), 0);
		Check.check(cerealList.indexOf("Frosted Flakes"), 1);
		Check.check(cerealList.indexOf("Wheaties"), 2);
		Check.check(cerealList.indexOf("Coco Puffs"), 3);
		Check.check(cerealList.indexOf("Cheerios"), 4);
		Check.check(cerealList.indexOf("Krave"), 5);
		Check.check(cerealList.indexOf("Pops"), 6);
		
		cerealList.add(5, "Apple Jacks");
		Check.check(cerealList.size(), 8);
		Check.check(cerealList.get(5), "Apple Jacks");
		Check.check(cerealList.get(6), "Krave");
		Check.check(cerealList.get(7), "Pops");
		
		Check.check(cerealList.remove(7), "Pops");
		Check.check(cerealList.size(), 7);
		
		RecursiveOOStringList cerealList1 = (RecursiveOOStringList) cerealList.toLowerCase();
		for(int i=0; i<cerealList1.size(); i++) {
			System.out.println(cerealList1.get(i));
		}
		System.out.println("-------");
		
		RecursiveOOStringList cerealList2 = (RecursiveOOStringList) cerealList1.toUpperCase();
		for(int i=0; i<cerealList2.size(); i++) {
			System.out.println(cerealList2.get(i));
		}
		System.out.println("-------");
		
		RecursiveOOStringList cerealList3 = (RecursiveOOStringList) cerealList1.startsWith("f");
		for(int i=0; i<cerealList3.size(); i++) {
			System.out.println(cerealList3.get(i));
		}
		System.out.println("-------");
		
		RecursiveOOStringList cerealList4 = new RecursiveOOStringList();
		cerealList4.addToEnd("Frxxuity Pebbles");
		cerealList4.addToEnd("Froyysted Flakes");
		cerealList4.addToEnd("Wheaxxties");
		cerealList4.addToEnd("Coxxco Puffs");
		cerealList4.addToEnd("Cheyyerios");
		cerealList4.addToEnd("Kravxxe");
		cerealList4.addToEnd("Poyyps");
		
		RecursiveOOStringList cerealList5 = (RecursiveOOStringList) cerealList4.hasSubstring("xx");
		for(int i=0; i<cerealList5.size(); i++) {
			System.out.println(cerealList5.get(i));
		}
		System.out.println("-------");
		
		RecursiveOOStringList cerealList6 = (RecursiveOOStringList) cerealList4.hasSubstring("yy");
		for(int i=0; i<cerealList6.size(); i++) {
			System.out.println(cerealList6.get(i));
		}
		System.out.println("-------");
		
		
		
		
		
		
		//Part 3 Test Cases
		RecursiveIOStringList nameList = new RecursiveIOStringList();
		
		nameList.addToEnd("Michael");
		nameList.addToEnd("James");
		nameList.addToEnd("Josephine");
		nameList.addToEnd("Carl");
		nameList.addToEnd("John");
		nameList.addToEnd("Carter");
		nameList.addToEnd("Russell");
		Check.check(nameList.size(), 7);
		Check.check(nameList.get(0), "Michael");
		Check.check(nameList.get(1), "James");
		Check.check(nameList.get(2), "Josephine");
		Check.check(nameList.get(3), "Carl");
		Check.check(nameList.get(4), "John");
		Check.check(nameList.get(5), "Carter");
		Check.check(nameList.get(6), "Russell");
		
		nameList.add(5, "Karen");
		Check.check(nameList.size(), 8);
		Check.check(nameList.get(5), "Karen");
		Check.check(nameList.get(6), "Carter");
		Check.check(nameList.get(7), "Russell");
		
		nameList.add(0, "Joe");
		Check.check(nameList.size(), 9);
		Check.check(nameList.get(0), "Joe");
		Check.check(nameList.get(1), "Michael");
		Check.check(nameList.get(2), "James");
		Check.check(nameList.get(3), "Josephine");
		Check.check(nameList.get(4), "Carl");
		Check.check(nameList.get(5), "John");
		Check.check(nameList.get(6), "Karen");
		Check.check(nameList.get(7), "Carter");
		Check.check(nameList.get(8), "Russell");
		
		nameList.remove(0);
		Check.check(nameList.size(), 8);
		Check.check(nameList.get(0), "Michael");
		
		nameList.remove(6);
		Check.check(nameList.size(), 7);
		Check.check(nameList.get(6), "Russell");
		//get(6) is pointing to Russell, should
		//point to Carter
		
		Check.check(nameList.indexOf("Josephine"), 2);
		Check.check(nameList.indexOf("Carl"), 3);
		Check.check(nameList.indexOf("John"), 4);
		
		RecursiveIOStringList nameList1 = (RecursiveIOStringList) nameList.toLowerCase();
		for(int i=0; i<nameList1.size(); i++) {
			System.out.println(nameList1.get(i));
		}
		System.out.println("-------");
		
		RecursiveIOStringList nameList2 = (RecursiveIOStringList) nameList.toUpperCase();
		for(int i=0; i<nameList2.size(); i++) {
			System.out.println(nameList2.get(i));
		}
		System.out.println("-------");
		
		RecursiveIOStringList nameList6 = (RecursiveIOStringList) nameList1.startsWith("j");
		for(int i=0; i<nameList6.size(); i++) {
			System.out.println(nameList6.get(i));
		}
		System.out.println("-------");
		
		RecursiveIOStringList nameList3 = new RecursiveIOStringList();
		nameList3.addToEnd("Micgghael");
		nameList3.addToEnd("Jamgges");
		nameList3.addToEnd("Josggephine");
		nameList3.addToEnd("Carlgg");
		nameList3.addToEnd("Jogghn");
		nameList3.addToEnd("Carggter");
		nameList3.addToEnd("Russggell");
		nameList3.addToEnd("Miceehael");
		nameList3.addToEnd("Jameees");
		nameList3.addToEnd("Joseeephine");
		nameList3.addToEnd("Caeerl");
		nameList3.addToEnd("Joeehn");
		nameList3.addToEnd("Careeter");
		nameList3.addToEnd("Russeeell");
		
		RecursiveIOStringList nameList4 = (RecursiveIOStringList) nameList3.hasSubstring("gg");
		for(int i=0; i<nameList4.size(); i++) {
			System.out.println(nameList4.get(i));
		}
		System.out.println("-------");
		
		RecursiveIOStringList nameList5 = (RecursiveIOStringList) nameList3.hasSubstring("ee");
		for(int i=0; i<nameList5.size(); i++) {
			System.out.println(nameList5.get(i));
		}
		System.out.println("-------");
		
		System.out.println("Tests: Done!!");
	}
	
	public static void main(String[] args) {
		test();
	}
}
