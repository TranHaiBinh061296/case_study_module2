package vn.thbinh.furniture.model;

public class OrderItem {
    private long id;
    private String name;
    private double price;
    private int quantity;
    private long orderId;
    private int productId;
    private String productName;
    private double total;

    public OrderItem() {
    }

    public OrderItem(long id, String name, double price, int quantity, long orderId, int productId, String productName, double total) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.orderId = orderId;
        this.productId = productId;
        this.productName = productName;
        this.total = total;
    }

    public OrderItem(String record) {
        String[] fields = record.split(",");
        id = Long.parseLong(fields[0]);
        name = fields[1];
        price = Double.parseDouble(fields[2]);
        quantity = Integer.parseInt(fields[3]);
        orderId = Long.parseLong(fields[4]);
        productId = Integer.parseInt(fields[5]);
        productName = fields[6];
        total = Double.parseDouble(fields[7]);
    }



    public OrderItem(long idPrt, double price, int quantity, long orderId, String namePrt, double total) {
        this.id =idPrt;
        this.price = price;
        this.quantity = quantity;
        this.orderId = orderId;
        this.productName = namePrt;
        this.total = total;
    }


    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
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

    public double getTotalMoney() {
        return price * quantity;
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

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getTotal() {
        return  price * quantity;

    }

    public void setTotal(double total) {
        this.total = total;
    }


    @Override
    public String toString() {
        return id +
                "," + name +
                "," + price +
                "," + quantity +
                "," + orderId +
                "," + productId +
                "," + productName +
                "," + total;
    }
}
