| Pertemuan 11  |  Pemrograman Berorientasi Objek  
|-------|---------
| NIM   | 312310611
| Nama  | Agung Pratama Sentosa
| Kelas | TI.23.A6


### 1. **Customer.java**
Kelas `Customer` digunakan untuk merepresentasikan pelanggan yang memiliki dua atribut utama:
- `name` (nama pelanggan).
- `address` (alamat pelanggan).

#### Penjelasan Kode:
```java
public class Customer {
    private String name;
    private String address;

    public Customer(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
```
- **Atribut `name` dan `address`** digunakan untuk menyimpan informasi pelanggan.
- Constructor menerima dua parameter (`name` dan `address`) untuk menginisialisasi objek pelanggan.
- Metode getter (`getName()` dan `getAddress()`) digunakan untuk mengakses atribut.

---

### 2. **Item.java**
Kelas `Item` merepresentasikan barang yang dijual. Barang memiliki:
- Berat (`shippingWeight`).
- Deskripsi barang (`description`).

#### Penjelasan Kode:
```java
public class Item {
    private float shippingWeight;
    private String description;

    public Item(float shippingWeight, String description) {
        this.shippingWeight = shippingWeight;
        this.description = description;
    }

    public float getPriceForQuantity(int quantity) {
        return quantity * 10.0f; // Contoh harga
    }

    public float getTax(float price) {
        return price * 0.1f; // Pajak 10%
    }

    public boolean inStock() {
        return true; // Contoh default selalu tersedia
    }
}
```
- **Metode `getPriceForQuantity()`** menghitung total harga untuk kuantitas tertentu.
- **Metode `getTax()`** menghitung pajak 10% dari harga total.
- **Metode `inStock()`** mengecek ketersediaan barang (contoh default: selalu tersedia).

---

### 3. **OrderDetail.java**
Kelas ini merepresentasikan detail pesanan, yaitu informasi tentang kuantitas barang yang dipesan dan status pajak.

#### Penjelasan Kode:
```java
public class OrderDetail {
    private int quantity;
    private String taxStatus;

    public OrderDetail(int quantity, String taxStatus) {
        this.quantity = quantity;
        this.taxStatus = taxStatus;
    }

    public float calcSubTotal(Item item) {
        return item.getPriceForQuantity(quantity);
    }

    public float calcWeight(Item item) {
        return quantity * item.shippingWeight;
    }

    public float calcTax(Item item) {
        float price = calcSubTotal(item);
        return item.getTax(price);
    }
}
```
- **`calcSubTotal()`** menghitung total harga berdasarkan kuantitas dan harga barang.
- **`calcWeight()`** menghitung total berat barang berdasarkan kuantitas.
- **`calcTax()`** menghitung pajak berdasarkan subtotal.

---

### 4. **Order.java**
Kelas ini merepresentasikan sebuah pesanan yang memiliki beberapa detail pesanan (agregasi dengan `OrderDetail`).

#### Penjelasan Kode:
```java
import java.util.ArrayList;
import java.util.Date;

public class Order {
    private Date date;
    private String status;
    private ArrayList<OrderDetail> orderDetails = new ArrayList<>();

    public Order(Date date, String status) {
        this.date = date;
        this.status = status;
    }

    public void addOrderDetail(OrderDetail detail) {
        orderDetails.add(detail);
    }

    public float calcTotal(Item item) {
        float total = 0;
        for (OrderDetail detail : orderDetails) {
            total += detail.calcSubTotal(item);
        }
        return total;
    }

    public float calcTotalWeight(Item item) {
        float totalWeight = 0;
        for (OrderDetail detail : orderDetails) {
            totalWeight += detail.calcWeight(item);
        }
        return totalWeight;
    }
}
```
- **`addOrderDetail()`** digunakan untuk menambahkan detail pesanan ke dalam daftar.
- **`calcTotal()`** menghitung total harga untuk semua detail pesanan.
- **`calcTotalWeight()`** menghitung total berat untuk semua detail pesanan.

---

### 5. **Payment.java** (Abstract Class)
Kelas ini merepresentasikan abstraksi untuk metode pembayaran. Atribut utamanya adalah:
- `amount` (jumlah pembayaran).

#### Penjelasan Kode:
```java
public abstract class Payment {
    protected float amount;

    public Payment(float amount) {
        this.amount = amount;
    }
}
```
- **Kelas abstrak** ini tidak bisa diinstansiasi secara langsung, hanya bisa digunakan oleh subclass.

---

### 6. **Cash.java**
Subclass dari `Payment` untuk pembayaran tunai.

#### Penjelasan Kode:
```java
public class Cash extends Payment {
    private float cashTendered;

    public Cash(float amount, float cashTendered) {
        super(amount);
        this.cashTendered = cashTendered;
    }
}
```
- **`cashTendered`** merepresentasikan uang tunai yang diterima.

---

### 7. **Check.java**
Subclass dari `Payment` untuk pembayaran dengan cek.

#### Penjelasan Kode:
```java
public class Check extends Payment {
    private String name;
    private String bankID;

    public Check(float amount, String name, String bankID) {
        super(amount);
        this.name = name;
        this.bankID = bankID;
    }

    public boolean authorized() {
        return true; // Default selalu terotorisasi
    }
}
```
- **`name`** adalah nama pemilik cek.
- **`bankID`** adalah ID bank terkait.
- **`authorized()`** mengecek otorisasi cek (contoh default: selalu berhasil).

---

### 8. **Credit.java**
Subclass dari `Payment` untuk pembayaran dengan kartu kredit.

#### Penjelasan Kode:
```java
public class Credit extends Payment {
    private String number;
    private String type;
    private String expDate;

    public Credit(float amount, String number, String type, String expDate) {
        super(amount);
        this.number = number;
        this.type = type;
        this.expDate = expDate;
    }

    public boolean authorized() {
        return true; // Default selalu terotorisasi
    }
}
```
- **`number`** adalah nomor kartu kredit.
- **`type`** adalah tipe kartu kredit (misalnya Visa, Mastercard).
- **`expDate`** adalah tanggal kedaluwarsa kartu.
- **`authorized()`** mengecek otorisasi kartu kredit.

---

### 9. **Main.java**
Kelas ini digunakan untuk menjalankan program dengan contoh sederhana.

#### Penjelasan Kode:
```java
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

```
- Membuat objek `Customer`, `Item`, `Order`, dan menambahkan detail pesanan.
- Menghitung total pesanan dan berat total.
- Menggunakan metode pembayaran `Credit` untuk otorisasi.

---

**OUTPUT**

![image](output.jpeg)
