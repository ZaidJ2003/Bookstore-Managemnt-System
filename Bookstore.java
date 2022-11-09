import java.util.ArrayList;
import java.util.Collections;
import java.lang.Math;

public class Bookstore implements BookStoreSpecification{

    private ArrayList<Product> productInventory = new ArrayList<>();
    private ArrayList<Member> memberInventory = new ArrayList<>();    
    private int orderNum = 1;
    private int memberID = 1;
    private int itemsInCart;
    private double total;
    private boolean bookEmpty = false;
    private boolean cdEmpty = false;
    private boolean dvdEmpty = false;
    private ArrayList<Product> productTracker = new ArrayList<>();
    private int books;
    private int cds;
    private int dvds;

    public Bookstore(){ //Adds default values in each list
        System.out.println("Welcome to The Bookstore Management System!\n");
        generateInventory();
        generateMembers();
    }
    

    private void generateInventory(){ //Method that generates defauly products
        productInventory.add(new Book("Harry Potter", 17.99, orderNum, 3));
        incrementOrderNum();
        productInventory.add(new Book("Fifty Shades of Grey", 15.99, orderNum, 3));
        incrementOrderNum();
        productInventory.add(new Book("Twilight", 10.99, orderNum, 3));
        incrementOrderNum();
        productInventory.add(new Book("Life of Pi", 14.99, orderNum, 3));
        incrementOrderNum();
        productInventory.add(new CD("Thriller", 2.99, orderNum, 3));
        incrementOrderNum();
        productInventory.add(new CD("Back in black", 1.99, orderNum, 3));
        incrementOrderNum();
        productInventory.add(new CD("The Bodygaurd", 2.49, orderNum, 3));
        incrementOrderNum();
        productInventory.add(new DVD("TOP GUN:MAVERICK", 19.99, orderNum, 3));
        incrementOrderNum();
        productInventory.add(new DVD("DOCTOR STRANGE" , 16.99, orderNum, 3));
        incrementOrderNum();
        productInventory.add(new DVD("SPIDER MAN", 15.99, orderNum, 3));
        incrementOrderNum();
    }

    private void generateMembers(){ //Method that generates defauly products
        memberInventory.add(new Member("John", "4343 road", "John@yahoo.com", memberID, 0));
        incrementMemberID();
        memberInventory.add(new Member("smith", "5431 road", "Smith@yahoo.com", memberID,0));
        incrementMemberID();
        memberInventory.add(new Member("Ryan", "8593 road", "Ryan@yahoo.com", memberID,0));
        incrementMemberID();
        memberInventory.add(new PremiumMember("Taylor", "3234 road", "Taylor@yahoo.com", memberID,0, "4a53", true));
        incrementMemberID();
        memberInventory.add(new PremiumMember("Bryan", "8649 road", "Bryan@yahoo.com", memberID,0,"5a43",true));
        incrementMemberID();
        memberInventory.add(new PremiumMember("Logan", "5632 road", "Logan@yahoo.com", memberID,0, "14@4",true ));
        incrementMemberID();
    }

    public void Purchase(int orderNum){ //Method that allows user to purchase a product
        for(int i = 0 ; i < productInventory.size(); i++){
            if(productInventory.get(i).getOrderNum() == orderNum){
                    System.out.println(productInventory.get(i).getName() + " added to cart");
                    productInventory.get(i).decrmentStock();
                    itemsInCart++;
                    total += productInventory.get(i).getPrice();
                    productTracker.add(productInventory.get(i));
                }
            }
    }

    public void addProductItem(int orderNum){ //method that adds product to productInventory
        for(int i = 0; i<productInventory.size(); i++){
            if(productInventory.get(i).getOrderNum() == orderNum){
                productInventory.add(productInventory.get(i));
            }
        }
    }
    
    public void removeProductItem(int orderNum){ //method that removes product from productInventory
        for(int i = 0; i < productInventory.size(); i++){
            if(productInventory.get(i).getOrderNum() == orderNum && productInventory.get(i).getStock() == 0){
                productInventory.remove(i);
            }
        }
    }
    
    public void resetProductTracker(){ //Method that removes all elements in productTracker list
        if(!productTracker.isEmpty()){
            productTracker.removeAll(productTracker);
        }

    }

    public void addAllToProduct(){ //Method that adds all elemnts of productTracker list to productInventory list
        if(productTracker.size()>0){ 
            for(int i = 0; i<productTracker.size(); i++){
                if(productInventory.contains(productTracker.get(i))){
                    productInventory.get(productInventory.indexOf(productTracker.get(i))).incrementStock();
                }
                else if(!productInventory.contains(productTracker.get(i))){
                    productInventory.add(productTracker.get(i));
                    restockProduct(productTracker.get(i).getOrderNum(), productTracker.get(i).getPrice());
                }
            }
        }
    }

    public void initializeValues(){ //Method that determines how many instances of each product there is
    books = 0;
    cds = 0;
    dvds = 0;
        for(Product i : productInventory){
            if(i instanceof Book){
                books++;
            }
            else if (i instanceof CD){
                cds++;
            }
            else if(i instanceof DVD){
                dvds++;
            }
        }
    }

