package fooddelivery.domain;

import fooddelivery.CustomerApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name = "NotificationLog_table")
@Data

public class NotificationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    private String customerId;

    private String message;

    public static NotificationLogRepository repository() {
        NotificationLogRepository notificationLogRepository = CustomerApplication.applicationContext
                .getBean(NotificationLogRepository.class);
        return notificationLogRepository;
    }

    public static void alertKakaotalk(Accepted accepted) {

        // * Example 1: new item
        NotificationLog notificationLog = new NotificationLog();
        notificationLog.setId(accepted.getId());
        repository().save(notificationLog);

        /**
         * Example 2: finding and process
         * 
         * repository().findById(accepted.get???()).ifPresent(notificationLog->{
         * 
         * notificationLog // do something
         * repository().save(notificationLog);
         * 
         * 
         * });
         */

    }

    public static void alertKakaotalk(Rejected rejected) {

        // Example 1: new item
        NotificationLog notificationLog = new NotificationLog();
        notificationLog.setId(rejected.getId());
        repository().save(notificationLog);

        /**
         * Example 2: finding and process
         * 
         * repository().findById(rejected.get???()).ifPresent(notificationLog->{
         * 
         * notificationLog // do something
         * repository().save(notificationLog);
         * 
         * 
         * });
         */

    }

    public static void alertKakaotalk(Paid paid) {

        // Example 1: new item
        NotificationLog notificationLog = new NotificationLog();
        notificationLog.setId(paid.getId());
        repository().save(notificationLog);

        /**
         * Example 2: finding and process
         * 
         * repository().findById(paid.get???()).ifPresent(notificationLog->{
         * 
         * notificationLog // do something
         * repository().save(notificationLog);
         * 
         * 
         * });
         */

    }

    public static void alertKakaotalk(OrderPlaced orderPlaced) {

        // Example 1: new item
        NotificationLog notificationLog = new NotificationLog();
        notificationLog.setId(orderPlaced.getId());
        repository().save(notificationLog);

        /**
         * Example 2: finding and process
         * 
         * repository().findById(orderPlaced.get???()).ifPresent(notificationLog->{
         * 
         * notificationLog // do something
         * repository().save(notificationLog);
         * 
         * 
         * });
         */

    }

    public static void alertKakaotalk(DeliveryStarted deliveryStarted) {

        // Example 1: new item
        NotificationLog notificationLog = new NotificationLog();
        notificationLog.setId(deliveryStarted.getId());
        repository().save(notificationLog);

        /**
         * Example 2: finding and process
         * 
         * repository().findById(deliveryStarted.get???()).ifPresent(notificationLog->{
         * 
         * notificationLog // do something
         * repository().save(notificationLog);
         * 
         * 
         * });
         */

    }

    public static void alertKakaotalk(Refunded refunded) {

        // Example 1: new item
        NotificationLog notificationLog = new NotificationLog();
        notificationLog.setId(refunded.getId());
        repository().save(notificationLog);

        /**
         * Example 2: finding and process
         * 
         * repository().findById(refunded.get???()).ifPresent(notificationLog->{
         * 
         * notificationLog // do something
         * repository().save(notificationLog);
         * 
         * 
         * });
         */

    }

}
