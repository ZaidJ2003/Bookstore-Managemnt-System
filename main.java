import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Bookstore obj = new Bookstore();
        Scanner scanner = new Scanner(System.in);

        loop1 : while(true){
            System.out.println("What would you like to do?\n1. Purchase a product \n2. Check inventory \n3. Register a new Member\n4. Register a new premium member \n5. Exit");
            int output = scanner.nextInt();
            if(output == 1){
                obj.setTotal(0.0);
                obj.setItemsInCart(0);
                loop2: while(true){
                System.out.println("What would you like to purchase?");
                System.out.println("1. Book(s)\n2. CD(s)\n3. DVD(s)");
                int item = scanner.nextInt();
                if(item == 1){
                    System.out.println("We have the following books in stock: ");
                    obj.getBookInventory();
                    System.out.println("Which one would you like to purchase?");
                    int book = scanner.nextInt();
                    obj.Purchase(1, book);
                    System.out.println("You have " + obj.getItemsInCart() + " item(s) in your cart. Do you want to add another item?\n1. Yes\n2. No");
                    int response = scanner.nextInt();
                    scanner.nextLine();
                        if(response == 1);

                        if(response == 2){
                            System.out.println("Your total is $" + obj.getTotal() + ". Are you a registered member?\n1. Yes\n2. No");
                            int input = scanner.nextInt();
                            if(input == 1){
                            System.out.println("What type of member?\n1.Regular member\n2.Premium member ");
                            int memberType = scanner.nextInt();
                                if(memberType == 2){
                                    System.out.println("Please enter your member ID");
                                    int memberID = scanner.nextInt();
                                    obj.isPremiumMember(memberID);        
                                }
                                if(memberType == 1){
                                    System.out.println("Please enter your member ID");
                                    int memberID = scanner.nextInt();
                                    obj.isMember(memberID);
                                }
                            }
                            else if(input == 2){
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
                                            obj.addMember(name, Address, email);
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
                                            System.out.println("Thanks! Your total for today is $" + (10.99 + obj.getTotal()) + ". (Membership fee + item(s) purchased).\n1. Confirm\n2. Cancel");
                                            int confirm = scanner.nextInt();
                                            if(confirm == 1){
                                                obj.addPremiumMember(name, Address, email);
                                            }
                                            else{
                                                System.out.println("Cancelled.");
                                            }
                                        //System.out.println("");
                                        }
                                    }
                                    else{
                                        System.out.println("Purchase Successful.");
                                    }
                            }
                        break loop2;
                        }    
                }
                if(item == 2){
                    System.out.println("We have the following CD(s) in stock: ");
                    obj.getCDInventory();
                    System.out.println("Which one would you like to purchase?");
                    int cd = scanner.nextInt();
                    obj.Purchase(2, cd);
                    System.out.println("You have " + obj.getItemsInCart() + " item(s) in your cart. Do you want to add another item?\n1. Yes\n2. No");
                    int response = scanner.nextInt();
                    scanner.nextLine();
                    if(response == 1);

                        if(response == 2){
                            System.out.println("Your total is $" + obj.getTotal() + ". Are you a registered member?\n1. Yes\n2. No");
                            int input = scanner.nextInt();
                            if(input == 1){
                            System.out.println("What type of member?\n1.Regular member\n2.Premium member ");
                            int memberType = scanner.nextInt();
                                if(memberType == 2){
                                    System.out.println("Please enter your member ID");
                                    int memberID = scanner.nextInt();
                                    obj.isPremiumMember(memberID);        
                                }
                                if(memberType == 1){
                                    System.out.println("Please enter your member ID");
                                    int memberID = scanner.nextInt();
                                    obj.isMember(memberID);
                                }
                            }
                            else if(input == 2){
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
                                            obj.addMember(name, Address, email);
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
                                            System.out.println("Thanks! Your total for today is $" + (10.99 + obj.getTotal()) + ". (Membership fee + item(s) purchased).\n1. Confirm\n2. Cancel");
                                            int confirm = scanner.nextInt();
                                            if(confirm == 1){
                                                obj.addPremiumMember(name, Address, email);
                                            }
                                            else{
                                                System.out.println("Cancelled.");
                                            }
                                        }
                                    }
                                    else{
                                        System.out.println("Purchase Successful.");
                                    }
                            }
                        break loop2;
                        } 
                }
                
                if(item == 3){
                    System.out.println("We have the following DVD(s) in stock: ");
                    obj.getDVDInventory();
                    System.out.println("Which one would you like to purchase?");
                    int dvd = scanner.nextInt();
                    obj.Purchase(3, dvd);
                    System.out.println("You have " + obj.getItemsInCart() + " item(s) in your cart. Do you want to add another item?\n1. Yes\n2. No");
                    int response = scanner.nextInt();
                    scanner.nextLine();
                    if(response == 1);

                        if(response == 2){
                            System.out.println("Your total is $" + obj.getTotal() + ". Are you a registered member?\n1. Yes\n2. No");
                            int input = scanner.nextInt();
                            if(input == 1){
                            System.out.println("What type of member?\n1.Regular member\n2.Premium member ");
                            int memberType = scanner.nextInt();
                                if(memberType == 2){
                                    System.out.println("Please enter your member ID");
                                    int memberID = scanner.nextInt();
                                    obj.isPremiumMember(memberID);        
                                }
                                if(memberType == 1){
                                    System.out.println("Please enter your member ID");
                                    int memberID = scanner.nextInt();
                                    obj.isMember(memberID);
                                }
                            }
                            else if(input == 2){
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
                                            obj.addMember(name, Address, email);
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
                                            System.out.println("Thanks! Your total for today is $" + (10.99 + obj.getTotal()) + ". (Membership fee + item(s) purchased).\n1. Confirm\n2. Cancel");
                                            int confirm = scanner.nextInt();
                                            if(confirm == 1){
                                                obj.addPremiumMember(name, Address, email);
                                            }
                                            else{
                                                System.out.println("Cancelled.");
                                            }
                                        }
                                    }
                                    else{
                                        System.out.println("Purchase Successful.");
                                    }
                            }
                        break loop2;
                        } 
                }   
            }  
        }

            else if(output == 2){
                obj.checkInventory();
            }

            else if(output == 3){
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
                        obj.addMember(name, Address, email);
                    }
                    else{
                        System.out.println("Cancelled");
                    }
            }

            else if(output == 4){
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
                        System.out.println("Thanks! Your total for today is $10.99.\n1. Confirm\n2. Cancel");
                        int confirm = scanner.nextInt();
                        if(confirm == 1){
                            obj.addPremiumMember(name, Address, email);
                        }
                        else{
                            System.out.println("Cancelled.");
                        }
                    }
                    else{
                        System.out.println("Cancelled");
                    }
            }

            else if(output == 5){
                System.out.println("Have a good day!");
                break;
            }
        }
    }
}
