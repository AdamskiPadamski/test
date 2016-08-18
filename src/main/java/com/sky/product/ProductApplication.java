package com.sky.product;

import com.sky.product.domain.Customer;
import com.sky.product.domain.Location;
import com.sky.product.domain.Product;
import com.sky.product.repositories.CustomerRepository;
import com.sky.product.repositories.LocationRepository;
import com.sky.product.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

	@Component
	public class DatabaseLoader implements CommandLineRunner {

		@Autowired
		CustomerRepository customerRepository;

		@Autowired
		LocationRepository locationRepository;

		@Autowired
		ProductRepository productRepository;

		/**
		 * Populates database
		 *
		 * @param strings variable number of arguments
		 * @throws Exception
         */
		@Override
		public void run(String... strings) throws Exception {
			Location location = new Location();
			location.setName("LONDON");

			locationRepository.save(location);

			Location location1 = new Location();
			location1.setName("LIVERPOOL");

			locationRepository.save(location1);

			Product product = new Product();
			product.setName("Arsenal TV");
			product.setCategory("Sports");
			product.addLocation(location);

			productRepository.save(product);

			Product product2 = new Product();
			product2.setName("Chelsea TV");
			product2.setCategory("Sports");
			product2.addLocation(location);

			productRepository.save(product2);

			Product product3 = new Product();
			product3.setName("Liverpool TV");
			product3.setCategory("Sports");
			product3.addLocation(location1);

			productRepository.save(product3);

			Product product4 = new Product();
			product4.setName("Sky News");
			product4.setCategory("News");

			productRepository.save(product4);

			Product product5 = new Product();
			product5.setName("Sky Sports News");
			product5.setCategory("News");

			productRepository.save(product5);

			Customer customer = new Customer();
			customer.setFirstName("test");
			customer.setLastName("test");
			customer.setEmail("test@test.com");
			customer.setPassword("test");
			customer.addLocation(location);

			customerRepository.save(customer);
		}
	}
}
