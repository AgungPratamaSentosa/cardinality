public class Item {
    private float shippingWeight;
    private String description;

    // Konstruktor
    public Item(float shippingWeight, String description) {
        this.shippingWeight = shippingWeight;
        this.description = description;
    }

    // Getter untuk shippingWeight
    public float getShippingWeight() {
        return shippingWeight;
    }

    // Getter untuk description
    public String getDescription() {
        return description;
    }
}
