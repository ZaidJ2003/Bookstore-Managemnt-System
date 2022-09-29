public class PremiumMember {

    private String name;
    private String address;
    private String email;
    public int premiumMemberID = 1;

    public PremiumMember(){}

    public PremiumMember(String name, String address, String email, int premiumMemberID) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.premiumMemberID = premiumMemberID;
    }

    public String getName(){
        return name;
    }

    public String getaddress() {
        return address;
    }

    public String getEmail(){
        return email;
    }

    public int getMemberID() {
        return premiumMemberID;
    }
}
