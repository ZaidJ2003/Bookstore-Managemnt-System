public class CD {

    private String cdName; 
    private double price;
    private int orderNum;
    
    
    public CD(String cdName, double price , int orderNum) {
        this.cdName = cdName;
        this.price = price;
        this.orderNum = orderNum;
    }
    
    public String getCDName() {
        return cdName;
    }
    
    public double getCDPrice() {
        return price;
    }

    public int getCDOrderNum() {
        return orderNum;
    }
}
