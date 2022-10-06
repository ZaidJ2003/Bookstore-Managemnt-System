public class PremiumMember {

    private String name;
    private String address;
    private String email;
    private int premiumMemberID = 1;
    private double totalSpending;
    private String cardInfo;
    private boolean monthlyFeePaid = false;

    public PremiumMember(){}

    public PremiumMember(String name, String address, String email, int premiumMemberID, String cardInfo, boolean monthlyFeePaid, double totalSpending) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.premiumMemberID = premiumMemberID;
        this.cardInfo = cardInfo;
        this.totalSpending = totalSpending;
        this.monthlyFeePaid = monthlyFeePaid;
    }

    public String getName(){
        return name;
    }

    public String getAddress(){
        return address;
    }

    public String getEmail(){
        return email;
    }

    public int getPremiumMemberID(){
        return premiumMemberID;
    }

    public String getCardInfo(){
        return cardInfo;
    }

    public void setCardInfo(String cardInfo){
        this.cardInfo = cardInfo;
    }

    public double getTotalSpending(){
        return totalSpending;
    }

    public void setTotalSpending(double total){
        totalSpending += total;
    }

    public boolean isMonthlyFeePaid(){
        return monthlyFeePaid;
    }
}
