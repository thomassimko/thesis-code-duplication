import java.util.Scanner;
import java.io.File;
import java.util.NoSuchElementException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Collections;


public class Reader
{
   public static void main(String [] args)
   {
	   File file;
	   ArrayList<Expenses> eList = new ArrayList<Expenses>();
	   try{
            file = new File("StoredExpenses.txt");
			   if (!file.exists())
			   {
			      file.createNewFile();
			   }
			
			   Scanner scan = new Scanner(file);
         
           //Reading from file and adding to list
            while( scan.hasNext())
            {
               String check = scan.next();
               if( check.equals("in-full"))
               {
                 try{
                    String date = scan.next();
                    String type = scan.next();
                    String payee = scan.next();
                    String amount = scan.next();
                              
                    //String to Date Conversion
                    DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                    Date theDate = df.parse(date);
               
                    //String to amount Conversion
                    MoneyConverter monCon = new MoneyConverter(amount);
						  
               
                    InFull expenseFull = new InFull(theDate, payee, type, monCon.getDollars(),
						    monCon.getCents());
               
                    eList.add(expenseFull);
                 }
                 catch ( ParseException i)
                 {
                    System.err.println("Parse exception caught in in");
                 }
                }
            
                if (check.equals("partial"))
                {
                   try{
                   String date = scan.next();
                   String type = scan.next();
                   String payee = scan.next();
                   String amount = scan.next();
                   String remaining = scan.next();
                              
                   //String to Date Conversion
                   DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                   Date theDate = df.parse(date);
               
                   //String to amount Conversion
                    MoneyConverter conAmount = new MoneyConverter(amount);               
                   //String to remaining Conversion
                   MoneyConverter conRemaining = new MoneyConverter(remaining);
               
                   Partial expensePartial = new Partial(theDate, payee, type, conAmount.getDollars(), 
						    conAmount.getCents(), conRemaining.getDollars(), conRemaining.getCents());
               
                   eList.add(expensePartial);
                   }
                   catch (ParseException pa)
                   {
                      System.err.println("Parse Error in partial");
                   }
                }
            } 
            scan.close();
         
            //****************Program Display******************
		      
		      if(file.exists())
		      {
		         System.out.println();
		         System.out.println("File Loaded");
		         System.out.println();
		      }
		  
		      boolean running = true;
		      Scanner userInput = new Scanner(System.in);
		  
		      while(running)
		      {
		        System.out.println("1. Display");
		        System.out.println("2. Add Expense");
		        System.out.println("3. Sort");
		        System.out.println("4. Save");
		        System.out.println("5. Quit");
		        System.out.println();
		        System.out.print("Enter choice: ");
		        int choice = userInput.nextInt();
		     
		        // ***Display List***
		        if (choice == 1)
		        {
		           for(int k = 0; k < eList.size(); k++)
		           {
		              Expenses object = eList.get(k);
		              String output;
		              if (object instanceof Partial)
		              {
		                 Partial pObject = (Partial)object;
		                 output = String.format("%1$2tm/%<2td/%<tY ", object.getDate())
                         + String.format("%-15.15s %s (%s) [%s]", object.getPayee(), 
                         object.getAmountPaid(), pObject.getBalanceRemain(), object.getCategory());
		              }
		              else
		              {
		                 output = String.format("%1$2tm/%<2td/%<tY ", object.getDate())
                          + String.format("%-15.15s %s [%s]", object.getPayee(), 
                          object.getAmountPaid(), object.getCategory());
                    }
                    System.out.println(output);
		           }
		           System.out.println();
		        }
		        // *** Add to List ***
		        else if (choice == 2)
		        {
		           System.out.print("Expense type (in-full, partial)? ");
		           String type = userInput.next();
		           System.out.print("Payment date: ");
		           String date = userInput.next();
		           System.out.print("Expense Amount: ");
		           String amount = userInput.next();
		           System.out.print("Who was this expense paid to? ");
		           String payee = userInput.next();
		           System.out.print("Expense category: ");
		           String category = userInput.next();
		           // ***Date Conversion***
		           DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                   Date theDate = df.parse(date);
                
                 //String to amount Conversion
                 MoneyConverter monCon = new MoneyConverter(amount);
					  
					                 
		           if( type.equals("partial"))
		           {
		              System.out.print("Expense Balance: ");
		              String balance = userInput.next();
		           
		               //String to balance Conversion
                    MoneyConverter balCon = new MoneyConverter(balance);
                   
                     Partial expensePartial = new Partial(theDate, payee, category, monCon.getDollars(),
							 monCon.getCents(), balCon.getDollars(), balCon.getCents());
               
                     eList.add(0, expensePartial);
		            }
		            else
		            {
		              InFull expenseFull = new InFull(theDate, payee, category, monCon.getDollars()
						     , monCon.getCents());
               
                    eList.add(0, expenseFull);
		            }
		            System.out.println();
		         }
		         //*** List Sort ***
		         else if (choice ==3)
		         {
					   
		            System.out.print("\nKeys to by: ");
						userInput.nextLine();
						String line = userInput.nextLine();
						String[] keys = line.split(" ");
						
						
						String lastKey = keys[(keys.length - 1)];
						
						Comparator<Expenses> eComp = null; 
						boolean invalidKey = false;
						
						
						if( lastKey.equals("date"))
						{
						   eComp = new ExpenseDateComparator();
						}
						else if ( lastKey.equals("amount"))
						{
						   eComp = new ExpenseAmountComparator();
						}
						else if (lastKey.equals("payee"))
						{
						   eComp = new ExpensePayeeComparator();
						}
						else if (lastKey.equals("category"))
						{
						   eComp = new ExpenseCategoryComparator();
						}
						else 
						{
						   
						   invalidKey = true;
						}
						
						for (int j = keys.length -1; j>=0 ; j--)
						{
						   if( keys[j].equals("date"))
						   {
						      eComp = new ExpenseDelegateComparator(new ExpenseDateComparator(), eComp);
						   }
						   else if ( keys[j].equals("amount"))
						   {
						      eComp = new ExpenseDelegateComparator(new ExpenseAmountComparator(), eComp);
						   }
						   else if (keys[j].equals("payee"))
						   {
						      eComp = new ExpenseDelegateComparator(new ExpensePayeeComparator(), eComp);
						   }
						   else if (keys[j].equals("category"))
						   {
						      eComp = new ExpenseDelegateComparator(new ExpenseCategoryComparator(), eComp);
						   }
						   else 
						   {
						      System.err.println(keys[j] + " Not a valid key!");
						      invalidKey = true;
						   }
						}
						
						if(!invalidKey)
						{
						   Collections.sort(eList, eComp);
						}
						
						
						System.out.println();
						
		         }
		         // *** Save List ***
		         else if (choice ==4)
		         {
		            PrintWriter saveFile = new PrintWriter(new File("StoredExpenses.txt"));
		        
		           for(int i = 0; i < eList.size(); i++)
		           {
		              Expenses object = eList.get(i);
		           
		              if(object instanceof Partial)
		              {
		                 Partial objectP = (Partial)object;
		                 saveFile.write("partial" + "\n");
		                 saveFile.write(String.format("%1$2tm/%<2td/%<tY " + "\n", object.getDate()));
		                 saveFile.write(object.getCategory() + "\n");
		                 saveFile.write(object.getPayee() + "\n");
		                 saveFile.write(object.getAmountPaid() + "\n");
		                 saveFile.write(objectP.getBalanceRemain() + "\n");
		                 saveFile.write("\n");
		              }
		              else
		              {
		                 saveFile.write("in-full" + "\n");
		                 saveFile.write(String.format("%1$2tm/%<2td/%<tY "  + "\n", object.getDate()));
		                 saveFile.write(object.getCategory() + "\n");
		                 saveFile.write(object.getPayee() + "\n");
		                 saveFile.write(object.getAmountPaid() + "\n");
		                 saveFile.write("\n");  
		              }
		           }
		           System.out.println();
		           System.out.println("Expenses Saved");
		           System.out.println();
		        
		           saveFile.close();
		     
		        }
		        // *** Quite Program ***
		        else
		        {
		           running = false;
		        }
		     }
		   } 
		   catch(ParseException p)
			{
			   System.err.println("parse error");
			}
         catch(FileNotFoundException f)
		   {
			  System.err.println("file not found");
		   }
	      catch(IOException i)
		   {
			   System.err.println("IO error.");
		   }
   }
}