package bunga.domain;

import bunga.ShipApplication;
import bunga.domain.Shipped;
import bunga.domain.ShippingCancelled;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Ship_table")
@Data
public class Ship {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String status;

    private Long orderId;

    private Long itemId;

    private String address;

    private Integer qty;

    @PostPersist
    public void onPostPersist() {
        Shipped shipped = new Shipped(this);
        shipped.publishAfterCommit();

        ShippingCancelled shippingCancelled = new ShippingCancelled(this);
        shippingCancelled.publishAfterCommit();
    }

    public static ShipRepository repository() {
        ShipRepository shipRepository = ShipApplication.applicationContext.getBean(
            ShipRepository.class
        );
        return shipRepository;
    }

    public static void shipping(OrderPlaced orderPlaced) {
        /** Example 1:  new item 
        Ship ship = new Ship();
        repository().save(ship);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(ship->{
            
            ship // do something
            repository().save(ship);


         });
        */

    }

    public static void shippingCancel(OrderCancelled orderCancelled) {
        /** Example 1:  new item 
        Ship ship = new Ship();
        repository().save(ship);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderCancelled.get???()).ifPresent(ship->{
            
            ship // do something
            repository().save(ship);


         });
        */

    }
}
