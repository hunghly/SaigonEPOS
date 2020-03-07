package models;

public class Food {

    private int id;
    private String name;
    private double price;
    private String imgUrl;
    private int userId;

    public Food() { };

    public Food(int id, String name, double price, String imgUrl, int userId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imgUrl = imgUrl;
        this.userId = userId;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
