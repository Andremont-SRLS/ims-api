package dias.andre.imsapi.repositories;

import dias.andre.imsapi.models.supplier.SupplierContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierContactRepository extends JpaRepository<SupplierContact, String> {

    List<SupplierContact> findAllBySupplierId(String supplierId);

}
