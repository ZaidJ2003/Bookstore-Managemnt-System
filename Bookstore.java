import java.util.ArrayList;
import java.util.Collections;
import java.lang.Math;
import java.io.*;
import java.util.Scanner;

public class Bookstore implements BookStoreSpecification{

    private ArrayList<Product> productInventory = new ArrayList<>();
    private ArrayList<Member> memberInventory = new ArrayList<>();    
    private int memberID = 1;
    private int itemsInCart;
    private double total;
    private boolean bookEmpty = false;
    private boolean cdEmpty = false;
    private boolean dvdEmpty = false;
    private ArrayList<Product> productTracker = new ArrayList<>();
    private ArrayList<Product> productTrackerReport = new ArrayList<>();
    private int books;
    private int cds;
    private int dvds;
    private int members;
    private int premMembers;

    public Bookstore() { //Adds values in each list
        System.out.println("Welcome to The Bookstore Management System!\n");
        generateMembers();
        try{
        populateInventory();
        }catch(FileNotFoundException e){
            System.out.println("File not found.");
        }
    }

    private void generateMembers(){ //Method that generates default members
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
    private void populateInventory() throws FileNotFoundException{ //method that reads data from file and places them in arraylist
        Scanner fileScanner = new Scanner(new File("/Users/zaid_jebril/Desktop/ProductInventory.csv"));
        while (fileScanner.hasNext()) {
            String line = fileScanner.nextLine();
            if (line.contains("book") || line.contains("cd") || line.contains("dvd")){
                String[] lineArray = line.split(",");
                String name = lineArray[2];
                String author = lineArray[3];
                double price = Double.parseDouble(lineArray[5]);
                int orderNum = Integer.parseInt(lineArray[0]);
                int stock = Integer.parseInt(lineArray[4]);
                if(line.contains("book")){
                    Product obj = new Book(name, author, price, orderNum, stock, 1);
                    productInventory.add(obj);
                }
                else if(line.contains("cd")){
                    Product obj = new CD(name, author, price, orderNum, stock, 1);
                    productInventory.add(obj);                   
                }
                else{
                    Product obj = new DVD(name, author, price, orderNum, stock, 1);
                    productInventory.add(obj);
                }
            }
        }
    }

    public void generateEndOfDayReport() throws IOException{ //Method that generates an end of day report file
        FileOutputStream fs = new FileOutputStream("EndOfDayReport.txt");
        PrintWriter pw = new PrintWriter(fs);
        double total = 0.0;

        pw.println("End of Day Report: ");
        pw.println("products purchased:");
        
        for (Product i: productTrackerReport) {
            pw.println(i.getBought() + " copies of " + i.getClass() + " " + i.getName());
            total += (i.getBought() * i.getPrice());
        }

        pw.println("Number of new members registered:\nmembers: " + members + "\npremium members: " + premMembers);
        pw.println("Total sales: $" + total);
        
        pw.close();
        fs.close();
    }

    public void generateBookInventoryDay2() throws IOException{ //method that generates an inventory for the next day
        FileOutputStream fs = new FileOutputStream("BookInventoryDay2.csv");
        PrintWriter pw = new PrintWriter(fs);

        pw.println("product ID Type title author/artist numInStock Price");
        for(Product i : productInventory){
            pw.println(i.getOrderNum() + "," + i.getName() + "," + i.getAuthor() + "," + i.getStock() + "," + i.getPrice());
        }
        
        pw.close();
        fs.close();
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
    
    public void resetProductTracker(){ //Method that removes all elements in productTracker list and places them in a different list for end of day report
        for(Product s : productTracker){
            if(productTrackerReport.contains(s)){
                s.incrementBought();
            }
            else{
            productTrackerReport.add(s);
            }
        }

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
                    restockProduct(productTracker.get(i).getOrderNum(), productTracker.get(i).getStock()+1);
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
        members++;
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
        premMembers++;
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
    public void restockProduct(int id, int stock) { //Method that restocks products if out of stock
        for(Product i : productInventory){
            if(i.getOrderNum() == id){
                i.setStock(stock);
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
