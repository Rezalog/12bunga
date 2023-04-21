package bunga.domain;

import bunga.infra.AbstractEvent;
import java.util.*;
import lombok.Data;

@Data
public class Shipped extends AbstractEvent {

    private Long id;
    private String status;
    private Long orderId;
    private Long itemId;
    private String address;
    private Integer qty;
}
