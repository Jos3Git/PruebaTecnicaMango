package com.mango.repositories;

import com.mango.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByNameAndLastNameAndAddressAndCityAndEmail(String name,String lastName,String Address,String city,String email);
}
