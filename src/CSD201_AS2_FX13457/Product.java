package CSD201_AS2_FX13457;

/**
 * Chứa thông tin và hành vi cần thiết cho sản phẩm.
 */
public class Product {
    private String bcode;
    private String title;
    private int quantity;
    private double price;

    public Product(){

    }
    public Product(String bcode, String title, int quantity, double price) {
        this.bcode = bcode;
        this.title = title;
        this.quantity = quantity;
        this.price = price;
    }

    public Product(int quantity){
        this.quantity = quantity;
    }

    public String getBcode() {
        return bcode;
    }

    public void setBcode(String bcode) {
        this.bcode = bcode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString(){
        return this.bcode + "   |   " + this.title + "   |   " + this.quantity + "   |   " + this.price;
    }
}
