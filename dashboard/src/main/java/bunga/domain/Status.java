package bunga.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Status_table")
@Data
public class Status {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String status;
}
