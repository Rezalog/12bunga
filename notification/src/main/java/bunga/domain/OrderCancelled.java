package bunga.domain;

import bunga.domain.*;
import bunga.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderCancelled extends AbstractEvent {

    private Long id;
    private Long customerId;
    private String status;
    private String address;
    private Long itemId;
    private Integer qty;
}
