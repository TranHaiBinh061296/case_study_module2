package vn.thbinh.furniture.view;

import java.util.Scanner;

import static vn.thbinh.furniture.view.MainLauncher.menuUser;

public class UserViewLauncher {
    public static void lauch() {
        Scanner scanner = new Scanner(System.in);
        UserView userView = new UserView();
        int choice = -1;
        do {
           menuUser();
           try {
               do {
                   System.out.println("Chọn chức năng");
                   System.out.print("➠ ");
                   choice = Integer.parseInt(scanner.nextLine());
                   if (choice > 6 || choice <1)
                       System.out.println("Chọn chức năng không đúng !!!");
               } while (choice > 6 || choice <1);
               switch (choice) {
                   case 1:
                       userView.addUser();
                       break;
                   case 2:
                       userView.updateUser();
                       break;
                   case 3:
                       userView.deleteUser();
                       menuUser();
                       break;
                   case 4:
                       userView.showUsers(InputOption.SHOW);
                       break;
                   case 5:
                       MainLauncher.menuOption();
                       break;
                   case 6:
                       System.exit(6);
                       break;
                   default:
                       System.out.println("Chọn chức năng không đúng !!!");
                       break;
               }
           }catch (Exception e) {
               System.out.println("Nhập sai !!!");
           }
        } while (choice != 6);
    }

}
