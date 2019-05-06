public class IterativeNode
{
    private String string;
    private IterativeNode next;

    public IterativeNode(String s, IterativeNode next)
    {
   	this.string = s;
		this.next = next;
    }
    
    public IterativeNode getNext()
    {
   	 return this.next;
    }
    
    public void setNext(IterativeNode node)
    {
   	 this.next = node;
    }
    
    public String getString()
    {
   	 return this.string;
    }
}