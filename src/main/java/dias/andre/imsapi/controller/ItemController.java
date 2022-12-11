package dias.andre.imsapi.controller;
import dias.andre.imsapi.models.item.Item;
import dias.andre.imsapi.repositories.ItemRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/item", produces = "application/json")
public class ItemController {

    private final ItemRepository itemRepository;

    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping("/")
    public List<Item> getAll() {
        return itemRepository.findAll();
    }

    @GetMapping("/{id}")
    public Item getById(@PathVariable String id) {
        return itemRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item with id " + id + " not found"));
    }

    @PostMapping
    public Item create(@RequestBody Item item) {

        try {
            return itemRepository.save(item);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Make sure you are sending a valid item object");
        }
    }

    @PostMapping("/{id}")
    public Item update(@PathVariable String id, @RequestBody Item item) {
        Item itemToUpdate = itemRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item with id " + id + " not found"));

        item.setId(id);

        if (item.getSerialNumber() != null) {
            itemToUpdate.setSerialNumber(item.getSerialNumber());
        }

        if (item.getBrand() != null) {
            itemToUpdate.setBrand(item.getBrand());
        }

        if (item.getOrder() != null) {
            itemToUpdate.setOrder(item.getOrder());
        }

        if (item.getPurchasePrice() != null) {
            itemToUpdate.setPurchasePrice(item.getPurchasePrice());
        }

        if (item.getModel() != null) {
            itemToUpdate.setModel(item.getModel());
        }

        return itemRepository.save(itemToUpdate);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {

        itemRepository.deleteById(id);
    }

}
