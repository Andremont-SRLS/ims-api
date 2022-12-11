package dias.andre.imsapi.models.supplier;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter @Setter
@Table(name="tbl_supplier_contact")
@Entity(name="SupplierContact")
@JsonSerialize()
@ToString
public class SupplierContact {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_supplier_contact")
    private String id;

    @Column(name = "dt_firstName")
    private String firstName;

    @Column(name = "dt_lastName")
    private String lastName;

    @Column(name = "dt_email")
    private String email;

    @Column(name = "dt_phone_nbr")
    private String phone;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(
            name = "fi_supplier",
            referencedColumnName = "id_supplier",
            foreignKey = @ForeignKey(name = "fk_supplier_contact_supplier"),
            updatable = false
    )
    @JsonBackReference
    private Supplier supplier;

    public SupplierContact() {
    }

    public SupplierContact(String firstName, String lastName, String email, String phone, Supplier supplier) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.supplier = supplier;
    }

}
