package org.karach.web.model;

import javax.persistence.*;

@Entity
@Table(name = "orderitems")
public class OrderItem {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "order_item_id")
  private int orderItemId;

  @ManyToOne
  @JoinColumn(name = "order_id")
  private Order order;

  @ManyToOne
  @JoinColumn(name = "track_id")
  private AudioTrack audioTrack;

  @Column(name = "quantity")
  private int quantity;

  @Column(name = "subtotal")
  private double subtotal;

  public OrderItem() {
  }

  public OrderItem(Order order, AudioTrack audioTrack, int quantity, double subtotal) {
    this.order = order;
    this.audioTrack = audioTrack;
    this.quantity = quantity;
    this.subtotal = subtotal;
  }

  public int getOrderItemId() {
    return orderItemId;
  }

  public void setOrderItemId(int orderItemId) {
    this.orderItemId = orderItemId;
  }

  public Order getOrder() {
    return order;
  }

  public void setOrder(Order order) {
    this.order = order;
  }

  public AudioTrack getAudioTrack() {
    return audioTrack;
  }

  public void setAudioTrack(AudioTrack audioTrack) {
    this.audioTrack = audioTrack;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public double getSubtotal() {
    return subtotal;
  }

  public void setSubtotal(double subtotal) {
    this.subtotal = subtotal;
  }
}