    public void checkInventory() { //Method that allows user to check inventory
        initializeValues();
        System.out.println("Book(s): ");
        for(Product i : productInventory){
            if(i instanceof Book && i.getStock()>0){
                System.out.println(i.getName() + " (" + i.getStock() + " in stock)");
            }
        }
        System.out.println("\nCD(s): ");
        for(Product i : productInventory){
            if(i instanceof CD){
                System.out.println(i.getName() + "(" + i.getStock() + " in stock)");
            }
        }
        System.out.println("\nDVD(s):");
        for(Product i : productInventory){
            if(i instanceof DVD){
                System.out.println(i.getName() + " (" + i.getStock() + " in stock)");
            } 
        }
    System.out.println("\nInventory value: $" + inventoryValue());
    }

    public void addMember(String name, String Address, String email, double totalSpending){ //Method that allows user to enroll as a member
        memberInventory.add(new Member(name, Address, email, memberID, totalSpending));
        System.out.println("Success! you are now a Book Store Member, " + name + ". Your ID is " + memberID + ". Make Sure to store this number because you will need it for verification!");
        System.out.println("Total money spent: " + totalSpending);
        incrementMemberID();
    }
    
    public void addPremiumMember(String name, String Address, String email, String cardInfo, boolean MonthlyFeePaid ,double totalSpending){ // Method that allows user to enroll as a premium member
        memberInventory.add(new PremiumMember(name, Address, email, memberID, totalSpending, cardInfo , MonthlyFeePaid));
        System.out.println("Success! you are now a Book Store Premium Memeber, " + name + ". Your ID is " + memberID + ". Make Sure to store this number because you will need it for verification!");
        System.out.println("Your monthly fee has been paid.");
        if(itemsInCart > 0){
        System.out.println("Your total for the items purchased is $" + total + ", billed to your card: " + cardInfo + ". Thanks for shopping!");
        }
        System.out.println("Total money spent: $" + totalSpending);
        incrementMemberID();
    }

    public boolean isMember(int memberID){ // Method that verifies If user is a member.
        for(Member i : memberInventory){
            if(i.getID() == memberID){
                if(i instanceof PremiumMember){
                    System.out.println("5% discount applied. Your new total is $" + applyDiscount(getTotal()) + ". This total will be billed to your card stored in the system. (Card info:" + ((PremiumMember) i).getCardInfo() + ")");
                    System.out.println("Purchase Sucessful. Thanks for being a premium member, " + i.getName());
                    i.setTotalSpending(total);
                    System.out.println("Your monthly fee for this month has already been paid.");
                    System.out.println("Total money spent at Bookstore: " + applyDiscount(i.getTotalSpending()));
                    return true;
                }
                else{
                    System.out.println("purchase successful. Thanks for being a member, " + i.getName());
                    i.setTotalSpending(total);
                    System.out.println("Total money spent at Bookstore: $" + i.getTotalSpending());
                    return true;
                }
            }
        }
    return false; 
    }
    
    public void productDisplay(int type){ //Method that generates display
        if(productInventory.size()>0){
            Collections.sort(productInventory); 
            for(Product i : productInventory){
            initializeValues();
                if(type == 1){
                    if(books == 0){
                        System.out.println("All our books are currently out of stock:/\nAll items removed from cart.");
                        bookEmpty = true;
                        break;
                    }
                    else if(i instanceof Book && i.getStock()>0){
                        System.out.println(i.getOrderNum() + "." + i.getName() + "-$" + i.getPrice() + " (" + i.getStock() + " in stock)");
                    }
                }
                else if(type == 2){
                    if(cds == 0){
                        System.out.println("All our cds are currently out of stock:/\nAll items removed from cart.");
                        cdEmpty = true;
                        break;
                    }
                    else if(i instanceof CD){
                        System.out.println(i.getOrderNum() + "." + i.getName() + "-$" + i.getPrice() + " (" + i.getStock() + " in stock)");
                    }
                }
                else if(type == 3){
                    if(dvds == 0){
                        System.out.println("All our dvds are currently out of stock:/\nAll items removed from cart.");
                        dvdEmpty = true;
                        break;
                    }
                    else if(i instanceof DVD){
                        System.out.println(i.getOrderNum() + "." + i.getName() + "-$" + i.getPrice() + " (" + i.getStock() + " in stock)");
                    } 
                }            
            }
        }
        else{     
            System.out.println("All our products are currently out of stock:/ All items removed from cart");
        }
    }

    public double applyDiscount(double total){ //Method that applies discount to total 
        double discount = (total *.05);
        double newTotal = total -= discount;
        return Math.round(newTotal*100.0)/100.0;
    }
    
    private void incrementOrderNum(){ //Method that increments OrderNum by 1
        orderNum++;
    }

    private void incrementMemberID(){ //Method that increments MemberID by 1
        memberID++;
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

    public void resetBookEmpty(){ //Method that sets bookEmpty to false
        bookEmpty = false;
    }
    
    public boolean getCDEmpty(){ //Method that returns cdEmpty
        return cdEmpty;
    }
    
    public void resetCDEmpty(){ //Method that sets cdEmpty to false
        cdEmpty = false;
    }

    public boolean getDVDEmpty(){ //Method that returns dvdEmpty
        return dvdEmpty;
    }

    public void resetDVDEmpty(){ //Method that sets dvdEmpty to false
        dvdEmpty = false;
    }

    @Override
    public void restockProduct(int id, double price) { //Method that restocks products if out of stock
        for(Product i : productInventory){
            if(i.getOrderNum() == id && i.getPrice() == price){
                i.incrementStock();
            }
        }
    }

    @Override
    public double inventoryValue() { //Method that returns total price of all elements in productList
    double inventoryValue = 0.0;
        for(Product i : productInventory){
           inventoryValue = inventoryValue + i.getPrice();
        }
    return Math.round(inventoryValue*100.0)/100.0;
    }
}
