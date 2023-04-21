package bunga.domain;

import bunga.StockApplication;
import bunga.domain.StockDecreased;
import bunga.domain.StockIncreased;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Stock_table")
@Data
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer qty;

    @PostPersist
    public void onPostPersist() {
        StockDecreased stockDecreased = new StockDecreased(this);
        stockDecreased.publishAfterCommit();

        StockIncreased stockIncreased = new StockIncreased(this);
        stockIncreased.publishAfterCommit();
    }

    public static StockRepository repository() {
        StockRepository stockRepository = StockApplication.applicationContext.getBean(
            StockRepository.class
        );
        return stockRepository;
    }

    public static void updateStock(Shipped shipped) {
        /** Example 1:  new item 
        Stock stock = new Stock();
        repository().save(stock);

        */

        /** Example 2:  finding and process
        
        repository().findById(shipped.get???()).ifPresent(stock->{
            
            stock // do something
            repository().save(stock);


         });
        */

    }

    public static void updateStock(ShippingCancelled shippingCancelled) {
        /** Example 1:  new item 
        Stock stock = new Stock();
        repository().save(stock);

        */

        /** Example 2:  finding and process
        
        repository().findById(shippingCancelled.get???()).ifPresent(stock->{
            
            stock // do something
            repository().save(stock);


         });
        */

    }
}
