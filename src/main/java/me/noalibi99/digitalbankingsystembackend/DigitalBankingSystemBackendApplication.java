package me.noalibi99.digitalbankingsystembackend;

import me.noalibi99.digitalbankingsystembackend.entities.AccountOperation;
import me.noalibi99.digitalbankingsystembackend.entities.CurrentAccount;
import me.noalibi99.digitalbankingsystembackend.entities.Customer;
import me.noalibi99.digitalbankingsystembackend.entities.SavingAccount;
import me.noalibi99.digitalbankingsystembackend.enums.AccountStatus;
import me.noalibi99.digitalbankingsystembackend.enums.OperationType;
import me.noalibi99.digitalbankingsystembackend.repositories.AccountOperationRepository;
import me.noalibi99.digitalbankingsystembackend.repositories.BankAccountRepository;
import me.noalibi99.digitalbankingsystembackend.repositories.CustomerRepository;
import org.hibernate.usertype.CompositeUserType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class DigitalBankingSystemBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(DigitalBankingSystemBackendApplication.class, args);
    }

    @Bean
    CommandLineRunner start(
            CustomerRepository customerRepository,
            BankAccountRepository accountRepository,
            AccountOperationRepository accountOperationRepository,
            BankAccountRepository bankAccountRepository) {
        return args -> {
            Stream.of("Hassan", "Yassine", "Adnane").forEach(name -> {
                Customer customer = new Customer();
                customer.setName(name);
                customer.setEmail(name + "@gmail.com");
                customerRepository.save(customer);
            });

            customerRepository.findAll().forEach(
                    customer -> {
                        CurrentAccount currentAccount = new CurrentAccount();
                        currentAccount.setId(UUID.randomUUID().toString());
                        currentAccount.setBalance(Math.random() * 100);
                        currentAccount.setOverDraft(Math.random() * 100);
                        currentAccount.setStatus(AccountStatus.CREATED);
                        currentAccount.setCreatedAt(new Date());
                        currentAccount.setCurrency("MAD");
                        currentAccount.setCustomer(customer);
                        accountRepository.save(currentAccount);

                        SavingAccount savingAccount = new SavingAccount();
                        savingAccount.setId(UUID.randomUUID().toString());
                        savingAccount.setBalance(Math.random() * 100);
                        savingAccount.setInterestRate(4.5);
                        savingAccount.setStatus(AccountStatus.CREATED);
                        savingAccount.setCreatedAt(new Date());
                        savingAccount.setCurrency("MAD");
                        savingAccount.setCustomer(customer);
                        accountRepository.save(savingAccount);
                    }
            );

            bankAccountRepository.findAll().forEach(
                    bankAccount -> {
                        for (int i = 0; i < 10; i++) {
                            AccountOperation accountOperation = new AccountOperation();
                            accountOperation.setType(Math.random() > 0.5 ? OperationType.DEBIT : OperationType.CREDIT);
                            accountOperation.setAmount(Math.random() * 10000);
                            accountOperation.setOperationDate(new Date());
                            accountOperation.setBankAccount(bankAccount);
                            accountOperationRepository.save(accountOperation);
                        }
                    }
            );
        };
    }
}
