import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private Date date;
    private String status;
    private List<OrderDetail> orderDetails; // Daftar detail pesanan
    private List<Item> items; // Daftar item pesanan

    // Konstruktor
    public Order(Date date, String status, List<OrderDetail> orderDetails) {
        this.date = date;
        this.status = status;
        this.orderDetails = orderDetails;
        this.items = new ArrayList<>(); // Inisialisasi daftar item
    }

    // Getter untuk tanggal pesanan
    public Date getDate() {
        return date;
    }

    // Getter untuk status pesanan
    public String getStatus() {
        return status;
    }

    // Setter untuk status pesanan
    public void setStatus(String status) {
        this.status = status;
    }

    // Menambahkan item ke pesanan
    public void addItem(Item item) {
        items.add(item);
    }

    // Getter untuk daftar item
    public List<Item> getItems() {
        return items;
    }

    // Menghitung total harga berdasarkan detail dan item
    public float calcTotal() {
        float total = 0.0f;
        for (OrderDetail detail : orderDetails) {
            total += detail.calcSubTotal();
        }
        return total;
    }
}
