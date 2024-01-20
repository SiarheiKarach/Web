package org.karach.web.dao;

import org.karach.web.model.Order;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;
@Component
public class OrderDAO {
  private final EntityManager entityManager;

  public OrderDAO(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public Order getOrderById(long orderId) {
    return entityManager.find(Order.class, orderId);
  }

  public List<Order> getAllOrders() {
    return entityManager.createQuery("SELECT o FROM Order o", Order.class).getResultList();
  }

  public void saveOrder(Order order) {
    if (order.getOrderId() == 0) {
      entityManager.persist(order);
    } else {
      entityManager.merge(order);
    }
  }

  public void updateOrder(Order order) {
    entityManager.merge(order);
  }

  public void deleteOrder(long orderId) {
    Order order = getOrderById(orderId);
    if (order != null) {
      entityManager.remove(order);
    }
  }
}