package dias.andre.imsapi.models.order;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import dias.andre.imsapi.models.supplier.Supplier;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString

@Entity(name = "Order")
@Table(name = "tbl_order")
@JsonSerialize
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_order")
    private String id;

    @Column(name = "dt_quote_reference")
    private String quoteReference;

    @Column(name = "dt_quote_date")
    private LocalDateTime quoteDate;

    @Column(name = "dt_invoice_reference")
    private String invoiceReference;

    @Column(name = "dt_invoice_date")
    private LocalDateTime invoiceDate;

    @OneToOne
    @JoinColumn(
            name = "fi_supplier",
            referencedColumnName = "id_supplier",
            foreignKey = @ForeignKey(name = "fk_order_supplier"))
    private Supplier supplier;

    public Order() {
    }

    public Order(String quoteReference, LocalDateTime quoteDate, String invoiceReference, LocalDateTime invoiceDate) {
        this.quoteReference = quoteReference;
        this.quoteDate = quoteDate;
        this.invoiceReference = invoiceReference;
        this.invoiceDate = invoiceDate;
    }
}
