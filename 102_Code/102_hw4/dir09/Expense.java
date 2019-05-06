import java.util.*;

public interface Expense
{
   String getType();
   Date date();
   String paid();
   int paidValue();
   String payee();
   String category();
   String toString();
}
