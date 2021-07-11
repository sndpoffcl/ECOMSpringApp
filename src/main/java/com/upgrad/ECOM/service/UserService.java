package com.upgrad.ECOM.service;

import com.upgrad.ECOM.entity.Order;
import com.upgrad.ECOM.entity.User;

import java.util.List;

public interface UserService {
    User acceptUserDetails(User user);
    User getUserDetails(int userId);
    List<Order> findAllOrders(int customerId);
    List<User> findAllOrders();
}
