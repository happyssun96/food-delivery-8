package fooddelivery.infra;

import javax.naming.NameParser;

import javax.naming.NameParser;
import javax.transaction.Transactional;

import fooddelivery.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import fooddelivery.domain.*;


@Service
@Transactional
public class PolicyHandler{
    @Autowired NotificationLogRepository notificationLogRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Accepted'")
    public void wheneverAccepted_AlertKakaotalk(@Payload Accepted accepted){

        Accepted event = accepted;
        System.out.println("\n\n##### listener AlertKakaotalk : " + accepted + "\n\n");


        

        // Sample Logic //
        NotificationLog.alertKakaotalk(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Rejected'")
    public void wheneverRejected_AlertKakaotalk(@Payload Rejected rejected){

        Rejected event = rejected;
        System.out.println("\n\n##### listener AlertKakaotalk : " + rejected + "\n\n");


        

        // Sample Logic //
        NotificationLog.alertKakaotalk(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Paid'")
    public void wheneverPaid_AlertKakaotalk(@Payload Paid paid){

        Paid event = paid;
        System.out.println("\n\n##### listener AlertKakaotalk : " + paid + "\n\n");


        

        // Sample Logic //
        NotificationLog.alertKakaotalk(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderPlaced'")
    public void wheneverOrderPlaced_AlertKakaotalk(@Payload OrderPlaced orderPlaced){

        OrderPlaced event = orderPlaced;
        System.out.println("\n\n##### listener AlertKakaotalk : " + orderPlaced + "\n\n");


        

        // Sample Logic //
        NotificationLog.alertKakaotalk(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='DeliveryStarted'")
    public void wheneverDeliveryStarted_AlertKakaotalk(@Payload DeliveryStarted deliveryStarted){

        DeliveryStarted event = deliveryStarted;
        System.out.println("\n\n##### listener AlertKakaotalk : " + deliveryStarted + "\n\n");


        

        // Sample Logic //
        NotificationLog.alertKakaotalk(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Refunded'")
    public void wheneverRefunded_AlertKakaotalk(@Payload Refunded refunded){

        Refunded event = refunded;
        System.out.println("\n\n##### listener AlertKakaotalk : " + refunded + "\n\n");


        

        // Sample Logic //
        NotificationLog.alertKakaotalk(event);
        

        

    }

}


