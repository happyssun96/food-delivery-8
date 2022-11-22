package fooddelivery.domain;

import fooddelivery.domain.OrderPlaced;
import fooddelivery.domain.OrderCanceled;
import fooddelivery.AppApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name = "Order_table")
@Data

public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    private String foodId;

    private String customerId;

    private String preference;

    private String options;

    private String address;

    private String status;

    @PostPersist
    public void onPostPersist() {

        // Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        fooddelivery.external.Payment payment = new fooddelivery.external.Payment();
        // mappings goes here
        AppApplication.applicationContext.getBean(fooddelivery.external.PaymentService.class)
                .pay(payment);

        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();

        OrderCanceled orderCanceled = new OrderCanceled(this);
        orderCanceled.publishAfterCommit();

    }

    @PrePersist
    public void onPrePersist() {
    }

    @PreRemove
    public void onPreRemove() {
        if (this.getStatus().equals("Cooked")) {
            System.out.println("\n\n##### 이미 조리가 시작되었습니다. 취소하실 수 없습니다. \n\n");
        }
    }

    public static OrderRepository repository() {
        OrderRepository orderRepository = AppApplication.applicationContext.getBean(OrderRepository.class);
        return orderRepository;
    }

    public static void updateOrderStatus(Accepted accepted) {

        /**
         * Example 1: new item
         * Order order = new Order();
         * repository().save(order);
         * 
         */

        // * Example 2: finding and process

        repository().findById(accepted.getId()).ifPresent(order -> {

            order.status = "Order Accepted"; // do something
            repository().save(order);

        });

    }

    public static void updateOrderStatus(Rejected rejected) {

        /**
         * Example 1: new item
         * Order order = new Order();
         * repository().save(order);
         * 
         */

        // * Example 2: finding and process

        repository().findById(rejected.getId()).ifPresent(order -> {

            order.status = "Order Rejected"; // do something
            repository().save(order);

        });

    }

    public static void updateOrderStatus(Cooked cooked) {

        /**
         * Example 1: new item
         * Order order = new Order();
         * repository().save(order);
         * 
         */

        // * Example 2: finding and process

        repository().findById(cooked.getId()).ifPresent(order -> {

            order.status = "Order Cooked"; // do something
            repository().save(order);

        });

    }

}
