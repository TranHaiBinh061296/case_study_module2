package vn.thbinh.furniture.sort;

import vn.thbinh.furniture.model.Product;

import java.util.Comparator;

public class SortByNameDesc implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return o2.getName().compareTo(o1.getName());
    }
}
