package org.karach.web.service;

import org.karach.web.dao.OrderDAO;
import org.karach.web.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderService {
  private final OrderDAO orderDAO;

  public OrderService(OrderDAO orderDAO) {
    this.orderDAO = orderDAO;
  }

  public void addOrder(Order order) {
    orderDAO.saveOrder(order);
  }

  public void updateOrder(int orderId, Order order) {
    order.setOrderId(orderId);
    orderDAO.updateOrder(order);
  }

  public Order getOrderById(long orderId) {
    return orderDAO.getOrderById(orderId);
  }

  public List<Order> getAllOrders() {
    return orderDAO.getAllOrders();
  }

  public void deleteOrder(long orderId) {
    orderDAO.deleteOrder(orderId);
  }
}