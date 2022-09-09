package vn.thbinh.furniture.model;

import java.util.Comparator;

public class Product implements Comparator<Product> {
    private long productID;
    private String name;
    private double price;
    private int quantity;

    public Product() {
    }
    public static Product parse(String record) {
        String [] fields = record.split(",");
        int productID = Integer.parseInt(fields[0]);
        String name = fields[1];
        double price = Double.parseDouble(fields[2]);
        int quantity = Integer.parseInt(fields[3]);
        return new Product(productID,name,price,quantity);
    }

    public Product(long productID, String name, double price, int quantity) {
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public long getProductID() {
        return productID;
    }

    public void setProductID(long productID) {
        this.productID = productID;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return  productID + ","
                + name + ","
                + price + ","
                + quantity ;
    }

    @Override
    public int compare(Product o1, Product o2) {
        return (int) (o1.getProductID() - o2.getProductID());
    }
}
