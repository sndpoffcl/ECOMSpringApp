package com.upgrad.ECOM.service;

import com.upgrad.ECOM.entity.Order;

import java.util.List;

public interface OrderService {
    Order acceptNewOrder(Order order);
    Order getOrderDetails(int orderId);
    List<Order> findAllOrdersForCustomer(int customerId);
    List<Order> findAllOrders();


}

//methods in interface are always public and abstract