package fooddelivery.domain;

import fooddelivery.domain.Paid;
import fooddelivery.domain.Refunded;
import fooddelivery.PayApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name = "Payment_table")
@Data

public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    private Long orderId;

    @PostPersist
    public void onPostPersist() {

        Paid paid = new Paid(this);
        paid.publishAfterCommit();

        Refunded refunded = new Refunded(this);
        refunded.publishAfterCommit();

    }

    public static PaymentRepository repository() {
        PaymentRepository paymentRepository = PayApplication.applicationContext.getBean(PaymentRepository.class);
        return paymentRepository;
    }

    public static void cancelPayment(OrderCanceled orderCanceled) {

        /**
         * Example 1: new item
         * Payment payment = new Payment();
         * repository().save(payment);
         * 
         */

        // * Example 2: finding and process

        Payment py = repository().findByOrderId(orderCanceled.getId());
        if (py.orderId == orderCanceled.getId()) {
            repository().save(py);

        }

    }

    public static void cancelPayment(Rejected rejected) {

        /**
         * Example 1: new item
         * Payment payment = new Payment();
         * repository().save(payment);
         * 
         */

        // * Example 2: finding and process

        Payment py = repository().findByOrderId(rejected.getId());
        if (py.orderId == rejected.getId()) {
            repository().save(py);
        }

    }

}
