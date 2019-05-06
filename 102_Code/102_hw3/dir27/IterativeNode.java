public class IterativeNode
{
	private String name;
	private IterativeNode nextn;
	public IterativeNode(String name, IterativeNode nextn)
	{
		this.name = name;
		this.nextn = nextn;
	}
	public IterativeNode getNext()
	{
		return this.nextn;
	}
	public String getString()
	{
		return this.name;
	}
	public void setNext(IterativeNode newnext)
	{
		this.nextn = newnext;
	}
}
	