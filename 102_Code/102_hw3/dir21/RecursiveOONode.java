public interface RecursiveOONode extends StringList{
	RecursiveOONode next();
	String getVal();
	void linkNext(RecursiveOONode r);
}