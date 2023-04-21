package bunga.domain;

import bunga.domain.*;
import bunga.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class ShippingCancelled extends AbstractEvent {

    private Long id;
    private String status;
    private Long orderId;
    private Long itemId;
    private String address;
    private Integer qty;

    public ShippingCancelled(Ship aggregate) {
        super(aggregate);
    }

    public ShippingCancelled() {
        super();
    }
}
