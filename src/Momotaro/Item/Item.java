package Momotaro.Item;

public abstract class Item {
    protected int id;
    protected String name;
    protected double rarityRate;

    public String getName() {
        return "『" + this.name + "』";
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRarityRate() {
        return rarityRate;
    }

    public void setRarityRate(double rarityRate) {
        this.rarityRate = rarityRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        return o == this;
    }

    public String toDetailString() {
        return getName();
    }

}