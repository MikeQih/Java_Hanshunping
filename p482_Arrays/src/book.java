public class book {
    private String name;
    private int price;
    public book(String name, int price) {
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        return "book [name=" + name + ", price=" + price + "]";
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public static void main(String[] args) {
        
    }
        
    
    
}
