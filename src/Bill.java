

import java.time.LocalDate;

public class Bill {

    private String employeeName;
    private String storeName;
    private double amount;
    private LocalDate date;

    public Bill(String employeeName, String storeName, double amount, LocalDate date) {
        this.employeeName = employeeName;
        this.storeName = storeName;
        this.amount = amount;
        this.date = date;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "employeeName='" + employeeName + '\'' +
                ", storeName='" + storeName + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}
