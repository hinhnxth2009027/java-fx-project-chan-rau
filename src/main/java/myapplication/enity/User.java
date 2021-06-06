package myapplication.enity;

public class User {
    private int ID;
    private String Username;
    private String password;
    private String phoneNumber;
    private String address;
    private int gender;
    private int status;
    private double balance;
    private String card;
    private String loverFood;
    private String createAt;


    public User(){}


    public User(String username, String password, String phoneNumber, String address, int gender,String createAt) {
        this.Username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.gender = gender;
        this.createAt = createAt;
    }


    public User(int ID, String username, String password, String phoneNumber, String address, int gender, int status, double balance, String card, String loverFood, String createAt) {
        this.ID = ID;
        Username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.gender = gender;
        this.status = status;
        this.balance = balance;
        this.card = card;
        this.loverFood = loverFood;
        this.createAt = createAt;
    }



    public void showinfomaion(){
        String statuss;
        String genders;

        if (this.status == 1){
            statuss = "active";
        }else {
            statuss = "deactive";
        }


        if (this.gender == 1){
            genders = "male";
        }else {
            genders = "female";
        }

        System.out.printf("ID : %d \t name : %s \t password : %s \t phone : %s \t address : %s \t gender : %s \t balance : %f \t in card : %s \t in lover lis : %s \t account create at : %s \t status : %s",
                this.ID,this.Username,this.password,this.phoneNumber,this.address,genders,this.balance,this.card,this.loverFood,this.createAt,statuss);
    }
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getLoverFood() {
        return loverFood;
    }

    public void setLoverFood(String loverFood) {
        this.loverFood = loverFood;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }
}