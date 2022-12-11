package dias.andre.imsapi.models.supplier;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@ToString
@Table(name="tbl_supplier")
@Entity(name="Supplier")
@JsonSerialize()
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_supplier")
    private String id;

    @Column(name = "dt_name")
    private String name;

    @Column(name = "dt_vat")
    private String vat;

    @Column(name = "dt_address")
    private String address;

    @OneToMany(
            mappedBy = "supplier"
    )
    @JsonIgnore
    private List<SupplierContact> contacts;

    public Supplier() {
    }

    public Supplier(String name, String vat, String address) {
        this.name = name;
        this.vat = vat;
        this.address = address;
    }

}
