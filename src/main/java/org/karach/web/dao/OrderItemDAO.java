package org.karach.web.dao;

import org.karach.web.model.OrderItem;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;
@Component
public class OrderItemDAO {
  private final EntityManager entityManager;

  public OrderItemDAO(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public OrderItem getOrderItemById(long orderItemId) {
    return entityManager.find(OrderItem.class, orderItemId);
  }

  public List<OrderItem> getAllOrderItems() {
    return entityManager.createQuery("SELECT oi FROM OrderItem oi", OrderItem.class).getResultList();
  }

  public void saveOrderItem(OrderItem orderItem) {
    if (orderItem.getOrderItemId() == 0) {
      entityManager.persist(orderItem);
    } else {
      entityManager.merge(orderItem);
    }
  }

  public void updateOrderItem(OrderItem orderItem) {
    entityManager.merge(orderItem);
  }

  public void deleteOrderItem(long orderItemId) {
    OrderItem orderItem = getOrderItemById(orderItemId);
    if (orderItem != null) {
      entityManager.remove(orderItem);
    }
  }
}