public class Member {
    
    private String memberName;
    private String address;
    private String email;
    private int memberID = 1;

    public Member(){}

    public Member(String memberName, String address, String email, int memberID){
        this.memberName = memberName;
        this.address = address;
        this.email = email;
        this.memberID = memberID;
    }

    public String getMemberName() {
        return memberName;
    }
    
    public String getaddress() {
        return address;
    }

    public String getEmail(){
        return email;
    }

    public int getMemberID() {
        return memberID;
    }
}
