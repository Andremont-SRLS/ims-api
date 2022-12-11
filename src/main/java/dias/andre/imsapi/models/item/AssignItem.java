package dias.andre.imsapi.models.item;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Timestamp;

@Table(name = "tbl_assingn")
@Entity(name = "Assign")
public class AssignItem {

    public AssignItem() {
    }

    @Id
    private String id;


}
