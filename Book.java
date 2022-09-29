public class Book {
    private String bookName;
    private double price;
    private int orderNum;

    public Book(String bookName, double price, int orderNum){
        this.bookName = bookName;
        this.price = price;
        this.orderNum = orderNum;
    }
    
    public String getBookName(){
        return bookName;
    }

    public double getBookPrice(){
        return price;
    }

    public int getBookOrderNum(){
        return orderNum;
    }
}