package vn.thbinh.furniture.service;

import vn.thbinh.furniture.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    User adminLogin(String username, String password);

    void addUser(User newUser);

//    void add(User newUser);

    void update(User newUser);
    boolean existById(int id);
    boolean existByEmail(String email);
    boolean existByPhone(String phone);
    boolean existByUserName(String userName);

    boolean existsByEmail(String email);

    boolean existsByPhone(String phone);

    boolean existsByUsername(String userName);

    User findById(int id);
    void deleteById(int id);
}
