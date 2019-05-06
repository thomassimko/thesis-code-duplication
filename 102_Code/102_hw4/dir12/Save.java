import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Save {
	public static void save(List<Expenses> expended) {
		try {
			PrintWriter out = new PrintWriter(new FileWriter(new File("StoredExpenses")));
			List<Expenses> copy = expended;
			Expenses e;
			if(!copy.isEmpty()){
				int lenght = expended.size();	
				for(int i = 0; i< lenght; i++){
					e=copy.get(i);
					out.println(e.getType());
					out.println(String.format("%1$2tm/%<2td/%<tY ", e.getDate()));
					out.println(e.getCategory());
					out.println(e.getName());
					out.println(e.getAmount());
					if(e instanceof partial)
						out.println(e.getBalance());
				}
			}
			out.close();
		} catch (IOException e) {
			System.err.println("Your file could not be written");
		}
		
	}
}
