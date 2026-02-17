package ExpenceTracker;
import java.util.*;

public class ExpenseService {
	private List<Expense> expenses;
    private int idCounter = 1;

    public ExpenseService() {
        expenses = FileUtil.loadExpenses();

        if (!expenses.isEmpty()) {
            idCounter = expenses.get(expenses.size() - 1).getId() + 1;
        }
    }

    // Add Expense
    public void addExpense(String date, String category, String desc, double amt) {
        Expense e = new Expense(idCounter++, date, category, desc, amt);
        expenses.add(e);
        FileUtil.saveExpenses(expenses);
    }

    // Show All with Serial Number (Always Sequential)
    public void showAll() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses found.");
            return;
        }

        System.out.println("\nS.No | Date         | Description         | Amount");
        System.out.println("------------------------------------------------------");

        for (int i = 0; i < expenses.size(); i++) {
            Expense e = expenses.get(i);

            System.out.printf("%-4d | %-12s | %-18s | ₹%.2f\n",
                    i + 1,
                    e.getDate(),
                    e.getDescription(),
                    e.getAmount());
        }
    }

    // Delete by Serial Number
    public void deleteBySerial(int serial) {
        if (serial <= 0 || serial > expenses.size()) {
            System.out.println("Invalid serial number.");
            return;
        }

        expenses.remove(serial - 1);
        FileUtil.saveExpenses(expenses);
        System.out.println("Expense deleted successfully.");
    }

    // Category Wise Total
    public void categoryTotal() {
        Map<String, Double> map = new HashMap<>();

        for (Expense e : expenses) {
            map.put(
                e.getCategory(),
                map.getOrDefault(e.getCategory(), 0.0) + e.getAmount()
            );
        }

        System.out.println("\nCategory Wise Total:");
        for (String key : map.keySet()) {
            System.out.println(key + " : ₹" + map.get(key));
        }
    }

}
