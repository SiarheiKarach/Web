package org.karach.web.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "order_id")
  private int orderId;

  @ManyToOne
  @JoinColumn(name = "client_id")
  private User user;

  @Column(name = "order_date")
  private Date orderDate;

  @Column(name = "order_total_price")
  private double orderTotalPrice;

  // Constructors, getters, and setters

  public Order() {
  }

  public Order(User user, Date orderDate, double orderTotalPrice) {
    this.user = user;
    this.orderDate = orderDate;
    this.orderTotalPrice = orderTotalPrice;
  }

  public int getOrderId() {
    return orderId;
  }

  public void setOrderId(int orderId) {
    this.orderId = orderId;
  }

  public User getClient() {
    return user;
  }

  public void setClient(User user) {
    this.user = user;
  }

  public Date getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(Date orderDate) {
    this.orderDate = orderDate;
  }

  public double getOrderTotalPrice() {
    return orderTotalPrice;
  }

  public void setOrderTotalPrice(double orderTotalPrice) {
    this.orderTotalPrice = orderTotalPrice;
  }
}