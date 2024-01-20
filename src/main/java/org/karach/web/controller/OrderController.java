package org.karach.web.controller;

import org.karach.web.model.Order;
import org.karach.web.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

  @Autowired
  private OrderService orderService;

  @GetMapping
  public List<Order> getAllOrders() {
    return orderService.getAllOrders();
  }

  @GetMapping("/{orderId}")
  public Order getOrderById(@PathVariable long orderId) {
    return orderService.getOrderById(orderId);
  }

  @PostMapping
  public void addOrder(@RequestBody Order order) {
    orderService.addOrder(order);
  }

  @PutMapping("/{orderId}")
  public void updateOrder(@PathVariable long orderId, @RequestBody Order order) {
    orderService.updateOrder((int) orderId, order);
  }

  @DeleteMapping("/{orderId}")
  public void deleteOrder(@PathVariable long orderId) {
    orderService.deleteOrder(orderId);
  }
}