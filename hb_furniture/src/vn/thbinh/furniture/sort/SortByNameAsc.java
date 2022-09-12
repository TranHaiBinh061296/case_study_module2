package vn.thbinh.furniture.sort;

import vn.thbinh.furniture.model.Product;

import java.util.Comparator;

public class SortByNameAsc implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
