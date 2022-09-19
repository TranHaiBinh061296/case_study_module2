package vn.thbinh.furniture.utils;

import java.util.regex.Pattern;

public class ValidateUtils {
    // định dạng userName : chỉ đc bắt đầu bằng chữ hoặc số, tối thiểu 5 đến 20 ký tự( chỉ chứa số, chữ số, dấu chấm và dấu gạch ngang dưới)
    public static final String USERNAME_PATTERN = "^(?=.{5,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$";
    public static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&–_[{}]:;',?/*~$^+=<>\\.]).{8,20}$";
    public static final String FULLNAME_PATTERN = "^([A-ZÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬĐÈẺẼÉẸÊỀỂỄẾỆÌỈĨÍỊÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢÙỦŨÚỤƯỪỬỮỨỰỲỶỸÝỴ][a-zàảãáạăằẳẵắặâầẩẫấậđèẻẽéẹêềểễếệiìỉĩíịòỏõóọôồổỗốộơờởỡớợùủũúụỤưừửữứựỳỷỹýỵ]{1,6} )*[ ]*[A-ZÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬĐÈẺẼÉẸÊỀỂỄẾỆÌỈĨÍỊÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢÙỦŨÚỤƯỪỬỮỨỰỲỶỸÝỴ][a-zàảãáạăằẳẵắặâầẩẫấậđèẻẽéẹêềểễếệiìỉĩíịòỏõóọôồổỗốộơờởỡớợùủũúụỤưừửữứựỳỷỹýỵ]{0,6}$";
    public static final String EMAIL_PATTERN = "^[A-Za-z0-9._]+@[a-z]{2,10}+\\.[a-z]{2,3}$";
    public static final String PHONE_PATTERN = "^0[1-9][0-9]{8}$";
    private static final String ADDRESS_PATTERN = "^[a-zA-Z0-9]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$";

    public static boolean isUserNameValid(String userName) {
        return Pattern.compile(USERNAME_PATTERN).matcher(userName).matches();
    }
    public static boolean isPasswordValid(String password) {
        return Pattern.compile(PASSWORD_PATTERN).matcher(password).matches();
    }
    public static boolean isFullNameValid(String fullname) {
        return Pattern.compile(FULLNAME_PATTERN).matcher(fullname).matches();
    }
    public static boolean isEmailValid(String email) {
        return Pattern.compile(EMAIL_PATTERN).matcher(email).matches();
    }
    public static boolean isPhoneValid(String phone) {
        return Pattern.compile(PHONE_PATTERN).matcher(phone).matches();
    }
    public static boolean isAddressValid(String address) {
        return Pattern.compile(ADDRESS_PATTERN).matcher(address).matches();
    }
}
