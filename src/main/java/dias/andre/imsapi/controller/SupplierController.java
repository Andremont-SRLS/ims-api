package dias.andre.imsapi.controller;


import dias.andre.imsapi.models.supplier.Supplier;
import dias.andre.imsapi.repositories.SupplierContactRepository;
import dias.andre.imsapi.repositories.SupplierRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/supplier", produces = "application/json")
public class SupplierController {

    private final SupplierRepository supplierRepository;
    private final SupplierContactRepository supplierContactRepository;

    public SupplierController(
            SupplierRepository supplierRepository,
            SupplierContactRepository supplierContactRepository
    ) {
        this.supplierRepository = supplierRepository;
        this.supplierContactRepository = supplierContactRepository;
    }

    @GetMapping
    public List<Supplier> getAll() {
        return supplierRepository.findAll();
    }

    @GetMapping("/{id}")
    public Supplier getById(@PathVariable String id) {
        return supplierRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Supplier with id " + id + " not found"));
    }

    @PostMapping
    public void createSupplier( @RequestBody Supplier supplier) {
        try {
            supplierRepository.save(supplier);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Make sure you are sending a valid supplier object");
        }

    }

    @PutMapping("/{id}")
    public void updateSupplier( @PathVariable String id,@RequestBody Supplier supplier) {

        Supplier supplierToUpdate = supplierRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Supplier with id " + id + " not found"));

        supplier.setId(supplierToUpdate.getId());

        if( supplier.getName() != null) {
            supplierToUpdate.setName(supplier.getName());
        }

        if( supplier.getAddress() != null) {
            supplierToUpdate.setAddress(supplier.getAddress());
        }

        if( supplier.getContacts() != null) {
            supplierToUpdate.setContacts(supplier.getContacts());
        }

        if( supplier.getVat() != null) {
            supplierToUpdate.setVat(supplier.getVat());
        }

        supplierRepository.save(supplierToUpdate);
    }

    @DeleteMapping("/{id}")
    public void deleteSupplier( @PathVariable String id) {

        supplierRepository.deleteById(id);
    }


}
