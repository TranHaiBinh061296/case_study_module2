package vn.thbinh.furniture.view;

import vn.thbinh.furniture.model.Role;
import vn.thbinh.furniture.model.User;
import vn.thbinh.furniture.service.IUserService;
import vn.thbinh.furniture.service.UserService;
import vn.thbinh.furniture.utils.AppUtils;
import vn.thbinh.furniture.utils.InstantUtils;
import vn.thbinh.furniture.utils.ValidateUtils;

import java.util.List;
import java.util.Scanner;

public class UserView {

    private final IUserService userService;
    private final Scanner scanner = new Scanner(System.in);

    public UserView() {
        userService = UserService.getInstance();
    }

    public void addUser() {
        do {
            try {
                long id = System.currentTimeMillis() / 1000;
                String username = inputUserName();
                String password = inputPassword();
                String fullName = inputFullName(InputOption.ADD);
                String phone = inputPhone(InputOption.ADD);
                String address = inputAddress(InputOption.ADD);
                String email = inputEmail(InputOption.ADD);
                User user = new User(id, username, password, fullName, phone, email, address, Role.USER);
                setRole(user);
                userService.addUser(user);
                System.out.println("Đã thêm người dùng thành công!");
            } catch (Exception e) {
                System.out.println("Nhập sai. Vui lòng nhập lại!111");
            }
        } while (AppUtils.isRetry(InputOption.ADD));
    }

