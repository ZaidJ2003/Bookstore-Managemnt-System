import java.util.ArrayList;
import java.lang.Math;

public class Bookstore {

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
    private boolean bookEmpty = false;
    private boolean cdEmpty = false;
    private boolean dvdEmpty = false;
    private ArrayList<Book> bookTracker = new ArrayList<>();
    private ArrayList<CD> cdTracker = new ArrayList<>();
    private ArrayList<DVD> dvdTracker = new ArrayList<>();

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
        memberInventory.add(new Member("John", "4343 road", "John@yahoo.com", memberID, 0));
        incrementMemberID();
        memberInventory.add(new Member("smith", "5431 road", "Smith@yahoo.com", memberID,0));
        incrementMemberID();
        memberInventory.add(new Member("Ryan", "8593 road", "Ryan@yahoo.com", memberID,0));
        incrementMemberID();
        PremiumMemberInventory.add(new PremiumMember("Taylor", "3234 road", "Taylor@yahoo.com", premiumMemberID,"4a53", true,0));
        incrementPremiumMemberID();
        PremiumMemberInventory.add(new PremiumMember("Bryan", "8649 road", "Bryan@yahoo.com", premiumMemberID,"5a43",true, 0));
        incrementPremiumMemberID();
        PremiumMemberInventory.add(new PremiumMember("Logan", "5632 road", "Logan@yahoo.com", premiumMemberID,"14@4",true ,0));
        incrementPremiumMemberID();
    }
    
    public void Purchase(int type, int orderNum){ //Method that allows user to purchase a product
        if(type == 1){
            for(int i = 0 ; i < bookInventory.size(); i++){
                if(bookInventory.get(i).getBookOrderNum() == orderNum){
                    System.out.println(bookInventory.get(i).getBookName() + " added to cart");
                    itemsInCart++;
                    total += bookInventory.get(i).getBookPrice();
                    bookTracker.add(bookInventory.get(i));
                }
            }
        }

        if(type == 2){ 
            for(int i = 0 ; i < cdInventory.size(); i++){
                if(cdInventory.get(i).getCDOrderNum() == orderNum){
                    System.out.println(cdInventory.get(i).getCDName() + " added to cart");
                    itemsInCart++;
                    total += cdInventory.get(i).getCDPrice();
                    cdTracker.add(cdInventory.get(i));
                }
            }
        }

        if(type == 3){
            for(int i = 0 ; i < dvdInventory.size(); i++){
                if(dvdInventory.get(i).getDVDOrderNum() == orderNum){
                    System.out.println(dvdInventory.get(i).getDVDName() + " added to cart");
                    itemsInCart++;
                    total += dvdInventory.get(i).getDVDPrice();
                    dvdTracker.add(dvdInventory.get(i));
                }
            }
        }
    }
    
    public void removeBookItem(int bookOrderNum){ //method that removes bookItem from bookInventory
        for(int i = 0; i<bookInventory.size(); i++){
            if(bookInventory.get(i).getBookOrderNum() == bookOrderNum){
                bookInventory.remove(i);
            }
        }
    }

    public void removeCDItem(int cdOrderNum){ //method that removes cdItem from cdInventory
        for(int i = 0; i<cdInventory.size(); i++){
            if(cdInventory.get(i).getCDOrderNum() == cdOrderNum){
                cdInventory.remove(i);
            }
        }
    }

    public void removeDVDItem(int dvdOrderNum){ //method that removes dvdItem from dvdInventory
        for(int i = 0; i<dvdInventory.size(); i++){
            if(dvdInventory.get(i).getDVDOrderNum() == dvdOrderNum){
                dvdInventory.remove(i);
            }
        }
    }

    public void addBookItem(int bookOrderNum){ //method that adds bookItem to bookInventory
        for(int i = 0; i<bookInventory.size(); i++){
            if(bookInventory.get(i).getBookOrderNum() == bookOrderNum){
                bookInventory.add(bookInventory.get(i));
            }
        }
    }

    public void addCDItem(int cdOrderNum){ //method that adds cdItem to cdInventory
        for(int i = 0; i<cdInventory.size(); i++){
            if(cdInventory.get(i).getCDOrderNum() == cdOrderNum){
                cdInventory.add(cdInventory.get(i));
            }
        }
    }
    
    public void addDVDItem(int dvdOrderNum){ //method that adds dvdItem to dvdInventory
        for(int i = 0; i<dvdInventory.size(); i++){
            if(dvdInventory.get(i).getDVDOrderNum() == dvdOrderNum){
                dvdInventory.add(dvdInventory.get(i));
            }
        }
    }

    public void addBookTrackerItem(int bookOrderNum){ //adds book item added to cart to bookTracker list
        for(int i = 0; i<bookInventory.size(); i++){
            if(bookInventory.get(i).getBookOrderNum() == bookOrderNum){
                bookTracker.add(bookInventory.get(i));
            }
        }
    }

    public void addCDTrackerItem(int cdOrderNum){ //adds cd item added to cart to cdTracker list
        for(int i = 0; i<cdInventory.size(); i++){
            if(cdInventory.get(i).getCDOrderNum() == cdOrderNum){
                cdTracker.add(cdInventory.get(i));
            }
        }
    }

    public void addDVDTrackerItem(int dvdOrderNum){ //adds dvd item added to cart to dvdTracker list
        for(int i = 0; i<dvdInventory.size(); i++){
            if(dvdInventory.get(i).getDVDOrderNum() == dvdOrderNum){
                dvdTracker.add(dvdInventory.get(i));
            }
        }
    }

    public void addAllToBook(){ //Method that adds all elemnts of Booktracker list to dvdInevntory list
        if(bookTracker.size()>0){
            for(int i = 0; i<bookTracker.size(); i++){
                bookInventory.add(bookTracker.get(i));
            }
        }
    }

    public void addAllToCD(){ //Method adds all elemnts of cdTracker list to cdInevntory list
        if(cdTracker.size() >0){
            for(int i = 0; i<cdTracker.size(); i++){
                cdInventory.add(cdTracker.get(i));
            }
        }
    }

    public void addAllToDVD(){ //Method adds all elemnts of dvdTracker list to dvdInevntory list
        if(dvdTracker.size() > 0){
            for(int i = 0; i<dvdTracker.size(); i++){
                dvdInventory.add(dvdTracker.get(i));
            }
        }
    }

    public void resetBookTracker(){ //Method removes all elements in booktracker list 
        for(int i = 0; i<bookTracker.size(); i++){
            bookTracker.remove(i);
        }
    }

    public void resetCDTracker(){ //Method removes all elements in cdtracker list 
        for(int i = 0; i<cdTracker.size(); i++){
            cdTracker.remove(i);
        }
    }

    public void resetDVDTracker(){ //Method removes all elements in dvdtracker list 
        for(int i = 0; i<dvdTracker.size(); i++){
            dvdTracker.remove(i);
        }
    }

    public void checkInventory() { //Method that allows user to check inventory
        System.out.println("Book(s): " + bookInventory.size());
        System.out.println("CD(s): " + cdInventory.size());
        System.out.println("DVD(s): " + dvdInventory.size());
    }

    public void addMember(String name, String Address, String email, double totalSpending){ //Method that allows user to enroll as a member
        memberInventory.add(new Member(name, Address, email, memberID, totalSpending));
        System.out.println("Success! you are now a Book Store Member, " + name + ". Your ID is " + memberID + ". Make Sure to store this number because you will need it for verification!");
        System.out.println("Total money spent: " + totalSpending);
        incrementMemberID();
    }
    
    public void addPremiumMember(String name, String Address, String email, String cardInfo, boolean MonthlyFeePaid ,double totalSpending){ // Method that allows user to enroll as a premium member
        PremiumMemberInventory.add(new PremiumMember(name, Address, email, premiumMemberID, cardInfo , MonthlyFeePaid, totalSpending));
        System.out.println("Success! you are now a Book Store Premium Memeber, " + name + ". Your ID is " + premiumMemberID + ". Make Sure to store this number because you will need it for verification!");
        System.out.println("Your monthly fee has been paid.");
        if(itemsInCart > 0){
        System.out.println("Your total for the items purchased is $" + total + ", billed to your card: " + cardInfo + ". Thanks for shopping!");
        }
        System.out.println("Total money spent: $" + totalSpending);
        incrementPremiumMemberID();
    }

    public boolean isMember(int memberID){ // Method that verifies If user is a member.
        for(Member i : memberInventory){
            if(i.getMemberID() == memberID){
                System.out.println("purchase successful, " + i.getMemberName());
                i.setTotalSpending(total);
                System.out.println("Total money spent at Bookstore: $" + i.getTotalSpending());
                return true;
            }
        }
    return false; 
    }

    public boolean isPremiumMember(int premiumMemberID){ //Method that verifies if user is a premium member
        for(PremiumMember i : PremiumMemberInventory){
            if(i.getPremiumMemberID() == premiumMemberID){
                System.out.println("5% discount applied. Your new total is $" + applyDiscount(getTotal()) + ". This total will be billed to your card stored in the system. (Card info:" + i.getCardInfo() + ")");
                System.out.println("Purchase Sucessful. Thanks for being a member, " + i.getName());
                i.setTotalSpending(total);
                System.out.println("Your monthly fee for this month has already been paid.");
                System.out.println("Total money spent at Bookstore: " + i.getTotalSpending());
                return true;
            }
        }
    return false;
    }
    
    public void getBookInventory(){ //Getter for Book list
        if(bookInventory.size()>0){
            for(Book i : bookInventory){
                System.out.println(i.getBookOrderNum() + "." + i.getBookName() + "-$" + i.getBookPrice());
            }
        }
        else{     
            System.out.println("All our books are currently out of stock:/ All items removed from cart");
            bookEmpty = true;
        }
    }

    public void getCDInventory(){ //Getter for CD list
        if(cdInventory.size()>0){
            for(CD i : cdInventory){
            System.out.println(i.getCDOrderNum() + "." + i.getCDName() + "-$" + i.getCDPrice());
            }
        }
        else{     
            System.out.println("All our CDs are currently out of stock:/ All items removed from cart.");
            cdEmpty = true;
        }
    }

    public void getDVDInventory(){ //Getter for DVD list
        if(dvdInventory.size()>0){
            for(DVD i : dvdInventory){
            System.out.println(i.getDVDOrderNum() + "." + i.getDVDName() + "-$" + i.getDVDPrice());
            }
        }
        else{
            System.out.println("All our DVDs are currently out of stock:/ All items removed from cart.");
            dvdEmpty = true;
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
        return Math.round(total*100.0)/100.0;
    }

    public void setTotal(double total){ //Setter for the total price
        this.total = total;
    }
    public boolean getBookEmpty(){ //Method that returns bookEmpty
        return bookEmpty;
    }

    public void setBookEmpty(){ //Method that sets bookEmpty to false
        bookEmpty = false;
    }
    
    public boolean getCDEmpty(){ //Method that returns cdEmpty
        return cdEmpty;
    }
    
    public void setCDEmpty(){ //Method that sets cdEmpty to false
        cdEmpty = false;
    }

    public boolean getDVDEmpty(){ //Method that returns dvdEmpty
        return dvdEmpty;
    }

    public void setDVDEmpty(){ //Method that sets dvdEmpty to false
        dvdEmpty = false;
    }
}
