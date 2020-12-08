////////////////////////////////////////////////////////////////////
// [ANTONIO] [BADAN] [1201209]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.model;

public class MenuItem {
    public enum item {Gelati,Budini,Bevande}

    private item itemType;
    private String name;
    private double price;

    public MenuItem(item itemType, String name, double price) {
        this.itemType = itemType;
        this.name = name;
        this.price = price;
    }

    public item getItemType() {
        return itemType;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

}
