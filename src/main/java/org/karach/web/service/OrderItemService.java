package org.karach.web.service;

import org.karach.web.dao.OrderItemDAO;
import org.karach.web.model.OrderItem;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderItemService {
  private final OrderItemDAO orderItemDAO;

  public OrderItemService(OrderItemDAO orderItemDAO) {
    this.orderItemDAO = orderItemDAO;
  }

  public void addOrderItem(OrderItem orderItem) {
    orderItemDAO.saveOrderItem(orderItem);
  }

  public void updateOrderItem(long orderItemId, OrderItem orderItem) {
    orderItem.setOrderItemId((int) orderItemId);
    orderItemDAO.updateOrderItem(orderItem);
  }

  public OrderItem getOrderItemById(long orderItemId) {
    return orderItemDAO.getOrderItemById(orderItemId);
  }

  public List<OrderItem> getAllOrderItems() {
    return orderItemDAO.getAllOrderItems();
  }

  public void deleteOrderItem(long orderItemId) {
    orderItemDAO.deleteOrderItem(orderItemId);
  }
}