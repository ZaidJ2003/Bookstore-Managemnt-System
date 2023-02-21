public class PremiumMember extends Member{

    private String cardInfo;
    private boolean monthlyFeePaid = false;

    public PremiumMember(){}

    public PremiumMember(String name, String address, String email, int memberID, double totalSpending, String cardInfo, boolean monthlyFeePaid) {
        super(name, address, email, memberID, totalSpending);
        this.cardInfo = cardInfo;
        this.monthlyFeePaid = monthlyFeePaid;
    }
    
    public String getCardInfo(){
        return cardInfo;
    }

    public void setCardInfo(String cardInfo){
        this.cardInfo = cardInfo;
    }
    public boolean isMonthlyFeePaid(){
        return monthlyFeePaid;
    }
}
