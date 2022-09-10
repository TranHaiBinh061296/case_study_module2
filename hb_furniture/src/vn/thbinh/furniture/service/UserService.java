package vn.thbinh.furniture.service;

import vn.thbinh.furniture.model.Role;
import vn.thbinh.furniture.model.User;
import vn.thbinh.furniture.utils.CSVUtils;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class UserService implements IUserService {
    //Singleton Design Pattern

    public static final String PATH = "D:\\case_study_module2\\hb_furniture\\data\\users.csv";

    private static UserService instance;

    private UserService() {

    }

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        List<String> records = CSVUtils.readFile(PATH);
        for (String record : records) {
            users.add(User.parseUser(record));
        }
        return null;
    }

    @Override
    public User adminLogin(String username, String password) {
        List<User> users = findAll();
        for (User user : users) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)
                    && user.getRole().equals(Role.ADMIN)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void addUser(User newUser) {
        newUser.setCreateAt(Instant.now());
        List<User> users = findAll();
        users.add(newUser);
        CSVUtils.writeFile(PATH, users);

    }

    @Override
    public void update(User newUser) {
        List<User> users = findAll();
        for (User user: users) {
            if (user.getId() == newUser.getId()) {
                String fullName = newUser.getFullName();
                if (fullName!= null && !fullName.isEmpty())
                    user.setFullName(newUser.getFullName());
                String phone = newUser.getMobile();
                if (phone != null && !phone.isEmpty())
                    user.setMobile(newUser.getMobile());
                String address = newUser.getAddress();
                if (address != null && !address.isEmpty())
                    user.setAddress(newUser.getAddress());
                user.setUpdateAt(Instant.now());
                CSVUtils.writeFile(PATH, users);
                break;

            }
        }

    }

    @Override
    public boolean existById(int id) {
        return findById(id) != null;
    }

    @Override
    public boolean existByEmail(String email) {
        List<User> users = findAll();
        for (User user: users) {
            if (user.getEmail().equals(email))
                return true;
        }
        return false;
    }

    @Override
    public boolean existByPhone(String phone) {
        List<User> users = findAll();
        for (User user: users) {
            if (user.getMobile().equals(phone))
                return true;
        }
        return false;
    }

    @Override
    public boolean existByUserName(String userName) {
        List<User> users = findAll();
        for (User user: users) {
            if (user.getUsername().equals(userName))
                return true;
        }
        return false;
    }

    @Override
    public User findById(int id) {
        List<User> users = findAll();
        for (User user: users) {
            if (user.getId() == id)
                return user;
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        List<User> users = findAll();
        users.removeIf(new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return user.getId() == id;
            }
        });
        CSVUtils.writeFile(PATH, users);
    }
}
