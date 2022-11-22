package fooddelivery.domain;

import fooddelivery.StoreApplication;
import fooddelivery.domain.Accepted;
import fooddelivery.domain.Cooked;
import fooddelivery.domain.Rejected;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "StoreOrder_table")
@Data
public class StoreOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String foodId;

    private String preference;

    private Long orderId;

    private String status;

    private String test;

    @PostPersist
    public void onPostPersist() {
        Cooked cooked = new Cooked(this);
        cooked.publishAfterCommit();

        Accepted accepted = new Accepted(this);
        accepted.publishAfterCommit();

        Rejected rejected = new Rejected(this);
        rejected.publishAfterCommit();
    }

    public static StoreOrderRepository repository() {
        StoreOrderRepository storeOrderRepository = StoreApplication.applicationContext.getBean(
                StoreOrderRepository.class);
        return storeOrderRepository;
    }

    public void finishCook() {
    }

    public void accept() {
    }

    public void reject() {
    }

    public void startCook() {
    }

    public static void updateStoreStatus(OrderCanceled orderCanceled) {
        /**
         * Example 1: new item
         * StoreOrder storeOrder = new StoreOrder();
         * repository().save(storeOrder);
         * 
         */

        // Example 2: finding and process
        StoreOrder st = repository().findByOrderId(orderCanceled.getId());
        if (st.status == "Started") {
            st.status = "Order Canceled"; // do something
            repository().save(st);
        }

    }

    public static void updateStoreStatus(Delivered delivered) {
        /**
         * Example 1: new item
         * StoreOrder storeOrder = new StoreOrder();
         * repository().save(storeOrder);
         * 
         */

        // Example 2: finding and process

        StoreOrder st = repository().findByOrderId(delivered.getId());
        st.status = "Delievered"; // do something
        repository().save(st);
    }

    public static void updateStoreStatus(Paid paid) {
        /**
         * Example 1: new item
         * StoreOrder storeOrder = new StoreOrder();
         * repository().save(storeOrder);
         * 
         */

        // * Example 2: finding and process

        StoreOrder st = repository().findByOrderId(paid.getId());
        st.status = "Paid";
        repository().save(st);
    }
}
