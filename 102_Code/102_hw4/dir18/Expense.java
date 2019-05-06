import java.text.*;
import java.util.*;

public interface Expense
{
    Calendar getDate();
    int getDollarsPaid();
    int getCentsPaid();
    int getDollarsLeft();
    int getCentsLeft();
    String getPayee();
    String getDescription();
    String toString();
    String toFileString();
    int getAmount();
}