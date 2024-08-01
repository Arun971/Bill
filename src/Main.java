import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BillManager billManager = new BillManager();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("1. Add Bill");
            System.out.println("2. Settle Bills");
            System.out.println("3. Filter Bills by Date Range");
            System.out.println("4. List All Bills");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter employee name: ");
                    String employeeName = scanner.nextLine();
                    System.out.print("Enter store name: ");
                    String storeName = scanner.nextLine();
                    System.out.print("Enter amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter date (YYYY-MM-DD): ");
                    LocalDate date = LocalDate.parse(scanner.nextLine());
                    Bill bill = new Bill(employeeName, storeName, amount, date);
                    billManager.addBill(bill);
                    System.out.println("Bill added successfully.");
                    break;
                case 2:
                    billManager.settleBills();
                    System.out.println("All bills settled.");
                    break;
                case 3:
                    System.out.print("Enter start date (YYYY-MM-DD): ");
                    LocalDate startDate = LocalDate.parse(scanner.nextLine());
                    System.out.print("Enter end date (YYYY-MM-DD): ");
                    LocalDate endDate = LocalDate.parse(scanner.nextLine());
                    List<Bill> filteredBills = billManager.filterBillsByDateRange(startDate, endDate);
                    filteredBills.forEach(System.out::println);
                    break;
                case 4:
                    List<Bill> allBills = billManager.listAllBills();
                    allBills.forEach(System.out::println);
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}
