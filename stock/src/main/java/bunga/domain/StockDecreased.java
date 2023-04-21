package bunga.domain;

import bunga.domain.*;
import bunga.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class StockDecreased extends AbstractEvent {

    private Long id;
    private Integer qty;

    public StockDecreased(Stock aggregate) {
        super(aggregate);
    }

    public StockDecreased() {
        super();
    }
}
