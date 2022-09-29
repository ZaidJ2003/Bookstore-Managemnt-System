public class DVD {

    private String dvdName;
    private double price;
    private int orderNum;

    public DVD(String dvdName, double price, int orderNum) {
        this.dvdName = dvdName;
        this.price = price;
        this.orderNum = orderNum;
    }

    public String getDVDName() {
        return dvdName;
    }
    
    public double getDVDPrice() {
        return price;
    }

    public int getDVDOrderNum() {
        return orderNum;
    }
    
}
