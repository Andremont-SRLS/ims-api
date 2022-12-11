package dias.andre.imsapi.models.repair;

import dias.andre.imsapi.models.item.Item;
import dias.andre.imsapi.models.supplier.Supplier;
import jakarta.persistence.*;
import org.hibernate.mapping.ToOne;

import java.sql.Timestamp;

@Table(name = "tbl_repair_log")
@Entity(name = "RepairLog")
public class Log {

    public Log() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_repair_log")
    private String id;

    @Column(name = "description")
    private String description;

    @Column(name = "dt_checkin_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp checkInDate;

    @Column(name = "dt_checkout_date", columnDefinition = "TIMESTAMP")
    private Timestamp checkOutDate;

    @ManyToOne
    @Id
    @JoinColumn(
            name = "fi_item",
            referencedColumnName = "id_item",
            foreignKey = @ForeignKey(name = "fk_repair_log_item"))
    private Item item;

    @ManyToOne
    @Id
    @JoinColumn(name = "fi_supplier", referencedColumnName = "id_supplier", foreignKey = @ForeignKey(name = "fk_repair_log_supplier"))
    private Supplier supplier;

}
