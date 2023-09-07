package com.insurance.vehicleInsurance.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.insurance.vehicleInsurance.entity.EndUser;

public interface EndUserRepository extends JpaRepository<EndUser, Integer> {

	Optional<EndUser> findByName(String name);
}
