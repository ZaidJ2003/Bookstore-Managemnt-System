public class Member {
    
    private String name;
    private String address;
    private String email;
    private int memberID = 1;
    private double totalSpending = 0.0;

    public Member(){}

    public Member(String name, String address, String email, int memberID, double totalSpending){
        this.name = name;
        this.address = address;
        this.email = email;
        this.memberID = memberID;
        this.totalSpending = totalSpending;
    }

    public String getName() {
        return name;
    }
    
    public String getAddress() {
        return address;
    }

    public String getEmail(){
        return email;
    }

    public int getID() {
        return memberID;
    }

    public double getTotalSpending(){
        return totalSpending;
    }

    public void setTotalSpending(double total){
        totalSpending += total;
    }
}
