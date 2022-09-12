package vn.thbinh.furniture.sort;

import vn.thbinh.furniture.model.Product;

import java.util.Comparator;

public class SortByPriceDesc implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        if(o1.getPrice() > o2.getPrice()){
            return -1;
        }else if(o1.getPrice() == o2.getPrice()){
            return 0;
        }else{
            return 1;
        }
    }
}