    public void setRole(User user) {
        System.out.println("= =  SET ROLE = =");
        System.out.println("=    1. USER    =");
        System.out.println("=    2. ADMIN   =");
        System.out.println("= = = = = = = = =");
        System.out.println("Chọn Role: ");
        System.out.print("➠");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                user.setRole(Role.USER);
                break;
            case 2:
                user.setRole(Role.ADMIN);
                break;
            default:
                System.out.println("Nhập không đúng chức năng! Vui lòng nhập lại!!!");
                setRole(user);
        }
    }
    public void showUsers(InputOption inputOption) {
        System.out.println("------------------------------------------------------------- DANH SÁCH NGƯỜI DÙNG ----------------------------------------------------------------");
        System.out.printf("%-15s %-22s %-15s %-22s %-18s %-15s %-20s %-20s\n", "Id", "Tên", "Số điện thoại", "Email", "Địa chỉ", "Người dùng", "Ngày tạo", "Ngày cập nhật");
        List<User> users = userService.findAll();
        for (User user : users) {
            System.out.printf("%-15d %-22s %-15s %-22s %-18s %-15s %-20s %-20s\n",
                    user.getId(),
                    user.getFullName(),
                    user.getMobile(),
                    user.getEmail(),
                    user.getAddress(),
                    user.getRole(),
                    InstantUtils.instantToString(user.getCreateAt()),
                    user.getUpdateAt() == null ? "" : InstantUtils.instantToString(user.getUpdateAt())
            );
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
        if (inputOption == InputOption.SHOW)
            AppUtils.isRetry(InputOption.SHOW);
    }

    public void updateUser() {
        boolean isRetry = false;
        do {
            try {
                showUsers(InputOption.UPDATE);
                int id = inputId(InputOption.UPDATE);
                System.out.println("⇆⇆⇆        SỬA NGƯỜI DÙNG      ⇆⇆⇆");
                System.out.println("⇆          1. Sửa tên              ⇆");
                System.out.println("⇆          2. Sửa số điện thoại    ⇆");
                System.out.println("⇆          3. Sửa địa chỉ          ⇆");
                System.out.println("⇆          4. Sửa email            ⇆");
                System.out.println("⇆          5. Quay lại             ⇆");
                System.out.println("⇆⇆⇆⇆⇆⇆⇆⇆⇆⇆⇆⇆⇆⇆⇆⇆⇆⇆⇆⇆⇆⇆⇆⇆⇆");

                int option = AppUtils.retryChoose(1,4);
                User newUser = new User();
                newUser.setId(id);
                switch (option) {
                    case 1:
                        String name = inputFullName(InputOption.UPDATE);
                        newUser.setFullName(name);
                        userService.update(newUser);
                        System.out.println("Đã đổi tên thành công!");
                        break;
                    case 2:
                        String phone = inputPhone(InputOption.UPDATE);
                        newUser.setMobile(phone);
                        userService.update(newUser);
                        System.out.println("Đổi số điện thoại thành công!");
                        break;
                    case 3:
                        String address = inputAddress(InputOption.UPDATE);
                        newUser.setAddress(address);
                        userService.update(newUser);
                        System.out.println("Đổi địa chỉ thành công!");
                        break;
                }
                isRetry =option != 4 && AppUtils.isRetry(InputOption.UPDATE);
            }catch (Exception e) {
                System.out.println("Nhập sai ! ");
            }
        }while (isRetry);
    }

    public void  deleteUser() {
        showUsers(InputOption.DELETE);
        int id;
        while (!userService.existById(id = inputId(InputOption.DELETE))) {
            System.out.println("Không tồn tại người dùng !");
            System.out.println("Nhấn 'y' để tìm lại người dùng || Nhấn 'q' để quay lại || Nhấn 't' để thoát chương trình ");
            System.out.print("➠");
            String option = scanner.nextLine().toLowerCase();
            switch (option) {
                case "y":
                    break;
                case "q":
                    return;
                case "t":
                    AppUtils.exit();
                    break;
                default:
                    System.out.println("Nhập chức năng không đúng! Vui lòng nhập lại!");
                    break;
            }
            System.out.println("≧❂◡❂≦≧❂◡❂≦    XÁC NHẬN XÓA    ≧❂◡❂≦≧❂◡❂≦");
            System.out.println("¿             1. Nhấn 1 để xóa              ¿");
            System.out.println("¿             2. Nhấn 2 để quay lại         ¿");
            System.out.println("≧❂◡❂≦≧❂◡❂≦≧❂◡❂≦≧❂◡❂≦≧❂◡❂≦≧❂◡❂≦≧❂◡❂≦");
        }
    }
    private int inputId(InputOption option) {
        int id;
        switch (option) {
            case ADD:
                System.out.println("Nhập id: ");
                break;
            case UPDATE:
                System.out.println("Nhập id bạn muốn sửa: ");
                break;
            case DELETE:
                System.out.println("Nhập id muốn xóa: ");
                break;
        }
        boolean isRetry = false;
        do {
            id = AppUtils.retryParseInt();
            boolean exist = userService.existById(id);
            switch (option) {
                case ADD:
                    if (exist) {
                        System.out.println("Id đã tồn tại. Vui lòng nhập lại!");
                    }
                    isRetry = exist;
                    break;
                case UPDATE:
                    if (!exist) {
                        System.out.println("Không tìm thấy id. Vui lòng nhập lại!");
                    }
                    isRetry = !exist;
            }
        } while (isRetry);
        return id;
    }

    public String inputUserName() {
        System.out.println("Nhập Username (không bao gồm dấu cách, kí tự đặc biệt)");
        System.out.print("⭆");
        String username;
        do {
            if (!ValidateUtils.isUserNameValid(username = AppUtils.retrySring("Username"))) {
                System.out.println(username + " của bạn không đúng định dạng. Vui lòng kiểm tra và nhập lại!");
                System.out.print("⭆ ");
                continue;
            }
            if (userService.existByUserName(username)) {
                System.out.println("Username này đã tồn tại. Vui lòng nhập lại!");
                System.out.print("⭆ ");
                continue;
            }
            break;
        } while (true);
        return username;
    }

    private String inputFullName(InputOption option) {
        switch (option) {
            case ADD:
                System.out.println("Nhập họ và tên (vd: Trần Hải Bình)");
                break;
            case UPDATE:
                System.out.println("Nhập tên mà bạn muốn sửa: ");
                break;
        }

        System.out.print("➠");
        String fullName;
        while (!ValidateUtils.isFullNameValid(fullName = scanner.nextLine())) {
            System.out.println("Tên " + fullName + " không đúng định dạng." + " Viết hoa chữ cái đầu và có dấu");
            System.out.println("Nhập tên (vd: Trần Hải Bình) ");
            System.out.println("➠");
        }
        return fullName;
    }

    public String inputPhone(InputOption option) {
        switch (option) {
            case ADD:
                System.out.println("Nhập số điện thoại (vd: 0969961123, 10 số)");
                break;
            case UPDATE:
                System.out.println("Nhập số điện thoại mà bạn muốn đổi lại: ");
                break;
        }
        System.out.print("➠");
        String phone;
        do {
            phone = scanner.nextLine();
            if (!ValidateUtils.isPhoneValid(phone)) {
                System.out.println("Số " + phone + " không đúng định dạng! Nhập lại!" + "Gồm 10 số và bắt đầu bằng số 0, số thứ 2 là từ 1-9!");
                System.out.println("Nhập số điện thoại (vd: 0969961123)");
                System.out.print("➠");
                continue;
            }
            if (userService.existByPhone(phone)) {
                System.out.println("Số này đã tồn tại. Mời bạn nhập lại!");
                System.out.print("➠");
                continue;
            }
            break;
        } while (true);
        return phone;
    }

//    private String inputEmail() {
//        System.out.println("Nhập email (vd: haibinh@gmail.com)");
//        System.out.print("➠");
//        String email;
//        do {
//            if (!ValidateUtils.isEmailValid(email = scanner.nextLine())) {
//                System.out.println("Email " + email + " không đúng định dạng Vui lòng nhập lại !");
//                System.out.print("➠");
//                continue;
//            }
//            if (userService.existByEmail(email)) {
//                System.out.println("Email " + email + " của bạn đẫ tồn tại! Vui lòng nhập lại!");
//                System.out.println("Nhập email (vd: haibinh@gmail.com");
//                System.out.print("➠");
//                continue;
//            }
//            break;
//        } while (true);
//        return email;
//    }
    private String inputEmail(InputOption option) {
        switch (option) {
            case ADD:
                System.out.println("Nhập email (vd: haibinh@gmail.com)");
                break;
            case UPDATE:
                System.out.println("Nhập email mà bạn muốn đổi: ");
                break;
        }
        System.out.print("➠");
        String email;
        do {
            if (!ValidateUtils.isEmailValid(email = scanner.nextLine())) {
                System.out.println("Email " + email + " không đúng định dạng Vui lòng nhập lại !");
                System.out.print("➠");
                continue;
            }
            if (userService.existByEmail(email)) {
                System.out.println("Email " + email + " của bạn đẫ tồn tại! Vui lòng nhập lại!");
                System.out.println("Nhập email (vd: haibinh@gmail.com");
                System.out.print("➠");
                continue;
            }
            break;
        } while (true);
        return email;
    }

    private String inputPassword() {
        System.out.println("Nhập mật khẩu (từ 8 đến 20 ký tự)");
        System.out.print("➠");
        String password;
        while (!ValidateUtils.isPasswordValid(password = scanner.nextLine())) {
            System.out.println("Mật khẩu yếu (Không đúng định dạng). Nhập lại !!!");
            System.out.print("➠");
        }
        return password;
    }

    private String inputAddress(InputOption option) {
        switch (option) {
            case ADD:
                String address;
                System.out.println("Nhập địa chỉ (vd: Huế)");
                do {
                    address = scanner.nextLine();
                    if (address.trim().isEmpty()) {
                        System.out.println("Địa chỉ không được để trống!");
                        System.out.println("Nhập lại địa chỉ");
                        System.out.print("➠");
                        address = scanner.nextLine();
                    }
                } while (address.trim().isEmpty());
                return address;
            case UPDATE:
                System.out.println("Nhập địa chỉ muốn đổi (vd: Huế");
                do {
                    address = scanner.nextLine();
                    if (address.trim().isEmpty()) {
                        System.out.println("Địa chỉ không được để trống!");
                        System.out.println("Nhập lại địa chỉ");
                        System.out.print("➠");
                        address = scanner.nextLine();
                    }
                } while (address.trim().isEmpty());
                return address;
        }
        return null;
    }
}
