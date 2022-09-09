package vn.thbinh.furniture.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainLauncher {
    static Scanner scanner = new Scanner(System.in);

    public MainLauncher() {
        startMainMenu();
    }
    public static void launch() {
        menuOption();
    }

    public static void menuOption() {
        do {
            mainMenu();
            try {
                System.out.println("Chọn chức năng: ");
                System.out.print(" ➱ ");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        break;
                    case 2:
                        ProductViewLauncher.runProduct();
                        break;
                    case 3:
                        break;
                    case 0:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Nhập sai ⚔️Vui lòng nhập lại! ");
                        break;
                }
            }catch (Exception e) {
                System.out.println("Error!  ̿’̿’\\̵͇̿̿\\");
            }
        }while (true);
    }

    public static void mainMenu() {
        System.out.println("❐◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈❐");
        System.out.println("❐    CHÀO MỪNG BẠN ĐẾN VỚI CỬA HÀNG NỘI THẤT HB     ❐");
        System.out.println("❐◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈❐");
        System.out.println("❐◈                     MAIN MENU                  ◈❐");
        System.out.println("❐◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈❐");
        System.out.println("❐                                                   ❐");
        System.out.println("❐                1.Quản lý người dùng               ❐");
        System.out.println("❐                2.Quản lý hàng hóa                 ❐");
        System.out.println("❐                3.Quản lý đơn đặt hàng             ❐");
        System.out.println("❐                4.Thoát chương trình               ❐");
        System.out.println("❐                                                   ❐");
        System.out.println("❐◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈❐");
    }

    public static void menuUser() {
        System.out.println("웃▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬웃");
        System.out.println("웃                   QUẢN LÝ NGƯỜI DÙNG             웃");
        System.out.println("웃▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬웃");
        System.out.println("웃▋✉                                               ✆▋웃");
        System.out.println("웃▋               1.Thêm người dùng                  ▋웃");
        System.out.println("웃▋               2.Sửa thông tin người dùng         ▋웃");
        System.out.println("웃▋               3.Xóa người dùng                   ▋웃");
        System.out.println("웃▋               4.Hiện thông tin người dùng        ▋웃");
        System.out.println("웃▋               5.Quay lại MAIN MENU               ▋웃");
        System.out.println("웃▋               0.Thoát chương trình               ▋웃");
        System.out.println("웃▋☎                                               ✍▋웃");
        System.out.println("웃▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬웃");
    }
    public static void menuProduct() {
        System.out.println("�◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘�");
        System.out.println("�◘             QUẢN LÝ SẢN PHẨM NỘI THẤT         ◘�");
        System.out.println("�◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘�");
        System.out.println("�❂                                              ❂�");
        System.out.println("�               1.Thêm sản phẩm                   �");
        System.out.println("�               2.Sửa thông tin sản phẩm          �");
        System.out.println("�               3.Tìm kiếm sản phẩm               �");
        System.out.println("�               4.Hiển thị danh sách sản phẩm     �");
        System.out.println("�               5.Tìm kiếm sản phẩm               �");
        System.out.println("�               6.Quay lại                        �");
        System.out.println("�               0.Thoát                           �");
        System.out.println("�❂                                              ❂�");
        System.out.println("�◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘�");
        System.out.println("Chọn chức năng");
        System.out.printf("⭆ \t");
    }

    public static void startMainMenu() {
        try {
            boolean flag = true;
            do {
                String choice = scanner.nextLine();
                switch (choice) {
                    case "1":
                        ProductViewLauncher.runProduct();
                        break;
                    case "2" :
                        break;
                    default:
                        System.out.println("Nhập sai ⚔️Vui lòng nhập lại !");
                }
            }while (!flag);
        }catch (InputMismatchException io) {
            io.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void inputUpdate() {
        System.out.println("✿◕ ‿ ◕✿ ❀◕ ‿ ◕❀      Update     ✿ ❀◕ ‿ ◕❀ ❁◕ ‿ ◕❁");
        System.out.println("♥                                                   ♥");
        System.out.println("♥                1. Cập nhật giá                    ♥");
        System.out.println("♥                2. Cập nhật số lượng               ♥");
        System.out.println("♥                3. Quay lại                        ♥");
        System.out.println("♥                                                   ♥");
        System.out.println("✿◕ ‿ ◕✿ ❀◕ ‿ ◕❀ ❁◕ ‿ ◕❁  ✿◕ ‿ ◕✿ ❀◕ ‿ ◕❀ ❁◕ ‿ ◕❁");
        System.out.println("Chọn chức năng");
        System.out.printf("⭆ \t");
    }
    public static void menuOrder() {
        System.out.println("✬⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿✬");
        System.out.println("✬⦿                  QUẢN LÝ ĐƠN HÀNG               ⦿✬");
        System.out.println("✬⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿✬");
        System.out.println("✬დ                                                 დ✬");
        System.out.println("✬                1.Tạo đơn hàng                      ✬");
        System.out.println("✬                2.Xem danh sách đơn hàng            ✬");
        System.out.println("✬                3.Quay lại MAIN MENU                ✬");
        System.out.println("✬                4.Thoát chương trình                ✬");
        System.out.println("✬დ                                                  დ✬");
        System.out.println("✬⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿⦿✬");
    }
}
