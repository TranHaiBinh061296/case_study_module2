package vn.thbinh.furniture.view;

import vn.thbinh.furniture.model.Order;
import vn.thbinh.furniture.model.OrderItem;
import vn.thbinh.furniture.model.Product;
import vn.thbinh.furniture.service.*;
import vn.thbinh.furniture.utils.AppUtils;
import vn.thbinh.furniture.utils.ValidateUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderView {

    private final Scanner scanner = new Scanner(System.in);
    private final IProductService productService;
    private final IOrderServices orderServices;
    private final IOrderItemService orderItemService;


    public OrderView() {
        productService = ProductService.getInstance();
        orderServices = OrderSevice.getInstance();
        orderItemService = OrderItemService.getInstance();
    }


    public OrderItem addOrderItem(long orderId) {
//        orderItemService.findAll();
        List<OrderItem> orderItems = new ArrayList<>();
        long id = System.currentTimeMillis() / 1000;
        System.out.println("Nhập Id sản phẩm muốn mua");
        System.out.print("➤ ");
        int idAcs = Integer.parseInt(scanner.nextLine());
        while (!productService.exitsts(idAcs)) {
            System.out.println("Id không tồn tại!");
            System.out.println("Nhập Id sản phẩm");
            System.out.print("➤ ");
            idAcs = scanner.nextInt();
        }
        Product product = productService.findById(idAcs);
        double price = product.getPrice();
        int oldQuantity = product.getQuantity();
        System.out.println("Nhập số lượng muốn mua");
        int quantity;
        do {
            quantity = AppUtils.retryParseInt();
            if (quantity < 0)
                System.out.println("(Số lượng phải lớn hơn 0)");
        } while (quantity < 0);
        while (!checkQuantity(product, quantity)) {
            System.out.println("Nhập sai số lượng. Vui lòng nhập lại!");
            System.out.println("Nhập số lượng");
            System.out.print("➤ ");
            quantity = scanner.nextInt();
        }
        String namePrt = product.getName();
        double total = quantity * product.getPrice();
        int currentQuantity = oldQuantity - quantity;
        product.setQuantity(currentQuantity);

        OrderItem orderItem = new OrderItem(idAcs, price, quantity, orderId, namePrt, total);
        productService.updateQuantity(idAcs, quantity);
        return orderItem;

    }


    public void addOrder() {
        try {
            long orderId = System.currentTimeMillis() / 1000;
            ProductView productView = new ProductView();
            productView.showProduct(InputOption.ADD);
            System.out.println("Nhập chức năng:");
            System.out.println("Nhập họ và tên: (vd: Trần Hải Bình) " + "Tên phải viết hoa chữ cái đầu)");
            System.out.print("➤ ");
            String name = scanner.nextLine();
            while (!ValidateUtils.isFullNameValid(name)) {
                System.out.println("Tên " + name + " không hợp lệ!" + "Vui lòng nhập lại" + "Tên phải viết hoa chữ cái đầu, có dấu");
                System.out.println("Nhập tên: (vd: Trần Hải Bình)");
                System.out.print("➤ ");
                name = scanner.nextLine();
            }
            System.out.println("Nhập số điện thoại (vd:0987654321)");
            System.out.print("➤ ");
            String phone = scanner.nextLine();
            while (!ValidateUtils.isPhoneValid(phone)) {
                System.out.println("Số điện thoại: (vd:0987654321) gồm 10 số");
                System.out.print("➤ ");
                phone = scanner.nextLine();
            }
            String address;
            do {
                System.out.println("Nhập địa chỉ: ");
                System.out.print("➤ ");
                address = scanner.nextLine();
                if (address.trim().isEmpty()) {
                    System.out.println("Địa chỉ không được để trống!!");
                    System.out.println("Nhập lại địa chỉ: ");
                    System.out.print("➤ ");
                }
            } while (address.trim().isEmpty());

            OrderItem orderItem = addOrderItem(orderId);
            Order order = new Order(orderId, name, phone, address);
            orderItemService.add(orderItem);
            orderServices.add(order);


            do {
                System.out.println("↞↞↞↞↞↞↞↞↞↞↞↞    TẠO ĐƠN THÀNH CÔNG    ↠↠↠↠↠↠↠↠↠↠↠↠");
                System.out.println("↡  Nhấn 'y' để tiếp tục mua hàng  ||  Nhấn 'q' để quay lại   ↟");
                System.out.println("↡  Nhấn 'p' để in hóa đơn         ||  Nhấn 't' để thoát      ↟");
                System.out.print("➽");
                String option = scanner.nextLine();

                switch (option) {
                    case "y":
                        addOrder();
                        break;
                    case "q":
                        OrderViewLaucher.runOrder();
                        break;
                    case "p":
                        showInfo(order);
                        showPay(orderItem);
                        break;
                    case "t":
                        UserViewLauncher.login();
                        break;
                    default:
                        System.out.println("Nhập sai vui lòng nhập lại!!!!");
                }
            } while (true);
        } catch (Exception e) {
            System.out.println("Nhập sai!!!!! Vui lòng nhập lại!");
            addOrder();
        }
    }
    public void addOrderUser() {
        try {
            long orderId = System.currentTimeMillis() / 1000;
            ProductView productView = new ProductView();
            productView.showProduct(InputOption.ADD);
            System.out.println("Nhập chức năng:");
            System.out.println("Nhập họ và tên: (vd: Trần Hải Bình) " + "Tên phải viết hoa chữ cái đầu)");
            System.out.print("➤ ");
            String name = scanner.nextLine();
            while (!ValidateUtils.isFullNameValid(name)) {
                System.out.println("Tên " + name + " không hợp lệ!" + "Vui lòng nhập lại" + "Tên phải viết hoa chữ cái đầu, có dấu");
                System.out.println("Nhập tên: (vd: Trần Hải Bình)");
                System.out.print("➤ ");
                name = scanner.nextLine();
            }
            System.out.println("Nhập số điện thoại (vd:0987654321)");
            System.out.print("➤ ");
            String phone = scanner.nextLine();
            while (!ValidateUtils.isPhoneValid(phone)) {
                System.out.println("Số điện thoại: (vd:0987654321) gồm 10 số");
                System.out.print("➤ ");
                phone = scanner.nextLine();
            }
            String address;
            do {
                System.out.println("Nhập địa chỉ: ");
                System.out.print("➤ ");
                address = scanner.nextLine();
                if (address.trim().isEmpty()) {
                    System.out.println("Địa chỉ không được để trống!!");
                    System.out.println("Nhập lại địa chỉ: ");
                    System.out.print("➤");
                }
            } while (address.trim().isEmpty());

            OrderItem orderItem = addOrderItem(orderId);
            Order order = new Order(orderId, name, phone, address);
            orderItemService.add(orderItem);
            orderServices.add(order);


            do {
                System.out.println("↞↞↞↞↞↞↞↞↞↞↞↞    TẠO ĐƠN THÀNH CÔNG    ↠↠↠↠↠↠↠↠↠↠↠↠");
                System.out.println("↡  Nhấn 'y' để tiếp tục mua hàng  ||  Nhấn 'q' để quay lại   ↟");
                System.out.println("↡  Nhấn 'p' để in hóa đơn         ||  Nhấn 't' để thoát      ↟");
                System.out.print("➽");
                String option = scanner.nextLine();

                switch (option) {
                    case "y":
                        addOrderUser();
                        break;
                    case "q":
                        MenuUser.runOderUser();
                        break;
                    case "p":
                        showInfo(order);
                        showPayUser(orderItem);
                        break;
                    case "t":
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Nhập sai vui lòng nhập lại!!!!");
                        break;
                }
            } while (true);
        } catch (Exception e) {
            System.out.println("Nhập sai!!!!! Vui lòng nhập lại!");
            addOrder();
        }
    }

//    public void updateOrderItem() {
//        List<OrderItem> orderItems = orderItemService.findAll();
////        List<Product> productList = productService.findAll();
//        ProductView productView = new ProductView();
//        productView.showProduct(InputOption.ADD);
//        long id = System.currentTimeMillis() / 1000;
//        System.out.println("Nhập id sản phẩm muốn mua");
//        int orderid = Integer.parseInt(scanner.nextLine());
//        Product product = productService.findById(orderid);
//        int oldQuantity = product.getQuantity();
//        double price = Double.valueOf(0);
//        double total = Double.valueOf(0);
//        String nameProduct = "";
//        price = product.getPrice();
//        nameProduct = product.getName();
//        int quantity = 0;
////        if (isExistProduct(orderItems, product)) {
////            System.out.println("Sản phẩm này đã có trong đơn !!! Vui lòng nhập thêm số lượng !");
////            quantity = Integer.parseInt(scanner.nextLine());
////        } else {
////            System.out.println("Nhập số lượng muốn mua: ");
////            quantity = Integer.parseInt(scanner.nextLine());
////        }
//        System.out.println("Nhập số lượng muốn mua: ");
//        quantity = Integer.parseInt(scanner.nextLine());
//        total = quantity * product.getPrice();
//        int currentQuantity = product.getQuantity() - quantity;
//        product.setQuantity(currentQuantity);
//        OrderItem neworderItem = new OrderItem(id, price, quantity, orderid, nameProduct, total);
//        productService.updateQuantity(id, quantity);
//        orderItemService.add(neworderItem);
//        System.out.println("Tạo đơn hàng thành công!!!");
//
//    }


    public void showInfo(Order order) {
        try {
            System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬     HOÁ ĐƠN THANH TOÁN      ▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
            System.out.println("Mã đơn hàng     :   " +    order.getId());
            System.out.println("Tên khách hàng  :   " + order.getName());
            System.out.println("Số điện thoại   :   " + order.getPhone());
            System.out.println("Địa chỉ         :   " + order.getAddress());
            System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
            System.out.println("__________________________________________________________________________________________________");
        } catch (Exception e) {
            System.out.println("Lỗi !!! Vui lòng nhập lại !!!");
        }
    }

    public void showPay(OrderItem orderItem) {
        try {
            System.out.printf("▐ %-30s ▐ %-15s ▐ %-15s ▐ %15s ▐\n", "Tên sản phẩm", "Số lượng", "Giá", "Tổng tiền cần thanh toán");
            System.out.println("__________________________________________________________________________________________________");
            System.out.printf("▐ %-30s ▐ %-15d ▐ %-15s ▐ %15s          ▐\n",
                    orderItem.getProductName(),
                    orderItem.getQuantity(),
                    AppUtils.doubleToVND(orderItem.getPrice()),
                    AppUtils.doubleToVND(orderItem.getTotal())
            );
            System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
            boolean is = true;
            do {
                System.out.println("Nhập 'q' để trở lại ||  Nhập 't' để thoát chương trình");
                System.out.print("⭆ ");
                String choice = scanner.nextLine();
                switch (choice) {
                    case "q":
                        OrderViewLaucher.runOrder();
                        break;
                    case "t":
                        AppUtils.exit();
                        break;
                    default:
                        System.out.println("Nhập không đúng. Vui lòng nhập lại!");
                        is = false;
                }
            } while (!is);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void showPayUser(OrderItem orderItem) {
        try {
            System.out.printf("▐ %-30s ▐ %-15s ▐ %-15s ▐ %15s ▐\n", "Tên sản phẩm", "Số lượng", "Giá", "Tổng tiền cần thanh toán");
            System.out.println("__________________________________________________________________________________________________");
            System.out.printf("▐ %-30s ▐ %-15d ▐ %-15s ▐ %15s          ▐\n",
                    orderItem.getProductName(),
                    orderItem.getQuantity(),
                    AppUtils.doubleToVND(orderItem.getPrice()),
                    AppUtils.doubleToVND(orderItem.getTotal())
            );
            System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
            boolean is = true;
            do {
                System.out.println("Nhập 'q' để trở lại ||  Nhập 't' để thoát chương trình");
                System.out.print(" ⭆ ");
                String choice = scanner.nextLine();
                switch (choice) {
                    case "q":
                        MenuUser.runOderUser();
                        break;
                    case "t":
                        AppUtils.exit();
                        break;
                    default:
                        System.out.println("Nhập không đúng. Vui lòng nhập lại!");
                        is = false;
                }
            } while (!is);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showTurnover() {
        List<Order> orders = orderServices.findAll();
        List<OrderItem> orderItems = orderItemService.findAll();
        OrderItem newOrderItem = new OrderItem();
        double totalMoney = 0;
        try {
            System.out.println("▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨ Doanh Thu ▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨");
            System.out.println("                                                                                                                                      ");
            System.out.printf("%-15s %-20s %-25s %-15s %-30s %-15s %-15s %-15s \n",
                    "   Id",
                    "Tên khách hàng",
                    " SĐT",
                    "Địa chỉ",
                    "Tên sản phẩm",
                    "Số lượng",
                    "Giá",
                    "Tổng");
            for (Order order : orders) {
                for (OrderItem orderItem : orderItems) {
                    if (orderItem.getOrderId() == order.getId()) {
                        newOrderItem = orderItem;
                        break;
                    }
                }
                System.out.printf("%-15d %-20s %-25s %-15s %-30s %-15d %-15s %-15s \n",
                        order.getId(),
                        order.getName(),
                        order.getPhone(),
                        order.getAddress(),
                        newOrderItem.getProductName(),
                        newOrderItem.getQuantity(),
                        AppUtils.doubleToVND(newOrderItem.getPrice()),
                        AppUtils.doubleToVND(newOrderItem.getTotal())
                );
                totalMoney += newOrderItem.getTotal();
            }
            System.out.println("");
            System.out.println("Tổng doanh thu: " + AppUtils.doubleToVND(totalMoney) );
            System.out.println("▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨");
            boolean is = true;
            do {
                System.out.println("Nhập 'q' để trở lại || Nhập 'e' để thoát chương trình");
                System.out.print("➽ ");
                String choice = scanner.nextLine().toLowerCase();
                switch (choice) {
                    case "q":
                        break;
                    case "e":
                        AppUtils.exit();
                        break;
                    default:
                        System.out.println("Nhập không đúng! Vui lóng nhập lại!");
                        is = false;
                }
            } while (!is);
        } catch (Exception e) {
            System.out.println("Nhập sai!!! Vui lòng nhập lại");
        }
    }


    public boolean checkQuantity(Product product, int quantity) {
        if (quantity <= product.getQuantity())
            return true;
        else
            return false;
    }

    public static boolean isExistProduct(List<OrderItem> list, Product product) {
        for (OrderItem item : list) {
            if (item.getProductId() == product.getProductID()) {
                return true;
            }
        }
        return false;
    }

}