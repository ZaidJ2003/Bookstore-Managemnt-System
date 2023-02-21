import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class main { 

    private static Bookstore obj = new Bookstore();
    private static Scanner scanner = new Scanner(System.in);
    private static int book = 0;
    private static int cd = 0;
    private static int dvd = 0;
    private static String errorMsg = "Invalid input. Try again.";

    private static void removeDecider(){ //method that removes item from appropriate list
        if(book != 0){
            obj.removeProductItem(book);
        }
        if(cd != 0){
            obj.removeProductItem(cd);
        }
        if(dvd != 0){
            obj.removeProductItem(dvd);
        }
    }

    private static void addDecider(){ //method that returns elements to appropriate list if user cancels transaction
        if(book != 0 || cd!=0 || dvd!=0)
            obj.addAllToProduct();
    }

    private static void memberDisplay(){ //method that prints member display to avoid repetition
        int decision = 0;
        while(true){
            try{
            System.out.println("Would you like to enroll as a member?\n1. Yes\n2. No");
            decision = scanner.nextInt();
            break;
            }
            catch(InputMismatchException e){
                System.out.println(errorMsg);
                scanner.nextLine();
            }
        }
        if(decision == 1){
            int a = 0;
                while(true){
                    try{
                    System.out.println("Awesome! Would you like to sign up as a member(free, access to occosional copouns), or a premium member($10.99, Discounts on every single purchase!)\n1. Member\n2. Premium member");
                    a = scanner.nextInt();
                    break;
                    }
                    catch(InputMismatchException e){
                        System.out.println(errorMsg);
                        scanner.nextLine();
                    }
                }
                if(a == 1){
                    System.out.println("Please fill out the information below:");
                    System.out.println("Full name:");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    System.out.println("Address:");
                    String Address = scanner.nextLine();
                    System.out.println("Email:");
                    String email = scanner.nextLine();
                    obj.addMember(name, Address, email, obj.getTotal());
                    removeDecider();
                    System.out.println("Purchase Successful.");
                }
                else if(a == 2){
                    while(true){
                        try{
                            System.out.println("Great! Please fill out the information below:");
                            System.out.println("Full name:");
                            scanner.nextLine();
                            String name = scanner.nextLine();
                            System.out.println("Address:");
                            String Address = scanner.nextLine();
                            System.out.println("Email:");
                            String email = scanner.nextLine();
                            System.out.println("Card info:");
                            String cardInfo = scanner.nextLine();
                            System.out.println("Thanks! Your total is $10.99.\n1. Confirm\n2. Cancel");
                            int confirm = scanner.nextInt();
                                if(confirm == 1){
                                    obj.addPremiumMember(name, Address, email, cardInfo , true ,obj.getTotal());
                                    removeDecider();
                                }
                                else{
                                    if(obj.getItemsInCart()>1){
                                        removeDecider();
                                        addDecider();
                                    }
                                System.out.println("Cancelled.");
                                }
                            break;
                        }
                        catch(InputMismatchException e){
                            System.out.println(errorMsg);
                            scanner.nextLine();
                        }
                    }
                }
        }
        else{
            removeDecider();
            System.out.println("Purchase Successful.");
        }
    }

    private static void option1(){ //Method for option1: purchase a product
        loop1: while(true){
        System.out.println("What would you like to purchase?");
        System.out.println("1. Book(s)\n2. CD(s)\n3. DVD(s)");
        int item = scanner.nextInt();
        if(item == 1){
            loop3: while(true){
                try{
                    System.out.println("We have the following books in stock: ");
                    obj.productDisplay(1);
                    if(obj.getBookEmpty()){
                        addDecider();
                        break loop1;
                    }
                    System.out.println("Which one would you like to purchase?");
                    book = scanner.nextInt();
                    obj.Purchase(book);
                break loop3;
                }
                catch(InputMismatchException e){
                    System.out.println(errorMsg);
                    scanner.nextLine();
                }
            }
            loop4: while(true){
                try{
                    System.out.println("You have " + obj.getItemsInCart() + " item(s) in your cart. Do you want to add another item?\n1. Yes\n2. No"); 
                    int response = scanner.nextInt();
                        if(response == 1){
                            obj.removeProductItem(book);
                        } 

                        if(response == 2){
                            int input = 0;
                            loop10: while(true){
                                if(obj.getItemsInCart()==0){
                                    System.out.println("Failed. 0 items in cart");
                                    break loop1;
                                }
                                try{
                                System.out.println("Your total is $" + obj.getTotal() + ". Are you a registered member?\n1. Yes\n2. No");
                                input = scanner.nextInt();
                                break loop10;
                                }
                                catch(InputMismatchException e){
                                    System.out.println(errorMsg);
                                    scanner.nextLine();
                                }
                            }
                            if(input == 1){
                                loop11: while(true){
                                    try{
                                    System.out.println("Please enter your member ID");
                                    int memberID = scanner.nextInt();
                                        if(obj.isMember(memberID)){
                                            obj.removeProductItem(book);
                                            break loop11;
                                        }
                                        else{
                                            System.out.println("Invalid ID.\n1. Try again\n2. Exit");
                                            int b = scanner.nextInt();
                                            if(b == 1);
                                            else if(b == 2){
                                                obj.removeProductItem(book);
                                                addDecider();
                                                break loop11;
                                            }
                                        }
                                    }
                                    catch(InputMismatchException e){
                                        System.out.println(errorMsg);
                                        scanner.nextLine();
                                    }  
                                }
                            }
                            else if(input == 2){
                                while(true){    
                                    try{
                                    memberDisplay();
                                    break;
                                    }
                                    catch(InputMismatchException e){
                                        System.out.println(errorMsg);
                                        scanner.nextLine();
                                    }
                                }
                            }
                        break loop1;
                        }
                    break loop4;
                }  
                catch(InputMismatchException e){
                    System.out.println(errorMsg);
                    scanner.nextLine();
                }  
            }
        }
        if(item == 2){
            loop5:while(true){
                try{
                    System.out.println("We have the following CD(s) in stock: ");
                    obj.productDisplay(2);
                    if(obj.getCDEmpty()){
                        addDecider();
                        break loop1;
                    }
                    System.out.println("Which one would you like to purchase?");
                    cd = scanner.nextInt();
                    obj.Purchase(cd);
                break loop5;
                }
                catch(InputMismatchException e){
                    System.out.println("input error. Try again");
                    scanner.nextLine();
                }
            }
            loop6: while(true){
                try{
                    System.out.println("You have " + obj.getItemsInCart() + " item(s) in your cart. Do you want to add another item?\n1. Yes\n2. No"); //
                    int response = scanner.nextInt();
                    scanner.nextLine();
                    if(response == 1){
                        obj.removeProductItem(cd);
                    } 
                    else if(response == 2){ 
                        int input = 0;
                        loop12: while(true){
                            try{
                            System.out.println("Your total is $" + obj.getTotal() + ". Are you a registered member?\n1. Yes\n2. No");
                            input = scanner.nextInt();
                            break loop12;
                            }
                            catch(InputMismatchException e){
                                System.out.println(errorMsg);
                                scanner.nextLine();
                            }
                        }
                            if(input == 1){
                                loop13: while(true){
                                    try{
                                        System.out.println("Please enter your member ID");
                                        int memberID = scanner.nextInt();
                                            if(obj.isMember(memberID)){
                                                obj.removeProductItem(cd);
                                                break loop13;
                                            }  
                                            else{
                                                System.out.println("Invalid ID.\n1. Try again\n2. Exit");
                                                int b = scanner.nextInt();
                                                if(b == 1);
                                                else if(b == 2){
                                                    obj.removeProductItem(cd);
                                                    addDecider();
                                                    break loop13;
                                                }
                                            }
                                    }
                                    catch(InputMismatchException e){
                                        System.out.println(errorMsg);
                                        scanner.nextLine();
                                    }
                                }
                            }
                            else if(input == 2){
                                memberDisplay();
                            }
                        break loop1;
                    } 
                break loop6;
                }
                catch(InputMismatchException e){
                    System.out.println(errorMsg);
                    scanner.nextLine();
                }
            }
    }
        
        if(item == 3){
            loop7:while(true){
                try{
                    System.out.println("We have the following DVD(s) in stock: ");
                    obj.productDisplay(3);
                    if(obj.getDVDEmpty()){
                        addDecider();
                        break loop1;
                    }
                    System.out.println("Which one would you like to purchase?");
                    dvd = scanner.nextInt();
                    obj.Purchase(dvd);
                break loop7;
                }
                catch(InputMismatchException e){
                    System.out.println(errorMsg);
                    scanner.nextLine();
                }
            }
            loop8: while(true){
                try{
                    System.out.println("You have " + obj.getItemsInCart() + " item(s) in your cart. Do you want to add another item?\n1. Yes\n2. No"); //
                    int response = scanner.nextInt();
                    scanner.nextLine();
                        if(response == 1){
                            obj.removeProductItem(dvd);
                        } 
                        if(response == 2){ 
                            int input = 0;
                            loop15: while(true){
                                try{
                                    System.out.println("Your total is $" + obj.getTotal() + ". Are you a registered member?\n1. Yes\n2. No");
                                    input = scanner.nextInt();
                                    break loop15;
                                }
                                catch(InputMismatchException e){
                                    System.out.println(errorMsg);
                                    scanner.nextLine();
                                }
                            }
                            if(input == 1){
                                loop16: while(true){
                                    try{
                                        System.out.println("Please enter your member ID");
                                        int memberID = scanner.nextInt();
                                            if(obj.isMember(memberID)){
                                                obj.removeProductItem(dvd);
                                                break loop16;
                                            }  
                                            else{
                                                System.out.println("Invalid ID.\n1. Try again\n2. Exit");
                                                int b = scanner.nextInt();
                                                if(b == 1);
                                                else if(b == 2){
                                                    obj.removeProductItem(dvd);
                                                    addDecider();
                                                    break loop16;
                                                }
                                            }
                                    }
                                    catch(InputMismatchException e){
                                        System.out.println(errorMsg);
                                        scanner.nextLine();
                                    }
                                }
                            }
                            else if(input == 2){
                                memberDisplay();
                            }
                        break loop1;
                        } 
                    break loop8;
                }
                catch(InputMismatchException e){
                    System.out.println("Invalid input. Try again.");
                    scanner.nextLine();
                }
            }
        } 
    }
}
    private static void option4() { //Method for option4: Register a new premium member
        System.out.println("The price of becoming a premium member is $10.99 a month. Benefits of being a premium member are: 5% off of every purchase and free shipping on all online purchases.\nWould you like to enroll?\n1. Yes\n2. No");
        int input = scanner.nextInt();
            if(input == 1){
                System.out.println("Great! Please fill out the information below:");
                System.out.println("Full name:");
                scanner.nextLine();
                String name = scanner.nextLine();
                System.out.println("Address:");
                String Address = scanner.nextLine();
                System.out.println("Email:");
                String email = scanner.nextLine();
                System.out.println("Card info: ");
                String cardInfo = scanner.nextLine();
                while(true){
                    try{
                        System.out.println("Thanks! Your total for today is $10.99.\n1. Confirm\n2. Cancel");
                        int confirm = scanner.nextInt();
                        if(confirm == 1){
                            obj.addPremiumMember(name, Address, email,cardInfo, true ,0);
                        }
                        else if(input == 2){
                            System.out.println("Cancelled.");
                        }
                    break;
                    }
                    catch(InputMismatchException e){
                        System.out.println(errorMsg);
                        scanner.nextLine();
                    }
                }
            }
            else if(input == 2){
                System.out.println("Cancelled");
            }
    }

    private static void option3() { // Method for option3: register a new member
        System.out.println("Becoming a member is free. Benefits of being a member include recieving coupons via email.\nWould you like to enroll?\n1. Yes\n2. No");
        int input = scanner.nextInt();
            if(input == 1){
                System.out.println("Great! Please fill out the information below:");
                System.out.println("Full name:");
                scanner.nextLine();
                String name = scanner.nextLine();
                System.out.println("Address:");
                String Address = scanner.nextLine();
                System.out.println("Email:");
                String email = scanner.nextLine();
                obj.addMember(name, Address, email,0);
            }
            else{
                System.out.println("Cancelled");
            }
    }

    public static void main(String[] args)  {
        while(true){
            book = 0; cd = 0; dvd = 0; obj.resetProductTracker(); obj.resetBookEmpty(); obj.resetCDEmpty(); 
            obj.resetDVDEmpty(); obj.setTotal(0.0); obj.setItemsInCart(0); obj.initializeValues();
            int output = 0;
            try{
            System.out.println("What would you like to do?\n\n1. Purchase a product \n2. Check inventory \n3. Register a new Member\n4. Register a new premium member\n5. Check inventory value\n6. Restock product \n7. Exit");
            output = scanner.nextInt();
            }
            catch(InputMismatchException e ){
                System.out.println(errorMsg);
                scanner.nextLine();
            }

            if(output == 1){
                while(true){
                    try{
                        option1();  
                        break;
                    }
                    catch(InputMismatchException e){
                        System.out.println(errorMsg);
                        addDecider();
                        scanner.nextLine();
                    }
                }
            }
            
            else if(output == 2){
                obj.checkInventory();
            }

            else if(output == 3){
                while(true){
                    try{
                        option3();
                        break;
                    }
                    catch(InputMismatchException e){
                        System.out.println("Invalid input.");
                        scanner.nextLine();
                    }
                }
            }

            else if(output == 4){
                while(true){    
                    try{
                        option4();
                        break;
                    }
                    catch(InputMismatchException e){
                        System.out.println("Invalid input.");
                        scanner.nextLine();
                    }
                }
            }

            else if(output == 5){
               System.out.println("Inventory value: $" + obj.inventoryValue()); 
            }

            else if(output == 6){
                int tempID = 0;
                while(true){
                    try{
                    System.out.println("This method changes stock of product to input.\nEnter the product ID that you would like to restock");
                    tempID = scanner.nextInt();
                    break;
                    }
                    catch(InputMismatchException e){
                        System.out.println(errorMsg);
                        scanner.nextLine();
                    }
                }
                while(true){
                    try{
                    System.out.println("Enter the number of stock that you would like to assign to the product.");
                    int stock = scanner.nextInt();
                    obj.restockProduct(tempID, stock);
                    break;
                    }
                    catch(InputMismatchException e){
                        System.out.println("Invalid input.");
                        scanner.nextLine();
                    }
                }
            System.out.println("Success!");
            }

            else if(output == 7){
                System.out.println("Have a good day!");
                try {
                    obj.generateEndOfDayReport();
                    obj.generateBookInventoryDay2();
                }
                catch(IOException e) {
                    System.out.println("error");
                }
                break;
            }
        }
    }
}


