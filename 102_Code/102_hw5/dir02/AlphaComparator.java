import java.util.*;
public class AlphaComparator implements 
	Comparator<String> 
{
	public int compare(String s1, String s2) 
	{
		return(s1.toLowerCase().compareTo(s2.toLowerCase()));
	}
	public boolean equals()
	{
		throw new UnsupportedOperationException();
	}
}
