package me.noalibi99.digitalbankingsystembackend.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.noalibi99.digitalbankingsystembackend.dtos.*;
import me.noalibi99.digitalbankingsystembackend.services.BankAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class BankAccountRestController {
    private final BankAccountService bankAccountService;

    @GetMapping("/{id}")
    public BankAccountDTO getBankAccount(@PathVariable String id) {
        return bankAccountService.getBankAccount(id);
    }

    @GetMapping("")
    public List<BankAccountDTO> bankAccounts() {
        return bankAccountService.listBankAccounts();
    }

    @GetMapping("/{accountId}/operations")
    public List<AccountOperationDTO> getAccountHistory(@PathVariable String accountId) {
        return bankAccountService.accountHistory(accountId);
    }

    @GetMapping("/{accountId}/pageOperations")
    public AccountHistoryDTO getAccountHistory(
            @PathVariable String accountId,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size) {
        return bankAccountService.getAccountHistory(accountId, page, size);
    }

    @PostMapping("/current")
    public CurrentBankAccountDTO saveCurrentBankAccount(
            @RequestParam double initialBalance,
            @RequestParam Long customerId,
            @RequestParam double overDraft) {
        return bankAccountService.saveCurrentAccount(initialBalance, customerId, overDraft);
    }

    @PostMapping("/saving")
    public SavingBankAccountDTO saveSavingBankAccount(
            @RequestParam double initialBalance,
            @RequestParam Long customerId,
            @RequestParam double interestRate) {
        return bankAccountService.saveSavingAccount(initialBalance, customerId, interestRate);
    }

    @PostMapping("/transfer")
    public void transfer(@RequestBody TransferRequestDTO transferRequestDTO) {
        this.bankAccountService.transfer(transferRequestDTO.getSourceAccountId(), transferRequestDTO.getDestinationAccountId(), transferRequestDTO.getAmount());
    }

    @PostMapping("/debit")
    public DebitDTO debit(@RequestBody DebitDTO debitDTO) {
        this.bankAccountService.debit(debitDTO.getAccountId(), debitDTO.getAmount(), debitDTO.getDescription());
        return debitDTO;
    }

    @PostMapping("/credit")
    public CreditDTO credit(@RequestBody CreditDTO creditDTO) {
        this.bankAccountService.credit(creditDTO.getAccountId(), creditDTO.getAmount(), creditDTO.getDescription());
        return creditDTO;
    }
}
