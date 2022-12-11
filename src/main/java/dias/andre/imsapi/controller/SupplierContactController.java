package dias.andre.imsapi.controller;


import dias.andre.imsapi.models.supplier.Supplier;
import dias.andre.imsapi.models.supplier.SupplierContact;
import dias.andre.imsapi.repositories.SupplierContactRepository;
import dias.andre.imsapi.repositories.SupplierRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/supplier-contact", produces = "application/json")
public class SupplierContactController {

    private final SupplierContactRepository supplierContactRepository;
    private final SupplierRepository supplierRepository;

    public SupplierContactController(
            SupplierContactRepository supplierContactRepository,
            SupplierRepository supplierRepository
    ) {
        this.supplierContactRepository = supplierContactRepository;
        this.supplierRepository = supplierRepository;
    }

    @GetMapping
    public List<SupplierContact> getAll() {
        return supplierContactRepository.findAll();
    }

    @GetMapping("/{id}")
    public SupplierContact getById(@PathVariable String id) {
        return supplierContactRepository.findById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Supplier contact with id " + id + " not found"));
    }

    @PostMapping("/{supplierId}")
    public SupplierContact createSupplierContact(
            @PathVariable String supplierId,
            @RequestBody SupplierContact supplierContact
    ) {
        Supplier supplier = supplierRepository.findById(supplierId).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Supplier with id " + supplierId + " not found"));
        supplierContact.setSupplier(supplier);

        try {
            return supplierContactRepository.save(supplierContact);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Make sure you are sending a valid supplier contact object");
        }
    }

     @PutMapping("/{contactId}")
     public SupplierContact updateSupplierContact(
             @PathVariable String contactId,
             @RequestBody SupplierContact supplierContact
        ) {
         SupplierContact supplierContactToUpdate = supplierContactRepository.findById(contactId).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Supplier contact with id " + contactId + " not found"));

         supplierContact.setId(supplierContactToUpdate.getId());

         if( supplierContact.getFirstName() != null ) {
             supplierContactToUpdate.setFirstName(supplierContact.getFirstName());
         }

         if( supplierContact.getLastName() != null ) {
             supplierContactToUpdate.setLastName(supplierContact.getLastName());
         }

         if( supplierContact.getEmail() != null ) {
             supplierContactToUpdate.setEmail(supplierContact.getEmail());
         }

         if( supplierContact.getPhone() != null ) {
             supplierContactToUpdate.setPhone(supplierContact.getPhone());
         }

         return supplierContactRepository.save(supplierContactToUpdate);
     }

     @DeleteMapping("/{id}")
     public void deleteSupplierContact(@PathVariable String id) {
         supplierContactRepository.deleteById(id);
     }
}
