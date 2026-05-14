package me.noalibi99.digitalbankingsystembackend.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.noalibi99.digitalbankingsystembackend.dtos.BankAccountDTO;
import me.noalibi99.digitalbankingsystembackend.dtos.CustomerDTO;
import me.noalibi99.digitalbankingsystembackend.entities.Customer;
import me.noalibi99.digitalbankingsystembackend.services.BankAccountService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/customers")
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class CustomerRestController {
    private BankAccountService bankAccountService;

    @GetMapping
    @PreAuthorize("hasAuthority('SCOPE_ROLE_USER')")
    public List<CustomerDTO> customers() {
        return bankAccountService.listCustomers();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ROLE_USER')")
    public CustomerDTO getCustomer(@PathVariable Long id) {
        return bankAccountService.getCustomer(id);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO) {
        return bankAccountService.saveCustomer(customerDTO);
    }

    @GetMapping("/search")
    @PreAuthorize("hasAuthority('SCOPE_ROLE_USER')")
    public List<CustomerDTO> searchCustomers(@RequestParam(name = "keyword", defaultValue = "")String keyword) {
        return bankAccountService.searchCustomers(keyword);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    public CustomerDTO updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO) {
        customerDTO.setId(id);
        return bankAccountService.saveCustomer(customerDTO);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    public void deleteCustomer(@PathVariable Long id) {
        bankAccountService.deleteCustomer(id);
    }

    @GetMapping("/{customerId}/accounts")
    public List<BankAccountDTO> getCustomerBankAccounts(@PathVariable Long customerId) {
        return bankAccountService.getCustomerBankAccounts(customerId);
    }
}
