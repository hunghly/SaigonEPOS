package models;

public class Modifier {
    private int id;
    private String modifer;
    private double priceMod;

    public Modifier () { };

    public Modifier (int id, String modifer, double priceMod) {
        this.id = id;
        this.modifer = modifer;
        this.priceMod = priceMod;
    }

    public Modifier (String modifer, double priceMod) {
        this.modifer = modifer;
        this.priceMod = priceMod;
    }

    public int getId() {
        return this.id;
    }

    public String getModifer() {
        return this.modifer;
    }

    public double getPriceMod() {
        return this.priceMod;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setModifer(String modifer) {
        this.modifer = modifer;
    }

    public void setPriceMod(double priceMod) {
        this.priceMod = priceMod;
    }
}
