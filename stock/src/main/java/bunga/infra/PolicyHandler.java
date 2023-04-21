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

    @Autowired
    StockRepository stockRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Shipped'"
    )
    public void wheneverShipped_UpdateStock(@Payload Shipped shipped) {
        Shipped event = shipped;
        System.out.println(
            "\n\n##### listener UpdateStock : " + shipped + "\n\n"
        );

        // Sample Logic //
        Stock.updateStock(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ShippingCancelled'"
    )
    public void wheneverShippingCancelled_UpdateStock(
        @Payload ShippingCancelled shippingCancelled
    ) {
        ShippingCancelled event = shippingCancelled;
        System.out.println(
            "\n\n##### listener UpdateStock : " + shippingCancelled + "\n\n"
        );

        // Sample Logic //
        Stock.updateStock(event);
    }
}
