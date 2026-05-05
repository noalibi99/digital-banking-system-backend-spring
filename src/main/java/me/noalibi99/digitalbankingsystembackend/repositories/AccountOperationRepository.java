package me.noalibi99.digitalbankingsystembackend.repositories;

import me.noalibi99.digitalbankingsystembackend.entities.AccountOperation;
import me.noalibi99.digitalbankingsystembackend.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountOperationRepository extends JpaRepository<AccountOperation, Long> {

}
