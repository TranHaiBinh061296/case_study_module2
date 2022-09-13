package vn.thbinh.furniture.service;

import vn.thbinh.furniture.model.Order;

import java.util.List;

public interface IOrderServices {
    List<Order> findAll();
    void add(Order newOrder);
    void update();
    Order getOrderById(int id);

    boolean exist(int id);
    boolean checkForDuplicateName(String name);
    boolean checkForDuplicateId(int id);
    void remove(Order order);
    boolean existsByPhone(String phone);

    Order findById(long orderId);
}
