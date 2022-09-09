package vn.thbinh.furniture.service;

import vn.thbinh.furniture.model.Product;

import java.util.List;

public interface IProductService {

    List<Product> findAll();
//    List<Product> getItem();
    void add(Product newProduct);
    void update(Product newProduct);
    void remove(long id);
    boolean exitsts(int id);
    Product findById(int id);
    void updateQuantity(long id, int quantity);
}
