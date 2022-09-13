package vn.thbinh.furniture.view;

import vn.thbinh.furniture.model.Role;
import vn.thbinh.furniture.model.User;
import vn.thbinh.furniture.service.IUserService;
import vn.thbinh.furniture.service.UserService;
import vn.thbinh.furniture.utils.AppUtils;

import java.util.List;
import java.util.Scanner;

public class AdminView {
    private final IUserService userService;
    private final Scanner scanner = new Scanner(System.in);

    public AdminView() {
        userService = UserService.getInstance();
    }


    public void adminLogin() {
        boolean isRetry = false;
        System.out.println("✠ ✠ ✠ ✠ ✠ ✠ ✠ ✠ ✠ ✠   ĐĂNG NHẬP HỆ THỐNG  ✠ ✠ ✠ ✠ ✠ ✠ ✠ ✠ ✠ ✠ ");
        do {
            System.out.println("Tên tài khoản: ");
            System.out.print("➣");
            String username = AppUtils.retrySring("Username");
            System.out.println("Mật khẩu: ");
            System.out.print("➣");
            String password = AppUtils.retrySring("Mật khẩu");
            User user = userService.adminLogin(username, password);
            if (user == null) {
                System.out.println("Tài khoản không hợp lệ!");
                isRetry = isRetry();
            } else if (user.getRole() == Role.ADMIN) {
                System.out.println("Đăng nhập thành công♥♥♥");
                MainLauncher.menuOption();
            } else if (user.getRole() == Role.USER) {
                System.out.println("Đăng nhập thành công♥♥♥");
                MenuUser.runOderUser();
            }
        } while (isRetry);
    }


    public Role set(String username, String password) {
        List<User> users = userService.findAll();
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)
                    && user.getRole().equals(Role.ADMIN)) {
                return Role.ADMIN;
            }
            if (user.getUsername().equals(username) && user.getPassword().equals(password)
                    && user.getRole().equals(Role.USER)) {
                return Role.USER;
            }
        }
        return null;
    }

    private boolean isRetry() {
        do {
            try {
                System.out.println("Nhấn 'y' để đăng nhập lại! || Nhấn 't' để thoát chương trình");
                System.out.print("➠");
                String option = scanner.nextLine().toLowerCase();
                switch (option) {
                    case "y":
                        return true;
                    case "t":
                        AppUtils.exit();
                    default:
                        System.out.println("Nhập chức năng không đúng! Vui lòng nhập lại!");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Nhập sai! Vui lòng nhập lại!");
                e.printStackTrace();
            }
        } while (true);
    }

}
