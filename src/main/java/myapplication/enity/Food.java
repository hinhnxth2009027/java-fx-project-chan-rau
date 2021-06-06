package myapplication.enity;
import myapplication.enity.foodType;
public class Food {
    private int ID;
    private String name;
    private String img;
    private double price;
    private int count;
    private int status;
    private int foodType;

    public Food(){}

    public Food(String name, double price,String img, int foodType) {
        this.name = name;
        this.price = price;
        this.img = img;
        this.foodType = foodType;
    }
    public Food(int ID, String name,String img, double price, int count, int status,int foodType) {
        this.ID = ID;
        this.name = name;
        this.img = img;
        this.price = price;
        this.count = count;
        this.status = status;
        this.foodType = foodType;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStatus() {
        return status;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getFoodType() {
        return foodType;
    }

    public void setFoodType(int foodType) {
        this.foodType = foodType;
    }
}
