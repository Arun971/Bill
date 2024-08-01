import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BillManager {
    private List<Bill> bills = new ArrayList<>();
    private List<Bill> settledBills = new ArrayList<>();

    public void addBill(Bill bill) {
        bills.add(bill);
    }

    public void settleBills() {
        settledBills.addAll(bills);
        bills.clear();
    }

    public List<Bill> filterBillsByDateRange(LocalDate startDate, LocalDate endDate) {
        return bills.stream()
                .filter(bill -> (bill.getDate().isAfter(startDate) || bill.getDate().isEqual(startDate)) &&
                        (bill.getDate().isBefore(endDate) || bill.getDate().isEqual(endDate)))
                .collect(Collectors.toList());
    }

//    public Bill getHighestAmountBill() {
//        return bills.stream()
//                .max((bill1, bill2) -> Double.compare(bill1.getAmount(), bill2.getAmount()))
//                .orElse(null);
//    }
//
//    public List<Bill> getSettledBills() {
//        return new ArrayList<>(settledBills);
//    } 

    public Map<String, List<Bill>> getBillsGroupedByStore() {
        return bills.stream().collect(Collectors.groupingBy(Bill::getStoreName));
    }

    public List<Bill> listAllBills() {
        return new ArrayList<>(bills);
    }
}
