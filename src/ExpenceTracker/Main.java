package ExpenceTracker;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ExpenseService service = new ExpenseService();

        while (true) {
            System.out.println("\n===== Expense Tracker =====");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. Category Wise Total");
            System.out.println("4. Delete Expense");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {

                case 1:
                    System.out.print("Date (dd-mm-yyyy): ");
                    String date = sc.nextLine();

                    System.out.print("Category: ");
                    String category = sc.nextLine();

                    System.out.print("Description: ");
                    String desc = sc.nextLine();

                    System.out.print("Amount: ");
                    double amount = sc.nextDouble();

                    service.addExpense(date, category, desc, amount);
                    System.out.println("Expense added successfully!");
                    break;

                case 2:
                    service.showAll();
                    break;

                case 3:
                    service.categoryTotal();
                    break;

                case 4:
                    System.out.print("Enter Serial Number to Delete: ");
                    int serial = sc.nextInt();
                    service.deleteBySerial(serial);
                    break;

                case 5:
                    System.out.println("Thank you for using Expense Tracker 😊");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
