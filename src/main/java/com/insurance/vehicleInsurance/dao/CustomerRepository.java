package com.insurance.vehicleInsurance.dao;



import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.insurance.vehicleInsurance.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	 Optional<Customer> findByCustomerName(String customerName);

}
