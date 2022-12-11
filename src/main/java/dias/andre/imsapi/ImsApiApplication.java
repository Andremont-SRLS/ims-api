package dias.andre.imsapi;

import dias.andre.imsapi.repositories.PersonRepository;
import dias.andre.imsapi.repositories.SupplierContactRepository;
import dias.andre.imsapi.repositories.SupplierRepository;
import dias.andre.imsapi.service.DatabasePopulator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class ImsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImsApiApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(PersonRepository studentRepository, SupplierRepository supplierRepository, SupplierContactRepository supplierContactRepository) {
		return args -> {

			DatabasePopulator.populatePerson(studentRepository);
			DatabasePopulator.populateSupplier(supplierRepository, supplierContactRepository);

		};

	}

}
