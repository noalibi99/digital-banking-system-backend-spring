package me.noalibi99.digitalbankingsystembackend.repositories;

import me.noalibi99.digitalbankingsystembackend.entities.AccountOperation;
import me.noalibi99.digitalbankingsystembackend.entities.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountOperationRepository extends JpaRepository<AccountOperation, Long> {
    public List<AccountOperation> findByBankAccountId(String accountId);
    public Page<AccountOperation> findByBankAccountId(String accountId, Pageable pageable);
    public Page<AccountOperation> findByBankAccountIdOrderByOperationDateDesc(String accountId, Pageable pageable);
}
