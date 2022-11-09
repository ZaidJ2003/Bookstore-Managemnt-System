import java.util.Scanner;

public class main { 

    private static Bookstore obj = new Bookstore();
    private static Scanner scanner = new Scanner(System.in);
    private static int book = 0;
    private static int cd = 0;
    private static int dvd = 0;

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
        System.out.println("Would you like to enroll as a member?\n1. Yes\n2. No");
        int decision = scanner.nextInt();
            if(decision == 1){
                System.out.println("Awesome! Would you like to sign up as a member(free, access to occosional copouns), or a premium member($10.99, Discounts on every single purchase!)\n1. Member\n2. Premium member");
                int a = scanner.nextInt();
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
                    }
            }
            else{
                removeDecider();
                System.out.println("Purchase Successful.");
            }
    }

    private static void option1() {
        loop2: while(true){
        System.out.println("What would you like to purchase?");
        System.out.println("1. Book(s)\n2. CD(s)\n3. DVD(s)");
        int item = scanner.nextInt();
        if(item == 1){
            System.out.println("We have the following books in stock: ");
            obj.productDisplay(1);
            if(obj.getBookEmpty()){
                addDecider();
                break loop2;
            }
            System.out.println("Which one would you like to purchase?");
            book = scanner.nextInt();
            obj.Purchase(book);
            System.out.println("You have " + obj.getItemsInCart() + " item(s) in your cart. Do you want to add another item?\n1. Yes\n2. No"); 
            int response = scanner.nextInt();
            scanner.nextLine();
                if(response == 1){
                    obj.removeProductItem(book);
                } 

                if(response == 2){
                    if(obj.getItemsInCart()==0){
                        System.out.println("Failed. 0 items in cart");
                        break loop2;
                    }
                    System.out.println("Your total is $" + obj.getTotal() + ". Are you a registered member?\n1. Yes\n2. No");
                    int input = scanner.nextInt();
                    if(input == 1){
                        loop4: while(true){
                            System.out.println("Please enter your member ID");
                            int memberID = scanner.nextInt();
                                if(obj.isMember(memberID)){
                                    obj.removeProductItem(book);
                                    break loop4;
                                }  
                                else{
                                    System.out.println("Invalid ID.\n1. Try again\n2. Exit");
                                    int b = scanner.nextInt();
                                    if(b == 1);
                                    else if(b == 2){
                                        obj.removeProductItem(book);
                                        addDecider();
                                        break loop4;
                                    }
                                }
                        }
                    }
                    else if(input == 2){
                        memberDisplay();
                    }
                break loop2;
                }    
        }
        if(item == 2){
            System.out.println("We have the following CD(s) in stock: ");
            obj.productDisplay(2);
            if(obj.getCDEmpty()){
                addDecider();
                break loop2;
            }
            System.out.println("Which one would you like to purchase?");
            cd = scanner.nextInt();
            obj.Purchase(cd);
            System.out.println("You have " + obj.getItemsInCart() + " item(s) in your cart. Do you want to add another item?\n1. Yes\n2. No"); //
            int response = scanner.nextInt();
            scanner.nextLine();
            if(response == 1){
                obj.removeProductItem(cd);
            } 
            else if(response == 2){ 
                System.out.println("Your total is $" + obj.getTotal() + ". Are you a registered member?\n1. Yes\n2. No");
                int input = scanner.nextInt();
                    if(input == 1){
                        loop4: while(true){
                            System.out.println("Please enter your member ID");
                            int memberID = scanner.nextInt();
                                if(obj.isMember(memberID)){
                                    obj.removeProductItem(cd);
                                    break loop4;
                                }  
                                else{
                                    System.out.println("Invalid ID.\n1. Try again\n2. Exit");
                                    int b = scanner.nextInt();
                                    if(b == 1);
                                    else if(b == 2){
                                        obj.removeProductItem(cd);
                                        addDecider();
                                        break loop4;
                                    }
                                }
                        }
                    }
                    else if(input == 2){
                        memberDisplay();
                    }
                break loop2;
                } 
        }
        
        if(item == 3){
            System.out.println("We have the following DVD(s) in stock: ");
            obj.productDisplay(3);
            if(obj.getDVDEmpty()){
                addDecider();
                break loop2;
            }
            System.out.println("Which one would you like to purchase?");
            dvd = scanner.nextInt();
            obj.Purchase(dvd);
            System.out.println("You have " + obj.getItemsInCart() + " item(s) in your cart. Do you want to add another item?\n1. Yes\n2. No"); //
            int response = scanner.nextInt();
            scanner.nextLine();
                if(response == 1){
                    obj.removeProductItem(dvd);
                } 
                if(response == 2){ 
                    System.out.println("Your total is $" + obj.getTotal() + ". Are you a registered member?\n1. Yes\n2. No");
                    int input = scanner.nextInt();
                    if(input == 1){
                        loop4: while(true){
                            System.out.println("Please enter your member ID");
                            int memberID = scanner.nextInt();
                                if(obj.isMember(memberID)){
                                    obj.removeProductItem(dvd);
                                    break loop4;
                                }  
                                else{
                                    System.out.println("Invalid ID.\n1. Try again\n2. Exit");
                                    int b = scanner.nextInt();
                                    if(b == 1);
                                    else if(b == 2){
                                        obj.removeProductItem(dvd);
                                        addDecider();
                                        break loop4;
                                    }
                                }
                        }
                    }
                    else if(input == 2){
                        memberDisplay();
                    }
                break loop2;
                } 
        }   
    }
}

    private static void option4() {
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
                System.out.println("Thanks! Your total for today is $10.99.\n1. Confirm\n2. Cancel");
                int confirm = scanner.nextInt();
                if(confirm == 1){
                    obj.addPremiumMember(name, Address, email,cardInfo, true ,0);
                }
                else{
                    System.out.println("Cancelled.");
                }
            }
            else{
                System.out.println("Cancelled");
            }
    }

    private static void option3() {
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

    public static void main(String[] args) {
        while(true){
            book = 0; cd = 0; dvd = 0; obj.resetProductTracker(); obj.resetBookEmpty(); obj.resetCDEmpty(); 
            obj.resetDVDEmpty(); obj.setTotal(0.0); obj.setItemsInCart(0); obj.initializeValues();

            System.out.println("What would you like to do?\n\n1. Purchase a product \n2. Check inventory \n3. Register a new Member\n4. Register a new premium member\n5. Check inventory value\n6. Restock product \n5. Exit");
            int output = scanner.nextInt();

            if(output == 1){
                option1();  
            }
            
            else if(output == 2){
                obj.checkInventory();
            }

            else if(output == 3){
                option3();
            }

            else if(output == 4){
                option4();
            }

            else if(output == 5){
                System.out.println("Have a good day!");
                break;
            }
        }
    }
}

