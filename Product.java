public abstract class Product implements Comparable<Product> {

    private String name;
    private double price;
    private int orderNum;
    private int stock = 1;

    public Product(String name, double price, int orderNum, int stock){
        this.name = name;
        this.price = price;
        this.orderNum = orderNum;
        this.stock = stock;
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

    @Override
    public int compareTo(Product obj) { //
        if(obj.price > price){
            return -1;
        }
        else if(obj.price < price){
            return 1;
        }
    return 0;
    }
}
