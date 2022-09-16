package vn.thbinh.furniture.view;

import vn.thbinh.furniture.model.Product;
import vn.thbinh.furniture.service.ProductService;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

public class SearchProductView {
    static Scanner scanner = new Scanner(System.in);
    static ProductView productView = new ProductView();
    static ProductService productService = new ProductService();
    static DecimalFormat format = new DecimalFormat("###,###,###" + "đ");

    public static void search() {

        productView.show(productService.findAll());
        boolean flag = true;
        int choice = -1;
        do {
            System.out.println("Ƹ̴Ӂ̴Ʒ Ƹ̴Ӂ̴Ʒ Ƹ̴Ӂ̴Ʒ Ƹ̴Ӂ̴Ʒ Ƹ̴Ӂ̴Ʒ Ƹ̴Ӂ̴Ʒ Ƹ̴Ӂ̴Ʒ Ƹ̴Ӂ̴Ʒ");
            System.out.println("⚅              TÌM KIẾM SẢN PHẨM              ⚅");
            System.out.println("Ƹ̴Ӂ̴Ʒ Ƹ̴Ӂ̴Ʒ Ƹ̴Ӂ̴Ʒ Ƹ̴Ӂ̴Ʒ Ƹ̴Ӂ̴Ʒ Ƹ̴Ӂ̴Ʒ Ƹ̴Ӂ̴Ʒ Ƹ̴Ӂ̴Ʒ");
            System.out.println("⚅                                             ⚅");
            System.out.println("⚅         1. Tìm kiếm theo id sản phẩm        ⚅");
            System.out.println("⚅         2. Tìm kiếm theo tên sản phẩm       ⚅");
            System.out.println("⚅         0. Quay lại                         ⚅");
            System.out.println("⚅                                             ⚅");
            System.out.println("Ƹ̴Ӂ̴Ʒ Ƹ̴Ӂ̴Ʒ Ƹ̴Ӂ̴Ʒ Ƹ̴Ӂ̴Ʒ Ƹ̴Ӂ̴Ʒ Ƹ̴Ӂ̴Ʒ Ƹ̴Ӂ̴Ʒ Ƹ̴Ӂ̴Ʒ");
            System.out.println("Chọn chức năng: ");
            System.out.print("➽ ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            }catch (Exception e) {
                e.printStackTrace();
            }
            switch (choice) {
                case 1:
                    searchById();
                    break;
                case 2:
                    searchByName();
                    break;
                case 0:
                    ProductViewLauncher.runProduct();
                    flag = false;
                    break;
                default:
                    System.out.println("Nhập sai !!! Vui lòng nhập lại !!!");
                    break;
            }
        }while (flag);
    }

    public static void searchById() {
        List<Product> products = productService.findAll();
        int count = 0;
        System.out.println("Nhập id cần tìm kiếm: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            System.out.printf("%-15s %-30s %-18s %-10s", "Id", "Tên Sản Phẩm", "Giá", "Số lượng\n");
            for (Product product : products) {
                if (product.getProductID() == id) {
                    count++;
                    System.out.printf("%-10s %-30s %-18s %-10s\n", product.getProductID(), product.getName(), format.format(product.getPrice()),
                            product.getQuantity());
                }
            }
            showReturnSearch(count);

        } catch (Exception e) {
            System.out.println("Chưa hợp lệ!Mời nhập lại");
        }
    }
    public static void searchByName() {
        List<Product> products = productService.findAll();
        int count = 0;
        System.out.println("Nhập tên cần tìm kiếm: ");
        try {
            String name = scanner.nextLine();
            System.out.printf("%-20s %-30s %-18s %-10s", "Id", "Tên Sản Phẩm", "Giá", "Số lượng\n");
            for (Product product : products) {
                if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                    count++;
                    System.out.printf("%-20s %-30s %-18s %-10s\n", product.getProductID(), product.getName(), format.format(product.getPrice()),
                            product.getQuantity());
                }
            }
            showReturnSearch(count);

        } catch (Exception e) {
            System.out.println("Chưa hợp lệ!Mời nhập lại");
        }
    }
    public static void showReturnSearch(int count) {
        char choice = ' ';
        boolean isChoice;
        System.out.println();
        do {
            System.out.println("Nhấn 'q' để quay lại.");
            System.out.print("➤ ");
            try {
                choice = scanner.nextLine().charAt(0);
            } catch (Exception e) {
                choice = ' ';
            }
            switch (choice) {
                case 'q': {
                    SearchProductView.search();
                    isChoice = false;
                    break;
                }
                default:
                    isChoice = true;
            }
        } while (isChoice);
    }
}
