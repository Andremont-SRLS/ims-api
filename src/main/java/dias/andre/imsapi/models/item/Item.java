package dias.andre.imsapi.models.item;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import dias.andre.imsapi.models.order.Order;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString

@Entity(name = "Item")
@Table(name = "tbl_item")
@JsonSerialize
@Data
public class Item {

    @Id
    @GeneratedValue( strategy = GenerationType.UUID)
    @Column(name = "id_item")
    private String id;

    @Column(name = "dt_serial_nbr")
    private String serialNumber;

    @Column(name = "dt_model")
    private String model;

    @Column(name = "dt_brand")
    private String brand;

    @Column(name = "dt_purchase_price")
    private Double purchasePrice;

    @OneToOne
    @JoinColumn(
            name = "fi_order",
            referencedColumnName = "id_order",
            foreignKey = @ForeignKey(name = "fk_item_order"))
    private Order order;

}
