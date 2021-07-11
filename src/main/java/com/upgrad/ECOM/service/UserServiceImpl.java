package com.upgrad.ECOM.service;

import com.upgrad.ECOM.entity.Order;
import com.upgrad.ECOM.entity.User;
import com.upgrad.ECOM.exception.UserAlreadyExistsException;
import com.upgrad.ECOM.exception.UserDoesNotExistException;
import com.upgrad.ECOM.repository.OrderRepository;
import com.upgrad.ECOM.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    OrderRepository orderRepository;

    @Override
    public User acceptUserDetails(User user) {
        Optional<User> savedUser = userRepository.findByEmail(user.getEmail());
        if(savedUser.isEmpty()){
            User newSavedUser = userRepository.save(user);
            return newSavedUser;
        }else{
            throw new UserAlreadyExistsException("User Already exists");
        }
    }

    @Override
    public User getUserDetails(int userId) {
        Optional<User> savedUser = userRepository.findById(userId);
        if(savedUser.isEmpty()){
            throw new UserDoesNotExistException();
        }else{
           return savedUser.get();
        }
    }

    @Override
    public List<Order> findAllOrders(int customerId) {
        User savedUser = getUserDetails(customerId);
        List<Order> orderByUser = new ArrayList<>();
        if(savedUser != null){
            List<Order> orders =  orderRepository.findAll();
            for(Order o : orders){
                if(o.getUser().getId() == customerId){
                    orderByUser.add(o);
                }
            }
        }

        return orderByUser;
    }

    @Override
    public List<User> findAllOrders() {
        return userRepository.findAll();
    }
}
