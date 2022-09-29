import java.util.ArrayList;
import java.util.Scanner;

public class Bookstore {

    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Book> bookInventory = new ArrayList<>();
    private int bookOrderNum = 1;
    private ArrayList<CD> cdInventory = new ArrayList<>();
    private int cdOrderNum = 1;
    private ArrayList<DVD> dvdInventory = new ArrayList<>();
    private int dvdOrderNum =1 ;
    private ArrayList<Member> memberInventory = new ArrayList<>();
    private int memberID = 1;
    private ArrayList<PremiumMember> PremiumMemberInventory = new ArrayList<>();
    private int premiumMemberID = 1;
    private int itemsInCart;
    private double total;

    public Bookstore(){ //default values in each list
        System.out.println("Welcome to The Bookstore Management System!\n");
        bookInventory.add(new Book("Harry Potter", 17.99, bookOrderNum));
        incrementBookOrderNum();
        bookInventory.add(new Book("Fifty Shades of Grey", 15.99, bookOrderNum));
        incrementBookOrderNum();
        bookInventory.add(new Book("Twilight", 10.99, bookOrderNum));
        incrementBookOrderNum();
        bookInventory.add(new Book("Life of Pi", 14.99, bookOrderNum));
        incrementBookOrderNum();
        cdInventory.add(new CD("Thriller", 2.99, cdOrderNum));
        incrementCDOrderNum();
        cdInventory.add(new CD("Back in black", 1.99, cdOrderNum));
        incrementCDOrderNum();
        cdInventory.add(new CD("The Bodygaurd", 2.49, cdOrderNum));
        incrementCDOrderNum();
        dvdInventory.add(new DVD("TOP GUN:MAVERICK", 19.99, dvdOrderNum));
        incrementDVDOrderNum();
        dvdInventory.add(new DVD("DOCTOR STRANGE" , 16.99, dvdOrderNum));
        incrementDVDOrderNum();
        dvdInventory.add(new DVD("SPIDER MAN", 15.99, dvdOrderNum));
        incrementDVDOrderNum();
        memberInventory.add(new Member("John", "4343 road", "John@yahoo.com", memberID));
        incrementMemberID();
        memberInventory.add(new Member("smith", "5431 road", "Smith@yahoo.com", memberID));
        incrementMemberID();
        memberInventory.add(new Member("Ryan", "8593 road", "Ryan@yahoo.com", memberID));
        incrementMemberID();
        PremiumMemberInventory.add(new PremiumMember("Taylor", "3234 road", "Taylor@yahoo.com", premiumMemberID));
        incrementPremiumMemberID();
        PremiumMemberInventory.add(new PremiumMember("Bryan", "8649 road", "Bryan@yahoo.com", premiumMemberID));
        incrementPremiumMemberID();
        PremiumMemberInventory.add(new PremiumMember("Logan", "5632 road", "Logan@yahoo.com", premiumMemberID));
        incrementPremiumMemberID();
    }
    
    public void Purchase(int type, int orderNum){ //Method that allows user to purchase a product
        if(type == 1){
            for(int i = 0 ; i < bookInventory.size(); i++){
                if(bookInventory.get(i).getBookOrderNum() == orderNum){
                    System.out.println(bookInventory.get(i).getBookName() + " added to cart");
                    itemsInCart++;
                    total += bookInventory.get(i).getBookPrice();
                    bookInventory.remove(bookInventory.get(i));
                }
            }
        }

        if(type == 2){ 
            for(int i = 0 ; i < cdInventory.size(); i++){
                if(cdInventory.get(i).getCDOrderNum() == orderNum){
                    System.out.println(cdInventory.get(i).getCDName() + " added to cart");
                    itemsInCart++;
                    total += cdInventory.get(i).getCDPrice();
                     cdInventory.remove(cdInventory.get(i));
                }
            }
        }

        if(type == 3){
            for(int i = 0 ; i < dvdInventory.size(); i++){
                if(dvdInventory.get(i).getDVDOrderNum() == orderNum){
                    System.out.println(dvdInventory.get(i).getDVDName() + " added to cart");
                    itemsInCart++;
                    total += dvdInventory.get(i).getDVDPrice();
                    dvdInventory.remove(dvdInventory.get(i));
                }
            }
        }
    }
    
