package me.noalibi99.digitalbankingsystembackend.services;

import me.noalibi99.digitalbankingsystembackend.dtos.CustomerDTO;
import me.noalibi99.digitalbankingsystembackend.entities.*;
import me.noalibi99.digitalbankingsystembackend.exceptions.*;

import java.util.List;

public interface BankAccountService {
    Customer saveCustomer(Customer customer);
    CurrentAccount saveCurrentAccount(double initialBalance, Long customerId, double overDraft) throws CustomerNotFoundException;
    SavingAccount saveSavingAccount(double initialBalance, Long customerId, double interestRate) throws CustomerNotFoundException;
    List<CustomerDTO> listCustomers();
    BankAccount getBankAccount(String accountId) throws BankAccountNotFoundException;
    void debit(String accountId, double amount, String description) throws BankAccountNotFoundException, BalanceNotSufficientException;
    void credit(String accountId, double amount, String description);
    void transfer(String accountIdSource, String accountIdDestination, double amount);

}
