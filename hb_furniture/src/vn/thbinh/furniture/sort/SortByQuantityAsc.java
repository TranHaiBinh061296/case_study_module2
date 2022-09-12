package vn.thbinh.furniture.sort;

import vn.thbinh.furniture.model.Product;

import java.util.Comparator;

public class SortByQuantityAsc implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return o1.getQuantity() - o2.getQuantity();
    }
}
