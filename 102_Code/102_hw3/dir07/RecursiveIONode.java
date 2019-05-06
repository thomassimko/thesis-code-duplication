public interface RecursiveIONode
{
	/**
	 * @return next RecursiveIONode
	 */
   RecursiveIONode getNext();
   
   /**
    * @return String at current node
    */
   String getString();
   
   /**
    * sets the next Node
    */
   void setNext(RecursiveIONode node);
}
