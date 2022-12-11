package dias.andre.imsapi.service;

import dias.andre.imsapi.models.person.Person;
import dias.andre.imsapi.models.supplier.Supplier;
import dias.andre.imsapi.models.supplier.SupplierContact;
import dias.andre.imsapi.repositories.PersonRepository;
import dias.andre.imsapi.repositories.SupplierContactRepository;
import dias.andre.imsapi.repositories.SupplierRepository;

public class DatabasePopulator {


    public static void populatePerson(PersonRepository personRepository) {

        Person person = new Person( "Andre", "Dias", "test@email.com", "diaan931");
        personRepository.save(person);

    }

    public static void populateSupplier(
            SupplierRepository supplierRepository,
            SupplierContactRepository supplierContactRepository
    ) {

        Supplier supplier = new Supplier( "Andre", "Dias", "123, sesame street");

        SupplierContact supplierContact = new SupplierContact(
                "Andre",
                "Dias",
                "supplier@mail.com",
                "+00 121 123 123",
                supplier
        );

        supplierContactRepository.save(supplierContact);
    }






}
