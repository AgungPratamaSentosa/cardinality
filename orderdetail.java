public class OrderDetail {
    private int quantity;
    private String taxStatus;

    // Konstruktor
    public OrderDetail(int quantity, String taxStatus) {
        this.quantity = quantity;
        this.taxStatus = taxStatus;
    }

    // Getter dan setter untuk quantity dan taxStatus
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getTaxStatus() {
        return taxStatus;
    }

    public void setTaxStatus(String taxStatus) {
        this.taxStatus = taxStatus;
    }

    // Hitung subtotal berdasarkan quantity
    public float calcSubTotal() {
        return quantity * 100.0f; // Anggap harga per item adalah 100.0
    }
}
