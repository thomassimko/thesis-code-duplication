import java.io.PrintWriter;
import java.util.Calendar;


public interface Payment {
	void display();
	void save(PrintWriter out);
	boolean after(Payment p);
	boolean before(Payment p);
	int amount();
	String name();
	String Catagory();
	Calendar date();
}
