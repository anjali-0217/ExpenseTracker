package ExpenceTracker;
import java.io.*;
import java.util.*;
public class FileUtil {
	private static final String FILE_NAME = "expenses.csv";

    public static void saveExpenses(List<Expense> list) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Expense e : list) {
                pw.println(e.getId() + "," + e.getDate() + "," + e.getCategory() + "," +
                        e.getDescription() + "," + e.getAmount());
            }
        } catch (Exception e) {
            System.out.println("Error saving expenses");
        }
    }

    public static List<Expense> loadExpenses() {
        List<Expense> list = new ArrayList<>();
        File file = new File(FILE_NAME);
        if (!file.exists()) return list;

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");
                list.add(new Expense(
                        Integer.parseInt(arr[0]),
                        arr[1],
                        arr[2],
                        arr[3],
                        Double.parseDouble(arr[4])
                ));
            }
        } catch (Exception e) {
            System.out.println("Error loading expenses");
        }
        return list;
    }

}
