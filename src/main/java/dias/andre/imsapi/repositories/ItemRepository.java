package dias.andre.imsapi.repositories;

import dias.andre.imsapi.models.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, String> {

}
