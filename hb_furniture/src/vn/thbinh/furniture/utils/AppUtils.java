package vn.thbinh.furniture.utils;


import vn.thbinh.furniture.view.InputOption;

import java.text.DecimalFormat;
import java.util.Scanner;

public class AppUtils {
    public static Scanner scanner = new Scanner(System.in);

    public static int retryChoose(int min, int max) {
        int option;
        do {
            System.out.print("➠ ");
            try {
                option = Integer.parseInt(scanner.nextLine());
                if (option > max || option < min) {
                    System.out.println("Chọn chức năng không đúng! Vui lóng nhập lại.!");
                    continue;
                }
                break;
            } catch (Exception ex) {
                System.out.println("Nhập sai! Nhập lại×͜×");
            }
        } while (true);
        return option;
    }

    public static int retryParseInt() {
        int result;
        do {
            System.out.println("➠ ");
            try {
                result = Integer.parseInt(scanner.nextLine());
                return result;
            } catch (Exception ex) {
                System.out.println("Nhập sai! Vui lòng nhập lại.×͜×");
            }
        } while (true);
    }
    public static double retryParseDouble() {
        double result;
        do {
            System.out.println("➠ ");
            try {
                result = Double.parseDouble(scanner.nextLine());
                return result;
            }catch (Exception ex) {
                System.out.println("Nhập sai! Vui lòng nhập lại.×͜×");
            }
        }while (true);
    }
    public static String retrySring(String fieldName) {
        String result;
        System.out.println(" ⭆ ");
        while ((result= scanner.nextLine()).isEmpty()) {
            System.out.printf("%s không được để trống\n", fieldName);
            System.out.print(" ⭆ ");
        }
        return result;
    }

    public static String doubleToVND(double value) {
        String patternVND = ",###đ";
        DecimalFormat decimalFormat = new DecimalFormat(patternVND);
        return decimalFormat.format(value);
    }

    public static boolean isRetry(InputOption inputOption) {
        do {
            switch (inputOption) {
                case ADD:
                    System.out.println("Nhấn 'y' để thêm tiếp || Nhấn 'q' để quay lại || Nhấn 't' để thoát chương trình");
                    break;
                case UPDATE:
                    System.out.println("Nhấn 'y' để sửa tiếp || Nhấn 'q' để quay lại || Nhấn 't' để thoát chương trình");
                    break;
                case DELETE:
                    System.out.println("Nhấn 'q' để quay lại || Nhấn 't' để thoát chương trình");
                    break;
                case SHOW:
                    System.out.println("Nhấn 'q' để quay lại || Nhấn 't' để thoát chương trình!");
                    break;
                default:
                    throw new IllegalStateException("Unexpected value " + inputOption);
            }
            System.out.println(" ➠ ");
            String option = scanner.nextLine();
            switch (option) {
                case "y":
                    return true;
                case "q":
                    return false;
                case "t":
                    exit();
                    break;
                default:
                    System.out.println("Chọn chức năng không đúng! Vui lòng nhập lại.");
            }
        }while (true);
    }
    public static void exit() {
        System.out.println("\t Tạm biệt. Hẹn gặp lại \uD83D\uDC4B!");
    }
}
