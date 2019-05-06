import java.util.Comparator;

public class alphaSort 
	implements Comparator<String>
{
	public int compare(String str1, String str2) 
	{
		return  str1.compareToIgnoreCase(str2);
	}

}
