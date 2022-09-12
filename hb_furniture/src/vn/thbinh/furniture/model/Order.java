package vn.thbinh.furniture.model;

public class Order {
    private long id;
    private String name;
    private String phone;
    private String address;

    public Order() {
    }

    public Order(String record) {

    }

    public static Order parse(String record) {
        Order order = new Order(record);
        String[] field = record.split(",");
        order.id = Long.parseLong(field[0]);
        order.name = field[1];
        order.phone = field[2];
        order.address = field[3];
        return order;
    }

    public Order(long id, String name, String phone, String address) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return id + "," +
                name +
                "," +
                phone +
                "," +
                address;
    }
}
