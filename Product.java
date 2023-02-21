public abstract class Product implements Comparable<Product> {

    private String name;
    private double price;
    private int orderNum;
    private int stock = 1;
    private String author;
    private int bought = 1;

    public Product(String name, String author, double price, int orderNum, int stock, int bought){
        this.name = name;
        this.price = price;
        this.orderNum = orderNum;
        this.author = author;
        this.stock = stock;
        this.bought = bought;
    }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

    public int getOrderNum(){
        return orderNum;
    }

    public int getStock(){
        return stock;
    }

    public String getAuthor(){
        return author;
    }

    public void incrementStock(){
        stock++;
    }

    public void setStock(int stock){
        this.stock = stock;
    }

    public void decrmentStock(){
        if(stock>0)
        stock--;
    }

    public int getBought(){
        return bought;
    }

    public void incrementBought(){
        bought++;
    }

    @Override
    public int compareTo(Product obj) { //
        if(orderNum > obj.orderNum){
            return 1;
        }
        else if(orderNum < obj.orderNum){
            return -1;
        }
    return 0;
    }
}