    public void checkInventory() { //method that allows user to check inventory
        System.out.println("Book(s): " + bookInventory.size());
        System.out.println("DVD(s): " + cdInventory.size());
        System.out.println("DVD(s): " + dvdInventory.size());
    }

    public void addMember(String name, String Address, String email){ //method that allows user to enroll as a member
        memberInventory.add(new Member(name, Address, email, memberID));
        System.out.println("Success! you are now a Book Store Member, " + name + ". Your ID is " + memberID + ". Make Sure to store this number because you will need it for verification!");
        incrementMemberID();
    }
    
    public void addPremiumMember(String name, String Address, String email){ // method that allows user to enroll as a premium member
        PremiumMemberInventory.add(new PremiumMember(name, Address, email, premiumMemberID));
        System.out.println("Success! you are now a Book Store Premium Memeber, " + name + ". Your ID is " + premiumMemberID + ". Make Sure to store this number because you will need it for verification!");
        incrementPremiumMemberID();
    }

    public boolean isMember(int memberID){ // Method that verifies If user is a member.
        for(Member i : memberInventory){
            if(i.getMemberID() == memberID){
                System.out.println("purchase successful, " + i.getMemberName());
                return true;
            }
        }
        System.out.println("Invalid ID. Purchase failed.");
        return false; 
    }

    public boolean isPremiumMember(int premiumMemberID){ //method that verifies if user is a premium member
        for(PremiumMember i : PremiumMemberInventory){
            if(i.getMemberID() == premiumMemberID){
                System.out.println("5% discount applied. Your new total is $" + applyDiscount(getTotal()) + ".");
                System.out.println("Purchase Sucessful. Thanks for being a member, " + i.getName());
                return true;
            }
        }
        System.out.println("Invalid ID. Purchase failed.");
        return false;
    }
    
    public void getBookInventory(){ //Getter for Book list
        for(Book i : bookInventory){
            if(bookInventory.size()>0){
            System.out.println(i.getBookOrderNum() + "." + i.getBookName() + "-$" + i.getBookPrice());
            }
            // else if(bookInventory.size() <= 0 ){
            //     System.out.println("All our books are currently out of stock;/");
            // }
        }
    }

    public void getCDInventory(){ //Getter for CD list
        for(CD i : cdInventory){
            System.out.println(i.getCDOrderNum() + "." + i.getCDName() + "-$" + i.getCDPrice());
        }
    }

    public void getDVDInventory(){ //Getter for DVD list
        for(DVD i : dvdInventory){
            System.out.println(i.getDVDOrderNum() + "." + i.getDVDName() + "-$" + i.getDVDPrice());
        }
    }

    public double applyDiscount(double total){ //Method that applies discount to total 
        double discount = (total *.05);
        double newTotal = total -= discount;
        return newTotal;
    }
    
    private void incrementBookOrderNum(){ //Method that increments BookOrderNum by 1
        bookOrderNum++;
    }

    private void incrementCDOrderNum() { //Method that increments CDOrderNum by 1
       cdOrderNum++;
    }

    private void incrementDVDOrderNum(){ //Method that increments DVDOrderNum by 1
       dvdOrderNum++;
    }

    private void incrementMemberID(){ //Method that increments MemberID by 1
        memberID++;
    }

    private void incrementPremiumMemberID(){ //Method that increments PremiumMemberID by 1
        premiumMemberID++;
    }

    public int getItemsInCart(){ // Getter for Items in cart
        return itemsInCart;
    }

    public void setItemsInCart(int itemsInCart){ //Setter for items in cart
        this.itemsInCart = itemsInCart;
    }

    public double getTotal(){ //Getter for the total price
        return total;
    }

    public void setTotal(double total){ //Setter for the total price
        this.total = total;
    }
}
