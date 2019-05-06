import java.util.*;

public class Display {
	
	private static int lenght;

	public static void Display(List<Expenses> l) {
		List<Expenses> copy = l;
		lenght = l.size();	
		if(!l.isEmpty()){
			System.out.println("");
			for(int i = 0; i< lenght; i++){
				System.out.println(copy.get(i).print());
			}
		}
	}
}
