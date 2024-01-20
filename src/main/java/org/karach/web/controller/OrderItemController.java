package org.karach.web.controller;

import org.karach.web.model.OrderItem;
import org.karach.web.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderitems")
public class OrderItemController {

  @Autowired
  private OrderItemService orderItemService;

  @GetMapping
  public List<OrderItem> getAllOrderItems() {
    return orderItemService.getAllOrderItems();
  }

  @GetMapping("/{orderItemId}")
  public OrderItem getOrderItemById(@PathVariable long orderItemId) {
    return orderItemService.getOrderItemById(orderItemId);
  }

  @PostMapping
  public void addOrderItem(@RequestBody OrderItem orderItem) {
    orderItemService.addOrderItem(orderItem);
  }

  @PutMapping("/{orderItemId}")
  public void updateOrderItem(@PathVariable long orderItemId, @RequestBody OrderItem orderItem) {
    orderItemService.updateOrderItem(orderItemId, orderItem);
  }

  @DeleteMapping("/{orderItemId}")
  public void deleteOrderItem(@PathVariable long orderItemId) {
    orderItemService.deleteOrderItem(orderItemId);
  }
}