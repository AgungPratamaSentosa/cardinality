import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class main {
    public static void main(String[] args) {
        // Buat customer
        Customer customer = new Customer("Agung", "Jawa");

        // Buat item
        Item item1 = new Item(2.5f, "tv");
        Item item2 = new Item(1.2f, "keyboard");

        // Buat order detail
        OrderDetail orderDetail1 = new OrderDetail(1, "Taxable");
        OrderDetail orderDetail2 = new OrderDetail(2, "Non-Taxable");

        // Tambahkan detail ke order
        List<OrderDetail> orderDetails = new ArrayList<>();
        orderDetails.add(orderDetail1);
        orderDetails.add(orderDetail2);

        // Buat order
        Order order = new Order(new Date(), "Online", orderDetails);

        // Tambahkan item ke order
        order.addItem(item1);
        order.addItem(item2);

        // Buat pembayaran
        Cash cashPayment = new Cash(1000.0f, 1500.0f);
        Check checkPayment = new Check(1000.0f, "Agung", "***********987");
        Credit creditPayment = new Credit(1000.0f, "1234567890123456", "Visa", "2024-08-18");

        // Output informasi customer
        System.out.println("=====================================");
        System.out.println(" CUSTOMER INFORMATION");
        System.out.println("=====================================");
        System.out.printf(" Name    : %s%n", customer.getName());
        System.out.printf(" Address : %s%n", customer.getAddress());
        System.out.println();

        // Output informasi order
        System.out.println("=====================================");
        System.out.println(" ORDER DETAILS");
        System.out.println("=====================================");
        System.out.printf(" Date    : %s%n", order.getDate());
        System.out.printf(" Status  : %s%n", order.getStatus());
        System.out.println(" Items   :");
        for (Item item : order.getItems()) {
            System.out.printf("   - %s (Weight: %.2f kg)%n", item.getDescription(), item.getShippingWeight());
        }
        System.out.printf(" Total   : %.2f%n", order.calcTotal());
        System.out.println();

        // Output informasi pembayaran
        System.out.println("=====================================");
        System.out.println(" PAYMENT INFORMATION");
        System.out.println("=====================================");
        System.out.printf(" Cash    : %.2f%n", cashPayment.getCashTendered());
        System.out.printf(" Check ID: %s%n", checkPayment.getBankID());
        System.out.printf(" Credit  : ExpDate %s%n", creditPayment.getExpDate());
        System.out.println("=====================================");
    }
}
