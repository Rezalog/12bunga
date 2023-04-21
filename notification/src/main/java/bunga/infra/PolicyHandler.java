package bunga.infra;

import bunga.config.kafka.KafkaProcessor;
import bunga.domain.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PolicyHandler {

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderPlaced'"
    )
    public void wheneverOrderPlaced_고객에게문자메시지발송(
        @Payload OrderPlaced orderPlaced
    ) {
        OrderPlaced event = orderPlaced;
        System.out.println(
            "\n\n##### listener 고객에게문자메시지발송 : " +
            orderPlaced +
            "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderCancelled'"
    )
    public void wheneverOrderCancelled_고객에게문자메시지발송(
        @Payload OrderCancelled orderCancelled
    ) {
        OrderCancelled event = orderCancelled;
        System.out.println(
            "\n\n##### listener 고객에게문자메시지발송 : " +
            orderCancelled +
            "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Shipped'"
    )
    public void wheneverShipped_고객에게문자메시지발송(
        @Payload Shipped shipped
    ) {
        Shipped event = shipped;
        System.out.println(
            "\n\n##### listener 고객에게문자메시지발송 : " + shipped + "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ShippingCancelled'"
    )
    public void wheneverShippingCancelled_고객에게문자메시지발송(
        @Payload ShippingCancelled shippingCancelled
    ) {
        ShippingCancelled event = shippingCancelled;
        System.out.println(
            "\n\n##### listener 고객에게문자메시지발송 : " +
            shippingCancelled +
            "\n\n"
        );
        // Sample Logic //

    }
}
