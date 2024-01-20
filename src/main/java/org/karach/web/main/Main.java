package org.karach.web.main;

import org.karach.web.dao.*;
import org.karach.web.model.*;
import org.karach.web.service.*;
import org.karach.web.service.UserService;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Main extends HttpServlet {
  private static final EntityManagerFactory ENTITY_MANAGER_FACTORY =
          Persistence.createEntityManagerFactory("MusicServicePersistenceUnit");

  public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
          throws IOException {
    EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();

    try {
      transaction.begin();

      UserService userService = new UserService(new UserDAO(entityManager));
      User user = new User();
      user.setUserName("John Doe");
      user.setUserEmail("john.doe@email.com");
      user.setUserPassword("password123");
      user.setUserRole("client");

      userService.addUser(user);

      OrderService orderService = new OrderService(new OrderDAO(entityManager));
      Order order = new Order();
      order.setClient(user);
      order.setOrderTotalPrice(50.00);

      orderService.addOrder(order);

      AudioTrackService audioTrackService = new AudioTrackService(new AudioTrackDAO(entityManager));
      AudioTrack audioTrack = new AudioTrack();
      audioTrack.setTrackTitle("Song 1");
      audioTrack.setTrackArtist("Artist 1");
      audioTrack.setTrackGenre("Pop");
      audioTrack.setTrackPrice(1.99);

      audioTrackService.addAudioTrack(audioTrack);

      OrderItemService orderItemService = new OrderItemService(new OrderItemDAO(entityManager));
      OrderItem orderItem = new OrderItem();
      orderItem.setOrder(order);
      orderItem.setAudioTrack(audioTrack);
      orderItem.setQuantity(2);
      orderItem.setSubtotal(20.00);

      orderItemService.addOrderItem(orderItem);

      ReviewService reviewService = new ReviewService(new ReviewDAO(entityManager));
      Review review = new Review();
      review.setClient(user);
      review.setAudioTrack(audioTrack);
      review.setReviewText("Great track! I loved it.");

      reviewService.addReview(review);

      transaction.commit();
    } catch (Exception e) {
      if (transaction.isActive()) {
        transaction.rollback();
      }
      e.printStackTrace();
    } finally {
      entityManager.close();
    }

    httpServletResponse.getWriter().print("Hello from servlet");
  }
}