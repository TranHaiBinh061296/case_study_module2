package vn.thbinh.furniture.service;

import vn.thbinh.furniture.model.OrderItem;
import vn.thbinh.furniture.utils.CSVUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderItemService implements IOrderItemService {

    private final static String path = "D:\\case_study_module2\\hb_furniture\\data\\orderitem.csv";
    private static OrderItemService instance;

    public OrderItemService() {
    }

    public static OrderItemService getInstance() {
        if (instance == null) {
            instance = new OrderItemService();
        }
        return instance;
    }

    @Override
    public List<OrderItem> findAll() {
        List<OrderItem> orderItems = new ArrayList<>();
        List<String> records = CSVUtils.readFile(path);
        for (String record : records) {
            orderItems.add(new OrderItem(record));
        }
        return orderItems;
    }

    @Override
    public void add(OrderItem newOrderItem) {
        List<OrderItem> orderItems = findAll();
        orderItems.add(newOrderItem);
        CSVUtils.writeFile(path, orderItems);
    }

    @Override
    public void update(OrderItem newOrderItem) {
        List<OrderItem> orderItems = findAll();
        CSVUtils.writeFile(path, orderItems);
    }


    @Override
    public OrderItem getOrderItemById(int id) {
        List<OrderItem> orderItems = findAll();
        for (OrderItem orderItem : orderItems) {
            if (orderItem.getId() == id)
                return orderItem;
        }
        return null;
    }

    public OrderItem getOrderItemByName(String name) {
        List<OrderItem> orderItems = findAll();
        for (OrderItem orderItem : orderItems) {
            if (orderItem.getName() == name)
                return orderItem;
        }
        return null;
    }

    public List<OrderItem> getListOrderItemByName(String name) {
        List<OrderItem> list = findAll();
        for (OrderItem orderItem : list) {
            if (Objects.equals(orderItem.getName(), name)) {
                list.add(orderItem);
            }
        }
        return list;
    }


@Override
    public List<OrderItem> findByOrderId(long orderId) {
        List<OrderItem> orderItems = findAll();
        List<OrderItem> orderItemsFind = new ArrayList<>();
        for (OrderItem orderItem : orderItems) {
            if (orderItem.getOrderId() == orderId) {
                orderItemsFind.add(orderItem);
            }
        }
        return orderItemsFind;
    }

}
