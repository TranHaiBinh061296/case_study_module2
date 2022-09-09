package vn.thbinh.furniture.service;

import vn.thbinh.furniture.model.Product;
import vn.thbinh.furniture.utils.CSVUtils;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService{

    List<Product> products = new ArrayList<>();

    private static final String PATH = "D:\\case_study_module2\\hb_furniture\\data\\product.csv";
    private static ProductService instance;

    public static ProductService getInstance() {
        if (instance == null) {
            instance = new ProductService();
        }
        return instance;
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        List<String> records = CSVUtils.readFile(PATH);
        for (String record: records) {
            products.add(Product.parse(record));
        }
        return products;
    }


//    @Override
//    public List<Product> getItem() {
//        return null;
//    }

    @Override
    public void add(Product newProduct) {
        List<Product> products = findAll();
        products.add(newProduct);
        CSVUtils.writeFile(PATH, products);
    }

    @Override
    public void update(Product newProduct) {
        List<Product> products = findAll();
        for (Product product: products) {
            if (product.getProductID() == newProduct.getProductID()) {
                product.setPrice(newProduct.getPrice());
                product.setQuantity(newProduct.getQuantity());
            }
        }
        CSVUtils.writeFile(PATH, products);
    }

    @Override
    public void remove(long id) {
        List<Product> products = findAll();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductID() == id) {
                products.remove(i);
                break;
            }
        }
        CSVUtils.writeFile(PATH, products);
    }

    public Product getProductByID(int id) {
        List<Product> products = findAll();
        for (Product product: products) {
            if (product.getProductID() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public boolean exitsts(int id) {
        return getProductByID(id) != null;
    }

    @Override
    public Product findById(int id) {
        List<Product> products = findAll();
        for (Product product:products) {
            if (id == product.getProductID()) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void updateQuantity(long id, int quantity) {
        List<Product> products = findAll();
        for (Product product: products) {
            if (product.getProductID() == id) {
                if (product.getQuantity() >= quantity) {
                    product.setQuantity(product.getQuantity() - quantity);
                    CSVUtils.writeFile(PATH, products);
                    break;
                }
            }
        }
    }
}
