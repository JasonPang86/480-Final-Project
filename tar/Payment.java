package tar;

public class Payment {
    private String cardholderFirstName;
    private String cardholderLastName;
    private String cardholderMiddleName;
    private String billingAddress;
    private long cardNumber;
    private long phoneNumber;
    private int cardCvv;

    public String get_cardholderFirstName(){
        return cardholderFirstName;
    }

    public String get_cardholderLastName(){
        return cardholderLastName;
    }

    public String get_cardholderMiddleName(){
        return cardholderMiddleName;
    }

    public String get_billingAddress(){
        return billingAddress;
    }

    public long get_cardNumber(){
        return cardNumber;
    }

    public long get_phoneNumber(){
        return phoneNumber;
    }

    public int get_cardCvv(){
        return cardCvv;
    }

    void set_cardholderFirstName(String name){
        this.cardholderFirstName=name;
    }

    void set_cardholderMiddleName(String name){
        this.cardholderMiddleName=name;
    }

    void set_cardholderLastName(String name){
        this.cardholderLastName=name;
    }

    void set_billingAddress(String address){
        this.billingAddress=address;
    }

    void set_cardNumber(long card){
        this.cardNumber=card;
    }

    void set_phoneNumber(long phoneNumber){
        this.phoneNumber=phoneNumber;
    }

    void set_cardCvv(int cvv){
        this.cardCvv=cvv;
    }

    public void payTicket(){

    }

    public void payAccountRegistration(){

    }
}
