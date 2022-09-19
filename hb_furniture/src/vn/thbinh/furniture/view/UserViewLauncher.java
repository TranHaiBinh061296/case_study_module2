package vn.thbinh.furniture.view;

import java.util.Scanner;

import static vn.thbinh.furniture.view.MainLauncher.menuUser;

public class UserViewLauncher {
    static Scanner scanner = new Scanner(System.in);
    static UserView userView = new UserView();
    static AdminView adminView = new AdminView();

    public static void lauch() {
        int choice = -1;
        do {
            menuUser();
            try {
                do {
                    System.out.println("Chọn chức năng");
                    System.out.print("➠ ");
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice > 6 || choice < 1)
                        System.out.println("Chọn chức năng không đúng !!!");
                } while (choice > 6 || choice < 1);
                switch (choice) {
                    case 1:
                        userView.addUser();
                        break;
                    case 2:
                        userView.updateUser();
                        break;
                    case 3:
                        userView.deleteUser();
//                        menuUser();
                        break;
                    case 4:
                        userView.showUsers(InputOption.SHOW);
                        break;
                    case 5:
                        MainLauncher.menuOption();
                        break;
                    case 6:
                        UserViewLauncher.login();
                        break;
                    default:
                        System.out.println("Chọn chức năng không đúng !!!");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Nhập sai !!!");
            }
        } while (choice != 6);
    }

    public static void login() {
        System.out.println("█ ▬▬▬▬▬▬▬▬▬▬▬▬ CHỌN ▬▬▬▬▬▬▬▬▬▬▬ █");
        System.out.println("█                                             █");
        System.out.println("█                 1.Đăng ký                   █");
        System.out.println("█                 2.Đăng nhập                 █");
        System.out.println("█                 3.Liên hệ hỗ trợ            █");
        System.out.println("█                 0.Thoát                     █");
        System.out.println("█                                             █");
        System.out.println("█ ▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬█");
        System.out.println("Chọn chức năng");
        System.out.print("➠ ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                userView.addUsers();
                break;
            case 2:
                adminView.adminLogin();
                break;
            case 3:
                    System.out.println("●▬▬▬▬▬▬▬▬▬▬▬▬▬▬๑۩۩๑▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬●");
                    System.out.println("●                                                   ●");
                    System.out.println("●             Liên hệ qua số điện thoại nóng        ●");
                    System.out.println("●                      0969455400                   ●");
                    System.out.println("●                    Để được tư vấn                 ●");
                    System.out.println("●                                                   ●");
                    System.out.println("●                                                   ●");
                    System.out.println("●▬▬▬▬▬▬▬▬▬▬▬▬▬▬๑۩۩๑▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬●");
                System.exit(0);
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Nhập sai !!! Vui lòng nhập lại !!!");
        }
    }
}
