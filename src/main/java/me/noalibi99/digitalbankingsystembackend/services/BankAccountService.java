package me.noalibi99.digitalbankingsystembackend.services;

import me.noalibi99.digitalbankingsystembackend.dtos.*;
import me.noalibi99.digitalbankingsystembackend.entities.*;
import me.noalibi99.digitalbankingsystembackend.exceptions.*;

import java.util.List;

public interface BankAccountService {
    CustomerDTO saveCustomer(CustomerDTO customerDTO);
    void deleteCustomer(Long id) throws CustomerNotFoundException;
    CurrentBankAccountDTO saveCurrentAccount(double initialBalance, Long customerId, double overDraft) throws CustomerNotFoundException;
    SavingBankAccountDTO saveSavingAccount(double initialBalance, Long customerId, double interestRate) throws CustomerNotFoundException;
    List<CustomerDTO> listCustomers();
    CustomerDTO getCustomer(Long customerId) throws CustomerNotFoundException;
    BankAccountDTO getBankAccount(String accountId) throws BankAccountNotFoundException;
    void debit(String accountId, double amount, String description) throws BankAccountNotFoundException, BalanceNotSufficientException;
    void credit(String accountId, double amount, String description);
    void transfer(String accountIdSource, String accountIdDestination, double amount);
    List<BankAccountDTO> listBankAccounts();
    List<AccountOperationDTO> accountHistory(String accountId) throws BankAccountNotFoundException;
    AccountHistoryDTO getAccountHistory(String accountId, int page, int size) throws BankAccountNotFoundException;
    List<CustomerDTO> searchCustomers(String keyword);
    List<BankAccountDTO> getCustomerBankAccounts(Long customerId) throws CustomerNotFoundException;
}
