import java.util.*;

public class Program 
{

   private static void displayMenu()
   {
      System.out.println("\n1. Display");
      System.out.println("2. Add Expense");
      System.out.println("3. Sort");
      System.out.println("4. Save");
      System.out.println("5. Quit\n");
      System.out.print("\nEnter choice: ");
   }

   private static void menu(List<Expense> list)
   {
      displayMenu();

      Scanner scan = new Scanner(System.in);

      try
      {
         int choice = scan.nextInt();
         scan.nextLine(); 

         switch (choice)
         {
            case 1: ShowExpenses.show(list);
                    break;
            case 2: AddExpense.add(list, scan);
                    break;
            case 3: SortExpenses.sort(list, scan);
                    break;
            case 4: SaveExpenses.save(list, "StoredExpenses");
                    break;
            case 5: System.exit(1);
                    break;
            default: throw new InputMismatchException();
         }
      }
      catch (InputMismatchException e)
      {
         System.err.println("Invalid choice.");
      }

      menu(list);    
   } 

   public static void main(String[] args)
   {
      List<Expense> mainList = ReadExpenses.read("StoredExpenses");

      menu(mainList);
   }
}
