import java.util.*;

public class AlphaComp
	implements Comparator<String>
{
	public int compare(String lft, String rht)
	{
		return lft.compareTo(rht);
	}
}
