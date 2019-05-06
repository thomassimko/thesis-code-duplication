//programmed by Michael Olivarez
import java.io.*;
import java.util.*;
import java.text.*;
import java.lang.*;
public interface Expense
{
  String getType();
  String getDate();
  String getAmt();
  String getAmtDue();
  String getPaidTo();
  String getCategory();
  int getDollNum();
  int getCentNum();
}
