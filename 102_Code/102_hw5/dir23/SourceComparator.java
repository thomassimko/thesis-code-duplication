import java.util.Comparator;


public class SourceComparator implements Comparator<String> {

	@Override
	public int compare(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return arg0.compareToIgnoreCase(arg1);
	}
	
}
