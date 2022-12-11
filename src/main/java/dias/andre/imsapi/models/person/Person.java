package dias.andre.imsapi.models.person;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;

@Getter @Setter @ToString
@Table(name = "tbl_person")
@Entity(name = "Person")
@JsonSerialize()
@JsonInclude(JsonInclude.Include.NON_NULL)
@DynamicUpdate
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_person")
    private String id;
    @Column(name = "dt_firstName", nullable = false)

    private String firstName;
    @Column(name = "dt_lastName", nullable = false)

    private String lastName;
    @Column(name = "dt_email", unique = true, nullable = false)

    private String email;
    @Column(name = "dt_iam", unique = true, updatable = false)

    private String iam;

    public Person(String firstName, String lastName, String email, String iam) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.iam = iam;
    }

    public Person() {
    }

}