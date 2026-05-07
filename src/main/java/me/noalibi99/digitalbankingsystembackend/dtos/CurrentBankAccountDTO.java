package me.noalibi99.digitalbankingsystembackend.dtos;

import lombok.*;
import me.noalibi99.digitalbankingsystembackend.enums.AccountStatus;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CurrentBankAccountDTO extends BankAccountDTO {
    private String id;
    private double balance;
    private Date createdAt;
    private AccountStatus status;
    private CustomerDTO customerDTO;
    private String currency;
    private double overDraft;
}
