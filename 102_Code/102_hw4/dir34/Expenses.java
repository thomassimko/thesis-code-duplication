import java.util.Calendar;

public interface Expenses {
Calendar getDate();
int getDollars();
int getCents();
String getPayee();
String getAmountPaid();
String getCategory();
String getBalance();
String getType();
void print();
}
