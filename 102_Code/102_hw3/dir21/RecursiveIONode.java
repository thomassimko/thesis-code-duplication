public interface RecursiveIONode{
	RecursiveIONode next();
	String getVal();
	void linkNext(RecursiveIONode r);
}