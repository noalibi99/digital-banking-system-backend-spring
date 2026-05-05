package me.noalibi99.digitalbankingsystembackend.repositories;

import me.noalibi99.digitalbankingsystembackend.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
