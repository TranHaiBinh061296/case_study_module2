package vn.thbinh.furniture.view;

import java.util.Scanner;

import static vn.thbinh.furniture.view.MainLauncher.mainMenu;
import static vn.thbinh.furniture.view.MainLauncher.menuOrder;

public class OrderViewLaucher {
    static Scanner scanner = new Scanner(System.in);
    static OrderView orderView = new OrderView();

    public static void main(String[] args) {
        runOrder();
    }
    public static void runOrder() {
        int choice;
        do {
            menuOrder();
            try {
                System.out.println("Chọn chức năng");
                System.out.print("➽");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        orderView.addOrder();
                        break;
                    case 2:
                        orderView.showTurnover();
                        break;
                    case 3:
                        mainMenu();
                        break;
                    case 0:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Nhập sai vui lòng nhập lại!");
                }
            }catch (Exception e) {
                System.out.println("Nhập sai vui lòng nhập lại!!!");
            }
        }while (true);
    }
}