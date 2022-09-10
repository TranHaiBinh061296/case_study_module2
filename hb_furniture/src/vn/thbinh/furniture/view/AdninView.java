package vn.thbinh.furniture.view;

import vn.thbinh.furniture.service.IUserService;
import vn.thbinh.furniture.service.UserService;
import vn.thbinh.furniture.utils.AppUtils;

import java.util.Scanner;

public class AdninView {
    private final IUserService userService;
    private final Scanner scanner = new Scanner(System.in);

    public AdninView() {
        userService = UserService.getInstance();
    }

    public void adminLogin() {
        boolean isRetry;
        System.out.println("✠ ✠ ✠ ✠ ✠ ✠ ✠ ✠ ✠ ✠   ĐĂNG NHẬP HỆ THỐNG  ✠ ✠ ✠ ✠ ✠ ✠ ✠ ✠ ✠ ✠ ");
        do {
            System.out.println("Username");
            String username = AppUtils.retrySring("Username");
            System.out.println("Mật khẩu");
            String password = AppUtils.retrySring("Mật khẩu");
            if (userService.adminLogin(username, password) == null) {
                System.out.println("Tài khoản không hợp lệ!");
                isRetry = isRetry();
            }else {
                System.out.println("Đăng nhập thành công!\n");
                isRetry = false;
            }
        }while (isRetry);
    }

    private boolean isRetry() {
        do {
            try {
                System.out.println("Nhấn 'y' để đăng nhập lại! || Nhấn 't' để thoát chương trình");
                System.out.print("➠");
                String option = scanner.nextLine();
                switch (option) {
                    case "y":
                        return true;
                    case "t":
                        AppUtils.exit();
                    default:
                        System.out.println("Nhập chức năng không đúng! Vui lòng nhập lại!");
                        break;
                }
            }catch (Exception e) {
                System.out.println("Nhập sai! Vui lòng nhập lại!");
                e.printStackTrace();
            }
        }while (true);
    }

}
