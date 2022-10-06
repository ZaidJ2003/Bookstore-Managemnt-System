public class Member {
    
    private String memberName;
    private String address;
    private String email;
    private int memberID = 1;
    private double totalSpending = 0.0;

    public Member(){}

    public Member(String memberName, String address, String email, int memberID, double totalSpending){
        this.memberName = memberName;
        this.address = address;
        this.email = email;
        this.memberID = memberID;
        this.totalSpending = totalSpending;
    }

    public String getMemberName() {
        return memberName;
    }
    
    public String getAddress() {
        return address;
    }

    public String getEmail(){
        return email;
    }

    public int getMemberID() {
        return memberID;
    }

    public double getTotalSpending(){
        return totalSpending;
    }

    public void setTotalSpending(double total){
        totalSpending += total;
    }
}
